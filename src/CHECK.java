import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import org.jdesktop.swingx.JXDatePicker;

public class CHECK {

	private JFrame frame;
	private JFrame frame2;
	private JButton btnBack;
	private JLabel lblEndDate;
	private JLabel lblEndMonth;
	private JLabel lblEndYear;
	private JTextField textField_14;
	private JLabel lblUssnusbn;
	private JTextField textField_15;
	private JLabel lblVenue;
	private JTextField textField_16;
	private JLabel lblProceedingsPublisher;
	private JTextField textField_18;
	private JLabel lblBtechmtechInvolvedName;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CHECK window = new CHECK();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public CHECK() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {
		frame = new JFrame("JFRAME EXAMPLE TO CHECK");
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image imgo = ImageIO.read(getClass().getResource("data/th.jpg"));
		final ImageIcon img = new ImageIcon(imgo);
		btnBack = new JButton(img);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		/*
		 * btnBack.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) { } });
		 */
		btnBack.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				btnBack.setBackground(Color.BLUE);
			}

			public void mouseEntered(MouseEvent evt) {
				img.setImage((img.getImage().getScaledInstance(10 + 10, 11,
						Image.SCALE_SMOOTH)));
				btnBack.setBounds(10 - 5, 11 - 5, 104 + 100, 34 + 10);
				// btnBack.setBackground(Color.BLACK);
				// button.setIcon(icon1);
			}

			public void mouseExited(MouseEvent evt) {
				btnBack.setBounds(10, 11, 104, 34);
				btnBack.setBackground(null);
			}
		});
		btnBack.setFont(new Font("Arial", Font.BOLD, 20));
		btnBack.setBounds(10, 11, 104, 34);
		frame.getContentPane().add(btnBack);

		lblEndDate = new JLabel("ENTER BELOW DETAILS TO SEARCH");
		lblEndDate.setFont(new Font("Footlight MT Light", Font.BOLD, 34));
		lblEndDate.setBounds(168, 11, 743, 78);
		frame.getContentPane().add(lblEndDate);

		lblEndMonth = new JLabel("SCOPUS INDEX:");
		lblEndMonth.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblEndMonth.setBounds(518, 180, 160, 34);
		frame.getContentPane().add(lblEndMonth);
		
		JMenuBar menuBar;
		final JMenu menu;
		JMenu submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;

		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the first menu.
		menu = new JMenu("->");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(menu);

		//a group of JMenuItems
		menuItem = new JMenuItem("A text-only menu item",
		                         KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
		        "This doesn't really do anything");
		menu.add(menuItem);

		menuItem = new JMenuItem("Both text and icon",
		                         new ImageIcon("images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_B);
		menu.add(menuItem);

		menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_D);
		menu.add(menuItem);

		//a group of radio button menu items
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Another one");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		//a group of check box menu items
		menu.addSeparator();
		cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		menu.add(cbMenuItem);

		cbMenuItem = new JCheckBoxMenuItem("Another one");
		cbMenuItem.setMnemonic(KeyEvent.VK_H);
		menu.add(cbMenuItem);

		//a submenu
		menu.addSeparator();
		submenu = new JMenu("A submenu");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("An item in the submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem("Another item");
		submenu.add(menuItem);
		menu.add(submenu);
		menu.add(submenu);
		menuBar.setBounds(700, 400, 200, 200);
		frame.getContentPane().add(menuBar);
		submenu.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  System.out.println("Coming");
			  } 
			} );
		submenu.setName("subMenu");
		//submenu.set
		submenu.addMenuListener(new MenuListener() {

	        @Override
	        public void menuSelected(MenuEvent e) {
	            System.out.println(e.getSource().getClass().getSimpleName());
	            //System.out.println(menu.getSelectedIcon());
	        }

	        @Override
	        public void menuDeselected(MenuEvent e) {
	            System.out.println("menuDeselected");

	        }

	        @Override
	        public void menuCanceled(MenuEvent e) {
	            System.out.println("menuCanceled");

	        }
	    });
		menu.addMenuListener(new MenuListener() {

	        @Override
	        public void menuSelected(MenuEvent e) {
	            System.out.println("menuSelected");
	            //System.out.println(menu.getSelectedIcon());
	        }

	        @Override
	        public void menuDeselected(MenuEvent e) {
	            System.out.println("menuDeselected");

	        }

	        @Override
	        public void menuCanceled(MenuEvent e) {
	            System.out.println("menuCanceled");

	        }
	    });
		//((JFrame) frame.getContentPane()).setJMenuBar(menuBar);

		lblEndYear = new JLabel("END YEAR:");
		lblEndYear.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblEndYear.setBounds(393, 120, 160, 34);
		frame.getContentPane().add(lblEndYear);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(393, 149, 160, 20);
		frame.getContentPane().add(textField_14);

		lblUssnusbn = new JLabel("START MONTH:");
		lblUssnusbn.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblUssnusbn.setBounds(284, 301, 160, 34);
		frame.getContentPane().add(lblUssnusbn);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(284, 334, 160, 20);
		frame.getContentPane().add(textField_15);

		/*
		 * JButton btnNewButton = new JButton("SIGNUP");
		 * btnNewButton.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) { } }); btnNewButton.setFont(new
		 * Font("Arial Black", Font.BOLD, 12)); btnNewButton.setBounds(393, 446,
		 * 160, 50); frame.getContentPane().add(btnNewButton);
		 */

		lblVenue = new JLabel("START YEAR:");
		lblVenue.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblVenue.setBounds(518, 301, 160, 34);
		frame.getContentPane().add(lblVenue);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(518, 334, 160, 20);
		frame.getContentPane().add(textField_16);

		lblProceedingsPublisher = new JLabel("END MONTH:");
		lblProceedingsPublisher
				.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblProceedingsPublisher.setBounds(284, 393, 176, 34);
		frame.getContentPane().add(lblProceedingsPublisher);

		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(284, 424, 160, 20);
		frame.getContentPane().add(textField_18);

		lblBtechmtechInvolvedName = new JLabel("END YEAR:");
		lblBtechmtechInvolvedName.setFont(new Font("Arial Black", Font.PLAIN,
				12));
		lblBtechmtechInvolvedName.setBounds(518, 393, 186, 34);
		frame.getContentPane().add(lblBtechmtechInvolvedName);

		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(518, 424, 160, 20);
		frame.getContentPane().add(textField_19);

		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(808, 270, 160, 20);
		frame.getContentPane().add(textField_20);

		/*
		 * JButton button = new JButton("ENTER INTO DATABASE");
		 * button.setFont(new Font("Arial Black", Font.BOLD, 12));
		 * button.setBounds(518, 256, 278, 50);
		 * frame.getContentPane().add(button);
		 */
		final ImageIcon icon1 = new ImageIcon("th.jpg");
		// final JButton button = new JButton(icon1);
		final int width = icon1.getIconWidth();
		final int height = icon1.getIconHeight();
		final JButton button = new JButton("very good");
		button.setFont(new Font("Arial Black", Font.BOLD, 12));
		button.setBounds(393, 446, 160, 50);
		// frame.getContentPane().add(button);
		// button.setBounds(100, 100, 200, 200);
		button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				button.setBackground(Color.BLACK);
				icon1.setImage((icon1.getImage().getScaledInstance(width + 10,
						height, Image.SCALE_SMOOTH)));
				// button.setIcon(icon1);
			}

			public void mouseExited(MouseEvent evt) {
				icon1.setImage((icon1.getImage().getScaledInstance(width,
						height, Image.SCALE_SMOOTH)));
			}

			public void mousePressed(MouseEvent evt) {
				icon1.setImage((icon1.getImage().getScaledInstance(width + 5,
						height, Image.SCALE_SMOOTH)));
			}

			public void mouseReleased(MouseEvent evt) {
				icon1.setImage((icon1.getImage().getScaledInstance(width + 10,
						height, Image.SCALE_SMOOTH)));
			}
		});
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		frame.getContentPane().add(button);

		JLabel label = new JLabel("END YEAR:");
		label.setFont(new Font("Arial Black", Font.PLAIN, 12));
		label.setBounds(393, 219, 160, 34);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(393, 248, 160, 20);
		frame.getContentPane().add(textField);

		JLabel label_1 = new JLabel("END YEAR:");
		label_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		label_1.setBounds(393, 317, 160, 34);
		frame.getContentPane().add(label_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(393, 346, 160, 20);
		frame.getContentPane().add(textField_1);
		String[] str = { "1", "2", "3", "4" };
		JList list = new JList(str);
		list.setBounds(318, 149, 195, 42);
		frame.getContentPane().add(list);

		JButton btnSignup = new JButton("SIGNUP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignup.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		//btnSignup.setBounds(69, 127, 200, 200);
		frame.getContentPane().add(btnSignup);
		final JXDatePicker picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        picker.setBounds(100,100,300,300);
        frame.getContentPane().add(picker);
        picker.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(picker.getDate());
			}
        	
        });
		class MyListener implements ActionListener {

			private int buttonNum;

			MyListener(int buttonNum) {

				this.buttonNum = buttonNum;

			}

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				switch (buttonNum) {
				case 1:
					frame.removeAll();
					frame.revalidate();
					frame.repaint();

				}
			}
		}
	}
}
