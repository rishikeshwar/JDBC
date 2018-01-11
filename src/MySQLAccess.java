import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	public static int authen = 0;

	@SuppressWarnings("deprecation")
	public void readPublicationDataBase(String s1, String s2, String s3,
			String s4) throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect = DriverManager
					.getConnection("jdbc:sqlserver://LAPTOP-1;databaseName=master;integratedSecurity=true");
			statement = connect.createStatement();
			preparedStatement = connect
					.prepareStatement("insert into  publication values (?, ?, ?, ?)");
			preparedStatement.setString(1, s1);
			preparedStatement.setString(2, s2);
			preparedStatement.setString(3, s3);
			preparedStatement.setString(4, s4);
			preparedStatement.executeUpdate();
			/*
			 * resultSet = statement
			 * .executeQuery("select * from feedback.comments"); //
			 * writeResultSet(resultSet); // PreparedStatements can use
			 * variables and are more efficient preparedStatement = connect
			 * .prepareStatement
			 * ("insert into  feedback.comments values (default, ?, ?, ?, ? , ?, ?)"
			 * ); //
			 * "myuser, webpage, datum, summary, COMMENTS from feedback.comments"
			 * ); // Parameters start with 1 preparedStatement.setString(1,
			 * "Test"); preparedStatement.setString(2, "TestEmail");
			 * preparedStatement.setString(3, "TestWebpage");
			 * preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
			 * preparedStatement.setString(5, "TestSummary");
			 * preparedStatement.setString(6, "TestComment");
			 * preparedStatement.executeUpdate();
			 * 
			 * preparedStatement = connect .prepareStatement(
			 * "SELECT myuser, webpage, datum, summary, COMMENTS from feedback.comments where myuser = 'Test'"
			 * ); resultSet = preparedStatement.executeQuery();
			 * writeResultSet(resultSet); preparedStatement = connect
			 * .prepareStatement
			 * ("delete from feedback.comments where myuser= ? ; ");
			 * preparedStatement.setString(1, "Test");
			 * preparedStatement.executeUpdate(); resultSet = statement
			 * .executeQuery("select * from feedback.comments");
			 */
			// writeMetaData(resultSet);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			close();
		}
	}
	public boolean TroubleShoot(String s) throws SQLException, ClassNotFoundException{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect = DriverManager
					.getConnection("jdbc:sqlserver://LAPTOP-1;databaseName=master;integratedSecurity=true");
			statement = connect.createStatement();
			preparedStatement = connect
					.prepareStatement("Select * from authenticity");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				if(resultSet.getString("Username").equals(s)){
					return false;
				}
			}
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		}

	
	}
	public void authenticity(String s1, String s2, String s3)
			throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect = DriverManager
					.getConnection("jdbc:sqlserver://LAPTOP-1;databaseName=master;integratedSecurity=true");
			statement = connect.createStatement();
			preparedStatement = connect
					.prepareStatement("insert into  authenticity values (?, ?, ?,?,?)");
			preparedStatement.setString(1, s1);
			preparedStatement.setString(2, s2);
			preparedStatement.setString(3, s3);
			preparedStatement.setString(4, "NO");
			preparedStatement.setString(5, "");
			System.out.println("coming");
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		}

	}

	public authenticityClass enteringAuthen(String s1) throws SQLException,
			ClassNotFoundException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect = DriverManager
					.getConnection("jdbc:sqlserver://LAPTOP-1;databaseName=master;integratedSecurity=true");
			statement = connect.createStatement();

			preparedStatement = connect
					.prepareStatement("SELECT * from authenticity where Username = '" + s1 + "'");
			resultSet = preparedStatement.executeQuery();

			authenticityClass au = new authenticityClass();
			while (resultSet.next()) {
				au.Name = resultSet.getString("Name");
				au.userName = resultSet.getString("Username");
				au.Password = resultSet.getString("Password");
				au.AdminApproval = resultSet.getString("AdminApproval");
				au.Role = resultSet.getString("Role");
			}
			return au;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		}

	}

	private void writeMetaData(ResultSet resultSet) throws SQLException {
		System.out.println("The coloumns in the table are: ");
		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column: " + i + " "
					+ resultSet.getMetaData().getColumnName(i));
		}
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			String user = resultSet.getString("myuser");
			String website = resultSet.getString("webpage");
			String summary = resultSet.getString("summary");
			Date date = resultSet.getDate("datum");
			String comment = resultSet.getString("comments");
			System.out.println("User: " + user);
			System.out.println("Website: " + website);
			System.out.println("summary: " + summary);
			System.out.println("Date: " + date);
			System.out.println("Comment: " + comment);
		}
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}
}
