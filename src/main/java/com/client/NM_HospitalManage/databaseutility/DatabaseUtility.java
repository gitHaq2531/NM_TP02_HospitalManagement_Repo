package com.client.NM_HospitalManage.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection conekt;

	public void connectToDatabase() throws SQLException {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conekt = DriverManager.getConnection("", "", "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public ResultSet executeSelectQuery() throws SQLException {
		ResultSet resultset = null;
		try {
			Statement state = conekt.createStatement();
			resultset = state.executeQuery("");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultset;
	}

	public int executeNonSelectQuery() {
		int result = 0;
		try {
			Statement state = conekt.createStatement();
			result = state.executeUpdate("");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	public void closeDatabaseConnection() throws SQLException {
		try {
			conekt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
