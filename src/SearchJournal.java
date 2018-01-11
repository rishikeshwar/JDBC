import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchJournal {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public String[] TroubleShoot(String storeAuthor, int storeScopus,
			int storeJournalStartMonth, int storeJournalStartYear,
			int storeJournalEndMonth, int storeJournalEndYear,
			String storeOwner, int storeDepartmentnumber) {
		int i = 0;
		String s[] = new String[10];
		if (storeAuthor.equals("") && storeScopus <= 0
				&& storeJournalStartMonth <= 0 && storeJournalEndMonth <= 0
				&& storeOwner.equals("") && storeDepartmentnumber == 0) {
			s[i++] = "Atleast One Field should be entered";
		}
		if ((storeJournalStartMonth <= 0 && !(storeJournalStartYear <= 0))
				|| (!(storeJournalStartMonth <= 0) && storeJournalStartYear <= 0)) {
			s[i++] = "Starting Month and Year both should be entered";
		}
		if ((storeJournalEndMonth <= 0 && !(storeJournalEndYear <= 0))
				|| (!(storeJournalEndMonth <= 0) && storeJournalEndYear <= 0)) {
			s[i++] = "Ending Month and Year both should be entered";
		}
		s[i] = null;
		return s;
	}

	public JournalApprovalClass check(String storeAuthor,
			String storeJournalScopus, String storeJournalStartMonth,
			String storeJournalStartYear, String storeJournalEndMonth,
			String storeJournalEndYear, String storeOwner,
			String storeDepartment1, String storeDepartment2,
			String storeDepartment3, String storeDepartment4,
			String storeDepartment5, String storeDepartment6,
			String storeDepartment7, String storeDepartment8,
			String storeDepartment9, String storeDepartment10)
			throws SQLException {
		System.out.println("CHECK IS BEING CALLED");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect = DriverManager
				.getConnection("jdbc:sqlserver://LAPTOP-1;databaseName=master;integratedSecurity=true");
		statement = connect.createStatement();
		preparedStatement = connect.prepareStatement("Select * from journal");
		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		int i = 0;
		while (!resultSet.isAfterLast() && resultSet != null) {
			journalSearchTable ma = new journalSearchTable();
			ma.values[0] = resultSet.getString("AUTHOR1");
			ma.values[1] = resultSet.getString("AUTHOR2");
			ma.values[2] = resultSet.getString("AUTHOR3");
			ma.values[3] = resultSet.getString("AUTHOR4");
			ma.values[4] = resultSet.getString("AUTHOR5");
			ma.values[5] = resultSet.getString("AUTHOR6");
			ma.values[6] = resultSet.getString("TITLE");
			ma.values[7] = resultSet.getString("JOURNAL_NAME");
			ma.values[8] = resultSet.getString("SCOPUS");
			ma.values[9] = resultSet.getString("IMPACT_FACTOR");
			ma.values[10] = resultSet.getString("MONTH");
			ma.values[11] = resultSet.getString("YEAR");
			ma.values[12] = resultSet.getString("ISSN/ISBN");
			ma.values[13] = resultSet.getString("DEPARTMENT");
			ma.values[14] = resultSet.getString("NAME_OF_THE_PUBLISHER");
			ma.values[15] = resultSet.getString("VOLUME_ISSUE_PAGE_NUMBER");
			ma.values[16] = resultSet.getString("NAME_BTECH_MTECH");
			ma.values[17] = resultSet.getString("OTHER_DETAILS");
			ma.values[18] = resultSet.getString("ADMIN_APPROVAL");
			ma.values[19] = resultSet.getString("OWNER");
			String s = resultSet.getString("ADMIN_APPROVAL");
			int keep = 0;
			System.out.println("ADMIN = " + s);
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
				if (storeDepartment1.equals("")) {
					keep++;
				} else if (((String) ma.values[13]).contains(storeDepartment1))
					keep++;
				if (storeDepartment2.equals("")) {
					keep++;
				} else if (((String) ma.values[13]).contains(storeDepartment2))
					keep++;
				if (storeDepartment3.equals("")) {
					keep++;
				} else if (((String) ma.values[13]).contains(storeDepartment3))
					keep++;
				if (storeDepartment4.equals("")) {
					keep++;
				} else if (((String) ma.values[13]).contains(storeDepartment4))
					keep++;
				if (storeDepartment5.equals("")) {
					keep++;
				} else if (((String) ma.values[13]).contains(storeDepartment5))
					keep++;
				if (storeDepartment6.equals("")) {
					keep++;
				} else if (((String) ma.values[13]).contains(storeDepartment6))
					keep++;
				if (storeDepartment7.equals("")) {
					keep++;
				} else if (((String) ma.values[13]).contains(storeDepartment7))
					keep++;
				if (storeDepartment8.equals("")) {
					keep++;
				} else if (((String) ma.values[13]).contains(storeDepartment8))
					keep++;
				if (storeDepartment9.equals("")) {
					keep++;
				} else if (((String) ma.values[13]).contains(storeDepartment9))
					keep++;
				if (storeDepartment10.equals("")) {
					keep++;
				} else if (((String) ma.values[13]).contains(storeDepartment10))
					keep++;

				if (storeOwner.equals("")) {
					keep++;
					System.out.println("coming");
				} else {
					if (ma.values[19].equals(storeOwner)) {
						keep++;
					}
				}
				if (storeJournalScopus.equals("")) {
					// System.out.println("2");
					// System.out.println("Scopus1 coming");
					keep++;
				} else if (storeJournalScopus.equals((String) ma.values[8])) {
					// System.out.println("Scopus2 coming");
					keep++;
				}
				// System.out.println(storeJournalStartMonth + "    " +
				// storeJournalStartYear);
				if (storeJournalStartMonth.equals("")
						&& storeJournalStartYear.equals("")) {
					// System.out.println("date1 coming");
					keep++;
				} else {

					if (referYear(storeJournalStartYear) <= referYear((String) ma.values[11])
							&& referYear(storeJournalEndYear) >= referYear((String) ma.values[11])) {
						// System.out.println("coming1");
						if (referYear(storeJournalStartYear) == referYear((String) ma.values[11])
								&& referYear(storeJournalStartYear) != referYear(storeJournalEndYear)) {
							if (referMonth(storeJournalStartMonth) <= referMonth((String) ma.values[10])) {
								keep++;
							}
						} else if (referYear(storeJournalEndYear) == referYear((String) ma.values[11])
								&& referYear(storeJournalStartYear) != referYear(storeJournalEndYear)) {
							if (referMonth(storeJournalEndMonth) >= referMonth((String) ma.values[10])) {
								keep++;
							}
						} else if (referYear(storeJournalStartYear) == referYear(storeJournalEndYear)
								&& ((referYear(storeJournalEndYear) == referYear((String) ma.values[11]) || (referYear(storeJournalStartYear) == referYear((String) ma.values[11]))))) {
							if (referMonth(storeJournalStartMonth) <= referMonth((String) ma.values[10])
									&& referMonth(storeJournalEndMonth) >= referMonth((String) ma.values[10]))
								keep++;
						} else {
							// System.out.println("coming12");
							keep++;
						}
					}
				}
				// System.out.println(storeOwner + "   " + ma.values[17]);
				System.out.println("keep value" + keep);
				if (keep == 14) {
					ma.values1[i] = new Object[20];
					ma.values1[i] = ma.values;
					i++;
				}
			}

			resultSet.next();
		}
		journalSearchTable.values2 = new Object[i][];
		for (int j = 0; j < i; j++)
			journalSearchTable.values2[j] = journalSearchTable.values1[j];
		System.out.println(journalSearchTable.values2.length);
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
