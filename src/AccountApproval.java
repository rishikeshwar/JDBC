import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JComboBox;

public class AccountApproval {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	public static ResultSet resultSet = null;
	public static int authen = 0;

	@SuppressWarnings("deprecation")
	public void adminApprovalAccountApproval() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect = DriverManager
					.getConnection("jdbc:sqlserver://LAPTOP-1;databaseName=master;integratedSecurity=true");
			statement = connect.createStatement();
			preparedStatement = connect
					.prepareStatement("SELECT * from authenticity");
			resultSet = preparedStatement.executeQuery();
			authenticityClass au = new authenticityClass();
			int i = 0;
			resultSet.next();
			while (!resultSet.isAfterLast() && resultSet != null) {

				au.Name = resultSet.getString("Name");
				au.userName = resultSet.getString("Username");
				au.Password = resultSet.getString("Password");
				au.Role = resultSet.getString("Role");
				au.AdminApproval = resultSet.getString("AdminApproval");
				// System.out.println(au.Name);
				if (au.AdminApproval.equals("NO")) {
					accountTable ma = new accountTable();
					ma.values[0] = au.Name;
					ma.values[1] = au.userName;
					ma.values[2] = au.Password;
					ma.values[3] = "SELECT";
					ma.values[4] = "SELECT";
					/*
					 * if (au.AdminApproval == "NO") { ma.values[16] = new
					 * JCheckBox("Approval"); } else ma.values[16] = new
					 * Boolean(true);
					 */
					ma.values1[i] = new Object[5];
					ma.values1[i] = ma.values;

					System.out.println(ma.values1[i] + " " + ma.values[0] + " "
							+ i);
					i++;
				}
				resultSet.next();
			}
			accountTable.values2 = new Object[i][];
			for (int j = 0; j < i; j++)
				accountTable.values2[j] = accountTable.values1[j];
			return;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	public void Approval(String s[], String s1[]) throws SQLException,
	ClassNotFoundException {
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
connect = DriverManager
		.getConnection("jdbc:sqlserver://LAPTOP-1;databaseName=master;integratedSecurity=true");
statement = connect.createStatement();

if (s[0] != null) {
	String query = "update authenticity set AdminApproval = 'YES' where ";
	for (int i = 0; s[i] != null; i++) {
		String query1 = "update authenticity set AdminApproval = 'YES', Role = '";
		query1 += s1[i];
		query1 += "'";
		query1 += " where ";
		query1 += "Username = '";
		query1 += s[i];
		query1 += "'";
		query1 += ";";
		System.out.println(query1);
		preparedStatement = connect.prepareStatement(query1);
		try {
			preparedStatement.executeQuery();
		} catch (Exception e) {

		}
	}
}
}
	public void adminApprovalAccountApprovalAcceptIN() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect = DriverManager
					.getConnection("jdbc:sqlserver://LAPTOP-1;databaseName=master;integratedSecurity=true");
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("update authenticity set  AdminApproval = 'YES' where Name = '" + resultSet.getString("Name")+"'");
			preparedStatement.executeQuery();
			return;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		} 
	}
	public void adminApprovalAccountRejectionRemoveOUT() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect = DriverManager
					.getConnection("jdbc:sqlserver://LAPTOP-1;databaseName=master;integratedSecurity=true");
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("delete authenticity where Name = '" + resultSet.getString("Name")+"'");
			preparedStatement.executeQuery();
			return;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		} 
	}

	
}
