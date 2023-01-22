import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.util.*;

public class LogInGUI extends JFrame implements ActionListener{
	public static void main(String[] args) {
		new LogInGUI();
	}
	ArrayList<Users> users = new ArrayList<>();
	
	
	
	Users user = new Users(null, null);


	JFrame frame = new JFrame("Login Prototye");
	private JTextField usernametxt = new JTextField(15);
	private JPasswordField passwordtxt = new JPasswordField(15);
	private JLabel usernameLB = new JLabel("Username: ");
	private JLabel passwordLB = new JLabel("Password: ");

	private JButton loginBtn = new JButton("Sign In");
	private JButton registerBtn = new JButton("Sign up"); 
	
	private JLabel topLabel = new JLabel();
	private JLabel labelUserCreated = new JLabel();
	
	private JPanel panel = new JPanel();

	private Font font = new Font("SansSerif", Font.PLAIN, 22);
	
	public LogInGUI() {

		frame.setSize(700, 540);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.getContentPane().setBackground(new Color(30,129,176));
		
		panel.setLayout(new GridBagLayout());
		// panel.setBackground(new Color(238,238,228));
		
		panel.setPreferredSize(new Dimension(700, 700));
		GridBagConstraints gbc = new GridBagConstraints();
		
			
		gbc.gridx = 0;
		gbc.gridy = 0;
		usernameLB.setFont(new Font("SansSerif", Font.PLAIN, 20));
		panel.add (usernameLB, gbc);
		
		
		
		gbc.gridx = 1;
		gbc.gridy = 0;	
		usernametxt.setFont(font);
		panel.add(usernametxt, gbc);
		
//		usernametxt.setPreferredSize(new Dimension(120, 50));
		gbc.insets = new Insets(50,0,0,0);
		
		gbc.gridx = 0;
		gbc.gridy = 1;	
		passwordLB.setFont(new Font("SansSerif", Font.PLAIN, 20));
		panel.add(passwordLB, gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		passwordtxt.setFont(font);
		panel.add(passwordtxt, gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		loginBtn.setPreferredSize(new Dimension(150, 40));
		panel.add(loginBtn,gbc);
	
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(75,0,0,0);
		registerBtn.setPreferredSize(new Dimension(85, 20));
		panel.add(registerBtn,gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.insets = new Insets(30,0,0,0);
		registerBtn.setPreferredSize(new Dimension(85, 20));
		panel.add(labelUserCreated,gbc);
		
		
		panel.setPreferredSize(new Dimension(500, 500));
		panel.setBorder(BorderFactory.createTitledBorder("Enter Details"));
		
		
		frame.setResizable(false);
		frame.add(panel);

		loginBtn.addActionListener(this);
		registerBtn.addActionListener(this);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		

		// TODO Auto-generated method stub
		String usernameln = usernametxt.getText().trim();
		String passwordln =new String( passwordtxt.getPassword());
		
//		
		
		
		if(e.getSource() == loginBtn ) {
			
			if(passwordln.isEmpty()  || usernameln.isEmpty()) {
				System.out.println("Working");
				JOptionPane.showMessageDialog(this, "Username or Password cannot be empty");
				
			}
			else {
				if(users.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Account does not exist ");
				}
				
				else 
				{
					for(Users user: users) 
					 {
						if(user.getUsername().equals(usernameln) && user.getPassword().equals(passwordln) ) {
							System.out.println("Hello");
							new WelcomeGUI();
							frame.dispose();
						}
						else{
							
							
							JOptionPane.showMessageDialog(this, "Account does not exist ");
						}
				    }
				}
			}
			
		}
			
		
		if(e.getSource()== registerBtn) {
			if(passwordln.isEmpty()  || usernameln.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Username or Password cannot be empty");
		}
		else{
			Users user = new Users(usernameln, passwordln);
			
			System.out.println("Working");
			if(!users.contains(user.getUsername()) && !users.contains(user.getPassword())) {	
				user.setUsername(usernameln);
				user.setPassword(passwordln);
		
				users.add(user);
				labelUserCreated.setText("User has been created successdully. you can Sign in now.");
				System.out.println("\nUser has successdully been created\n");
				System.out.println(user.getUsername());
				
			}
			else {
				System.out.println("User already exist");

			}
			
//			}
		 }
		}
			
		}
}
