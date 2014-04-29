package com.viergewinnt.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.viergewinnt.logging.CCLog;
import com.viergewinnt.server.GameClient;
import com.viergewinnt.util.CCDate;

public class VGDatabase extends DerbyDatabase {
	private final static String XML_NAME = "database/VG_DB_Schema.xml"; //$NON-NLS-1$
	private final static String DB_PATH = "VGData"; //$NON-NLS-1$
	
	public VGDatabase() {
		super();
	}

	public boolean tryconnect() {
		if (!connect(DB_PATH)) {
			if (!create(DB_PATH)) {
				CCLog.addWarning("Connection to DB failed"); //$NON-NLS-1$
				return false;
			} else {
				CCLog.addWarning("Database created"); //$NON-NLS-1$
				return true;
			}
		} else {
			CCLog.addInformation("Connected to DB"); //$NON-NLS-1$
			return true;
		}
	}

	private boolean connect(String dbpath) {
		try {
			establishDBConnection(dbpath);
			return true;
		} catch (SQLException e) {
			lastError = e;
			return false;
		}
	}
	
	public void disconnect(boolean cleanshutdown) {
		try {
			if (isConnected()) {
				closeDBConnection(cleanshutdown);
			}
		} catch (SQLException e) {
			CCLog.addError("Could not disconnect from Database", e); //$NON-NLS-1$
		}
	}
	
	public void reconnect() {
		if (! connect(getDBPath())) {
			CCLog.addFatalError("Could not reconnect to DB", lastError); //$NON-NLS-1$
		}
	}

	private boolean create(String dbpath) {
		boolean res = createNewDatabasefromResourceXML('/' + XML_NAME, dbpath);
		return res;
	}
	
	public String getDBPath() {
		return DB_PATH;
	}

	private int getNewUserID() {
		return querySingleIntSQL("SELECT MAX(LOCALID) + 1 from USERS", 0);
	}
	
	public int addUser(String un, String ui, String us, CCDate currentDate, int points) {
		int id = getNewUserID();
		
		executeSQL(String.format("INSERT INTO USERS (LOCALID, USERNAME, USERID, USERSECRET, REGISTERDATE, POINTS) VALUES (%d, '%s', '%s', '%s', '%s', %d)", 
				id, 
				un, ui, us, 
				currentDate.getSQLStringRepresentation(), 
				points));
		
		return id;
	}

	public boolean setUserValues(GameClient user, int dbuid) {
		try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM USERS WHERE LOCALID = " + dbuid);
			
			if (rs.next()) {
				user.points = rs.getInt("POINTS");
				user.registerDate = CCDate.create(rs.getDate("REGISTERDATE"));
				user.userid = rs.getString("USERID");
				user.username = rs.getString("USERNAME");
				user.usersecret = rs.getString("USERSECRET");
				
				rs.close();
				s.close();
				return true;				
			} else {
				CCLog.addError("DB INTERNAL ERROR - USER NOT THERE");
				
				rs.close();
				s.close();
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}}
