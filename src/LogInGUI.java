import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.util.*;

public class LogInGUI extends JFrame implements ActionListener{
	ArrayList<Users> userlist = new ArrayList<>();
	Users user = null;
	public static void main(String[] args) {
		new LogInGUI();
	}
	// Users user = new Users(null, null);
	JFrame frame = new JFrame("Login Prototye");
	private JTextField usernametxt = new JTextField(12);
	private JPasswordField passwordtxt = new JPasswordField(12);
	private JLabel usernameLB = new JLabel("Username ");
	private JLabel passwordLB = new JLabel("Password ");
	private JLabel outputLB = new JLabel();

	private JButton loginBtn = new JButton("Login");
	private JButton registerBtn = new JButton("Register");
	
	private JLabel rightLabel = new JLabel("werwrwe");

	private JLabel topLabel = new JLabel();
	private JLabel labelUserCreated = new JLabel();
	
	private JPanel[] panel = null;

	private Font font = new Font("SansSerif", Font.PLAIN, 19);
	
	public LogInGUI() {

		frame.setSize(950, 570);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.getContentPane().setBackground(new Color(151,208,203));
		
		getPanel();
		loginBtn.addActionListener(this);
		registerBtn.addActionListener(this);
		frame.setVisible(true);
	}

	public JPanel[] getPanel() {
		panel = new JPanel[4];
		for (int i = 0; i <panel.length; i++) {
			panel[i] = new JPanel();
			frame.add(panel[i]);
		}

		panel[0].setPreferredSize(new Dimension(425, 530));
		panel[0].setBackground(new Color(86,196,188));
		panel[0].setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel[0].add(panel[1], gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panel[0].add(panel[2], gbc);

		panel[1].setBorder(BorderFactory.createLineBorder(new Color(231,231,231), 2));
		panel[1].setBackground(new Color(86,196,188));
		panel[1].setPreferredSize(new Dimension(350, 250));
		panel[1].setLayout(new GridBagLayout());
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		usernametxt.setFont(font);
		panel[1].add(usernametxt,gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0,0,0,150);
		usernameLB.setForeground(Color.white);
		panel[1].add(usernameLB,gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		passwordtxt.setFont(font);
		gbc.insets = new Insets(20,0,0,0);
		panel[1].add(passwordtxt,gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(0,0,0,150);
		passwordLB.setForeground(Color.white);
		panel[1].add(passwordLB,gbc);

		panel[2].setLayout(new GridBagLayout());
		panel[2].setBackground(new Color(86,196,188));
		panel[2].setPreferredSize(new Dimension(350, 210));

		gbc.insets = new Insets(35,0,0,0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		loginBtn.setPreferredSize(new Dimension(150, 37));
		panel[2].add(loginBtn, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		registerBtn.setPreferredSize(new Dimension(100, 30));
		panel[2].add(registerBtn, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		outputLB.setForeground(Color.white);
		panel[2].add(outputLB, gbc);

		

		
		panel[3].setPreferredSize(new Dimension(500, 530));
		panel[3].setBackground(Color.white);

		panel[3].setLayout(new GridBagLayout());
		ImageIcon icon = new ImageIcon("login.png");
		rightLabel.setIcon(icon);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel[3].add(rightLabel, gbc);

		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String usernameln = usernametxt.getText().trim();
		String passwordln = String.valueOf(passwordtxt.getPassword()).trim();

		

/*****Register Method */
		if(e.getSource() == registerBtn)
		{
			user = new Users(usernameln, passwordln);
				if(usernameln.isEmpty()) {
						System.out.println("Working");
						JOptionPane.showMessageDialog(this, "Username cannot be empty");
				}
				else if(passwordln.isEmpty()){
						JOptionPane.showMessageDialog(this, "Password cannot be empty");
				}
				else if(!userlist.contains(user)){
						userlist.add(user);
						outputLB.setText("User has successfully registered");
						for (Users users : userlist) {
							System.out.println(users.getUsername() + " "+users.getPassword());
						}
				}
				else{
					outputLB.setText("Not registered");
				}
					// usernametxt.setText(null);
					// passwordtxt.setText(null);
		}

/*****Login Method */
		if (e.getSource()==loginBtn ) 
		{
			
				if(usernameln.isEmpty()) {
						System.out.println("Working");
						JOptionPane.showMessageDialog(this, "Username cannot be empty");
				}
				else if(passwordln.isEmpty()){
						JOptionPane.showMessageDialog(this, "Password cannot be empty");
				}
				else
				{
					for (Users users : userlist) {
						if(users.getUsername().equals(usernameln) && users.getPassword().equals(passwordln) ) {
							System.out.println("Hello");
						}
						else{
							System.out.println("Not");
						}
					}

			// 			for (Users userln : userlist) {
			// 				if(userln.getUsername().equals(usernameln) && userln.getPassword().equals(usernameln)){
			// 					System.out.println("Welcome");
			// 				}
			// 				else{
			// 					System.out.println("User does not exist");
			// 				}
			// 			}
		
				}
		}


		
	
	}
}
