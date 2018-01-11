import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

public class ConferenceApproval {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	public static int authen = 0;

	@SuppressWarnings("deprecation")
	public void readPublicationDataBase(String storeAuthor1,
			String storeAuthor2, String storeAuthor3, String storeAuthor4,
			String storeAuthor5, String storeAuthor6, String storeTitle,
			String storeConferenceName, String storeScopus,
			String storeStartDate, String storeStartMonth,
			String storeStartYear, String storeEndDate, String storeEndMonth,
			String storeEndYear,String storeISSN,String storeDepartment, String storeVenue,
			String storeNameOfTheOrganiser, String storeProceedingsPublisher,
			String storeBtechMtech, String storeOtherDetails)
			throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect = DriverManager
					.getConnection("jdbc:sqlserver://LAPTOP-1;databaseName=master;integratedSecurity=true");
			statement = connect.createStatement();
			preparedStatement = connect
					.prepareStatement("insert into  conference values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, storeAuthor1);
			preparedStatement.setString(2, storeAuthor2);
			preparedStatement.setString(3, storeAuthor3);
			preparedStatement.setString(4, storeAuthor4);
			preparedStatement.setString(5, storeAuthor5);
			preparedStatement.setString(6, storeAuthor6);
			preparedStatement.setString(7, storeTitle);
			preparedStatement.setString(8, storeConferenceName);
			preparedStatement.setString(9, storeScopus);
			preparedStatement.setString(10, storeStartDate);
			preparedStatement.setString(11, storeStartMonth);
			preparedStatement.setString(12, storeStartYear);
			preparedStatement.setString(13, storeEndDate);
			preparedStatement.setString(14, storeEndMonth);
			preparedStatement.setString(15, storeEndYear);
			preparedStatement.setString(16, storeISSN);
			preparedStatement.setString(17, storeDepartment);
			preparedStatement.setString(18, storeVenue);
			preparedStatement.setString(19, storeNameOfTheOrganiser);
			preparedStatement.setString(20, storeProceedingsPublisher);
			preparedStatement.setString(21, storeBtechMtech);
			preparedStatement.setString(22, storeOtherDetails);
			preparedStatement.setString(23, "NO");
			preparedStatement.setString(24, "");
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			close();
		}
	}

	public void adminApprovalConferenceApproval() throws SQLException,
			ClassNotFoundException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect = DriverManager
					.getConnection("jdbc:sqlserver://LAPTOP-1;databaseName=master;integratedSecurity=true");
			statement = connect.createStatement();
			preparedStatement = connect
					.prepareStatement("select * from conference");
			resultSet = preparedStatement.executeQuery();
			ConferenceApprovalClass au = new ConferenceApprovalClass();
			int i = 0;
			resultSet.next();
			while (!resultSet.isAfterLast() && resultSet != null) {

				au.Author1 = resultSet.getString("AUTHOR1");
				au.Author2 = resultSet.getString("AUTHOR2");
				au.Author3 = resultSet.getString("AUTHOR3");
				au.Author4 = resultSet.getString("AUTHOR4");
				au.Author5 = resultSet.getString("AUTHOR5");
				au.Author6 = resultSet.getString("AUTHOR6");
				au.Title = resultSet.getString("TITLE");
				au.ConferenceName = resultSet.getString("CONFERENCE_NAME");
				au.Scopus = resultSet.getString("SCOPUS");
				au.StartDate = resultSet.getString("START_DATE");
				au.StartMonth = resultSet.getString("START_MONTH");
				au.StartYear = resultSet.getString("START_YEAR");
				au.EndDate = resultSet.getString("END_DATE");
				au.EndMonth = resultSet.getString("END_MONTH");
				au.EndYear = resultSet.getString("END_YEAR");
				au.ISSN = resultSet.getString("ISSN/ISBN");
				au.Department = resultSet.getString("DEPARTMENT");
				au.Venue = resultSet.getString("VENUE");
				au.NameOfTheOrganiser = resultSet
						.getString("NAME_OF_THE_ORGANIZER");
				au.ProceedingsPublisher = resultSet
						.getString("PROCEEDINGS_PUBLISHED_BY");
				au.BtechMtech = resultSet.getString("NAME_BTECH_MTECH");
				au.OtherDetails = resultSet.getString("OTHER_DETAILS");
				au.AdminApproval = resultSet.getString("ADMIN_APPROVAL");
				// System.out.println(au.Name);
				if (au.AdminApproval.equals("NO")) {
					ConferenceTable ma = new ConferenceTable();
					ma.values[0] = au.Author1;
					ma.values[1] = au.Author2;
					ma.values[2] = au.Author3;
					ma.values[3] = au.Author4;
					ma.values[4] = au.Author5;
					ma.values[5] = au.Author6;
					ma.values[6] = au.Title;
					ma.values[7] = au.ConferenceName;
					ma.values[8] = au.Scopus;
					ma.values[9] = "SELECT";
					ma.values[10] = au.StartDate;
					ma.values[11] = au.StartMonth;
					ma.values[12] = au.StartYear;
					ma.values[13] = au.EndDate;
					ma.values[14] = au.EndMonth;
					ma.values[15] = au.EndYear;
					ma.values[16] = au.ISSN;
					ma.values[17] = au.Department;
					ma.values[18] = au.Venue;
					ma.values[19] = au.NameOfTheOrganiser;
					ma.values[20] = au.ProceedingsPublisher;
					ma.values[21] = au.BtechMtech;
					ma.values[22] = au.OtherDetails;
					JComboBox comboBox = new JComboBox();
					comboBox.addItem("NO");
					comboBox.addItem("YES");
					ma.values[23] = "SELECT";
					ma.values[24] = "SELECT";
					/*
					 * if (au.AdminApproval == "NO") { ma.values[16] = new
					 * JCheckBox("Approval"); } else ma.values[16] = new
					 * Boolean(true);
					 */
					ma.values1[i] = new Object[25];
					ma.values1[i] = ma.values;

					System.out.println(ma.values1[i] + " " + ma.values[0] + " "
							+ i);
					i++;
				}
				resultSet.next();
			}
			ConferenceTable.values2 = new Object[i][];
			for (int j = 0; j < i; j++)
				ConferenceTable.values2[j] = ConferenceTable.values1[j];
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
			String query = "update Conference set ADMIN_APPROVAL = 'YES' where ";
			for (int i = 0; s[i] != null; i++) {
				String query1 = "update Conference set ADMIN_APPROVAL = 'YES', OWNER = '";
				query1 += s1[i];
				query1 += "'";
				query1 += " where ";
				query1 += "CONFERENCE_NAME = '";
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
