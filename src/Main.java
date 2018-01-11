import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jdesktop.swingx.JXDatePicker;

class authenticityClass {
	String Name;
	String userName;
	String Password;
	String AdminApproval;
	String Role;
};

class accountTable {
	static Object[][] values1 = new Object[200][];
	Object[] values = new Object[5];
	static Object[][] values2 = new Object[200][];
}

class journalTable {
	static Object[][] values1 = new Object[200][];
	Object[] values = new Object[21];
	static Object[][] values2 = new Object[200][];
}

class journalSearchTable {
	static Object[][] values1 = new Object[200][];
	Object[] values = new Object[20];
	static Object[][] values2 = new Object[200][];
}

class JournalApprovalClass {
	String Author1;
	String Author2;
	String Author3;
	String Author4;
	String Author5;
	String Author6;
	String Title;
	String JournalName;
	String Scopus;
	String ImpactFactor;
	String JournalMonth;
	String JournalYear;
	String ISSN;
	String Department;
	String NamePublisher;
	String VolumeIssuePageNo;
	String BtechMtech;
	String OtherDetails;
	String AdminApproval;
	String Owner;
};

class ConferenceApprovalClass {
	String Author1;
	String Author2;
	String Author3;
	String Author4;
	String Author5;
	String Author6;
	String Title;
	String ConferenceName;
	String Scopus;
	String StartDate;
	String StartMonth;
	String StartYear;
	String EndDate;
	String EndMonth;
	String EndYear;
	String ISSN;
	String Department;
	String Venue;
	String NameOfTheOrganiser;
	String ProceedingsPublisher;
	String BtechMtech;
	String OtherDetails;
	String AdminApproval;
	String Owner;
};

class ConferenceTable {
	static Object[][] values1 = new Object[200][];
	Object[] values = new Object[25];
	static Object[][] values2 = new Object[200][];
}

class ConferenceSearchTable {
	static Object[][] values1 = new Object[200][];
	Object[] values = new Object[24];
	static Object[][] values2 = new Object[200][];
}

public class Main extends JFrame implements ActionListener {
	boolean[] conferenceDownloadCri = new boolean[24];
	boolean[] journalDownloadCri = new boolean[20];
	JCheckBox[] journalBoxes = new JCheckBox[20];
	JCheckBox[] conferenceBoxes = new JCheckBox[24];
	// Image logo = getImage("th.png");
	int downloadCriSet = 0;
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JLabel AU;
	private JPanel controlPanel;
	JTable ConferenceAdminApprovalTable;
	JTable journalAdminApprovalTable;
	JTable authenticityTable;
	int scopusCheckingSingleGo = 0;
	int goingJournal = 0;
	int goingConference = 0;
	public boolean go = true;

	public Main() {
		/*
		 * try { for (LookAndFeelInfo info :
		 * UIManager.getInstalledLookAndFeels()) { if
		 * ("Nimbus".equals(info.getName())) {
		 * UIManager.setLookAndFeel(info.getClassName()); break; } } } catch
		 * (Exception e) { // If Nimbus is not available, you can set the GUI to
		 * another look and feel. }
		 */
		try {
			/*
			 * UIManager.setLookAndFeel(
			 * UIManager.getCrossPlatformLookAndFeelClassName());
			 */
			// UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		prepareGUI();
	}

	public static void main(String[] args) throws IOException {
		Main swingControlDemo = new Main();
		swingControlDemo.showTextFieldDemo();
	}

	private void prepareGUI() {
		mainFrame = new JFrame("DATABASE MANAGEMENT");
		mainFrame.setBounds(100, 100, 1025, 600);
		mainFrame.setLayout(null);// new GridLayout(0, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		// headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("sjdhfkhsdfhskjdfh", JLabel.CENTER);
		statusLabel.setBounds(300, 100, 100, 100);
		AU = new JLabel("", JLabel.CENTER);
		// statusLabel1 = new JLabel("", JLabel.CENTER);

		statusLabel.setSize(100, 100);
		AU.setSize(350, 100);

		controlPanel = new JPanel();
		controlPanel.setLayout(null);
		controlPanel.setBounds(0, 0, 1000, 600);
		// controlPanel.setBackground(Color.BLACK);
		// controlPanel.setSize(, arg1);
		// controlPanel.setBackground(Color.BLACK);
		// controlPanel.setLayout(new GridLayout(5,5));

		// mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		// mainFrame.add(statusLabel);
		// mainFrame.add(AU);
		// mainFrame.add(statusLabel1);
		mainFrame.setVisible(true);
	}

	public String sendMonth(String str) {
		if (str.equals("Jan"))
			return "January";
		if (str.equals("Feb"))
			return "February";
		if (str.equals("Mar"))
			return "March";
		if (str.equals("Apr"))
			return "April";
		if (str.equals("May"))
			return "May";
		if (str.equals("Jun"))
			return "June";
		if (str.equals("Jul"))
			return "July";
		if (str.equals("Aug"))
			return "August";
		if (str.equals("Sep"))
			return "September";
		if (str.equals("Oct"))
			return "October";
		if (str.equals("Nov"))
			return "November";
		if (str.equals("Dec"))
			return "December";
		return "Wrong";
	}
	public String menuPerformed(ActionEvent e){
		System.out.println(this.getClass().getSimpleName());
		return null;
	}
	class MenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println(e.getActionCommand());
		}
	}
	@SuppressWarnings("unchecked")
	private void showTextFieldDemo() throws IOException {
		// Image imgo =
		// ImageIO.read(getClass().getResource("data/35594084.jpg"));
		Image imgo1 = ImageIO.read(getClass().getResource("data/amrita.jpg"));
		final Image imgo2 = ImageIO.read(getClass()
				.getResource("data/gogo.jpg"));
		Image imgo3 = ImageIO.read(getClass().getResource(
				"data/theloginpage4.png"));
		final Image imgo4 = ImageIO.read(getClass().getResource(
				"data/downarrow.gif"));
		final Image imgo5 = ImageIO.read(getClass().getResource(
				"data/home.png"));
		// ImageIcon imagei = new ImageIcon(imgo);
		ImageIcon imagei1 = new ImageIcon(imgo1);
		ImageIcon imagei2 = new ImageIcon(imgo2);
		ImageIcon theLoginPage1 = new ImageIcon(imgo3);
		final ImageIcon backIcon = new ImageIcon(imgo5);
		final JLabel mainBack = new JLabel(imagei2);
		mainBack.setBounds(0, 0, 1125, 600);
		JLabel amrita = new JLabel(imagei1);
		// mainBack.
		controlPanel.add(mainBack);
		// controlPanel.setBackground(Color.CYAN);
		// headerLabel.setText("Control in action: JTextField");

		final JLabel userLabel = new JLabel("USERNAME: ", JLabel.RIGHT);
		final JLabel passwordLabel = new JLabel("PASSWORD: ", JLabel.RIGHT);
		final JTextField userText = new JTextField(6);
		final JPasswordField passwordText = new JPasswordField(6);
		final JLabel nameLabel = new JLabel("Name: ", JLabel.LEFT);
		final JTextField nameText = new JTextField(6);
		final JLabel startMonthLabel = new JLabel("StartMonth: ", JLabel.CENTER);
		final JTextField startMonthText = new JTextField(6);
		final JLabel endMonthLabel = new JLabel("EndMonth: ", JLabel.CENTER);
		final JTextField endMonthText = new JTextField(6);
		final JLabel yearLabel = new JLabel("Year: ", JLabel.CENTER);
		final JTextField yearText = new JTextField(6);
		final JLabel nameSignupLabel = new JLabel("Enter Name :       ",
				JLabel.CENTER);
		final JLabel usernameSignupLabel = new JLabel(
				"Enter Username :       ", JLabel.CENTER);
		final JLabel passwordSignupLabel = new JLabel(
				"Enter Password :       ", JLabel.CENTER);
		final JTextField nameSignupTextField = new JTextField(6);
		final JTextField usernameSignupTextField = new JTextField(6);
		final JPasswordField passowordSignupTextField = new JPasswordField(6);
		final String[] conferenceColumns = { "Author1", "Author2", "Author3",
				"Author4", "Author5", "Author6", "Title", "ConferenceName",
				"Scopus", "StartDate", "StartMonth", "StartYear", "EndDate",
				"EndMonth", "EndYear", "ISSN/ISBN", "Department", "Venue",
				"NameOrganiser", "ProceedingsPublisher", "BtechMtech",
				"OtherDetails", "Approval", "PUBLICATION CATEGORY" };
		final String[] conferenceApprovalColumns = { "Author1", "Author2",
				"Author3", "Author4", "Author5", "Author6", "Title",
				"ConferenceName", "Scopus", "ScopusOnlineCheck", "StartDate",
				"StartMonth", "StartYear", "EndDate", "EndMonth", "EndYear",
				"ISSN/ISBN", "Department", "Venue", "NameOrganiser",
				"ProceedingsPublisher", "BtechMtech", "OtherDetails",
				"Approval", "PUBLICATION CATEGORY" };
		final String[] journalColumns = { "Author1", "Author2", "Author3",
				"Author4", "Author5", "Author6", "Title", "JournalName",
				"Scopus", "ImpactFactor", "JournalMonth", "JournalYear",
				"ISSN/ISBN", "Department", "NamePublisher",
				"VolumeIssuePageNo", "BtechMtech", "OtherDetails", "Approval",
				"PUBLICATION CATEGORY" };
		final String[] journalApprovalColumns = { "Author1", "Author2",
				"Author3", "Author4", "Author5", "Author6", "Title",
				"JournalName", "Scopus", "ScopusOnlineCheck", "ImpactFactor",
				"JournalMonth", "JournalYear", "ISSN/ISBN", "Department",
				"NamePublisher", "VolumeIssuePageNo", "BtechMtech",
				"OtherDetails", "Approval", "PUBLICATION CATEGORY" };
		final String[] authenticityColumns = { "Name", "Username", "Password",
				"Approval", "Role" };
		String s = "";
		for (int i = 0; i < 10; i++) {
			s += " ";
		}
		final JLabel[] space1 = new JLabel[30];
		for (int i = 0; i < 30; i++) {
			space1[i] = new JLabel(s, JLabel.CENTER);
		}
		final JTextField userApprovedEnterAuthor1 = new JTextField(6);
		final JTextField userApprovedEnterAuthor2 = new JTextField(6);
		final JTextField userApprovedEnterAuthor3 = new JTextField(6);
		final JTextField userApprovedEnterAuthor4 = new JTextField(6);
		final JTextField userApprovedEnterAuthor5 = new JTextField(6);
		final JTextField userApprovedEnterAuthor6 = new JTextField(6);
		final JTextField userApprovedEnterTitle = new JTextField(6);
		final JTextField userApprovedEnterJournalName = new JTextField(6);
		// final JTextField userApprovedEnterScopus = new JTextField(6);
		final JTextField userApprovedEnterImpactFactor = new JTextField(6);
		final JTextField userApprovedEnterNamePublisher = new JTextField(6);
		final JTextField userApprovedEnterISSN = new JTextField(6);
		final JTextField userApprovedEnterVolumeIssuePageNo = new JTextField(6);
		final JTextField userApprovedEnterBtechMtech = new JTextField(6);
		final JTextField userApprovedEnterBtechMtech1 = new JTextField(6);
		final JTextField userApprovedEnterOtherDetails = new JTextField(6);
		final JTextField userApprovedEnterVenue = new JTextField(6);
		final JTextField userApprovedEnterProceedingsPublisher = new JTextField(
				6);
		final JTextField userApprovedEnterConferenceName = new JTextField(6);
		final JTextField userApprovedEnterNameOfTheOrganiser = new JTextField(6);
		final JTextField userApprovedEnterAmount = new JTextField(6);

		final JButton loginButton = new JButton("Login");
		final JButton addButton = new JButton("AddField");
		final JButton removeButton = new JButton("RemoveField");
		final JButton add2Button = new JButton("ADD");
		final JButton mainLoginButton = new JButton("Login");
		final JButton mainSignupButton = new JButton("SignUp");
		final JButton signupButton = new JButton("SignUp");
		final JButton adminAccountNext = new JButton("Next");
		final JComboBox OWNER = new JComboBox();
		OWNER.addItem("SELECT");
		OWNER.addItem("PH.D Scholar");
		OWNER.addItem("PG Student");
		OWNER.addItem("UG Student");
		OWNER.addItem("FACULTY");
		/*
		 * final String[] str = {"CSE","ECE","EIE","EEE","MECH"}; final JList
		 * journalDepartmentList = new JList(str); final JList
		 * conferenceDepartmentList = new JList(str);
		 */
		final JCheckBox Department1 = new JCheckBox("CSE", false);
		final JCheckBox Department2 = new JCheckBox("ECE", false);
		final JCheckBox Department3 = new JCheckBox("EEE", false);
		final JCheckBox Department4 = new JCheckBox("EIE", false);
		final JCheckBox Department5 = new JCheckBox("MECH", false);
		final JCheckBox Department6 = new JCheckBox("MATHS", false);
		final JCheckBox Department7 = new JCheckBox("PHY", false);
		final JCheckBox Department8 = new JCheckBox("CHEM", false);
		final JCheckBox Department9 = new JCheckBox("HUMANI", false);
		final JCheckBox Department10 = new JCheckBox("OTHERS", false);
		final JComboBox authenticityBox = new JComboBox();
		authenticityBox.addItem("SELECT");
		authenticityBox.addItem("ADMIN");
		authenticityBox.addItem("FACULTY");
		authenticityBox.addItem("GUEST");
		authenticityBox.addItem("STUDENT");

		final JComboBox journalMonth = new JComboBox();
		journalMonth.addItem("SelectMonth");
		journalMonth.addItem("January");
		journalMonth.addItem("February");
		journalMonth.addItem("March");
		journalMonth.addItem("April");
		journalMonth.addItem("May");
		journalMonth.addItem("June");
		journalMonth.addItem("July");
		journalMonth.addItem("August");
		journalMonth.addItem("September");
		journalMonth.addItem("October");
		journalMonth.addItem("November");
		journalMonth.addItem("December");
		final JComboBox journalYear = new JComboBox();
		journalYear.addItem("SelectYear");
		for (int i = 2000; i <= 2030; i++) {
			journalYear.addItem(String.valueOf(i));
		}
		final JComboBox userApprovedEnterScopus = new JComboBox();
		userApprovedEnterScopus.addItem("Select");
		userApprovedEnterScopus.addItem("Y");
		userApprovedEnterScopus.addItem("N");

		final JComboBox ConferenceStartMonth = new JComboBox();
		ConferenceStartMonth.addItem("SelectMonth");
		ConferenceStartMonth.addItem("January");
		ConferenceStartMonth.addItem("February");
		ConferenceStartMonth.addItem("March");
		ConferenceStartMonth.addItem("April");
		ConferenceStartMonth.addItem("May");
		ConferenceStartMonth.addItem("June");
		ConferenceStartMonth.addItem("July");
		ConferenceStartMonth.addItem("August");
		ConferenceStartMonth.addItem("September");
		ConferenceStartMonth.addItem("October");
		ConferenceStartMonth.addItem("November");
		ConferenceStartMonth.addItem("December");
		final JComboBox ConferenceStartYear = new JComboBox();
		ConferenceStartYear.addItem("SelectYear");
		for (int i = 2000; i <= 2030; i++) {
			ConferenceStartYear.addItem(String.valueOf(i));
		}
		final JComboBox ConferenceStartDate = new JComboBox();
		ConferenceStartDate.addItem("SelectDate");
		for (int i = 1; i <= 31; i++) {
			ConferenceStartDate.addItem(String.valueOf(i));
		}

		final JComboBox ConferenceEndMonth = new JComboBox();
		ConferenceEndMonth.addItem("SelectMonth");
		ConferenceEndMonth.addItem("January");
		ConferenceEndMonth.addItem("February");
		ConferenceEndMonth.addItem("March");
		ConferenceEndMonth.addItem("April");
		ConferenceEndMonth.addItem("May");
		ConferenceEndMonth.addItem("June");
		ConferenceEndMonth.addItem("July");
		ConferenceEndMonth.addItem("August");
		ConferenceEndMonth.addItem("September");
		ConferenceEndMonth.addItem("October");
		ConferenceEndMonth.addItem("November");
		ConferenceEndMonth.addItem("December");
		final JComboBox ConferenceEndYear = new JComboBox();
		ConferenceEndYear.addItem("SelectYear");
		for (int i = 2000; i <= 2030; i++) {
			ConferenceEndYear.addItem(String.valueOf(i));
		}
		final JComboBox ConferenceEndDate = new JComboBox();
		ConferenceEndDate.addItem("SelectDate");
		for (int i = 1; i <= 31; i++) {
			ConferenceEndDate.addItem(String.valueOf(i));
		}

		final JButton conferenceDownload = new JButton("Download");

		String s1 = new String("");
		for (int i = 0; i < 500; i++)
			s1 += " ";
		final JLabel[] line = new JLabel[15];
		for (int i = 0; i < 15; i++)
			line[i] = new JLabel(s1, JLabel.CENTER);
		String s2 = new String("");
		for (int i = 0; i < 42; i++) {
			s2 += " ";
		}
		final JLabel[] space = new JLabel[20];
		for (int i = 0; i < 20; i++) {
			space[i] = new JLabel(s2, JLabel.CENTER);
		}
		final JLabel lblHeading = new JLabel(
				"AMRITA PUBLICATION MANAGEMENT SYSTEM");
		lblHeading.setFont(new Font("Castellar", Font.BOLD, 30));
		lblHeading.setBounds(100, 11, 900, 78);
		lblHeading.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				// img.setImage((img.getImage().getScaledInstance(10 + 10,
				// 11,Image.SCALE_SMOOTH)));
				lblHeading.setBounds(100 - 70, 11, 900 + 140, 78);
				lblHeading.setFont(new Font("Castellar", Font.BOLD, 35));
				// mainLoginButton.setBackground(Color.orange);
				// btnBack.setBackground(Color.BLACK);
				// button.setIcon(icon1);
			}

			public void mouseExited(MouseEvent evt) {
				lblHeading.setBounds(100, 11, 900, 78);
				lblHeading.setFont(new Font("Castellar", Font.BOLD, 30));
			}
		});
		
		

		mainBack.add(lblHeading);
		/*
		 * mainLoginButton.setUI(new CustomizedButtonUI(Color.RED, Color.ORANGE,
		 * Color.GREEN));
		 */
		final JLabel theloginPage1Label = new JLabel(theLoginPage1);
		theloginPage1Label.setBounds(0, 0, 1125, 600);
		// controlPanel.add(theloginPage1Label);
		mainLoginButton.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		mainLoginButton.setBounds(310, 200, 100, 50);
		mainLoginButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				// img.setImage((img.getImage().getScaledInstance(10 + 10,
				// 11,Image.SCALE_SMOOTH)));
				mainLoginButton
						.setBounds(310 - 10, 200 - 10, 100 + 20, 50 + 20);
				mainLoginButton
						.setFont(new Font("Snap ITC", Font.PLAIN, 20 + 5));
				// mainLoginButton.setBackground(Color.orange);
				// btnBack.setBackground(Color.BLACK);
				// button.setIcon(icon1);
			}

			public void mouseExited(MouseEvent evt) {
				mainLoginButton.setBounds(310, 200, 100, 50);
				mainLoginButton.setFont(new Font("Snap ITC", Font.PLAIN, 20));
				mainLoginButton.setBackground(null);
			}
		});
		// mainLoginButton.setBackground(Color.cyan);
		mainSignupButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		mainSignupButton.setBounds(610, 200, 100, 50);
		mainSignupButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				// img.setImage((img.getImage().getScaledInstance(10 + 10,
				// 11,Image.SCALE_SMOOTH)));
				mainSignupButton.setBounds(610 - 10, 200 - 10, 100 + 20,
						50 + 20);
				mainSignupButton.setFont(new Font("Snap ITC", Font.PLAIN, 20));
			}

			public void mouseExited(MouseEvent evt) {
				mainSignupButton.setBounds(610, 200, 100, 50);
				mainSignupButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
			}
		});
		mainFrame.add(mainLoginButton);
		mainBack.add(mainLoginButton);
		controlPanel.add(space[0]);
		mainBack.add(mainSignupButton);
		controlPanel.repaint();
		mainFrame.revalidate();
		mainFrame.repaint();
		// controlPanel.add(addButton);
		mainFrame.setVisible(true);
		class MyListener implements ActionListener {

			private int buttonNum;

			MyListener(int buttonNum) {

				this.buttonNum = buttonNum;

			}

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				switch (buttonNum) {
				case 50:{
					System.out.println("coming");
					//System.out.println(this.getClass().getL);
					System.out.println((e.getSource()).getClass().getSimpleName());
					System.out.println((e.getSource()).getClass().getCanonicalName());
					
				}break;
				case 1: {
					controlPanel.remove(mainLoginButton);
					controlPanel.remove(space[0]);
					controlPanel.remove(mainSignupButton);
					controlPanel.removeAll();
					controlPanel.add(theloginPage1Label);
					/*
					 * try { UIManager.setLookAndFeel(
					 * UIManager.getSystemLookAndFeelClassName()); } catch
					 * (ClassNotFoundException | InstantiationException |
					 * IllegalAccessException | UnsupportedLookAndFeelException
					 * e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */
					JLabel lblHeading = new JLabel(
							"AMRITA PUBLICATION MANAGEMENT");
					lblHeading.setForeground(Color.DARK_GRAY);
					lblHeading.setFont(new Font("Castellar", Font.BOLD, 25));
					lblHeading.setBounds(220, 80, 900, 78);

					JLabel loginLabel = new JLabel("Login");
					loginLabel.setFont(new Font("Footlight MT Light",
							Font.BOLD, 20));
					loginLabel.setBounds(608, 107, 50, 50);
					theloginPage1Label.add(loginLabel);
					JLabel simpleLoginGif = new JLabel();
					ImageIcon ii = new ImageIcon(imgo4);
					simpleLoginGif.setIcon(ii);
					simpleLoginGif.setBounds(670, 107, 50, 50);
					theloginPage1Label.add(simpleLoginGif);
					// theloginPage1Label.add(lblHeading);
					userLabel.setFont(new Font("Footlight MT Light",
							Font.PLAIN, 20));
					userLabel.setBounds(270, 180, 180, 34);
					passwordLabel.setFont(new Font("Footlight MT Light",
							Font.PLAIN, 20));
					passwordLabel.setBounds(270, 280, 180, 34);

					userText.setBounds(340, 220, 310, 25);
					userText.setColumns(10);
					passwordText.setColumns(10);
					passwordText.setBounds(340, 320, 310, 25);
					JLabel forgotPassword = new JLabel("Forgot Password ?");
					loginButton.setFont(new Font("Arial", Font.BOLD, 15));
					forgotPassword.setBounds(350, 390, 200, 20);

					loginButton.setBounds(520, 380, 100, 40);
					loginButton.setFont(new Font("Arial", Font.BOLD, 14));
					theloginPage1Label.add(userLabel);
					theloginPage1Label.add(passwordLabel);
					theloginPage1Label.add(userText);
					theloginPage1Label.add(passwordText);
					theloginPage1Label.add(loginButton);
					theloginPage1Label.add(forgotPassword);
					
					JButton backLocal = new JButton("  Back");
					backLocal.setIcon(backIcon);
					
					backLocal.setBounds(10, 11, 104, 34);
					theloginPage1Label.add(backLocal);
					controlPanel.revalidate();
					controlPanel.repaint();
				}
					break;
				case 2: {
					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					controlPanel.add(adminAcceptBack);
					adminAcceptBack.addActionListener(new MyListener(1));
					controlPanel.remove(mainLoginButton);
					controlPanel.remove(space[0]);
					controlPanel.remove(mainSignupButton);
					controlPanel.add(line[0]);
					controlPanel.removeAll();
					controlPanel.add(adminAcceptBack);
					JLabel topic = new JLabel("Enter Details To Signup");
					topic.setHorizontalAlignment(SwingConstants.CENTER);
					topic.setFont(new Font("Castellar", Font.BOLD, 30));
					topic.setBounds(100, 11, 800, 78);
					controlPanel.add(topic);

					JLabel lblEndYear = new JLabel("ENTER NAME:");
					lblEndYear.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblEndYear.setBounds(423, 120, 160, 34);
					nameSignupTextField.setColumns(10);
					nameSignupTextField.setBounds(423, 149, 160, 20);
					controlPanel.add(lblEndYear);
					controlPanel.add(nameSignupTextField);
					controlPanel.add(line[1]);
					controlPanel.add(theloginPage1Label);

					JLabel label = new JLabel("ENTER USERNAME:");
					label.setFont(new Font("Arial Black", Font.PLAIN, 12));
					label.setBounds(423, 219, 160, 34);
					usernameSignupTextField.setColumns(10);
					usernameSignupTextField.setBounds(423, 248, 160, 20);
					controlPanel.add(label);
					controlPanel.add(usernameSignupTextField);
					controlPanel.add(line[2]);

					JLabel label_1 = new JLabel("ENTER PASSWORD:");
					label_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
					label_1.setBounds(423, 317, 160, 34);
					passowordSignupTextField.setColumns(10);
					passowordSignupTextField.setBounds(423, 346, 160, 20);
					controlPanel.add(label_1);
					controlPanel.add(passowordSignupTextField);

					signupButton
							.setFont(new Font("Arial Black", Font.BOLD, 12));
					signupButton.setBounds(423, 446, 160, 50);
					controlPanel.add(signupButton);
					// signupButton.addActionListener(new MyListener(7));
					controlPanel.revalidate();
					controlPanel.repaint();

				}
					break;
				case 3: {

					controlPanel.removeAll();
					JButton adminAcceptBack = new JButton("BACK");
					// btnBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					// frame.getContentPane().add(btnBack);
					controlPanel.add(adminAcceptBack);
					authenticityClass c = new authenticityClass();
					MySQLAccess m = new MySQLAccess();
					try {
						c = m.enteringAuthen(userText.getText());
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(passwordText.getText() + " "
							+ c.Password);
					System.out.println(c.Role);
					if (passwordText.getText().equals(c.Password)) {
						// controlPanel.removeAll();
						if (c.Role != null && c.Role.equals("ADMIN")) {
							JButton adminAcceptAccount = new JButton(
									"APPROVE USERS");
							JButton adminAcceptJournal = new JButton(
									"APPROVE JOURNAL");
							JButton adminAcceptConference = new JButton(
									"APPROVE CONFERENCE");
							JButton adminAcceptSearching = new JButton(
									"SEARCH RECORDS");
							controlPanel.removeAll();

							String s = "";
							for (int i = 0; i < 420; i++)
								s += " ";
							controlPanel.add(new JLabel(s));
							for (int i = 0; i < 1; i++)
								controlPanel.add(line[i]);
							// btnAcceptUser = new JButton("APPROVE USER");
							adminAcceptAccount.setFont(new Font("Arial",
									Font.BOLD, 15));
							adminAcceptAccount.setBounds(353, 117, 278, 50);
							// frame.getContentPane().add(btnAcceptUser);

							// adminAcceptJournal = new
							// JButton("APPROVE JOURNAL");
							adminAcceptJournal.setFont(new Font("Arial",
									Font.BOLD, 15));
							adminAcceptJournal.setBounds(353, 375, 278, 50);
							// frame.getContentPane().add(btnAcceptJournal);

							// btnSearchRecords = new JButton("SEARCH RECORDS");
							adminAcceptSearching.setFont(new Font("Arial",
									Font.BOLD, 15));
							adminAcceptSearching.setBounds(353, 203, 278, 50);
							// frame.getContentPane().add(btnSearchRecords);

							// btnApproveConference = new
							// JButton("APPROVE CONFERENCE");
							adminAcceptConference.setFont(new Font("Arial",
									Font.BOLD, 15));
							adminAcceptConference.setBounds(353, 289, 278, 50);
							// frame.getContentPane().add(btnApproveConference);
							controlPanel.add(adminAcceptAccount);
							controlPanel.add(line[5]);
							controlPanel.add(adminAcceptJournal);
							controlPanel.add(line[6]);
							controlPanel.add(adminAcceptConference);
							controlPanel.add(line[7]);
							controlPanel.add(adminAcceptSearching);
							controlPanel.revalidate();
							controlPanel.repaint();
							adminAcceptAccount
									.addActionListener(new MyListener(8));
							adminAcceptJournal
									.addActionListener(new MyListener(9));
							adminAcceptConference
									.addActionListener(new MyListener(10));
							adminAcceptSearching
									.addActionListener(new MyListener(17));
							adminAcceptBack
									.addActionListener(new MyListener(1));

						} else if (c.AdminApproval.equals("YES")
								&& passwordText.getText().equals(c.Password)) {

							// controlPanel.removeAll();

							String s = "";
							for (int i = 0; i < 400; i++)
								s += " ";
							controlPanel.add(new JLabel(s));

							controlPanel.add(line[0]);
							controlPanel.add(line[1]);
							JButton userApprovedJournal = new JButton(
									"ADD JOURNAL DATA");
							JButton userApprovedConference = new JButton(
									"ADD CONFERENCE DATA");
							userApprovedJournal.setFont(new Font("Arial",
									Font.BOLD, 15));
							userApprovedJournal.setBounds(353, 117, 278, 50);

							userApprovedConference.setFont(new Font("Arial",
									Font.BOLD, 15));
							userApprovedConference.setBounds(353, 243, 278, 50);
							controlPanel.add(new JLabel("         "));
							controlPanel.add(userApprovedJournal);
							controlPanel.add(new JLabel("             "));
							controlPanel.add(userApprovedConference);

							userApprovedJournal
									.addActionListener(new MyListener(13));
							userApprovedConference
									.addActionListener(new MyListener(14));

						} else {
							JOptionPane.showMessageDialog(null,
									"ADMIN APPROVAL PENDING");
							JLabel adminApp = new JLabel(
									"ADMIN APPROVAL PENDING", JLabel.CENTER);
							controlPanel.add(line[0]);
							controlPanel.add(line[1]);
							controlPanel.add(line[2]);
							controlPanel.add(line[3]);
							controlPanel.add(adminApp);
							controlPanel.revalidate();
							controlPanel.repaint();
						}
					} else {

						JOptionPane.showMessageDialog(null,
								"INCORRECT USERNAME OR PASSWORD");
					}
					controlPanel.add(adminAcceptBack);
					adminAcceptBack.addActionListener(new MyListener(1));
					controlPanel.revalidate();
					controlPanel.repaint();

					String authenticity = null;
					AU.setText(authenticity);
					mainFrame.add(AU);
				}
					break; // login with username and password, handles admin
							// seperately and others seperately
				case 4: {

					controlPanel.remove(addButton);
					controlPanel.remove(removeButton);

					controlPanel.revalidate();
					controlPanel.repaint();
					controlPanel.add(nameLabel);
					controlPanel.add(nameText);
					controlPanel.add(startMonthLabel);
					controlPanel.add(startMonthText);
					controlPanel.add(endMonthLabel);
					controlPanel.add(endMonthText);
					controlPanel.add(yearLabel);
					controlPanel.add(yearText);
					mainFrame.remove(AU);
					mainFrame.remove(statusLabel);
					mainFrame.repaint();
					controlPanel.add(add2Button);
				}
					break;
				case 5: {

					remove(removeButton);
					controlPanel.remove(removeButton);
					// AU.setText("Bangalore");
					mainFrame.add(AU);
				}
					break;
				case 6: {
					AU.setText("Field Added");
					MySQLAccess m = new MySQLAccess();
					try {
						m.readPublicationDataBase(nameText.getText(),
								startMonthText.getText(),
								endMonthText.getText(), yearText.getText());
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					controlPanel.remove(nameLabel);
					controlPanel.remove(nameText);
					controlPanel.remove(startMonthLabel);
					controlPanel.remove(startMonthText);
					controlPanel.remove(endMonthLabel);
					controlPanel.remove(endMonthText);
					controlPanel.remove(yearLabel);
					controlPanel.remove(yearText);
					controlPanel.remove(add2Button);
					controlPanel.add(addButton);
					controlPanel.add(removeButton);
					controlPanel.repaint();
					mainFrame.add(AU);
					mainFrame.repaint();
				}
					break;
				case 7: {
					controlPanel.removeAll();
					controlPanel.add(line[0]);
					controlPanel.add(line[1]);
					controlPanel.add(line[2]);
					controlPanel.add(line[3]);
					JButton adminAcceptBack = new JButton("BACK");
					// btnBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					// frame.getContentPane().add(btnBack);
					// adminAcceptBack.addActionListener(new MyListener(1));
					controlPanel.add(adminAcceptBack);
					if (nameSignupTextField.getText().equals("")
							|| usernameSignupTextField.getText().equals("")
							|| passowordSignupTextField.getText().equals("")) {
						controlPanel.removeAll();
						controlPanel.add(adminAcceptBack);
						JOptionPane.showMessageDialog(null,
								"All Fields are mandatory");
						adminAcceptBack.addActionListener(new MyListener(2));
						controlPanel.revalidate();
						controlPanel.repaint();

					} else {
						JLabel temp142 = new JLabel(
								"Signed Up Successfully Wait for Admins Approval",
								JLabel.CENTER);
						controlPanel.add(temp142);
						controlPanel.revalidate();
						controlPanel.repaint();
						MySQLAccess m = new MySQLAccess();
						String s1 = new String(nameSignupTextField.getText());
						String s2 = new String(
								usernameSignupTextField.getText());
						String s3 = new String(
								passowordSignupTextField.getText());
						boolean k = true;
						try {
							k = m.TroubleShoot(usernameSignupTextField
									.getText());
						} catch (ClassNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						if (k == true) {
							try {
								System.out.println("coming1");
								m.authenticity(s1, s2, s3);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							adminAcceptBack
									.addActionListener(new MyListener(1));
							JOptionPane
									.showMessageDialog(null,
											"SignedUp Successfully wait for admin approval");
						} else {
							adminAcceptBack
									.addActionListener(new MyListener(2));
							JOptionPane.showMessageDialog(null,
									"USERNAME already Exist");

						}
					}

				}
					break;
				case 8: {
					authenticityClass ac = new authenticityClass();
					AccountApproval aa = new AccountApproval();
					try {
						aa.adminApprovalAccountApproval();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					controlPanel.removeAll();
					DefaultTableModel model = new DefaultTableModel(
							accountTable.values2, authenticityColumns);
					authenticityTable = new JTable(model);

					authenticityTable
							.setPreferredScrollableViewportSize(new Dimension(
									1200, 100));
					authenticityTable.setFillsViewportHeight(true);
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
					centerRenderer
							.setHorizontalAlignment(SwingConstants.CENTER);
					System.out.println(authenticityTable.getColumnCount());
					TableColumn column = null;
					for (int i = 0; i <= 4; i++) {
						column = authenticityTable.getColumnModel()
								.getColumn(i);
						column.setMinWidth(200);
						column.setCellRenderer(centerRenderer);

					}

					JComboBox comboBox = new JComboBox();
					comboBox.addItem("NO");
					comboBox.addItem("YES");
					JComboBox comboBox1 = new JComboBox();
					comboBox1.addItem("ADMIN");
					comboBox1.addItem("FACULTY");
					comboBox1.addItem("STUDENT");
					comboBox1.addItem("GUEST");
					for (int i = 0; i < authenticityTable.getRowCount(); i++) {
						authenticityTable.getColumnModel().getColumn(3)
								.setCellEditor(new DefaultCellEditor(comboBox));
						authenticityTable
								.getColumnModel()
								.getColumn(4)
								.setCellEditor(new DefaultCellEditor(comboBox1));
					}
					controlPanel.add(line[0]);
					JScrollPane scrollPane = new JScrollPane(authenticityTable,
							JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
							JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setBounds(118, 90, 770, 363);

					authenticityTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					controlPanel.add(scrollPane);

					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(3));
					JButton journalApprovalButton = new JButton("APPROVE");
					journalApprovalButton.setFont(new Font("Arial", Font.BOLD,
							20));
					journalApprovalButton.setBounds(388, 474, 230, 46);
					journalApprovalButton.addActionListener(new MyListener(11));
					controlPanel.add(journalApprovalButton);
					controlPanel.add(adminAcceptBack);

					// Back.addActionListener(new MyListener(3));
					controlPanel.revalidate();
					controlPanel.repaint();

				}
					break; // adminAcceptAccount
				case 9: {
					controlPanel.removeAll();
					JournalApprovalClass JAC = new JournalApprovalClass();
					JournalApproval JA = new JournalApproval();

					try {
						JA.adminApprovalJournalApproval();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					DefaultTableModel model = new DefaultTableModel(
							journalTable.values2, journalApprovalColumns);
					journalAdminApprovalTable = new JTable(model);

					journalAdminApprovalTable
							.setPreferredScrollableViewportSize(new Dimension(
									1200, 100));
					journalAdminApprovalTable.setFillsViewportHeight(true);
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
					centerRenderer
							.setHorizontalAlignment(SwingConstants.CENTER);
					System.out.println(journalAdminApprovalTable
							.getColumnCount());
					TableColumn column = null;
					for (int i = 0; i <= 20; i++) {
						column = journalAdminApprovalTable.getColumnModel()
								.getColumn(i);
						column.setMinWidth(100);
						column.setCellRenderer(centerRenderer);
						if (i == 9) {
							column.setMinWidth(150);
						}
						if (i == 19) {
							column.setMinWidth(40);
						} else if (i == 20) {
							column.setMinWidth(150);
						}
					}

					JComboBox comboBox = new JComboBox();
					comboBox.addItem("NO");
					comboBox.addItem("YES");
					JComboBox comboBox1 = new JComboBox();
					comboBox1.addItem("PH.D Scholar");
					comboBox1.addItem("PG Student");
					comboBox1.addItem("UG Student");
					comboBox1.addItem("FACULTY");
					JComboBox comboBox2 = new JComboBox();
					comboBox2.addItem("YES");
					comboBox2.addItem("NO");
					JCheckBox justkeep = new JCheckBox();
					for (int i = 0; i < journalAdminApprovalTable.getRowCount(); i++) {
						journalAdminApprovalTable
								.getColumnModel()
								.getColumn(9)
								.setCellEditor(new DefaultCellEditor(comboBox2));
						journalAdminApprovalTable.getColumnModel()
								.getColumn(19)
								.setCellEditor(new DefaultCellEditor(comboBox));
						journalAdminApprovalTable
								.getColumnModel()
								.getColumn(20)
								.setCellEditor(new DefaultCellEditor(comboBox1));
					}
					controlPanel.add(line[0]);
					JScrollPane scrollPane = new JScrollPane(
							journalAdminApprovalTable,
							JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
							JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setBounds(118, 90, 770, 363);

					journalAdminApprovalTable
							.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					controlPanel.add(scrollPane);
					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(3));
					JButton journalApprovalButton = new JButton("APPROVE");
					journalApprovalButton.setFont(new Font("Arial", Font.BOLD,
							20));
					journalApprovalButton.setBounds(250, 474, 230, 46);
					JButton journalScopusApprovalButton = new JButton(
							"SCOPUS CHECK");
					journalScopusApprovalButton.setFont(new Font("Arial",
							Font.BOLD, 20));
					journalScopusApprovalButton.setBounds(520, 474, 230, 46);
					scopusCheckingSingleGo = 0;
					journalApprovalButton.addActionListener(new MyListener(24));
					journalScopusApprovalButton
							.addActionListener(new MyListener(26));
					controlPanel.add(journalScopusApprovalButton);
					controlPanel.add(journalApprovalButton);

					controlPanel.add(adminAcceptBack);
					controlPanel.revalidate();
					controlPanel.repaint();

				}
					break; // adminAcceptJournal
				case 10: {
					controlPanel.removeAll();

					ConferenceApprovalClass JAC = new ConferenceApprovalClass();
					ConferenceApproval JA = new ConferenceApproval();
					JButton Back = new JButton("BACK");
					controlPanel.add(Back);
					String s = "";
					for (int i = 0; i < 420; i++)
						s += " ";
					controlPanel.add(new JLabel(s));

					try {
						JA.adminApprovalConferenceApproval();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					DefaultTableModel model = new DefaultTableModel(
							ConferenceTable.values2, conferenceApprovalColumns);
					ConferenceAdminApprovalTable = new JTable(model);

					ConferenceAdminApprovalTable
							.setPreferredScrollableViewportSize(new Dimension(
									1200, 100));
					ConferenceAdminApprovalTable.setFillsViewportHeight(true);
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
					centerRenderer
							.setHorizontalAlignment(SwingConstants.CENTER);
					TableColumn column = null;
					for (int i = 0; i <= 24; i++) {
						column = ConferenceAdminApprovalTable.getColumnModel()
								.getColumn(i);
						column.setMinWidth(130);
						column.setCellRenderer(centerRenderer);
						if (i == 9) {
							column.setMinWidth(150);
						}
						if (i == 23) {
							column.setMinWidth(40);
						}
						if (i == 24) {
							column.setMinWidth(150);
						}

					}

					JComboBox comboBox = new JComboBox();
					comboBox.addItem("NO");
					comboBox.addItem("YES");
					JComboBox comboBox1 = new JComboBox();
					comboBox1.addItem("PH.D Scholar");
					comboBox1.addItem("PG Student");
					comboBox1.addItem("UG Student");
					comboBox1.addItem("FACULTY");
					JComboBox comboBox2 = new JComboBox();
					comboBox2.addItem("NO");
					comboBox2.addItem("YES");
					for (int i = 0; i < ConferenceAdminApprovalTable
							.getRowCount(); i++) {
						ConferenceAdminApprovalTable
								.getColumnModel()
								.getColumn(9)
								.setCellEditor(new DefaultCellEditor(comboBox2));
						ConferenceAdminApprovalTable.getColumnModel()
								.getColumn(23)
								.setCellEditor(new DefaultCellEditor(comboBox));
						ConferenceAdminApprovalTable
								.getColumnModel()
								.getColumn(24)
								.setCellEditor(new DefaultCellEditor(comboBox1));
					}
					controlPanel.add(line[0]);
					JScrollPane scrollPane = new JScrollPane(
							ConferenceAdminApprovalTable,
							JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
							JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setBounds(118, 90, 770, 363);

					ConferenceAdminApprovalTable
							.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					controlPanel.add(scrollPane);
					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(3));
					JButton conferenceApprovalButton = new JButton("APPROVE");
					conferenceApprovalButton.setFont(new Font("Arial",
							Font.BOLD, 20));
					conferenceApprovalButton.setBounds(250, 474, 230, 46);
					JButton conferenceScopusApprovalButton = new JButton(
							"SCOPUS CHECK");
					conferenceScopusApprovalButton.setFont(new Font("Arial",
							Font.BOLD, 20));
					conferenceScopusApprovalButton.setBounds(520, 474, 230, 46);
					scopusCheckingSingleGo = 0;
					conferenceApprovalButton.addActionListener(new MyListener(
							25));
					scopusCheckingSingleGo = 1;
					conferenceScopusApprovalButton
							.addActionListener(new MyListener(26));
					controlPanel.add(conferenceScopusApprovalButton);
					controlPanel.add(conferenceApprovalButton);
					controlPanel.add(adminAcceptBack);
					controlPanel.revalidate();
					controlPanel.repaint();

				}
					break; // adminAcceptConference
				case 11: {
					controlPanel.removeAll();
					AccountApproval aa = new AccountApproval();
					String s[] = new String[500];
					String s1[] = new String[500];
					int run = 0;
					for (int i = 0; i < authenticityTable.getRowCount(); i++) {
						if (authenticityTable.getModel().getValueAt(i, 3)
								.equals("YES")) {
							String go = "";
							if (!authenticityTable.getModel().getValueAt(i, 4)
									.equals("SELECT")) {
								go += (String) authenticityTable.getModel()
										.getValueAt(i, 4);
								s1[run] = go;
							}
							s[run++] = (String) authenticityTable.getModel()
									.getValueAt(i, 1);
							System.out.println(s[run - 1]);
						}
					}
					s[run] = null;
					try {
						aa.Approval(s, s1);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Approval Successfull");
					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(3));
					controlPanel.add(adminAcceptBack);
					controlPanel.add(line[0]);
					controlPanel.add(line[1]);
					controlPanel.add(new JLabel("APPROVED"));
					controlPanel.revalidate();
					controlPanel.repaint();

				}
					break; // adminAcceptAccountApprove
				case 12: {
					AccountApproval aa = new AccountApproval();
					if (aa.resultSet != null)
						try {
							aa.adminApprovalAccountRejectionRemoveOUT();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					controlPanel.removeAll();
					for (int i = 0; i < 5; i++) {
						controlPanel.add(line[i]);
					}
					controlPanel.add(new JLabel("Removed Successfully",
							JLabel.CENTER));
					controlPanel.add(line[6]);
					controlPanel.add(adminAccountNext);
					controlPanel.revalidate();
					controlPanel.repaint();

				}
					break; // adminAcceptAccountReject
				case 13: {
					controlPanel.removeAll();
					goingJournal = 1;
					JComboBox b = new JComboBox();
					JLabel lblHeading = new JLabel("JOURNAL DETAILS");
					lblHeading.setFont(new Font("Castellar", Font.BOLD, 30));
					lblHeading.setBounds(330, 11, 900, 78);
					controlPanel.add(lblHeading);
					JLabel lblUsername = new JLabel("AUTHOR 1:");
					lblUsername
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblUsername.setBounds(70, 90, 160, 34);
					userApprovedEnterAuthor1.setBounds(70, 120, 160, 20);
					userApprovedEnterAuthor1.setColumns(10);
					controlPanel.add(lblUsername);
					controlPanel.add(userApprovedEnterAuthor1);

					JLabel lblAuthor = new JLabel("AUTHOR 2:");
					lblAuthor.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor.setBounds(70, 160, 160, 34);
					userApprovedEnterAuthor2.setColumns(10);
					userApprovedEnterAuthor2.setBounds(70, 190, 160, 20);
					controlPanel.add(lblAuthor);
					controlPanel.add(userApprovedEnterAuthor2);

					JLabel lblAuthor_1 = new JLabel("AUTHOR 3:");
					lblAuthor_1
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_1.setBounds(70, 240, 160, 34);
					userApprovedEnterAuthor3.setColumns(10);
					userApprovedEnterAuthor3.setBounds(70, 270, 160, 20);
					controlPanel.add(lblAuthor_1);
					controlPanel.add(userApprovedEnterAuthor3);
					controlPanel.add(space1[20]);

					JLabel lblAuthor_2 = new JLabel("AUTHOR 4:");
					lblAuthor_2
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_2.setBounds(70, 320, 160, 34);
					userApprovedEnterAuthor4.setColumns(10);
					userApprovedEnterAuthor4.setBounds(70, 350, 160, 20);
					controlPanel.add(lblAuthor_2);
					controlPanel.add(userApprovedEnterAuthor4);

					JLabel lblAuthor_3 = new JLabel("AUTHOR 5:");
					lblAuthor_3
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_3.setBounds(70, 400, 160, 34);
					userApprovedEnterAuthor5.setColumns(10);
					userApprovedEnterAuthor5.setBounds(70, 430, 160, 20);
					controlPanel.add(lblAuthor_3);
					controlPanel.add(userApprovedEnterAuthor5);

					JLabel lblAuthor_4 = new JLabel("AUTHOR 6:");
					lblAuthor_4
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_4.setBounds(70, 480, 160, 34);
					userApprovedEnterAuthor6.setColumns(10);
					userApprovedEnterAuthor6.setBounds(70, 510, 160, 20);
					controlPanel.add(lblAuthor_4);
					controlPanel.add(userApprovedEnterAuthor6);

					JMenuBar menuBar = new JMenuBar();
					;
					JMenu menu;
					JMenuItem menuItem;
					
					menu = new JMenu("->");
					menu.setMnemonic(KeyEvent.VK_A);
					menuBar.add(menu);

					JMenu subMenu1[] = new JMenu[3];
					JMenuItem menuItem1[][] = new JMenuItem[3][10];
					String tempo[] = { "CSE", "ECE", "EEE", "PHY", "HUMANI",
							"EIE", "MECH", "MATHS", "CHEM", "OTHERS" };
					for (int j = 0; j < 3; j++) {
						if(j == 0){
							subMenu1[j] = new JMenu("Faculty");
							subMenu1[j].setName("GOT");
							subMenu1[j].setText("FACULTY");
							//subMenu1[j].addActionListener(new MyListener(50));
						}else if(j == 1){
							subMenu1[j] = new JMenu("UG Student");
						}else {
							subMenu1[j] = new JMenu("PG Student");
						}
						for (int i = 0; i < 10; i++) {
							menuItem1[j][i] = new JMenuItem(tempo[i]);
							menuItem1[j][i].setName("came");
							//menuItem1[j][i].addActionListener(new MyListener(50));
							subMenu1[j].add(menuItem1[j][i]);
						}
						menu.add(subMenu1[j]);
					}
					MenuItemListener mi = new MenuItemListener();
					
					subMenu1[0].addActionListener(this);
					//menuItem1[0][0].addActionListener(new MyListener(50));
					menuBar.setBounds(250, 100, 50, 20);
					controlPanel.add(menuBar);

					JLabel lblTitle = new JLabel("TITLE:");
					lblTitle.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblTitle.setBounds(443, 90, 160, 34);
					userApprovedEnterTitle.setColumns(10);
					userApprovedEnterTitle.setBounds(443, 120, 160, 20);
					controlPanel.add(lblTitle);
					controlPanel.add(userApprovedEnterTitle);

					JLabel lblJournalName = new JLabel("JOURNAL NAME:");
					lblJournalName.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					lblJournalName.setBounds(443, 160, 160, 34);
					userApprovedEnterJournalName.setColumns(10);
					userApprovedEnterJournalName.setBounds(443, 190, 160, 20);
					controlPanel.add(lblJournalName);
					controlPanel.add(userApprovedEnterJournalName);

					JLabel lblScopusIndex = new JLabel("SCOPUS INDEX:");
					lblScopusIndex.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					lblScopusIndex.setBounds(443, 240, 160, 34);
					userApprovedEnterScopus.setBounds(443, 270, 160, 20);
					controlPanel.add(lblScopusIndex);
					controlPanel.add(userApprovedEnterScopus);

					JLabel lblImpactFactor = new JLabel("IMPACT FACTOR:");
					lblImpactFactor.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					lblImpactFactor.setBounds(443, 320, 160, 34);
					userApprovedEnterImpactFactor.setColumns(10);
					userApprovedEnterImpactFactor.setBounds(443, 350, 160, 20);
					controlPanel.add(lblImpactFactor);
					controlPanel.add(userApprovedEnterImpactFactor);

					JLabel lblMonth = new JLabel("MONTH:");
					lblMonth.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblMonth.setBounds(443, 400, 160, 34);
					journalMonth.setBounds(443, 430, 160, 20);
					controlPanel.add(lblMonth);
					controlPanel.add(journalMonth);

					JLabel lblYear = new JLabel("YEAR:");
					lblYear.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblYear.setBounds(443, 480, 160, 40);
					journalYear.setBounds(443, 510, 160, 20);
					controlPanel.add(lblYear);
					controlPanel.add(journalYear);

					JLabel ISSNLabel = new JLabel("ISSN/ISBN:");
					ISSNLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
					ISSNLabel.setBounds(797, 90, 180, 34);
					userApprovedEnterISSN.setColumns(10);
					userApprovedEnterISSN.setBounds(797, 120, 190, 20);
					controlPanel.add(userApprovedEnterISSN);
					controlPanel.add(ISSNLabel);

					JLabel labelDepartment = new JLabel("DEPARTMENTS INVOLVED");
					labelDepartment.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					labelDepartment.setBounds(797, 160, 180, 34);
					Department1.setBounds(657, 190, 49, 20);
					Department2.setBounds(717, 190, 49, 20);
					Department3.setBounds(777, 190, 49, 20);
					Department4.setBounds(657, 220, 49, 20);
					Department5.setBounds(717, 220, 63, 20);
					Department6.setBounds(777, 220, 68, 20);
					Department7.setBounds(847, 190, 63, 20);
					Department8.setBounds(847, 220, 63, 20);
					Department9.setBounds(907, 190, 70, 20);
					Department10.setBounds(907, 220, 74, 20);
					controlPanel.add(labelDepartment);
					controlPanel.add(Department1);
					controlPanel.add(Department2);
					controlPanel.add(Department3);
					controlPanel.add(Department4);
					controlPanel.add(Department5);
					controlPanel.add(Department6);
					controlPanel.add(Department7);
					controlPanel.add(Department8);
					controlPanel.add(Department9);
					controlPanel.add(Department10);

					JLabel namePublishLabel = new JLabel(
							"NAME OF THE PUBLISHER:");
					namePublishLabel.setFont(new Font("Arial Black",
							Font.PLAIN, 12));
					namePublishLabel.setBounds(797, 240, 180, 34);
					userApprovedEnterNamePublisher.setColumns(10);
					userApprovedEnterNamePublisher.setBounds(797, 270, 190, 20);
					controlPanel.add(namePublishLabel);
					controlPanel.add(userApprovedEnterNamePublisher);

					JLabel label_1 = new JLabel("VOLUME,ISSUE,PAGENO:");
					label_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
					label_1.setBounds(797, 320, 180, 34);
					userApprovedEnterVolumeIssuePageNo.setColumns(10);
					userApprovedEnterVolumeIssuePageNo.setBounds(797, 350, 160,
							20);
					controlPanel.add(label_1);
					controlPanel.add(userApprovedEnterVolumeIssuePageNo);

					JLabel label_2 = new JLabel("Btech/Mtech INVOLED NAME:");
					label_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
					label_2.setBounds(797, 400, 200, 34);
					userApprovedEnterBtechMtech.setColumns(10);
					userApprovedEnterBtechMtech.setBounds(797, 430, 160, 20);
					controlPanel.add(label_2);
					controlPanel.add(userApprovedEnterBtechMtech);

					JLabel label_3 = new JLabel("OTHER DETAILS:");
					label_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
					label_3.setBounds(797, 480, 160, 40);
					userApprovedEnterOtherDetails.setBounds(797, 510, 160, 20);
					userApprovedEnterOtherDetails.setColumns(10);
					// userApprovedEnterOtherDetails.setBounds(797, 430, 160,
					// 20);
					controlPanel.add(space1[22]);
					controlPanel.add(label_3);
					controlPanel.add(userApprovedEnterOtherDetails);

					// JButton JournalEnter = new
					// JButton("Enter into database");
					JButton JournalEnter = new JButton("ADD JOURNAL");
					JournalEnter
							.setFont(new Font("Arial Black", Font.BOLD, 12));
					JournalEnter.setBounds(744, 25, 230, 46);
					controlPanel.add(JournalEnter);

					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(3));
					controlPanel.add(adminAcceptBack);

					JournalEnter.addActionListener(new MyListener(15));
					controlPanel.revalidate();
					controlPanel.repaint();
				} // userApprovedJournal
					break;
				case 14: {
					controlPanel.removeAll();
					goingConference = 1;
					JComboBox b = new JComboBox();
					JLabel lblHeading = new JLabel("CONFERENCE DETAILS");
					lblHeading.setFont(new Font("Castellar", Font.BOLD, 30));
					lblHeading.setBounds(310, 11, 900, 78);
					controlPanel.add(lblHeading);

					JLabel lblUsername = new JLabel("AUTHOR 1:");
					lblUsername
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblUsername.setBounds(26, 90, 160, 34);
					userApprovedEnterAuthor1.setBounds(26, 120, 160, 20);
					userApprovedEnterAuthor1.setColumns(10);
					controlPanel.add(lblUsername);
					controlPanel.add(userApprovedEnterAuthor1);

					JLabel lblAuthor = new JLabel("AUTHOR 2:");
					lblAuthor.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor.setBounds(26, 160, 160, 34);
					userApprovedEnterAuthor2.setColumns(10);
					userApprovedEnterAuthor2.setBounds(26, 190, 160, 20);
					controlPanel.add(lblAuthor);
					controlPanel.add(userApprovedEnterAuthor2);

					JLabel lblAuthor_1 = new JLabel("AUTHOR 3:");
					lblAuthor_1
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_1.setBounds(26, 240, 160, 34);
					userApprovedEnterAuthor3.setColumns(10);
					userApprovedEnterAuthor3.setBounds(26, 270, 160, 20);
					controlPanel.add(lblAuthor_1);
					controlPanel.add(userApprovedEnterAuthor3);

					JLabel lblAuthor_2 = new JLabel("AUTHOR 4:");
					lblAuthor_2
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_2.setBounds(26, 320, 160, 34);
					userApprovedEnterAuthor4.setColumns(10);
					userApprovedEnterAuthor4.setBounds(26, 350, 160, 20);
					controlPanel.add(space1[2]);
					controlPanel.add(lblAuthor_2);
					controlPanel.add(userApprovedEnterAuthor4);

					JLabel lblAuthor_3 = new JLabel("AUTHOR 5:");
					lblAuthor_3
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_3.setBounds(26, 400, 160, 34);
					userApprovedEnterAuthor5.setColumns(10);
					userApprovedEnterAuthor5.setBounds(26, 430, 160, 20);
					controlPanel.add(lblAuthor_3);
					controlPanel.add(userApprovedEnterAuthor5);

					JLabel lblAuthor_4 = new JLabel("AUTHOR 6:");
					lblAuthor_4
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_4.setBounds(26, 480, 160, 34);
					userApprovedEnterAuthor6.setColumns(10);
					userApprovedEnterAuthor6.setBounds(26, 510, 160, 20);
					controlPanel.add(lblAuthor_4);
					controlPanel.add(userApprovedEnterAuthor6);

					JLabel lblTitle = new JLabel("TITLE:");
					lblTitle.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblTitle.setBounds(281, 90, 160, 34);
					userApprovedEnterTitle.setColumns(10);
					userApprovedEnterTitle.setBounds(281, 120, 160, 20);
					controlPanel.add(lblTitle);
					controlPanel.add(userApprovedEnterTitle);

					JLabel lblJournalName = new JLabel("CONFERENCE NAME:");
					lblJournalName.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					lblJournalName.setBounds(281, 160, 160, 34);
					userApprovedEnterConferenceName.setColumns(10);
					userApprovedEnterConferenceName
							.setBounds(281, 190, 160, 20);
					controlPanel.add(lblJournalName);
					controlPanel.add(userApprovedEnterConferenceName);

					JLabel lblScopusIndex = new JLabel("SCOPUS INDEX:");
					lblScopusIndex.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					lblScopusIndex.setBounds(281, 240, 160, 34);
					userApprovedEnterScopus.setBounds(281, 270, 160, 20);
					controlPanel.add(lblScopusIndex);
					controlPanel.add(userApprovedEnterScopus);

					JLabel lblImpactFactor = new JLabel("START DATE:");
					lblImpactFactor.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					lblImpactFactor.setBounds(281, 320, 160, 34);
					ConferenceStartDate.setBounds(281, 350, 160, 20);
					controlPanel.add(lblImpactFactor);
					// controlPanel.add(ConferenceStartDate);

					/*
					 * JLabel lblMonth = new JLabel("START MONTH:");
					 * lblMonth.setFont(new Font("Arial Black", Font.PLAIN,
					 * 12)); lblMonth.setBounds(281, 400, 160, 34);
					 * ConferenceStartMonth.setBounds(281, 430, 160, 20);
					 * controlPanel.add(lblMonth);
					 * controlPanel.add(ConferenceStartMonth);
					 */

					final JXDatePicker picker = new JXDatePicker();
					picker.setDate(Calendar.getInstance().getTime());
					picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
					picker.setBounds(281, 350, 160, 20);
					controlPanel.add(picker);
					picker.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							System.out.println(picker.getDate());
							System.out.println(picker.getDate().getDate());
							ConferenceStartDate.setSelectedIndex(picker
									.getDate().getDate());
							ConferenceStartMonth.setSelectedIndex(picker
									.getDate().getMonth() + 1);
							ConferenceStartYear.setSelectedIndex(picker
									.getDate().getYear());
						}

					});

					/*
					 * JLabel lblYear = new JLabel("START YEAR:");
					 * lblYear.setFont(new Font("Arial Black", Font.PLAIN, 12));
					 * lblYear.setBounds(281, 480, 160, 34);
					 * ConferenceStartYear.setBounds(281, 510, 160, 20);
					 * controlPanel.add(lblYear);
					 * controlPanel.add(ConferenceStartYear);
					 */

					JLabel lblEndDate = new JLabel("END DATE:");
					lblEndDate.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblEndDate.setBounds(541, 90, 160, 34);
					ConferenceEndDate.setBounds(541, 120, 160, 20);
					controlPanel.add(lblEndDate);
					// controlPanel.add(ConferenceEndDate);

					JLabel lblEndMonth = new JLabel("Cost");
					lblEndMonth
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblEndMonth.setBounds(541, 160, 160, 34);
					userApprovedEnterAmount.setBounds(541, 190, 160, 20);
					controlPanel.add(lblEndMonth);
					controlPanel.add(userApprovedEnterAmount);

					final JXDatePicker picker1 = new JXDatePicker();
					picker1.setDate(Calendar.getInstance().getTime());
					picker1.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
					picker1.setBounds(541, 120, 160, 20);
					controlPanel.add(picker1);
					picker1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							System.out.println(picker1.getDate());
							System.out.println(picker1.getDate().getDate());
							ConferenceEndDate.setSelectedIndex(picker1
									.getDate().getDate());
							ConferenceEndMonth.setSelectedIndex(picker1
									.getDate().getMonth() + 1);
							ConferenceEndYear.setSelectedIndex(picker1
									.getDate().getYear());
						}

					});

					/*
					 * JLabel lblEndYear = new JLabel("END YEAR:");
					 * lblEndYear.setFont(new Font("Arial Black", Font.PLAIN,
					 * 12)); lblEndYear.setBounds(541, 240, 160, 34);
					 * ConferenceEndYear.setBounds(541, 270, 160, 20);
					 * controlPanel.add(lblEndYear);
					 * controlPanel.add(ConferenceEndYear);
					 */

					JLabel lblIssnisbn = new JLabel("ISSN/ISBN:");
					lblIssnisbn
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblIssnisbn.setBounds(541, 320, 160, 34);
					userApprovedEnterISSN.setColumns(10);
					userApprovedEnterISSN.setBounds(541, 350, 160, 20);
					controlPanel.add(lblIssnisbn);
					controlPanel.add(userApprovedEnterISSN);

					JLabel lblVenue = new JLabel("VENUE:");
					lblVenue.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblVenue.setBounds(541, 400, 160, 34);
					userApprovedEnterVenue.setColumns(10);
					userApprovedEnterVenue.setBounds(541, 430, 160, 20);
					controlPanel.add(lblVenue);
					controlPanel.add(userApprovedEnterVenue);

					JLabel lblNameOfThe = new JLabel("NAME OF THE ORGANIZER:");
					lblNameOfThe
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblNameOfThe.setBounds(541, 480, 196, 34);
					userApprovedEnterNameOfTheOrganiser.setColumns(10);
					userApprovedEnterNameOfTheOrganiser.setBounds(541, 510,
							160, 20);
					controlPanel.add(lblNameOfThe);
					controlPanel.add(userApprovedEnterNameOfTheOrganiser);
					JLabel labelDepartment = new JLabel("DEPARTMENTS INVOLVED");
					labelDepartment.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					labelDepartment.setBounds(808, 90, 176, 34);
					Department1.setBounds(820, 120, 60, 20);
					Department2.setBounds(820, 140, 60, 20);
					Department3.setBounds(820, 160, 60, 20);
					Department4.setBounds(820, 180, 60, 20);
					Department5.setBounds(820, 200, 60, 20);
					Department6.setBounds(900, 120, 80, 20);
					Department7.setBounds(900, 140, 80, 20);
					Department8.setBounds(900, 160, 80, 20);
					Department9.setBounds(900, 180, 80, 20);
					Department10.setBounds(900, 200, 80, 20);
					controlPanel.add(labelDepartment);
					controlPanel.add(Department1);
					controlPanel.add(Department2);
					controlPanel.add(Department3);
					controlPanel.add(Department4);
					controlPanel.add(Department5);
					controlPanel.add(Department6);
					controlPanel.add(Department7);
					controlPanel.add(Department8);
					controlPanel.add(Department9);
					controlPanel.add(Department10);
					JLabel lblProceedingsPublisher = new JLabel(
							"Proceedings Publisher:");
					lblProceedingsPublisher.setFont(new Font("Arial Black",
							Font.PLAIN, 12));
					lblProceedingsPublisher.setBounds(808, 240, 176, 34);
					userApprovedEnterProceedingsPublisher.setColumns(10);
					userApprovedEnterProceedingsPublisher.setBounds(808, 270,
							160, 20);
					controlPanel.add(lblProceedingsPublisher);
					controlPanel.add(userApprovedEnterProceedingsPublisher);

					JLabel lblBtechmtechInvolvedName = new JLabel(
							"Btech/Mtech Involved Name:");
					lblBtechmtechInvolvedName.setFont(new Font("Arial Black",
							Font.PLAIN, 12));
					lblBtechmtechInvolvedName.setBounds(798, 320, 186, 34);
					userApprovedEnterBtechMtech.setColumns(10);
					userApprovedEnterBtechMtech.setBounds(808, 350, 160, 20);
					controlPanel.add(lblBtechmtechInvolvedName);
					controlPanel.add(userApprovedEnterBtechMtech);

					JLabel lblOtherDetails = new JLabel("OTHER DETAILS:");
					lblOtherDetails.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					lblOtherDetails.setBounds(808, 400, 160, 34);
					userApprovedEnterOtherDetails.setColumns(10);
					userApprovedEnterOtherDetails.setBounds(808, 430, 160, 20);
					controlPanel.add(lblOtherDetails);
					controlPanel.add(userApprovedEnterOtherDetails);

					JButton ConferenceEnter = new JButton("Enter Conference");
					ConferenceEnter.setFont(new Font("Arial Black", Font.BOLD,
							15));
					ConferenceEnter.setBounds(744, 460, 230, 46);
					controlPanel.add(ConferenceEnter);
					ConferenceEnter.addActionListener(new MyListener(16));

					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(3));
					controlPanel.add(adminAcceptBack);

					controlPanel.revalidate();
					controlPanel.repaint();

				}// userApprovedConference
					break;
				case 15: {
					controlPanel.removeAll();
					String storeAuthor1 = userApprovedEnterAuthor1.getText();
					String storeAuthor2 = userApprovedEnterAuthor2.getText();
					String storeAuthor3 = userApprovedEnterAuthor3.getText();
					String storeAuthor4 = userApprovedEnterAuthor4.getText();
					String storeAuthor5 = userApprovedEnterAuthor5.getText();
					String storeAuthor6 = userApprovedEnterAuthor6.getText();
					String storeTitle = userApprovedEnterTitle.getText();
					String storeJournalName = userApprovedEnterJournalName
							.getText();
					String storeISSN = userApprovedEnterISSN.getText();
					String storeScopus = "";
					if (userApprovedEnterScopus.getSelectedIndex() > 0) {
						storeScopus = (String) userApprovedEnterScopus
								.getItemAt(userApprovedEnterScopus
										.getSelectedIndex());
					}
					String DepartmentTemp = "";
					if (Department1.isSelected()) {
						DepartmentTemp += Department1.getText() + ",";

					}
					if (Department2.isSelected()) {
						DepartmentTemp += Department2.getText() + ",";

					}
					if (Department3.isSelected()) {
						DepartmentTemp += Department3.getText() + ",";

					}
					if (Department4.isSelected()) {
						DepartmentTemp += Department4.getText() + ",";

					}
					if (Department5.isSelected()) {
						DepartmentTemp += Department5.getText() + ",";
					}
					if (Department6.isSelected()) {
						DepartmentTemp += Department6.getText() + ",";
					}
					if (Department7.isSelected()) {
						DepartmentTemp += Department7.getText() + ",";
					}
					if (Department8.isSelected()) {
						DepartmentTemp += Department8.getText() + ",";
					}
					if (Department9.isSelected()) {
						DepartmentTemp += Department9.getText() + ",";
					}
					if (Department10.isSelected()) {
						DepartmentTemp += Department10.getText() + ",";
					}
					// DepartmentTemp -= ",";
					if (!DepartmentTemp.equals("")) {
						DepartmentTemp = DepartmentTemp.substring(0,
								DepartmentTemp.length() - 1);
					}
					System.out.println(DepartmentTemp);
					// String storeScopus = userApprovedEnterScopus.getText();
					String storeImpactFactor = userApprovedEnterImpactFactor
							.getText();
					String storeMonth = "";
					if (journalMonth.getSelectedIndex() > 0) {
						storeMonth = (String) journalMonth
								.getItemAt(journalMonth.getSelectedIndex());
					}
					String storeYear = "";
					if (journalYear.getSelectedIndex() > 0) {
						storeYear = (String) journalYear.getItemAt(journalYear
								.getSelectedIndex());
					}
					String storeNamePublisher = userApprovedEnterNamePublisher
							.getText();
					String storeVolumeIssuePageNo = userApprovedEnterVolumeIssuePageNo
							.getText();
					String storeBtechMtech = userApprovedEnterBtechMtech
							.getText();
					String storeOtherDetails = userApprovedEnterOtherDetails
							.getText()
							+ ", "
							+ userApprovedEnterAmount.getText();
					TroubleshootJournal tj = new TroubleshootJournal();
					String[] keeps = null;
					try {
						keeps = tj.check(storeAuthor1, storeAuthor2,
								storeAuthor3, storeAuthor4, storeAuthor5,
								storeAuthor6, storeTitle, storeJournalName,
								storeScopus, storeImpactFactor, storeMonth,
								storeYear, storeISSN, storeNamePublisher,
								storeVolumeIssuePageNo, storeBtechMtech,
								storeOtherDetails);
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if (keeps[0] != null) {
						controlPanel.removeAll();
						int i = 0;
						String outError = new String("<html>");
						for (i = 0; keeps[i] != null; i++) {
							outError += "<br>";
							outError += keeps[i];
							controlPanel.add(new JLabel(keeps[i]));
							controlPanel.add(line[i]);
						}
						outError += "</html>";
						System.out.println("joption");
						JOptionPane.showMessageDialog(null, outError);
						JButton adminJournalSearchEnter = new JButton(
								"Get Back");
						JButton adminAcceptBack = new JButton("BACK");
						adminAcceptBack.setFont(new Font("Arial", Font.PLAIN,
								15));
						adminAcceptBack.setBounds(10, 11, 104, 34);
						adminAcceptBack.addActionListener(new MyListener(13));
						controlPanel.add(adminAcceptBack);

					} else {
						JournalApproval JA = new JournalApproval();
						try {
							JA.readPublicationDataBase(storeAuthor1,
									storeAuthor2, storeAuthor3, storeAuthor4,
									storeAuthor5, storeAuthor6, storeTitle,
									storeJournalName, storeScopus,
									storeImpactFactor, storeMonth, storeYear,
									storeISSN, DepartmentTemp,
									storeNamePublisher, storeVolumeIssuePageNo,
									storeBtechMtech, storeOtherDetails);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						for (int i = 0; i < 4; i++) {
							controlPanel.add(line[i]);
						}
						controlPanel
								.add(new JLabel(
										"Journal Entered into Database Wait for Admins Approval"));
						JOptionPane
								.showMessageDialog(null,
										"Journal Entered into Database Wait for Admins Approval");
						JButton adminAcceptBack = new JButton("BACK");
						adminAcceptBack.setFont(new Font("Arial", Font.PLAIN,
								15));
						adminAcceptBack.setBounds(10, 11, 104, 34);
						adminAcceptBack.addActionListener(new MyListener(3));
						controlPanel.add(adminAcceptBack);
					}

					controlPanel.revalidate();
					controlPanel.repaint();
				}// userApprovedJournalEnterDatabase
					break;
				case 16: {
					controlPanel.removeAll();
					String storeAuthor1 = userApprovedEnterAuthor1.getText();
					String storeAuthor2 = userApprovedEnterAuthor2.getText();
					String storeAuthor3 = userApprovedEnterAuthor3.getText();
					String storeAuthor4 = userApprovedEnterAuthor4.getText();
					String storeAuthor5 = userApprovedEnterAuthor5.getText();
					String storeAuthor6 = userApprovedEnterAuthor6.getText();
					String storeTitle = userApprovedEnterTitle.getText();
					String storeConferenceName = userApprovedEnterConferenceName
							.getText();
					String storeISSN = userApprovedEnterISSN.getText();
					// String storeScopus = userApprovedEnterScopus.getText();
					String storeScopus = "";
					if (userApprovedEnterScopus.getSelectedIndex() > 0) {
						storeScopus = (String) userApprovedEnterScopus
								.getItemAt(userApprovedEnterScopus
										.getSelectedIndex());
					}
					String storeVenue = userApprovedEnterVenue.getText();
					String storeStartDate = "";
					if (ConferenceStartDate.getSelectedIndex() > 0) {
						storeStartDate = (String) ConferenceStartDate
								.getItemAt(ConferenceStartDate
										.getSelectedIndex());
					}
					String storeStartMonth = "";
					if (ConferenceStartMonth.getSelectedIndex() > 0) {
						storeStartMonth = (String) ConferenceStartMonth
								.getItemAt(ConferenceStartMonth
										.getSelectedIndex());
					}
					String storeStartYear = "";
					if (ConferenceStartYear.getSelectedIndex() > 0) {
						storeStartYear = (String) ConferenceStartYear
								.getItemAt(ConferenceStartYear
										.getSelectedIndex());
					}
					String storeEndDate = "";
					if (ConferenceEndDate.getSelectedIndex() > 0) {
						storeEndDate = (String) ConferenceEndDate
								.getItemAt(ConferenceEndDate.getSelectedIndex());
					}
					String storeEndMonth = "";
					if (ConferenceEndMonth.getSelectedIndex() > 0) {
						storeEndMonth = (String) ConferenceEndMonth
								.getItemAt(ConferenceEndMonth
										.getSelectedIndex());
					}
					String storeEndYear = "";
					if (ConferenceEndYear.getSelectedIndex() > 0) {
						storeEndYear = (String) ConferenceEndYear
								.getItemAt(ConferenceEndYear.getSelectedIndex());
					}

					String DepartmentTemp = "";
					if (Department1.isSelected()) {
						DepartmentTemp += Department1.getText() + ",";

					}
					if (Department2.isSelected()) {
						DepartmentTemp += Department2.getText() + ",";

					}
					if (Department3.isSelected()) {
						DepartmentTemp += Department3.getText() + ",";

					}
					if (Department4.isSelected()) {
						DepartmentTemp += Department4.getText() + ",";

					}
					if (Department5.isSelected()) {
						DepartmentTemp += Department5.getText() + ",";
					}
					if (Department6.isSelected()) {
						DepartmentTemp += Department6.getText() + ",";
					}
					if (Department7.isSelected()) {
						DepartmentTemp += Department7.getText() + ",";
					}
					if (Department8.isSelected()) {
						DepartmentTemp += Department8.getText() + ",";
					}
					if (Department9.isSelected()) {
						DepartmentTemp += Department9.getText() + ",";
					}
					if (Department10.isSelected()) {
						DepartmentTemp += Department10.getText() + ",";
					}
					// DepartmentTemp -= ",";
					if (!DepartmentTemp.equals("")) {
						DepartmentTemp = DepartmentTemp.substring(0,
								DepartmentTemp.length() - 1);
					}

					String storeProceedingsPublisher = userApprovedEnterProceedingsPublisher
							.getText();
					String storeNameOfTheOrganiser = userApprovedEnterNameOfTheOrganiser
							.getText();
					String storeBtechMtech = userApprovedEnterBtechMtech
							.getText();
					String storeOtherDetails = userApprovedEnterOtherDetails
							.getText();
					TroubleshootConference tc = new TroubleshootConference();
					String[] keeps = null;
					try {
						keeps = tc.check(storeAuthor1, storeAuthor2,
								storeAuthor3, storeAuthor4, storeAuthor5,
								storeAuthor6, storeTitle, storeConferenceName,
								storeScopus, storeStartDate, storeStartMonth,
								storeStartYear, storeEndDate, storeEndMonth,
								storeEndYear, storeVenue,
								storeNameOfTheOrganiser,
								storeProceedingsPublisher, storeBtechMtech,
								storeOtherDetails);
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if (keeps[0] != null) {
						int i = 0;
						String outError = new String("<html>");
						for (i = 0; keeps[i] != null; i++) {
							outError += "<br>";
							outError += keeps[i];
							controlPanel.add(new JLabel(keeps[i]));
							controlPanel.add(line[i]);
						}
						outError += "</html>";
						System.out.println("joption");
						JOptionPane.showMessageDialog(null, outError);
						JButton adminJournalSearchEnter = new JButton(
								"Get Back");
						JButton adminAcceptBack = new JButton("BACK");
						adminAcceptBack.setFont(new Font("Arial", Font.PLAIN,
								15));
						adminAcceptBack.setBounds(10, 11, 104, 34);
						adminAcceptBack.addActionListener(new MyListener(14));
						controlPanel.add(adminAcceptBack);

					} else {
						ConferenceApproval JA = new ConferenceApproval();
						try {
							JA.readPublicationDataBase(storeAuthor1,
									storeAuthor2, storeAuthor3, storeAuthor4,
									storeAuthor5, storeAuthor6, storeTitle,
									storeConferenceName, storeScopus,
									storeStartDate, storeStartMonth,
									storeStartYear, storeEndDate,
									storeEndMonth, storeEndYear, storeISSN,
									DepartmentTemp, storeVenue,
									storeNameOfTheOrganiser,
									storeProceedingsPublisher, storeBtechMtech,
									storeOtherDetails);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						for (int i = 0; i < 4; i++) {
							controlPanel.add(line[i]);
						}
						controlPanel
								.add(new JLabel(
										"Conference Entered into Database Wait for Admins Approval"));
						JOptionPane
								.showMessageDialog(null,
										"Conference Entered into Database Wait for Admins Approval");
						JButton adminAcceptBack = new JButton("BACK");
						adminAcceptBack.setFont(new Font("Arial", Font.PLAIN,
								15));
						adminAcceptBack.setBounds(10, 11, 104, 34);
						adminAcceptBack.addActionListener(new MyListener(3));
						controlPanel.add(adminAcceptBack);
					}
					controlPanel.revalidate();
					controlPanel.repaint();
				}// userApprovedConferenceEnterDatabase
					break;
				case 17: {
					controlPanel.removeAll();
					JButton Back = new JButton("BACK");
					controlPanel.add(Back);
					String s = "";
					for (int i = 0; i < 420; i++)
						s += " ";
					controlPanel.add(new JLabel(s));
					JButton userAdminSearchJournal = new JButton("JOURNAL");
					JButton userAdminSearchConference = new JButton(
							"CONFERENCE");
					controlPanel.add(line[0]);
					controlPanel.add(line[1]);

					userAdminSearchJournal.setFont(new Font("Arial Black",
							Font.BOLD, 15));
					userAdminSearchJournal.setBounds(353, 174, 278, 50);
					controlPanel.add(userAdminSearchJournal);
					userAdminSearchConference.setFont(new Font("Arial Black",
							Font.BOLD, 15));
					userAdminSearchConference.setBounds(353, 285, 278, 50);
					controlPanel.add(userAdminSearchConference);

					// controlPanel.add(line[0]);
					userAdminSearchJournal
							.addActionListener(new MyListener(18));
					userAdminSearchConference.addActionListener(new MyListener(
							20));
					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(3));
					controlPanel.add(adminAcceptBack);

					controlPanel.revalidate();
					controlPanel.repaint();
				}
					break;
				// admin approved Searching Journal 18 and Conference 20
				case 18: {
					controlPanel.removeAll();
					JButton Back = new JButton("BACK");
					controlPanel.add(Back);
					String s = "";
					for (int i = 0; i < 420; i++)
						s += " ";
					controlPanel.add(new JLabel(s));
					JTextField userApprovedSearchJournalStartMonth = new JTextField(
							6);
					JTextField userApprovedSearchJournalStartYear = new JTextField(
							6);
					JTextField userApprovedSearchJournalEndMonth = new JTextField(
							6);
					JTextField userApprovedSearchJournalEndYear = new JTextField(
							6);
					JButton userApprovedSearchJournalSearch = new JButton(
							"SEARCH");
					userApprovedSearchJournalSearch.setFont(new Font(
							"Arial Black", Font.BOLD, 12));
					userApprovedSearchJournalSearch
							.setBounds(403, 476, 176, 50);

					JLabel lblHeading = new JLabel(
							"ENTER BELOW DETAILS TO SEARCH");
					lblHeading.setFont(new Font("Castellar", Font.BOLD, 34));
					lblHeading.setBounds(168, 11, 743, 78);
					controlPanel.add(lblHeading);

					JLabel lblEndDate = new JLabel("AUTHOR:");
					lblEndDate.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblEndDate.setBounds(304, 112, 160, 34);
					if (goingJournal == 1)
						userApprovedEnterAuthor1.setText("");
					userApprovedEnterAuthor1.setColumns(10);
					userApprovedEnterAuthor1.setBounds(304, 143, 160, 20);
					controlPanel.add(lblEndDate);
					controlPanel.add(userApprovedEnterAuthor1);

					JLabel lblEndMonth = new JLabel("SCOPUS INDEX:");
					lblEndMonth
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblEndMonth.setBounds(538, 112, 160, 34);
					if (goingJournal == 1)
						userApprovedEnterScopus.setSelectedIndex(0);
					userApprovedEnterScopus.setBounds(538, 143, 160, 20);
					controlPanel.add(lblEndMonth);
					controlPanel.add(userApprovedEnterScopus);

					JLabel lblEndYear = new JLabel("PUBLICATION CATEGORY:");
					lblEndYear.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblEndYear.setBounds(419, 180, 200, 34);
					if (goingJournal == 1)
						OWNER.setSelectedIndex(0);
					OWNER.setBounds(419, 215, 200, 20);
					controlPanel.add(OWNER);
					controlPanel.add(lblEndYear);

					JLabel labelDepartment = new JLabel("DEPARTMENT:");
					labelDepartment.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					labelDepartment.setBounds(419, 250, 200, 34);
					Department1.setBounds(217, 280, 50, 20);
					Department2.setBounds(277, 280, 50, 20);
					Department3.setBounds(337, 280, 50, 20);
					Department4.setBounds(397, 280, 50, 20);
					Department5.setBounds(457, 280, 60, 20);
					Department6.setBounds(517, 280, 70, 20);
					Department7.setBounds(587, 280, 50, 20);
					Department8.setBounds(637, 280, 60, 20);
					Department9.setBounds(697, 280, 70, 20);
					Department10.setBounds(767, 280, 80, 20);
					controlPanel.add(Department1);
					controlPanel.add(Department2);
					controlPanel.add(Department3);
					controlPanel.add(Department4);
					controlPanel.add(Department5);
					controlPanel.add(Department6);
					controlPanel.add(Department7);
					controlPanel.add(Department8);
					controlPanel.add(Department9);
					controlPanel.add(Department10);
					controlPanel.add(labelDepartment);

					controlPanel.add(line[2]);
					JLabel lblUssnusbn = new JLabel("START MONTH:");
					lblUssnusbn
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblUssnusbn.setBounds(304, 321, 160, 34);
					if (goingJournal == 1)
						ConferenceStartMonth.setSelectedIndex(0);
					ConferenceStartMonth.setBounds(304, 354, 160, 20);
					controlPanel.add(lblUssnusbn);
					controlPanel.add(ConferenceStartMonth);

					JLabel lblVenue = new JLabel("START YEAR:");
					lblVenue.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblVenue.setBounds(538, 321, 160, 34);
					if (goingJournal == 1)
						ConferenceStartYear.setSelectedIndex(0);
					ConferenceStartYear.setBounds(538, 354, 160, 20);
					controlPanel.add(lblVenue);
					controlPanel.add(ConferenceStartYear);

					JLabel lblProceedingsPublisher = new JLabel("END MONTH:");
					lblProceedingsPublisher.setFont(new Font("Arial Black",
							Font.PLAIN, 12));
					lblProceedingsPublisher.setBounds(304, 413, 176, 34);
					if (goingJournal == 1)
						ConferenceEndMonth.setSelectedIndex(0);
					ConferenceEndMonth.setBounds(304, 444, 160, 20);
					controlPanel.add(lblProceedingsPublisher);
					controlPanel.add(ConferenceEndMonth);

					JLabel lblBtechmtechInvolvedName = new JLabel("END YEAR:");
					lblBtechmtechInvolvedName.setFont(new Font("Arial Black",
							Font.PLAIN, 12));
					lblBtechmtechInvolvedName.setBounds(538, 413, 186, 34);
					if (goingJournal == 1)
						ConferenceEndYear.setSelectedIndex(0);
					ConferenceEndYear.setBounds(538, 444, 160, 20);
					controlPanel.add(lblBtechmtechInvolvedName);
					controlPanel.add(ConferenceEndYear);
					goingJournal = 0;

					controlPanel.add(line[4]);
					controlPanel.add(userApprovedSearchJournalSearch);
					userApprovedSearchJournalSearch
							.addActionListener(new MyListener(19));
					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(17));
					controlPanel.add(adminAcceptBack);
					controlPanel.revalidate();
					controlPanel.repaint();
					// DefaultTableModel model = new DefaultTableModel(model,)

				}
					break;
				// admin approved Searching Journal from 17
				case 19: {
					controlPanel.removeAll();
					System.out.println("coming to 19");
					String p = "";
					for (int i = 0; i < 420; i++)
						p += " ";
					controlPanel.add(new JLabel(p));
					SearchJournal sj = new SearchJournal();
					String go = "";
					if (OWNER.getSelectedIndex() > 0) {
						go += OWNER.getItemAt(OWNER.getSelectedIndex());
					}
					int token = 0;
					if (Department1.isSelected() || Department2.isSelected()
							|| Department3.isSelected()
							|| Department4.isSelected()
							|| Department5.isSelected()
							|| Department6.isSelected()
							|| Department7.isSelected()
							|| Department8.isSelected()
							|| Department9.isSelected()
							|| Department10.isSelected())
						token = 3;
					String s[] = sj.TroubleShoot(
							userApprovedEnterAuthor1.getText(),
							userApprovedEnterScopus.getSelectedIndex(),
							ConferenceStartMonth.getSelectedIndex(),
							ConferenceStartYear.getSelectedIndex(),
							ConferenceEndMonth.getSelectedIndex(),
							ConferenceEndYear.getSelectedIndex(), go, token);
					if (s[0] != null) {
						System.out.println("coming");
						Object[] obj1 = new Object[10];
						int i = 0;
						String outError = new String("<html>");
						for (i = 0; s[i] != null; i++) {
							outError += "<br>";
							outError += s[i];
							controlPanel.add(new JLabel(s[i]));
							controlPanel.add(line[i]);
						}
						outError += "</html>";
						System.out.println("joption");
						JOptionPane.showMessageDialog(null, outError);
						JButton adminJournalSearchEnter = new JButton(
								"Get Back");
						JButton adminAcceptBack = new JButton("BACK");
						adminAcceptBack.setFont(new Font("Arial", Font.PLAIN,
								15));
						adminAcceptBack.setBounds(10, 11, 104, 34);
						adminAcceptBack.addActionListener(new MyListener(18));
						controlPanel.add(adminAcceptBack);
						controlPanel.add(adminJournalSearchEnter);
						adminJournalSearchEnter
								.addActionListener(new MyListener(18));
					} else {
						String send = "";
						if (userApprovedEnterScopus.getSelectedIndex() > 0) {
							send += userApprovedEnterScopus
									.getItemAt(userApprovedEnterScopus
											.getSelectedIndex());
						}
						String send1 = "";
						if (ConferenceStartMonth.getSelectedIndex() > 0) {
							send1 += ConferenceStartMonth
									.getItemAt(ConferenceStartMonth
											.getSelectedIndex());
						}
						String send2 = "";
						if (ConferenceStartYear.getSelectedIndex() > 0) {
							send2 += ConferenceStartYear
									.getItemAt(ConferenceStartYear
											.getSelectedIndex());
						}
						String send3 = "";
						if (ConferenceEndMonth.getSelectedIndex() > 0) {
							send3 += ConferenceEndMonth
									.getItemAt(ConferenceEndMonth
											.getSelectedIndex());
						}
						String send4 = "";
						if (ConferenceEndYear.getSelectedIndex() > 0) {
							send4 += ConferenceEndYear
									.getItemAt(ConferenceEndYear
											.getSelectedIndex());
						}
						String send5 = "";
						if (OWNER.getSelectedIndex() > 0) {
							send5 += OWNER.getItemAt(OWNER.getSelectedIndex());
						}
						String send6 = "";
						if (Department1.isSelected()) {
							send6 += Department1.getText();
						}
						String send7 = "";
						if (Department2.isSelected()) {
							send7 += Department2.getText();
						}
						String send8 = "";
						if (Department3.isSelected()) {
							send8 += Department3.getText();
						}
						String send9 = "";
						if (Department4.isSelected()) {
							send9 += Department4.getText();
						}
						String send10 = "";
						if (Department5.isSelected()) {
							send10 += Department5.getText();
						}
						String send11 = "";
						if (Department6.isSelected()) {
							send11 += Department6.getText();
						}
						String send12 = "";
						if (Department7.isSelected()) {
							send12 += Department7.getText();
						}
						String send13 = "";
						if (Department8.isSelected()) {
							send13 += Department8.getText();
						}
						String send14 = "";
						if (Department9.isSelected()) {
							send14 += Department9.getText();
						}
						String send15 = "";
						if (Department10.isSelected()) {
							send15 += Department10.getText();
						}
						try {
							sj.check(userApprovedEnterAuthor1.getText(), send,
									send1, send2, send3, send4, send5, send6,
									send7, send8, send9, send10, send11,
									send12, send13, send14, send15);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						DefaultTableModel model = new DefaultTableModel(
								journalSearchTable.values2, journalColumns);
						journalAdminApprovalTable = new JTable(model);

						journalAdminApprovalTable
								.setPreferredScrollableViewportSize(new Dimension(
										1200, 100));
						journalAdminApprovalTable.setFillsViewportHeight(true);
						DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
						centerRenderer
								.setHorizontalAlignment(SwingConstants.CENTER);
						TableColumn column = null;
						for (int i = 0; i <= 19; i++) {
							column = journalAdminApprovalTable.getColumnModel()
									.getColumn(i);
							column.setMinWidth(100);
							column.setCellRenderer(centerRenderer);

							if (i == 19) {
								column.setMinWidth(200);
							}

						}

						controlPanel.add(line[0]);
						JScrollPane scrollPane = new JScrollPane(
								journalAdminApprovalTable,
								JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
						scrollPane.setBounds(118, 90, 770, 363);

						journalAdminApprovalTable
								.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						controlPanel.add(scrollPane);
						JButton adminAcceptBack = new JButton("BACK");
						adminAcceptBack.setFont(new Font("Arial", Font.PLAIN,
								15));
						adminAcceptBack.setBounds(10, 11, 104, 34);
						adminAcceptBack.addActionListener(new MyListener(18));
						controlPanel.add(adminAcceptBack);
						controlPanel.add(line[1]);

						JButton journalDownload = new JButton("Download");
						journalDownload.setFont(new Font("Arial Black",
								Font.BOLD, 12));
						journalDownload.setBounds(403, 476, 176, 50);
						controlPanel.add(journalDownload);
						journalDownload.addActionListener(new MyListener(27));
					}

					controlPanel.revalidate();
					controlPanel.repaint();
				}
					break;
				// admin approved Searching Conference from 17
				case 20: {
					controlPanel.removeAll();
					JButton Back = new JButton("BACK");
					controlPanel.add(Back);
					String s = "";
					for (int i = 0; i < 420; i++)
						s += " ";
					controlPanel.add(new JLabel(s));
					JTextField userApprovedSearchConferenceStartMonth = new JTextField(
							6);
					JTextField userApprovedSearchConferenceStartYear = new JTextField(
							6);
					JTextField userApprovedSearchConferenceEndMonth = new JTextField(
							6);
					JTextField userApprovedSearchConferenceEndYear = new JTextField(
							6);
					JButton userApprovedSearchConferenceSearch = new JButton(
							"SEARCH");
					userApprovedSearchConferenceSearch.setFont(new Font(
							"Arial Black", Font.BOLD, 12));
					userApprovedSearchConferenceSearch.setBounds(403, 476, 176,
							50);

					JLabel lblHeading = new JLabel(
							"ENTER BELOW DETAILS TO SEARCH");
					lblHeading.setFont(new Font("Castellar", Font.BOLD, 34));
					lblHeading.setBounds(168, 11, 743, 78);
					controlPanel.add(lblHeading);

					JLabel lblEndDate = new JLabel("AUTHOR:");
					lblEndDate.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblEndDate.setBounds(304, 112, 160, 34);
					if (goingConference == 1)
						userApprovedEnterAuthor1.setText("");
					userApprovedEnterAuthor1.setColumns(10);
					userApprovedEnterAuthor1.setBounds(304, 143, 160, 20);
					controlPanel.add(lblEndDate);
					controlPanel.add(userApprovedEnterAuthor1);

					JLabel lblEndMonth = new JLabel("SCOPUS INDEX:");
					lblEndMonth
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblEndMonth.setBounds(538, 112, 160, 34);
					if (goingConference == 1)
						userApprovedEnterScopus.setSelectedIndex(0);
					userApprovedEnterScopus.setBounds(538, 143, 160, 20);
					controlPanel.add(lblEndMonth);
					controlPanel.add(userApprovedEnterScopus);

					JLabel lblEndYear = new JLabel("PUBLICATION CATEGORY:");
					lblEndYear.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblEndYear.setBounds(419, 180, 200, 34);
					if (goingConference == 1)
						OWNER.setSelectedIndex(0);
					OWNER.setBounds(419, 215, 200, 20);
					controlPanel.add(OWNER);
					controlPanel.add(lblEndYear);

					JLabel labelDepartment = new JLabel("DEPARTMENT:");
					labelDepartment.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					labelDepartment.setBounds(419, 250, 200, 34);
					Department1.setBounds(217, 280, 50, 20);
					Department2.setBounds(277, 280, 50, 20);
					Department3.setBounds(337, 280, 50, 20);
					Department4.setBounds(397, 280, 50, 20);
					Department5.setBounds(457, 280, 60, 20);
					Department6.setBounds(517, 280, 70, 20);
					Department7.setBounds(587, 280, 50, 20);
					Department8.setBounds(637, 280, 60, 20);
					Department9.setBounds(697, 280, 70, 20);
					Department10.setBounds(767, 280, 80, 20);
					controlPanel.add(Department1);
					controlPanel.add(Department2);
					controlPanel.add(Department3);
					controlPanel.add(Department4);
					controlPanel.add(Department5);
					controlPanel.add(Department6);
					controlPanel.add(Department7);
					controlPanel.add(Department8);
					controlPanel.add(Department9);
					controlPanel.add(Department10);
					controlPanel.add(labelDepartment);

					controlPanel.add(line[2]);
					JLabel lblUssnusbn = new JLabel("START MONTH:");
					lblUssnusbn
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblUssnusbn.setBounds(304, 321, 160, 34);
					if (goingConference == 1)
						ConferenceStartMonth.setSelectedIndex(0);
					ConferenceStartMonth.setBounds(304, 354, 160, 20);
					controlPanel.add(lblUssnusbn);
					controlPanel.add(ConferenceStartMonth);

					JLabel lblVenue = new JLabel("START YEAR:");
					lblVenue.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblVenue.setBounds(538, 321, 160, 34);
					if (goingConference == 1)
						ConferenceStartYear.setSelectedIndex(0);
					ConferenceStartYear.setBounds(538, 354, 160, 20);
					controlPanel.add(lblVenue);
					controlPanel.add(ConferenceStartYear);

					JLabel lblProceedingsPublisher = new JLabel("END MONTH:");
					lblProceedingsPublisher.setFont(new Font("Arial Black",
							Font.PLAIN, 12));
					lblProceedingsPublisher.setBounds(304, 413, 176, 34);
					if (goingConference == 1)
						ConferenceEndMonth.setSelectedIndex(0);
					ConferenceEndMonth.setBounds(304, 444, 160, 20);
					controlPanel.add(lblProceedingsPublisher);
					controlPanel.add(ConferenceEndMonth);

					JLabel lblBtechmtechInvolvedName = new JLabel("END YEAR:");
					lblBtechmtechInvolvedName.setFont(new Font("Arial Black",
							Font.PLAIN, 12));
					lblBtechmtechInvolvedName.setBounds(538, 413, 186, 34);
					if (goingConference == 1)
						ConferenceEndYear.setSelectedIndex(0);
					ConferenceEndYear.setBounds(538, 444, 160, 20);
					controlPanel.add(lblBtechmtechInvolvedName);
					controlPanel.add(ConferenceEndYear);
					/*
					 * JLabel lblHeading = new JLabel(
					 * "ENTER BELOW DETAILS TO SEARCH"); lblHeading.setFont(new
					 * Font("Castellar", Font.BOLD, 34));
					 * lblHeading.setBounds(168, 11, 743, 78);
					 * controlPanel.add(lblHeading);
					 * 
					 * JLabel lblEndDate = new JLabel("AUTHOR:");
					 * lblEndDate.setFont(new Font("Arial Black", Font.PLAIN,
					 * 12)); lblEndDate.setBounds(304, 112, 160, 34);
					 * userApprovedEnterAuthor1.setColumns(10);
					 * userApprovedEnterAuthor1.setBounds(304, 143, 160, 20);
					 * controlPanel.add(lblEndDate);
					 * controlPanel.add(userApprovedEnterAuthor1);
					 * 
					 * JLabel lblEndMonth = new JLabel("SCOPUS INDEX:");
					 * lblEndMonth .setFont(new Font("Arial Black", Font.PLAIN,
					 * 12)); lblEndMonth.setBounds(538, 112, 160, 34);
					 * userApprovedEnterScopus.setBounds(538, 143, 160, 20);
					 * controlPanel.add(lblEndMonth);
					 * controlPanel.add(userApprovedEnterScopus);
					 * 
					 * JLabel lblEndYear = new JLabel("PUBLICATION CATEGORY:");
					 * lblEndYear.setFont(new Font("Arial Black", Font.PLAIN,
					 * 12)); lblEndYear.setBounds(419, 192, 160, 34);
					 * OWNER.setBounds(419, 225, 160, 20);
					 * controlPanel.add(OWNER); controlPanel.add(lblEndYear);
					 * 
					 * controlPanel.add(lblEndYear);
					 * 
					 * controlPanel.add(line[2]); JLabel lblUssnusbn = new
					 * JLabel("START MONTH:"); lblUssnusbn .setFont(new
					 * Font("Arial Black", Font.PLAIN, 12));
					 * lblUssnusbn.setBounds(304, 301, 160, 34);
					 * ConferenceStartMonth.setBounds(304, 334, 160, 20);
					 * controlPanel.add(lblUssnusbn);
					 * controlPanel.add(ConferenceStartMonth);
					 * 
					 * JLabel lblVenue = new JLabel("START YEAR:");
					 * lblVenue.setFont(new Font("Arial Black", Font.PLAIN,
					 * 12)); lblVenue.setBounds(538, 301, 160, 34);
					 * ConferenceStartYear.setBounds(538, 334, 160, 20);
					 * controlPanel.add(lblVenue);
					 * controlPanel.add(ConferenceStartYear);
					 * 
					 * JLabel lblProceedingsPublisher = new
					 * JLabel("END MONTH:"); lblProceedingsPublisher.setFont(new
					 * Font("Arial Black", Font.PLAIN, 12));
					 * lblProceedingsPublisher.setBounds(304, 393, 176, 34);
					 * ConferenceEndMonth.setBounds(304, 424, 160, 20);
					 * controlPanel.add(lblProceedingsPublisher);
					 * controlPanel.add(ConferenceEndMonth);
					 * 
					 * JLabel lblBtechmtechInvolvedName = new
					 * JLabel("END YEAR:");
					 * lblBtechmtechInvolvedName.setFont(new Font("Arial Black",
					 * Font.PLAIN, 12));
					 * lblBtechmtechInvolvedName.setBounds(538, 393, 186, 34);
					 * ConferenceEndYear.setBounds(538, 424, 160, 20);
					 * controlPanel.add(lblBtechmtechInvolvedName);
					 * controlPanel.add(ConferenceEndYear);
					 */
					controlPanel.add(userApprovedSearchConferenceSearch);
					goingConference = 0;
					userApprovedSearchConferenceSearch
							.addActionListener(new MyListener(21));
					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(17));
					controlPanel.add(adminAcceptBack);
					controlPanel.revalidate();
					controlPanel.repaint();
				}
					break;
				case 21: {
					System.out.println("EVEN COMING");
					controlPanel.removeAll();
					JButton Back = new JButton("BACK");
					controlPanel.add(Back);
					String p = "";
					for (int i = 0; i < 420; i++)
						p += " ";
					controlPanel.add(new JLabel(p));
					SearchConference sc = new SearchConference();
					String go = "";
					if (OWNER.getSelectedIndex() > 0) {
						go += OWNER.getItemAt(OWNER.getSelectedIndex());
					}
					int token = 0;
					if (Department1.isSelected() || Department2.isSelected()
							|| Department3.isSelected()
							|| Department4.isSelected()
							|| Department5.isSelected()
							|| Department6.isSelected()
							|| Department7.isSelected()
							|| Department8.isSelected()
							|| Department9.isSelected()
							|| Department10.isSelected())
						token = 3;
					String s[] = sc.TroubleShoot(
							userApprovedEnterAuthor1.getText(),
							userApprovedEnterScopus.getSelectedIndex(),
							ConferenceStartMonth.getSelectedIndex(),
							ConferenceStartYear.getSelectedIndex(),
							ConferenceEndMonth.getSelectedIndex(),
							ConferenceEndYear.getSelectedIndex(), go, token);
					if (s[0] != null) {
						System.out.println("coming");
						Object[] obj1 = new Object[10];
						int i = 0;
						String outError = new String("<html>");
						for (i = 0; s[i] != null; i++) {
							outError += "<br>";
							outError += s[i];
							controlPanel.add(new JLabel(s[i]));
							controlPanel.add(line[i]);
						}
						outError += "</html>";
						System.out.println("joption");
						JOptionPane.showMessageDialog(null, outError);
						JButton adminJournalSearchEnter = new JButton(
								"Get Back");
						JButton adminAcceptBack = new JButton("BACK");
						adminAcceptBack.setFont(new Font("Arial", Font.PLAIN,
								15));
						adminAcceptBack.setBounds(10, 11, 104, 34);
						adminAcceptBack.addActionListener(new MyListener(20));
						controlPanel.add(adminAcceptBack);
					} else {
						String send = "";
						if (userApprovedEnterScopus.getSelectedIndex() > 0) {
							send += userApprovedEnterScopus
									.getItemAt(userApprovedEnterScopus
											.getSelectedIndex());
						}
						String send1 = "";
						if (ConferenceStartMonth.getSelectedIndex() > 0) {
							send1 += ConferenceStartMonth
									.getItemAt(ConferenceStartMonth
											.getSelectedIndex());
						}
						String send2 = "";
						if (ConferenceStartYear.getSelectedIndex() > 0) {
							send2 += ConferenceStartYear
									.getItemAt(ConferenceStartYear
											.getSelectedIndex());
						}
						String send3 = "";
						if (ConferenceEndMonth.getSelectedIndex() > 0) {
							send3 += ConferenceEndMonth
									.getItemAt(ConferenceEndMonth
											.getSelectedIndex());
						}
						String send4 = "";
						if (ConferenceEndYear.getSelectedIndex() > 0) {
							send4 += ConferenceEndYear
									.getItemAt(ConferenceEndYear
											.getSelectedIndex());
						}
						String send5 = "";
						if (OWNER.getSelectedIndex() > 0) {
							send5 += OWNER.getItemAt(OWNER.getSelectedIndex());
						}
						String send6 = "";
						if (Department1.isSelected()) {
							send6 += Department1.getText();
						}
						String send7 = "";
						if (Department2.isSelected()) {
							send7 += Department2.getText();
						}
						String send8 = "";
						if (Department3.isSelected()) {
							send8 += Department3.getText();
						}
						String send9 = "";
						if (Department4.isSelected()) {
							send9 += Department4.getText();
						}
						String send10 = "";
						if (Department5.isSelected()) {
							send10 += Department5.getText();
						}
						String send11 = "";
						if (Department6.isSelected()) {
							send11 += Department6.getText();
						}
						String send12 = "";
						if (Department7.isSelected()) {
							send12 += Department7.getText();
						}
						String send13 = "";
						if (Department8.isSelected()) {
							send13 += Department8.getText();
						}
						String send14 = "";
						if (Department9.isSelected()) {
							send14 += Department9.getText();
						}
						String send15 = "";
						if (Department10.isSelected()) {
							send15 += Department10.getText();
						}
						try {
							System.out.println("coming");
							sc.check(userApprovedEnterAuthor1.getText(), send,
									send1, send2, send3, send4, send5, send6,
									send7, send8, send9, send10, send11,
									send12, send13, send14, send15);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("SEARCH COMING");

						DefaultTableModel model = new DefaultTableModel(
								ConferenceSearchTable.values2,
								conferenceColumns);
						JTable ConferenceAdminApprovalTable = new JTable(model);

						ConferenceAdminApprovalTable
								.setPreferredScrollableViewportSize(new Dimension(
										1200, 100));
						ConferenceAdminApprovalTable
								.setFillsViewportHeight(true);

						DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
						centerRenderer
								.setHorizontalAlignment(SwingConstants.CENTER);
						TableColumn column = null;
						for (int i = 0; i <= 20; i++) {
							column = ConferenceAdminApprovalTable
									.getColumnModel().getColumn(i);
							column.setMinWidth(100);
							column.setCellRenderer(centerRenderer);

							if (i == 20) {
								column.setMinWidth(200);
							}

						}

						JScrollPane scrollPane = new JScrollPane(
								ConferenceAdminApprovalTable,
								JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
						scrollPane.setBounds(118, 90, 770, 363);

						ConferenceAdminApprovalTable
								.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						controlPanel.add(scrollPane);
						// conferenceDownload = new JButton("Download");
						JButton adminAcceptBack = new JButton("BACK");
						adminAcceptBack.setFont(new Font("Arial", Font.PLAIN,
								15));
						adminAcceptBack.setBounds(10, 11, 104, 34);
						adminAcceptBack.addActionListener(new MyListener(20));
						controlPanel.add(adminAcceptBack);
						conferenceDownload.setFont(new Font("Arial Black",
								Font.BOLD, 12));
						conferenceDownload.setBounds(403, 476, 176, 50);
						controlPanel.add(conferenceDownload);
						conferenceDownload
								.addActionListener(new MyListener(30));
					}
					Back.addActionListener(new MyListener(20));
					controlPanel.revalidate();
					controlPanel.repaint();
				}
					break;
				case 22: {

					if (downloadCriSet == 11) {
						for (int i = 0; i < 20; i++) {
							if (i == 18) {
								journalDownloadCri[i] = true;
							} else if (i == 19) {
								journalDownloadCri[i] = true;
							} else if (journalBoxes[i].isSelected()) {
								journalDownloadCri[i] = true;
							} else {
								journalDownloadCri[i] = false;
							}
						}
					} else if (downloadCriSet == 12) {
						for (int i = 0; i < 20; i++) {
							journalDownloadCri[i] = true;
						}
					}
					JFileChooser chooser;
					chooser = new JFileChooser();
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle("SAVE FILE");
					chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					//
					// disable the "All files" option.
					//
					String path = "";
					;
					chooser.setAcceptAllFileFilterUsed(false);
					//
					if (chooser.showOpenDialog(conferenceDownload) == JFileChooser.APPROVE_OPTION) {
						System.out.println("getCurrentDirectory(): "
								+ chooser.getCurrentDirectory());
						System.out.println("getSelectedFile() : "
								+ chooser.getSelectedFile());
						path = chooser.getSelectedFile().toString();
					} else {
						System.out.println("No Selection ");
					}
					String oriPath = "";
					for (int i = 0; i < path.length(); i++) {
						if (path.charAt(i) == '\\')
							oriPath += "/";
						else
							oriPath += path.charAt(i);
					}
					if (oriPath.charAt(oriPath.length() - 1) == '/')
						oriPath += "JournalSearch";
					oriPath += ".xls";
					System.out.println(oriPath);
					controlPanel.removeAll();
					SearchJournalDownload sjd = new SearchJournalDownload();
					sjd.Download(journalSearchTable.values2, journalColumns,
							oriPath, journalDownloadCri);
					JButton Back = new JButton("BACK");
					controlPanel.add(Back);
					String s = "";
					for (int i = 0; i < 420; i++)
						s += " ";
					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(3));
					controlPanel.add(adminAcceptBack);
					System.out.println("supercoming");
					Back.addActionListener(new MyListener(18));
					controlPanel.revalidate();
					controlPanel.repaint();
				}
					break;
				case 23: {

					if (downloadCriSet == 21) {
						for (int i = 0; i < 24; i++) {
							if (i == 22 || i == 23) {
								conferenceDownloadCri[i] = true;
							} else if (conferenceBoxes[i].isSelected()) {
								conferenceDownloadCri[i] = true;
							} else {
								conferenceDownloadCri[i] = false;
							}
						}
					} else if (downloadCriSet == 22) {
						for (int i = 0; i < 24; i++) {
							conferenceDownloadCri[i] = true;
						}
					}
					JFileChooser chooser;
					chooser = new JFileChooser();
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle("SAVE FILE");
					chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					//
					// disable the "All files" option.
					//
					String path = "";
					;
					chooser.setAcceptAllFileFilterUsed(false);
					//
					if (chooser.showOpenDialog(conferenceDownload) == JFileChooser.APPROVE_OPTION) {
						System.out.println("getCurrentDirectory(): "
								+ chooser.getCurrentDirectory());
						System.out.println("getSelectedFile() : "
								+ chooser.getSelectedFile());
						path = chooser.getSelectedFile().toString();
					} else {
						System.out.println("No Selection ");
					}
					String oriPath = "";
					for (int i = 0; i < path.length(); i++) {
						if (path.charAt(i) == '\\')
							oriPath += "/";
						else
							oriPath += path.charAt(i);
					}
					if (oriPath.charAt(oriPath.length() - 1) == '/')
						oriPath += "ConferenceSearch";
					oriPath += ".xls";
					System.out.println(oriPath);
					controlPanel.removeAll();
					JButton Back = new JButton("BACK");
					controlPanel.add(Back);
					String s = "";
					for (int i = 0; i < 420; i++)
						s += " ";
					controlPanel.add(new JLabel(s));
					controlPanel.add(line[0]);
					SearchJournalDownload sjd = new SearchJournalDownload();
					if (ConferenceSearchTable.values2.equals(null)) {
						System.out.println("easily die");
					}
					System.out.println(ConferenceSearchTable.values2[0][1]);
					sjd.Download(ConferenceSearchTable.values2,
							conferenceColumns, oriPath, conferenceDownloadCri);
					controlPanel.add(new JLabel("Downloaded as an excel File"));
					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(3));
					controlPanel.add(adminAcceptBack);
					controlPanel.revalidate();
					controlPanel.repaint();
					Back.addActionListener(new MyListener(20));
					controlPanel.revalidate();
					controlPanel.repaint();
				}
					break;
				case 24: {
					controlPanel.removeAll();
					JournalApproval ca = new JournalApproval();
					String s[] = new String[500];
					String s1[] = new String[500];
					int run = 0;
					for (int i = 0; i < journalAdminApprovalTable.getRowCount(); i++) {
						if (journalAdminApprovalTable.getModel()
								.getValueAt(i, 19).equals("YES")) {
							String go = "";
							if (!(journalAdminApprovalTable.getModel()
									.getValueAt(i, 20)).equals("SELECT")) {
								go += (String) journalAdminApprovalTable
										.getModel().getValueAt(i, 20);
								s1[run] = go;
							}
							s[run++] = (String) journalAdminApprovalTable
									.getModel().getValueAt(i, 7);
							System.out.println(s[run - 1]);
						}
					}
					s[run] = null;
					try {
						ca.Approval(s, s1);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Approval Sucessful");
					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(3));
					controlPanel.add(adminAcceptBack);
					controlPanel.add(line[0]);
					controlPanel.add(line[1]);
					controlPanel.add(new JLabel("APPROVED"));
					controlPanel.revalidate();
					controlPanel.repaint();

				}
					break; // journal inside admin accept download
				case 25: {

					controlPanel.removeAll();
					ConferenceApproval ca = new ConferenceApproval();
					String s[] = new String[500];
					String s1[] = new String[500];
					int run = 0;
					for (int i = 0; i < ConferenceAdminApprovalTable
							.getRowCount(); i++) {
						if (ConferenceAdminApprovalTable.getModel()
								.getValueAt(i, 23).equals("YES")) {
							String go = "";
							if (!ConferenceAdminApprovalTable.getModel()
									.getValueAt(i, 24).equals("SELECT")) {
								go += (String) ConferenceAdminApprovalTable
										.getModel().getValueAt(i, 24);
								s1[run] = go;
							}
							s[run++] = (String) ConferenceAdminApprovalTable
									.getModel().getValueAt(i, 7);
							System.out.println(s[run - 1]);
						}
					}
					s[run] = null;
					try {
						ca.Approval(s, s1);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Approval Sucessful");
					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(3));
					controlPanel.add(adminAcceptBack);
					controlPanel.add(line[0]);
					controlPanel.add(line[1]);
					controlPanel.add(new JLabel("APPROVED"));
					controlPanel.revalidate();
					controlPanel.repaint();
				}
					break; // conference inside admin accept download
				case 26: {
					JTable usethis = new JTable();
					if (scopusCheckingSingleGo == 0) {
						usethis = journalAdminApprovalTable;
					} else {
						usethis = ConferenceAdminApprovalTable;
					}
					for (int i = 0; i < usethis.getRowCount(); i++) {
						if (usethis.getModel().getValueAt(i, 9).equals("YES")) {
							try {
								ScopusCheck.check((String) usethis.getModel()
										.getValueAt(i, 6));
							} catch (IOException | URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
					break;// scopus global check
				case 27: {
					controlPanel.removeAll();

					JLabel lblHeading = new JLabel("SELECT FORMAT");
					lblHeading.setFont(new Font("Castellar", Font.BOLD, 30));
					lblHeading.setBounds(350, 11, 900, 78);
					controlPanel.add(lblHeading);

					JButton complete = new JButton("COMPLETE");
					complete.setFont(new Font("Arial", Font.BOLD, 15));
					complete.setBounds(353, 147, 278, 50);
					// frame.getContentPane().add(btnAcceptUser);

					// adminAcceptJournal = new
					// JButton("APPROVE JOURNAL");
					JButton customize = new JButton("CUSTOMIZE");
					customize.setFont(new Font("Arial", Font.BOLD, 15));
					customize.setBounds(353, 329, 278, 50);
					// frame.getContentPane().add(btnAcceptJournal);

					// btnSearchRecords = new JButton("SEARCH RECORDS");
					JButton IEEE = new JButton("IEEE");
					IEEE.setFont(new Font("Arial", Font.BOLD, 15));
					IEEE.setBounds(353, 233, 278, 50);
					downloadCriSet = 12;
					complete.addActionListener(new MyListener(22));
					customize.addActionListener(new MyListener(28));
					IEEE.addActionListener(new MyListener(29));
					controlPanel.add(complete);
					controlPanel.add(customize);
					controlPanel.add(IEEE);
					controlPanel.revalidate();
					controlPanel.repaint();

				}
					break; // send to 28 or 29 or 30
				case 28: {
					controlPanel.removeAll();

					JLabel lblHeading = new JLabel("SELECT PREFERRED");
					lblHeading.setFont(new Font("Castellar", Font.BOLD, 30));
					lblHeading.setBounds(330, 11, 900, 78);
					controlPanel.add(lblHeading);

					JLabel lblUsername = new JLabel("AUTHOR 1:");
					lblUsername
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblUsername.setBounds(70, 90, 160, 34);
					journalBoxes[0] = new JCheckBox();
					journalBoxes[0].setBounds(70, 120, 50, 20);
					controlPanel.add(lblUsername);
					controlPanel.add(journalBoxes[0]);

					JLabel lblAuthor = new JLabel("AUTHOR 2:");
					lblAuthor.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor.setBounds(70, 160, 160, 34);
					journalBoxes[1] = new JCheckBox();
					journalBoxes[1].setBounds(70, 190, 50, 20);
					controlPanel.add(lblAuthor);
					controlPanel.add(journalBoxes[1]);

					JLabel lblAuthor_1 = new JLabel("AUTHOR 3:");
					lblAuthor_1
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_1.setBounds(70, 240, 160, 34);
					journalBoxes[2] = new JCheckBox();
					journalBoxes[2].setBounds(70, 270, 50, 20);
					controlPanel.add(lblAuthor_1);
					controlPanel.add(journalBoxes[2]);
					controlPanel.add(space1[20]);

					JLabel lblAuthor_2 = new JLabel("AUTHOR 4:");
					lblAuthor_2
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_2.setBounds(70, 320, 160, 34);
					journalBoxes[3] = new JCheckBox();
					journalBoxes[3].setBounds(70, 350, 50, 20);
					controlPanel.add(lblAuthor_2);
					controlPanel.add(journalBoxes[3]);

					JLabel lblAuthor_3 = new JLabel("AUTHOR 5:");
					lblAuthor_3
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_3.setBounds(70, 400, 160, 34);
					journalBoxes[4] = new JCheckBox();
					journalBoxes[4].setBounds(70, 430, 50, 20);
					controlPanel.add(lblAuthor_3);
					controlPanel.add(journalBoxes[4]);

					JLabel lblAuthor_4 = new JLabel("AUTHOR 6:");
					lblAuthor_4
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_4.setBounds(70, 480, 160, 34);
					journalBoxes[5] = new JCheckBox();
					journalBoxes[5].setBounds(70, 510, 50, 20);
					controlPanel.add(lblAuthor_4);
					controlPanel.add(journalBoxes[5]);

					JLabel lblTitle = new JLabel("TITLE:");
					lblTitle.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblTitle.setBounds(443, 90, 160, 34);
					journalBoxes[6] = new JCheckBox();
					journalBoxes[6].setBounds(443, 120, 50, 20);
					controlPanel.add(lblTitle);
					controlPanel.add(journalBoxes[6]);

					JLabel lblJournalName = new JLabel("JOURNAL NAME:");
					lblJournalName.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					lblJournalName.setBounds(443, 160, 160, 34);
					journalBoxes[7] = new JCheckBox();
					journalBoxes[7].setBounds(443, 190, 50, 20);
					controlPanel.add(lblJournalName);
					controlPanel.add(journalBoxes[7]);

					JLabel lblScopusIndex = new JLabel("SCOPUS INDEX:");
					lblScopusIndex.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					lblScopusIndex.setBounds(443, 240, 160, 34);
					journalBoxes[8] = new JCheckBox();
					journalBoxes[8].setBounds(443, 270, 50, 20);
					controlPanel.add(lblScopusIndex);
					controlPanel.add(journalBoxes[8]);

					JLabel lblImpactFactor = new JLabel("IMPACT FACTOR:");
					lblImpactFactor.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					lblImpactFactor.setBounds(443, 320, 160, 34);
					journalBoxes[9] = new JCheckBox();
					journalBoxes[9].setBounds(443, 350, 50, 20);
					controlPanel.add(lblImpactFactor);
					controlPanel.add(journalBoxes[9]);

					JLabel lblMonth = new JLabel("MONTH:");
					lblMonth.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblMonth.setBounds(443, 400, 160, 34);
					journalBoxes[10] = new JCheckBox();
					journalBoxes[10].setBounds(443, 430, 50, 20);
					controlPanel.add(lblMonth);
					controlPanel.add(journalBoxes[10]);

					JLabel lblYear = new JLabel("YEAR:");
					lblYear.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblYear.setBounds(443, 480, 160, 40);
					journalBoxes[11] = new JCheckBox();
					journalBoxes[11].setBounds(443, 510, 50, 20);
					controlPanel.add(lblYear);
					controlPanel.add(journalBoxes[11]);

					JLabel ISSNLabel = new JLabel("ISSN/ISBN:");
					ISSNLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
					ISSNLabel.setBounds(797, 90, 180, 34);
					journalBoxes[12] = new JCheckBox();
					journalBoxes[12].setBounds(797, 120, 50, 20);
					controlPanel.add(ISSNLabel);
					controlPanel.add(journalBoxes[12]);

					JLabel labelDepartment = new JLabel("DEPARTMENTS INVOLVED");
					labelDepartment.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					labelDepartment.setBounds(797, 160, 180, 34);
					journalBoxes[13] = new JCheckBox();
					journalBoxes[13].setBounds(797, 190, 50, 20);
					controlPanel.add(labelDepartment);
					controlPanel.add(journalBoxes[13]);

					JLabel namePublishLabel = new JLabel(
							"NAME OF THE PUBLISHER:");
					namePublishLabel.setFont(new Font("Arial Black",
							Font.PLAIN, 12));
					namePublishLabel.setBounds(797, 240, 180, 34);
					journalBoxes[14] = new JCheckBox();
					journalBoxes[14].setBounds(797, 270, 50, 20);
					controlPanel.add(namePublishLabel);
					controlPanel.add(journalBoxes[14]);

					JLabel label_1 = new JLabel("VOLUME,ISSUE,PAGENO:");
					label_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
					label_1.setBounds(797, 320, 180, 34);
					journalBoxes[15] = new JCheckBox();
					journalBoxes[15].setBounds(797, 350, 50, 20);
					controlPanel.add(label_1);
					controlPanel.add(journalBoxes[15]);

					JLabel label_2 = new JLabel("Btech/Mtech INVOLED NAME:");
					label_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
					label_2.setBounds(797, 400, 200, 34);
					journalBoxes[16] = new JCheckBox();
					journalBoxes[16].setBounds(797, 430, 50, 20);
					controlPanel.add(label_2);
					controlPanel.add(journalBoxes[16]);

					JLabel label_3 = new JLabel("OTHER DETAILS:");
					label_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
					label_3.setBounds(797, 480, 160, 40);
					journalBoxes[17] = new JCheckBox();
					journalBoxes[17].setBounds(797, 510, 50, 20);
					controlPanel.add(label_3);
					controlPanel.add(journalBoxes[17]);

					// JButton JournalEnter = new
					// JButton("Enter into database");
					JButton JournalEnter = new JButton("DOWNLOAD");
					JournalEnter
							.setFont(new Font("Arial Black", Font.BOLD, 12));
					JournalEnter.setBounds(744, 25, 230, 46);
					controlPanel.add(JournalEnter);

					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(27));
					controlPanel.add(adminAcceptBack);
					downloadCriSet = 11;
					JournalEnter.addActionListener(new MyListener(22));
					controlPanel.revalidate();
					controlPanel.repaint();
				}
					break;// sending to 27 coming from
				case 29: {
					controlPanel.removeAll();
					String[] sup = new String[100];
					for (int i = 0; i < journalAdminApprovalTable.getRowCount(); i++) {
						sup[i] = "";
						for (int j = 0; j < 20; j++) {
							if (j != 0 && j != 1 && j != 2 && j != 3 && j != 4
									&& j != 5 && j != 6 && j != 10 && j != 11
									&& j != 15) {
								continue;
							}
							String temp = (String) journalAdminApprovalTable
									.getModel().getValueAt(i, j);
							if (j == 11) {
								sup[i] = sup[i].substring(0,
										sup[i].length() - 2);
							}
							if (!temp.equals(""))
								sup[i] += temp + " , ";
						}
						sup[i] = sup[i].substring(0, sup[i].length() - 2);
						System.out.println(sup[i]);

					}
					JFileChooser chooser;
					chooser = new JFileChooser();
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle("SAVE FILE");
					chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					//
					// disable the "All files" option.
					//
					String path = "";
					;
					chooser.setAcceptAllFileFilterUsed(false);
					//
					if (chooser.showOpenDialog(conferenceDownload) == JFileChooser.APPROVE_OPTION) {
						System.out.println("getCurrentDirectory(): "
								+ chooser.getCurrentDirectory());
						System.out.println("getSelectedFile() : "
								+ chooser.getSelectedFile());
						path = chooser.getSelectedFile().toString();
					} else {
						System.out.println("No Selection ");
					}
					String oriPath = "";
					for (int i = 0; i < path.length(); i++) {
						if (path.charAt(i) == '\\')
							oriPath += "/";
						else
							oriPath += path.charAt(i);
					}
					if (oriPath.charAt(oriPath.length() - 1) == '/')
						oriPath += "JournalSearch";
					oriPath += ".xls";
					System.out.println(oriPath);
					IEEEDownload ieed = new IEEEDownload();
					ieed.download(sup, oriPath);
					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(27));
					controlPanel.add(adminAcceptBack);
					controlPanel.revalidate();
					controlPanel.repaint();
				}
					break;// sending from 27
				case 30: {
					controlPanel.removeAll();

					JLabel lblHeading = new JLabel("SELECT FORMAT");
					lblHeading.setFont(new Font("Castellar", Font.BOLD, 30));
					lblHeading.setBounds(350, 11, 900, 78);
					controlPanel.add(lblHeading);

					JButton complete = new JButton("COMPLETE");
					complete.setFont(new Font("Arial", Font.BOLD, 15));
					complete.setBounds(353, 147, 278, 50);
					// frame.getContentPane().add(btnAcceptUser);

					// adminAcceptJournal = new
					// JButton("APPROVE JOURNAL");
					JButton customize = new JButton("CUSTOMIZE");
					customize.setFont(new Font("Arial", Font.BOLD, 15));
					customize.setBounds(353, 329, 278, 50);
					// frame.getContentPane().add(btnAcceptJournal);

					// btnSearchRecords = new JButton("SEARCH RECORDS");
					JButton IEEE = new JButton("IEEE");
					IEEE.setFont(new Font("Arial", Font.BOLD, 15));
					IEEE.setBounds(353, 233, 278, 50);
					downloadCriSet = 22;
					complete.addActionListener(new MyListener(23));
					customize.addActionListener(new MyListener(31));
					IEEE.addActionListener(new MyListener(32));
					controlPanel.add(complete);
					controlPanel.add(customize);
					controlPanel.add(IEEE);
					controlPanel.revalidate();
					controlPanel.repaint();
				}
					break; // coming from 2 sending to 23
				case 31: {
					controlPanel.removeAll();

					downloadCriSet = 21;
					JLabel lblHeading = new JLabel("SELECT PREFERRED");
					lblHeading.setFont(new Font("Castellar", Font.BOLD, 30));
					lblHeading.setBounds(330, 11, 900, 78);
					controlPanel.add(lblHeading);

					JLabel lblUsername = new JLabel("AUTHOR 1:");
					lblUsername
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblUsername.setBounds(26, 90, 160, 34);
					conferenceBoxes[0] = new JCheckBox();
					conferenceBoxes[0].setBounds(26, 120, 160, 20);
					controlPanel.add(lblUsername);
					controlPanel.add(conferenceBoxes[0]);

					JLabel lblAuthor = new JLabel("AUTHOR 2:");
					lblAuthor.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor.setBounds(26, 160, 160, 34);
					conferenceBoxes[1] = new JCheckBox();
					conferenceBoxes[1].setBounds(26, 190, 160, 20);
					controlPanel.add(conferenceBoxes[1]);
					controlPanel.add(lblAuthor);

					JLabel lblAuthor_1 = new JLabel("AUTHOR 3:");
					lblAuthor_1
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_1.setBounds(26, 240, 160, 34);
					conferenceBoxes[2] = new JCheckBox();
					conferenceBoxes[2].setBounds(26, 270, 160, 20);
					controlPanel.add(conferenceBoxes[2]);
					controlPanel.add(lblAuthor_1);

					JLabel lblAuthor_2 = new JLabel("AUTHOR 4:");
					lblAuthor_2
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_2.setBounds(26, 320, 160, 34);
					conferenceBoxes[3] = new JCheckBox();
					conferenceBoxes[3].setBounds(26, 350, 160, 20);
					controlPanel.add(conferenceBoxes[3]);
					controlPanel.add(lblAuthor_2);

					JLabel lblAuthor_3 = new JLabel("AUTHOR 5:");
					lblAuthor_3
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_3.setBounds(26, 400, 160, 34);
					conferenceBoxes[4] = new JCheckBox();
					conferenceBoxes[4].setBounds(26, 430, 160, 20);
					controlPanel.add(conferenceBoxes[4]);
					controlPanel.add(lblAuthor_3);

					JLabel lblAuthor_4 = new JLabel("AUTHOR 6:");
					lblAuthor_4
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblAuthor_4.setBounds(26, 480, 160, 34);
					conferenceBoxes[5] = new JCheckBox();
					conferenceBoxes[5].setBounds(26, 510, 160, 20);
					controlPanel.add(conferenceBoxes[5]);
					controlPanel.add(lblAuthor_4);

					JLabel lblTitle = new JLabel("TITLE:");
					lblTitle.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblTitle.setBounds(281, 90, 160, 34);
					conferenceBoxes[6] = new JCheckBox();
					conferenceBoxes[6].setBounds(281, 120, 160, 20);
					controlPanel.add(conferenceBoxes[6]);
					controlPanel.add(lblTitle);

					JLabel lblJournalName = new JLabel("CONFERENCE NAME:");
					lblJournalName.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					lblJournalName.setBounds(281, 160, 160, 34);
					conferenceBoxes[7] = new JCheckBox();
					conferenceBoxes[7].setBounds(281, 190, 160, 20);
					controlPanel.add(conferenceBoxes[7]);
					controlPanel.add(lblJournalName);

					JLabel lblScopusIndex = new JLabel("SCOPUS INDEX:");
					lblScopusIndex.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					lblScopusIndex.setBounds(281, 240, 160, 34);
					conferenceBoxes[8] = new JCheckBox();
					conferenceBoxes[8].setBounds(281, 270, 160, 20);
					controlPanel.add(conferenceBoxes[8]);
					controlPanel.add(lblScopusIndex);

					JLabel lblImpactFactor = new JLabel("START DATE:");
					lblImpactFactor.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					lblImpactFactor.setBounds(281, 320, 160, 34);
					conferenceBoxes[9] = new JCheckBox();
					conferenceBoxes[9].setBounds(281, 350, 160, 20);
					controlPanel.add(conferenceBoxes[9]);
					controlPanel.add(lblImpactFactor);

					JLabel lblMonth = new JLabel("START MONTH:");
					lblMonth.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblMonth.setBounds(281, 400, 160, 34);
					conferenceBoxes[10] = new JCheckBox();
					conferenceBoxes[10].setBounds(281, 430, 160, 20);
					controlPanel.add(conferenceBoxes[10]);
					controlPanel.add(lblMonth);

					JLabel lblYear = new JLabel("START YEAR:");
					lblYear.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblYear.setBounds(281, 480, 160, 34);
					conferenceBoxes[11] = new JCheckBox();
					conferenceBoxes[11].setBounds(281, 510, 160, 20);
					controlPanel.add(conferenceBoxes[11]);
					controlPanel.add(lblYear);

					JLabel lblEndDate = new JLabel("END DATE:");
					lblEndDate.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblEndDate.setBounds(541, 90, 160, 34);
					conferenceBoxes[12] = new JCheckBox();
					conferenceBoxes[12].setBounds(541, 120, 160, 20);
					controlPanel.add(conferenceBoxes[12]);
					controlPanel.add(lblEndDate);

					JLabel lblEndMonth = new JLabel("END MONTH:");
					lblEndMonth
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblEndMonth.setBounds(541, 160, 160, 34);
					conferenceBoxes[13] = new JCheckBox();
					conferenceBoxes[13].setBounds(541, 190, 160, 20);
					controlPanel.add(conferenceBoxes[13]);
					controlPanel.add(lblEndMonth);

					JLabel lblEndYear = new JLabel("END YEAR:");
					lblEndYear.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblEndYear.setBounds(541, 240, 160, 34);
					conferenceBoxes[14] = new JCheckBox();
					conferenceBoxes[14].setBounds(541, 270, 160, 20);
					controlPanel.add(conferenceBoxes[14]);
					controlPanel.add(lblEndYear);

					JLabel lblIssnisbn = new JLabel("ISSN/ISBN:");
					lblIssnisbn
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblIssnisbn.setBounds(541, 320, 160, 34);
					conferenceBoxes[15] = new JCheckBox();
					conferenceBoxes[15].setBounds(541, 350, 160, 20);
					controlPanel.add(conferenceBoxes[15]);
					controlPanel.add(lblIssnisbn);

					JLabel lblVenue = new JLabel("VENUE:");
					lblVenue.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblVenue.setBounds(541, 400, 160, 34);
					conferenceBoxes[16] = new JCheckBox();
					conferenceBoxes[16].setBounds(541, 430, 160, 20);
					controlPanel.add(conferenceBoxes[16]);
					controlPanel.add(lblVenue);

					JLabel lblNameOfThe = new JLabel("NAME OF THE ORGANIZER:");
					lblNameOfThe
							.setFont(new Font("Arial Black", Font.PLAIN, 12));
					lblNameOfThe.setBounds(541, 480, 196, 34);
					conferenceBoxes[17] = new JCheckBox();
					conferenceBoxes[17].setBounds(541, 510, 160, 20);
					controlPanel.add(conferenceBoxes[17]);
					controlPanel.add(lblNameOfThe);

					JLabel labelDepartment = new JLabel("DEPARTMENTS INVOLVED");
					labelDepartment.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					labelDepartment.setBounds(808, 90, 176, 34);
					conferenceBoxes[18] = new JCheckBox();
					conferenceBoxes[18].setBounds(808, 120, 160, 20);
					controlPanel.add(conferenceBoxes[18]);
					controlPanel.add(labelDepartment);

					JLabel lblProceedingsPublisher = new JLabel(
							"Proceedings Publisher:");
					lblProceedingsPublisher.setFont(new Font("Arial Black",
							Font.PLAIN, 12));
					lblProceedingsPublisher.setBounds(808, 240, 176, 34);
					conferenceBoxes[19] = new JCheckBox();
					conferenceBoxes[19].setBounds(808, 270, 160, 20);
					controlPanel.add(conferenceBoxes[19]);
					controlPanel.add(lblProceedingsPublisher);

					JLabel lblBtechmtechInvolvedName = new JLabel(
							"Btech/Mtech Involved Name:");
					lblBtechmtechInvolvedName.setFont(new Font("Arial Black",
							Font.PLAIN, 12));
					lblBtechmtechInvolvedName.setBounds(798, 320, 186, 34);
					conferenceBoxes[20] = new JCheckBox();
					conferenceBoxes[20].setBounds(808, 350, 160, 20);
					controlPanel.add(conferenceBoxes[20]);
					controlPanel.add(lblBtechmtechInvolvedName);

					JLabel lblOtherDetails = new JLabel("OTHER DETAILS:");
					lblOtherDetails.setFont(new Font("Arial Black", Font.PLAIN,
							12));
					lblOtherDetails.setBounds(808, 400, 160, 34);
					conferenceBoxes[21] = new JCheckBox();
					conferenceBoxes[21].setBounds(808, 430, 160, 20);
					controlPanel.add(conferenceBoxes[21]);
					controlPanel.add(lblOtherDetails);
					controlPanel.add(userApprovedEnterOtherDetails);

					JButton ConferenceEnter = new JButton("DOWNLOAD");
					ConferenceEnter.setFont(new Font("Arial Black", Font.BOLD,
							15));
					ConferenceEnter.setBounds(780, 460, 230, 46);
					controlPanel.add(ConferenceEnter);
					ConferenceEnter.addActionListener(new MyListener(23));

					JButton adminAcceptBack = new JButton("BACK");
					adminAcceptBack.setFont(new Font("Arial", Font.PLAIN, 15));
					adminAcceptBack.setBounds(10, 11, 104, 34);
					adminAcceptBack.addActionListener(new MyListener(30));
					controlPanel.add(adminAcceptBack);

					controlPanel.revalidate();
					controlPanel.repaint();
				}
					break;
				}
			}
		}
		// controlPanel.set
		mainLoginButton.addActionListener(new MyListener(1));
		mainSignupButton.addActionListener(new MyListener(2));
		loginButton.addActionListener(new MyListener(3));
		addButton.addActionListener(new MyListener(4));
		removeButton.addActionListener(new MyListener(5));
		add2Button.addActionListener(new MyListener(6));
		signupButton.addActionListener(new MyListener(7));
		adminAccountNext.addActionListener(new MyListener(8));

		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}