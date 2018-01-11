import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchConference {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public String[] TroubleShoot(String storeAuthor, int storeScopus,
			int storeConferenceStartMonth, int storeConferenceStartYear,
			int storeConferenceEndMonth, int storeConferenceEndYear,
			String storeOwner, int storeDepartmentnumber) {
		int i = 0;
		String s[] = new String[10];
		if (storeAuthor.equals("") && storeScopus <= 0
				&& storeConferenceStartMonth <= 0
				&& storeConferenceEndMonth <= 0 && storeOwner.equals("")
				&& storeDepartmentnumber == 0) {
			s[i++] = "Atleast One Field should be entered";
		}
		if ((storeConferenceStartMonth <= 0 && !(storeConferenceStartYear <= 0))
				|| (!(storeConferenceStartMonth <= 0) && storeConferenceStartYear <= 0)) {
			s[i++] = "Starting Month and Year both should be entered";
		}
		if ((storeConferenceEndMonth <= 0 && !(storeConferenceEndYear <= 0))
				|| (!(storeConferenceEndMonth <= 0) && storeConferenceEndYear <= 0)) {
			s[i++] = "Ending Month and Year both should be entered";
		}
		s[i] = null;
		return s;
	}

	public ConferenceApprovalClass check(String storeAuthor,
			String storeConferenceScopus, String storeConferenceStartMonth,
			String storeConferenceStartYear, String storeConferenceEndMonth,
			String storeConferenceEndYear, String storeOwner,
			String storeDepartment1, String storeDepartment2,
			String storeDepartment3, String storeDepartment4,
			String storeDepartment5, String storeDepartment6,
			String storeDepartment7, String storeDepartment8,
			String storeDepartment9, String storeDepartment10)
			throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect = DriverManager
				.getConnection("jdbc:sqlserver://LAPTOP-1;databaseName=master;integratedSecurity=true");
		statement = connect.createStatement();
		preparedStatement = connect
				.prepareStatement("Select * from conference");
		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		int i = 0;
		while (!resultSet.isAfterLast() && resultSet != null) {
			ConferenceSearchTable ma = new ConferenceSearchTable();
			ma.values[0] = resultSet.getString("AUTHOR1");
			ma.values[1] = resultSet.getString("AUTHOR2");
			ma.values[2] = resultSet.getString("AUTHOR3");
			ma.values[3] = resultSet.getString("AUTHOR4");
			ma.values[4] = resultSet.getString("AUTHOR5");
			ma.values[5] = resultSet.getString("AUTHOR6");
			ma.values[6] = resultSet.getString("TITLE");
			ma.values[7] = resultSet.getString("CONFERENCE_NAME");
			ma.values[8] = resultSet.getString("SCOPUS");
			ma.values[9] = resultSet.getString("START_DATE");
			ma.values[10] = resultSet.getString("START_MONTH");
			ma.values[11] = resultSet.getString("START_YEAR");
			ma.values[12] = resultSet.getString("END_DATE");
			ma.values[13] = resultSet.getString("END_MONTH");
			ma.values[14] = resultSet.getString("END_YEAR");
			ma.values[15] = resultSet.getString("ISSN/ISBN");
			ma.values[16] = resultSet.getString("DEPARTMENT");
			ma.values[17] = resultSet.getString("VENUE");
			ma.values[18] = resultSet.getString("NAME_OF_THE_ORGANIZER");
			ma.values[19] = resultSet.getString("PROCEEDINGS_PUBLISHED_BY");
			ma.values[20] = resultSet.getString("NAME_BTECH_MTECH");
			ma.values[21] = resultSet.getString("OTHER_DETAILS");
			ma.values[22] = resultSet.getString("ADMIN_APPROVAL");
			ma.values[23] = resultSet.getString("OWNER");
			String s = resultSet.getString("ADMIN_APPROVAL");
			int keep = 0;
			if (s.equals("YES")) {
				if (storeAuthor.equals("")) {
					// System.out.println("author1 coming");
					keep++;
				} else {

					if (((String) ma.values[0]).toLowerCase().contains(
							storeAuthor.toLowerCase())
							|| ((String) ma.values[1]).toLowerCase().contains(
									storeAuthor.toLowerCase())
							|| ((String) ma.values[2]).toLowerCase().contains(
									storeAuthor.toLowerCase())
							|| ((String) ma.values[3]).toLowerCase().contains(
									storeAuthor.toLowerCase())
							|| ((String) ma.values[4]).toLowerCase().contains(
									storeAuthor.toLowerCase())
							|| ((String) ma.values[5]).toLowerCase().contains(
									storeAuthor.toLowerCase())) {
						// System.out.println("author2 coming");
						keep++;
					}
				}
				System.out.println("______________________");
				System.out.println(storeDepartment1 + " " + storeDepartment6);
				if (storeDepartment1.equals("")) {
					keep++;
				} else if (((String) ma.values[16]).contains(storeDepartment1))
					keep++;
				if (storeDepartment2.equals("")) {
					keep++;
				} else if (((String) ma.values[16]).contains(storeDepartment2))
					keep++;
				if (storeDepartment3.equals("")) {
					keep++;
				} else if (((String) ma.values[16]).contains(storeDepartment3))
					keep++;
				if (storeDepartment4.equals("")) {
					keep++;
				} else if (((String) ma.values[16]).contains(storeDepartment4))
					keep++;
				if (storeDepartment5.equals("")) {
					keep++;
				} else if (((String) ma.values[16]).contains(storeDepartment5))
					keep++;
				if (storeDepartment6.equals("")) {
					keep++;
				} else if (((String) ma.values[16]).contains(storeDepartment6))
					keep++;
				if (storeDepartment7.equals("")) {
					keep++;
				} else if (((String) ma.values[16]).contains(storeDepartment7))
					keep++;
				if (storeDepartment8.equals("")) {
					keep++;
				} else if (((String) ma.values[16]).contains(storeDepartment8))
					keep++;
				if (storeDepartment9.equals("")) {
					keep++;
				} else if (((String) ma.values[16]).contains(storeDepartment9))
					keep++;
				if (storeDepartment10.equals("")) {
					keep++;
				} else if (((String) ma.values[16]).contains(storeDepartment10))
					keep++;

				if (storeOwner.equals("")) {
					keep++;
				} else {
					if (storeOwner.equals(ma.values[23])) {
						keep++;
					}
				}
				if (storeConferenceScopus.equals("")) {
					// System.out.println("2");
					// System.out.println("Scopus1 coming");
					keep++;
				} else if (storeConferenceScopus.equals((String) ma.values[8])) {
					// System.out.println("Scopus2 coming");
					keep++;
				}
				// System.out.println(storeConferenceStartMonth + "    " +
				// storeConferenceStartYear);
				if (storeConferenceStartMonth.equals("")
						&& storeConferenceStartYear.equals("")) {
					// System.out.println("date1 coming");
					keep++;
				} else {

					if (referYear(storeConferenceStartYear) <= referYear((String) ma.values[11])
							&& referYear(storeConferenceEndYear) >= referYear((String) ma.values[11])) {
						// System.out.println("coming1");
						if (referYear(storeConferenceStartYear) == referYear((String) ma.values[11])
								&& referYear(storeConferenceStartYear) != referYear(storeConferenceEndYear)) {
							if (referMonth(storeConferenceStartMonth) <= referMonth((String) ma.values[10])) {
								keep++;
							}
						} else if (referYear(storeConferenceEndYear) == referYear((String) ma.values[11])
								&& referYear(storeConferenceStartYear) != referYear(storeConferenceEndYear)) {
							if (referMonth(storeConferenceEndMonth) >= referMonth((String) ma.values[10])) {
								keep++;
							}
						} else if (referYear(storeConferenceStartYear) == referYear(storeConferenceEndYear)
								&& ((referYear(storeConferenceEndYear) == referYear((String) ma.values[11]) || (referYear(storeConferenceStartYear) == referYear((String) ma.values[11]))))) {
							if (referMonth(storeConferenceStartMonth) <= referMonth((String) ma.values[10])
									&& referMonth(storeConferenceEndMonth) >= referMonth((String) ma.values[10]))
								keep++;
						} else {
							// System.out.println("coming12");
							keep++;
						}
					}
				}

				// System.out.println(keep);
				if (keep == 14) {
					ma.values1[i] = new Object[24];
					ma.values1[i] = ma.values;
					i++;
				}
			}

			resultSet.next();
		}
		ConferenceSearchTable.values2 = new Object[i][];
		for (int j = 0; j < i; j++)
			ConferenceSearchTable.values2[j] = ConferenceSearchTable.values1[j];
		System.out.println(ConferenceSearchTable.values2.length);
		return null;
	}

	public int referMonth(String s) {
		// System.out.println(s);
		switch (s) {
		case "January":
			return 1;
		case "February":
			return 2;
		case "March":
			return 3;
		case "April":
			return 4;
		case "May":
			return 5;
		case "June":
			return 6;
		case "July":
			return 7;
		case "August":
			return 8;
		case "September":
			return 9;
		case "October":
			return 10;
		case "November":
			return 11;
		case "December":
			return 12;
		}
		return 0;
	}

	public int referYear(String s) {
		int year = 2000;
		for (; year <= 2030; year++) {
			if (String.valueOf(year).equals(s)) {
				return year;
			}
		}
		return 0;
	}
}
