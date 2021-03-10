package frontend;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import backend.Console;

public class Authentification {

	public JFrame frmLogin;
	private JTextField textUsername;
	private JPasswordField txtPassword;
	public Authentification() {
		initialize();
	}

	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Authentification \r\n");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel SmartLogo = new JLabel();
		SmartLogo.setIcon(new ImageIcon("Smart-Parking-JAVA resize3.png"));
		SmartLogo.setBounds(260, 40, 148, 148);
		frmLogin.getContentPane().add(SmartLogo);
		
		JLabel lblNewLabel = new JLabel("Username\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(70, 85, 74, 14);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(70, 123, 74, 14);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to our Parking");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBounds(141, 20, 151, 14);
		frmLogin.getContentPane().add(lblNewLabel_2);
		
		textUsername = new JTextField();
		textUsername.setBounds(160, 82, 98, 20);
		frmLogin.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(160, 120, 98, 20);
		frmLogin.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login\r\n");
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				@SuppressWarnings("deprecation")
				String password = txtPassword.getText();
				String username = textUsername.getText();
				
				if ((password.contains("a") && username.contains("a")) || (password.contains("Otmane") && username.contains("ELHAOUCHI")) ) 
				{
					txtPassword.setText(null);
					textUsername.setText(null);
					frmLogin.dispose();
			     	Console console = new Console();
					try {
						console.begin();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, String.format("Invalid Login Details", 10, 10));
					txtPassword.setText(null);
					textUsername.setText(null);
				}
			}
		});
		btnLogin.setBounds(82, 205, 89, 23);
		frmLogin.getContentPane().add(btnLogin);
		
		JButton btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFrame frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login System"
						, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		
		btnexit.setBounds(260, 205, 89, 23);
		frmLogin.getContentPane().add(btnexit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 167, 414, 2);
		frmLogin.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 45, 414, 10);
		frmLogin.getContentPane().add(separator_1);
	}
}