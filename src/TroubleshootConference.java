import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TroubleshootConference {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	public String[] check(String storeAuthor1,
			String storeAuthor2, String storeAuthor3, String storeAuthor4,
			String storeAuthor5, String storeAuthor6, String storeTitle,
			String storeConferenceName, String storeScopus,
			String storeStartDate, String storeStartMonth,
			String storeStartYear, String storeEndDate, String storeEndMonth,
			String storeEndYear, String storeVenue,
			String storeNameOfTheOrganiser, String storeProceedingsPublisher,
			String storeBtechMtech, String storeOtherDetails) throws SQLException, ClassNotFoundException {
		String[] s = new String[10];
		int i = 0;
		// System.out.println(storeAuthor1);
		if (storeAuthor1.equals("")) {
			System.out.println("sotreAuthor1");
			s[i++] = "Author1 cannot be empty;";
		} else {
			if (storeAuthor2.equals("")
					&& (!storeAuthor3.equals("") || !storeAuthor4.equals("")
							|| !storeAuthor5.equals("") || !storeAuthor6
								.equals(""))) {
				s[i++] = "Author2 should be filled before entering other authors";
			} else if (storeAuthor3.equals("")
					&& (!storeAuthor4.equals("") || !storeAuthor5.equals("") || !storeAuthor6
							.equals(""))) {
				s[i++] = "Author3 should be filled before entering other authors";
			} else if (storeAuthor4.equals("")
					&& (!storeAuthor5.equals("") || !storeAuthor6.equals(""))) {
				s[i++] = "Author4 should be filled before entering other authors";
			} else if (storeAuthor5.equals("") && (!storeAuthor6.equals(""))) {
				s[i++] = "Author5 should be filled before entering other authors";
			}
		}
		if (storeTitle.equals("")) {
			s[i++] = "Title cannot be Empty";
		}

		if (storeConferenceName.equals("")) {
			s[i++] = "ConferenceName cannot be empty";
		}
		if(storeStartDate.equals("") || storeStartDate.equals("") || storeStartDate.equals("")){
			s[i++] = "Conference Start date or month or year cannot be empty";
		}
		if(storeEndDate.equals("") || storeEndDate.equals("") || storeEndDate.equals("")){
			s[i++] = "Conference End date or month or year cannot be empty";
		}
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect = DriverManager
					.getConnection("jdbc:sqlserver://LAPTOP-1;databaseName=master;integratedSecurity=true");
			statement = connect.createStatement();
			/*
			 * if(storeJournalName.equals("")) storeJournalName = " ";
			 */
			resultSet = null;
			String p = "select * from conference where replace(lower(CONFERENCE_NAME),' ','') like replace(lower('"
					+ storeConferenceName + "'),' ','');";
			preparedStatement = connect.prepareStatement(p);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next() == true) {
				s[i++] = "Conference already Entered";
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		s[i] = null;
		return s;

	}
}
