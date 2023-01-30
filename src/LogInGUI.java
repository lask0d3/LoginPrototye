import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.util.*;

public class LogInGUI extends JFrame implements ActionListener, FocusListener{
	
	public static void main(String[] args) {
		new LogInGUI();
	}

	JFrame frame = new JFrame("Login Prototye");
	private JTextField usernametxt = new JTextField("Username",10);
	private JPasswordField passwordtxt = new JPasswordField("Password",10);
	private JLabel usernameLB = new JLabel("Username: ");
	private JLabel passwordLB = new JLabel("Password: ");

	private JButton loginBtn = new JButton("Login");
	private JButton registerBtn = new JButton("Register"); 
	
	private JLabel rightLabel = new JLabel("werwrwe");


	private JLabel topLabel = new JLabel();
	private JLabel labelUserCreated = new JLabel();
	
	private JPanel[] panel = null;

	private Font font = new Font("SansSerif", Font.PLAIN, 18);
	
	public LogInGUI() {

		frame.setSize(950, 570);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.getContentPane().setBackground(new Color(151,208,203));
		
		getPanel();
		loginBtn.addActionListener(this);
		registerBtn.addActionListener(this);
		usernametxt.addFocusListener(this);
		passwordtxt.addFocusListener(this);
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

		/*gbc.gridx = 0;
		gbc.gridy = 1;
		loginBtn.setPreferredSize(size);
		panel[0].add(loginBtn, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		registerBtn.setPreferredSize(size);
		panel[0].add(registerBtn, gbc);*/

		// gbc.gridx = 2;
		// gbc.gridy = 1;
		// panel[0].add(registerBtn, gbc);
		

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
		passwordtxt.setFont(font);
		// passwordtxt.setBorder(BorderFactory.createTitledBorder("Username"));
		panel[1].add(passwordtxt,gbc);


		// panel[2].setBackground(new Color(86,196,188));
		panel[2].setLayout(new GridBagLayout());
		panel[2].setBackground(new Color(86,196,188));
		panel[2].setPreferredSize(new Dimension(350, 175));
		// Dimension size = new Dimension(100,37);
		gbc.insets = new Insets(40,0,0,0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		loginBtn.setPreferredSize(new Dimension(100, 37));
		panel[2].add(loginBtn, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		registerBtn.setPreferredSize(new Dimension(100, 25));
		panel[2].add(registerBtn, gbc);

		
		panel[3].setPreferredSize(new Dimension(500, 530));
		panel[3].setBackground(Color.white);

		// rightLabel.setPreferredSize(new Dimension(320, 530));
		panel[3].setLayout(new GridBagLayout());
		ImageIcon icon = new ImageIcon("login.png");
		rightLabel.setIcon(icon);
		panel[3].add(rightLabel);

		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String usernameln = usernametxt.getText().trim();
		// String passwordln =new String( passwordtxt.getPassword());
		String passwordln = String.valueOf(passwordtxt.getPassword()).trim();

		ArrayList<Users> userlist = new ArrayList<>();
		
		
	if (usernametxt.equals("Username")){
		usernametxt.setText(null);
	}

		
		if(e.getSource() == registerBtn)
		{
				Users user = new Users(usernameln, passwordln);
				if(usernameln.isEmpty()) {
						System.out.println("Working");
						JOptionPane.showMessageDialog(this, "Username cannot be empty");
				}
				else if(passwordln.isEmpty()){
						JOptionPane.showMessageDialog(this, "Password cannot be empty");
				}
				else if(!userlist.contains(user)){
						System.out.println("Successfully registered");
				}
				else{
						System.out.println("Not registered");
				}
					usernametxt.setText(null);
					passwordtxt.setText(null);
		}
	
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == usernametxt) {
			
			usernametxt.setText(null);
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == usernametxt && usernametxt != null) {
			usernametxt.setText(null);
		}
		// if (e.getSource() == usernametxt && usernametxt == null) {
		// 	usernametxt.setText(null);
		// }

		// if (e.getSource() == passwordtxt && passwordtxt == null) {
		// 	passwordtxt.setText(null);
		// }
		
	}
}
