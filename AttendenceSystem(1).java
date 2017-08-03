import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AttendenceSystem {

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendenceSystem window = new AttendenceSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AttendenceSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 631, 309);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Check In/Out", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setName("Check In/Out");
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 3, 5, 10));
		
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		JButton btnNewButton_7 = new JButton("7");
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("8");
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("9");
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_4 = new JButton("4");
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("5");
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("6");
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_1 = new JButton("1");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("2");
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("3");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_11 = new JButton("In/Out");
		panel.add(btnNewButton_11);
		
		JButton btnNewButton_10 = new JButton("0");
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_12 = new JButton("Remove");
		panel.add(btnNewButton_12);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setName("Menu");
		frame.getContentPane().add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{291, 0};
		gbl_panel_1.rowHeights = new int[]{201, 50, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel login_panel = new JPanel();
		login_panel.setLayout(null);
		GridBagConstraints gbc_login_panel = new GridBagConstraints();
		gbc_login_panel.fill = GridBagConstraints.BOTH;
		gbc_login_panel.insets = new Insets(0, 0, 5, 0);
		gbc_login_panel.gridx = 0;
		gbc_login_panel.gridy = 0;
		panel_1.add(login_panel, gbc_login_panel);
		
		login_panel.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("UserName :");
		lblNewLabel_1.setBounds(21, 65, 88, 14);
		login_panel.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(21, 90, 75, 14);
		login_panel.add(lblPassword);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(119, 62, 86, 20);
		login_panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(119, 87, 86, 20);
		login_panel.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(21, 136, 75, 23);
		login_panel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
//				login_panel.setVisible(true);
				MenuForm menuForm = new MenuForm();
				menuForm.setVisible(true);
				frame.setVisible(false);
//				frame.setDefaultCloseOperation(0);
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(119, 136, 75, 23);
		login_panel.add(btnCancel);
		JButton btnMenu = new JButton("Menu");
		GridBagConstraints gbc_btnMenu = new GridBagConstraints();
		gbc_btnMenu.fill = GridBagConstraints.BOTH;
		gbc_btnMenu.insets = new Insets(0, 0, 5, 0);
		gbc_btnMenu.gridx = 0;
		gbc_btnMenu.gridy = 0;
		panel_1.add(btnMenu, gbc_btnMenu);
		
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMenu.setVisible(false);
				login_panel.setVisible(true);
			}
		});
		
		
		JButton btnNewButton_3 = new JButton("Exit");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 1;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);
		
	}
	
	 public boolean TableFromMySqlDatabase(String UserName, String Password)
	    {
	    	boolean isValid =false;
	    	System.out.println(UserName);
	    	System.out.println(Password);
	        ArrayList columnNames = new ArrayList();
	        ArrayList data = new ArrayList();

	        //  Connect to an MySQL Database, run query, get result set
	        String url = "jdbc:mysql://localhost:3306/attendancetable?autoReconnect=true&useSSL=false";
	        String userid = "root";
	        String password = "root";
	        String sql = "SELECT * FROM LoginAttendance where (UserName='"+UserName+"' and PassWd='"+Password+"');";
	        System.out.println(sql);

	        // Java SE 7 has try-with-resources
	        // This will ensure that the sql objects are closed when the program 
	        // is finished with them
	        try (Connection connection = DriverManager.getConnection( url, userid, password );
	            Statement stmt = connection.createStatement();
	            ResultSet rs = stmt.executeQuery( sql ))
	        {  
	               if(rs.next())
	            {
	            	System.out.println("Credntials are Valid");
	            	isValid = true;
	            } else {
	            	
	            	System.out.println("Credintials are not valid");
	            }
	        }
	        catch (SQLException e)
	        {
	            System.out.println( e.getMessage() );
	        }
			return isValid;
	    }
}
