import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
// import javax.swing.event.*;

import java.awt.event.*;
import java.io.*;
import java.util.*;

public class LogInGUI extends JFrame implements ActionListener, MouseListener, FocusListener {
	ArrayList<Users> userlist = new ArrayList<>();
	Users user = null;
//			new Users(null, null, null, null, null);
	
	
	public static void main(String[] args) {
		new LogInGUI();
	}
	
	 
	JFrame frame = new JFrame("Login Prototye");
	private JTextField[] textField = null;
	private Border border  = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(230,230,230,255));        

	private JTextField usernametxt = new JTextField("username", 12);
	private JPasswordField passwordtxt = new JPasswordField("password", 12);

	private ImageIcon[] icon = null;
	private Font[] font = null;

	private JLabel[] label = null;

	private JButton loginBtn = new JButton("Login");
	private JButton registerBtn = new JButton("Register");
	
	private JPanel[] panel = null;
	
	public LogInGUI() {
		frame.setSize(1200, 650);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.getContentPane().setBackground(new Color(151,208,203));
		getPanel();
		loginBtn.addActionListener(this);
		registerBtn.addActionListener(this);
		usernametxt.addFocusListener(this);
		passwordtxt.addFocusListener(this);
		frame.add(panel[0]);
		frame.add(panel[1]);
		frame.setVisible(true);
	}

	public JPanel[] getPanel() {
		panel = new JPanel[12];
		for (int i = 0; i <panel.length; i++) {
			panel[i] = new JPanel();
			
		}

		textField = addJTextFields();
		label = addJLabels();
		font = addsFonts();
		icon = addIcons();
		GridBagConstraints gbc = new GridBagConstraints();
		Dimension dim = new Dimension(175, 40);

// Left Panel
		panel[0].setLayout(new BorderLayout());
		panel[0].setPreferredSize(new Dimension(475, 600));
		panel[0].setBackground(Color.white);

		panel[0].add(panel[2], BorderLayout.NORTH); //North Panel on the Login panel
		panel[2].setBackground(Color.white);
		panel[2].add(label[0]);//Login Label
		panel[2].add(label[1]);//Register Label

		panel[0].add(panel[3], BorderLayout.CENTER); 
		panel[3].setLayout(new CardLayout()); //Setting Panel[3] to Card Layout 
		panel[3].add(panel[4]); //Login Panel Card
		panel[3].add(panel[5]); //Register Panel Card
		panel[4].setBackground(Color.white);
		panel[5].setBackground(Color.white);

/**** Adding Login Panel Components ****/
		panel[4].add(panel[6], BorderLayout.NORTH); 
		panel[6].setPreferredSize(new Dimension(400, 58));
		panel[6].setBackground(Color.white);
		label[2].setFont(font[2]);
		panel[6].add(label[2]); //Adding the "Already got an Account"

//Adding username and password textfields to the Center panel [7] of the Login Panel
		panel[4].add(panel[7], BorderLayout.CENTER);
		panel[7].setPreferredSize(new Dimension(400, 410));
		panel[7].setBackground(Color.white);
		panel[7].setBorder(BorderFactory.createLineBorder(new Color(47,62,82), 2));
		panel[7].setLayout(new GridBagLayout()); // Change the Center panel layout to GridBagLayout
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 0, 5 );
		label[9].setIcon(icon[0]); //User icon set to the Label [4]
		panel[7].add(label[9], gbc); //Username icon label added to the center panel

		gbc.gridx = 1;
		gbc.gridy = 0;
		usernametxt.setFont(font[0]);// Change the font of the Username
		usernametxt.setBorder(border);// Change the border of the username
		panel[7].add(usernametxt, gbc); //Username Textfield

		gbc.gridx = 1;
		gbc.gridy = 1;
		label[4].setFont(font[3]);// Change the font of the Username Label
		gbc.insets = new Insets(0, 0, 0,140 );
		panel[7].add(label[4], gbc); //Username Label
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(50, 0, 0,0 );
		label[10].setIcon(icon[1]); //Lock Icon set to the Label [5]
		panel[7].add(label[10], gbc);//Password Icon

		gbc.gridx = 1;
		gbc.gridy = 2;
		passwordtxt.setFont(font[0]); // Change the font of the Password 
		passwordtxt.setBorder(border); //Change the border of the Password
		panel[7].add(passwordtxt, gbc);//Password Textfield

		gbc.gridx = 1;
		gbc.gridy = 3;
		label[5].setFont(font[3]);// Change the font of the Username Label
		gbc.insets = new Insets(0, 0, 0,140 );
		
		panel[7].add(label[5], gbc); //Username Label

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.insets = new Insets(50, 0, 0,0 );
		label[16].setVisible(false);
		panel[7].add(label[16], gbc);

/***** South Panel of the Login Panel ****/
		panel[4].add(panel[8], BorderLayout.SOUTH);
		panel[8].setPreferredSize(new Dimension(400, 50));
		panel[8].setBackground(new Color(96,208,193));
		loginBtn.setPreferredSize(dim);
		panel[8].add(loginBtn);// Login Button
/****************************************************************
 *
 * 
 *
/**** Adding Register Panel Components ****/
	panel[5].add(panel[9], BorderLayout.NORTH);// Panel [5] is one of the panels added to the Card Layout Panel [3]
	panel[9].setPreferredSize(new Dimension(400, 75));
	panel[9].setBackground(Color.white);
	label[3].setFont(font[2]);
	panel[9].add(label[3]); //"Don't an Account?" Label

	//Center Panel for Registration Panel
	panel[5].add(panel[10], BorderLayout.CENTER);
		panel[10].setPreferredSize(new Dimension(400, 393));
		panel[10].setBackground(Color.white);

		panel[10].setLayout(new GridBagLayout());
		gbc.insets = new Insets(0, 0, 0, 50); 
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		// gbc.insets = new Insets(20, 0, 0, 0); 
		textField[0].setFont(font[0]);
		panel[10].add(textField[0], gbc); //First name Textfield

		gbc.gridx = 0;
		gbc.gridy = 1;
		label[6].setFont(font[3]);
		panel[10].add(label[6], gbc); //First name Label

		gbc.gridx = 1;
		gbc.gridy = 0;
		textField[1].setFont(font[0]);
		gbc.insets = new Insets(0, 0, 0, 0);
		panel[10].add(textField[1], gbc);  //Last name Textfield

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		label[7].setFont(font[3]);
		panel[10].add(label[7], gbc); //Last name Label
	
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(20, 0, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		textField[2].setFont(font[0]);
		panel[10].add(textField[2], gbc); //Email Textfield

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 0, 0);
		label[8].setFont(font[3]);
		panel[10].add(label[8], gbc); // Email Label

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(20, 0, 0, 0);
		textField[3].setFont(font[0]);
		panel[10].add(textField[3], gbc); //Username Textfield

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(0, 0, 0, 0);
		label[11].setFont(font[3]);
		panel[10].add(label[11], gbc); // Username Label

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(20, 0, 0, 0);
		textField[4].setFont(font[0]);
		panel[10].add(textField[4], gbc); //Password Textfield

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.insets = new Insets(0, 0, 0, 0);
		label[12].setFont(font[3]);
		panel[10].add(label[12], gbc); // Password Label

		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.insets = new Insets(30, 0, 0, 0);
		label[13].setVisible(false);
		label[13].setIcon(icon[2]);
		label[13].setForeground(new Color(149,70,93));
		panel[10].add(label[13], gbc); // OK Icon Label

		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.insets = new Insets(0, 0, 0, 0);
		label[14].setVisible(false);
		label[14].setForeground(new Color(149,70,93));
		panel[10].add(label[14], gbc); // OK Label


/***** South Panel of the Registration Panel ****/
	panel[5].add(panel[11], BorderLayout.SOUTH);
		panel[11].setPreferredSize(new Dimension(400, 50));
		panel[11].setBackground(new Color(47,62,82));
		registerBtn.setPreferredSize(dim);
		panel[11].add(registerBtn);// Login Button

/****************************************************************
 *
 * 
 * 	
 * 
 * 	
/**** Right Panel Components ****/
		panel[1].setLayout(new GridBagLayout());
		panel[1].setPreferredSize(new Dimension(700, 600));
		panel[1].setBackground(Color.white);
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		label[15].setIcon(icon[3]);
		panel[1].add(label[15], gbc);
		return panel;
	}

	public JTextField[] addJTextFields(){
		font = addsFonts();
		// String[] textFields = {"name", "email", "username", "password"};
        textField = new JTextField[5];
        for (int i = 0; i < textField.length; i++) {
            textField[i] = new JTextField(12);
			textField[i].setFont(font[1]);
			textField[i].setForeground(new Color(36,49,66,255));
			textField[i].setBorder(border);  
			textField[i].addFocusListener(this);
		}
		textField[0] = new JTextField(8);
		textField[0].setBorder(border);  
		textField[0].addFocusListener(this);  
		textField[1] = new JTextField(8);
		textField[1].setBorder(border);
		textField[1].addFocusListener(this);

        return textField;
    }

	public JLabel[] addJLabels(){
		font = addsFonts();
		String[] labels = new String[17]; 
		labels[0] = "Login";
		labels[1] = "Register";
		labels[2] = "Already have an Account?";
		labels[3] = "Don't have an Account?";
		labels[4] = "Username";
		labels[5] = "Password";
		labels[6] = "First Name";
		labels[7] = "Last Name";
		labels[8] = "Email";
		// labels[9] = User Icon
		// labels[10] = Lock Icon
		labels[11] = "username"; //Register Label
		labels[12] = "password";//Register Label
		labels[13] = "";
		labels[14] = "All Done, User Registered";
		// label[15] = "Right Icon";
		labels[16] = "User does not have an Account";

        label = new JLabel[labels.length];
        for (int i = 0; i < label.length; i++) {
            label[i] = new JLabel(labels[i]);
			label[i].addMouseListener(this);
			label[i].setForeground(new Color(47,62,82));
			label[i].setHorizontalAlignment(JLabel.CENTER);
        }

		label[0].setBackground(new Color(96,208,193)); // Login Label  Backgroud Color
		label[1].setBackground(new Color(47,62,82)); //Register Label Backgroud Color
		
		label[0].setForeground(Color.white);
		label[1].setForeground(Color.white);

		label[0].setOpaque(true);
		label[1].setOpaque(true);

		label[0].setPreferredSize(new Dimension(195, 50));
		label[1].setPreferredSize(new Dimension(195, 50));

		label[0].setFont(font[0]);
		label[1].setFont(font[0]);
		label[4].setForeground(new Color(47,62,82));
		label[5].setForeground(new Color(47,62,82));
		
		Dimension size = new Dimension(300, 40);
		label[2].setPreferredSize(size); //"Already have an Account?" Label
		label[2].setForeground(new Color(47,62,82));
		// label[2].setBorder(border);  //Changing the border for Label 2

		label[3].setPreferredSize(size); //"Dont have an Account?" Label
		label[3].setForeground(new Color(47,62,82));
		// label[3].setBorder(border);  //Changing the border for Label 3
	
        return label;
    }

	public ImageIcon[] addIcons(){
		String[] iconNames = {"user.png", "lock.png", "ok.png", "front.png"};
		icon = new ImageIcon[iconNames.length];
		for (int i = 0; i < icon.length; i++) {
			icon[i] = new ImageIcon(iconNames[i]);
		}
		return icon;
	}

	public Font[] addsFonts() {
		font =  new Font[4];
		font[0] = new Font("TimesRoman", Font.BOLD, 20); //Login and Reg Labels Font
		font[1] = new Font("Monospaced", Font.PLAIN, 19); //textfields Labels Font
		font[2] = new Font("TimesRoman", Font.PLAIN, 20); //Question Labels Font
		font[3] = new Font("TimesRoman", Font.PLAIN, 15); // Username and password Labels Font
		return font;	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String usernameln = usernametxt.getText().trim();
		String passwordln = String.valueOf(passwordtxt.getPassword()).trim();
		String firstnameln = textField[0].getText();
		String lastnameln = textField[1].getText();
		String email = textField[2].getText();

		String username = textField[3].getText();
		String password = textField[4].getText();
		

/*****Register Method */
if(e.getSource() == registerBtn)
{
	System.out.println("Resgister");
	if(e.getSource() == registerBtn)
	{
			user = new Users(firstnameln, lastnameln, email, username, password );
					
			
			if(firstnameln.isEmpty()) 
			{
				System.out.println("Working");
				JOptionPane.showMessageDialog(this, "First Name cannot be empty");
			}
			else if(lastnameln.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Last cannot be empty");
			}
			else if(email.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Email cannot be empty");
			}
			else if(!email.contains(".com"))
			{
				JOptionPane.showMessageDialog(this, "Email is not a Valid Email. Add [.com]");
			}
			else if(email.contains("$") || email.contains(",") || email.contains("#"))
			{
				JOptionPane.showMessageDialog(this, "Email cannot contain special characters");
			}
			else if(username.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Username cannot be empty");
			}
			else if(username.contains("$") || username.contains(",") || username.contains("#"))
			{
				JOptionPane.showMessageDialog(this, "Username cannot contain special characters");
			}
			else if(password.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Password cannot be empty");
			}
			
		else 
		{
			if(!userlist.contains(user))
			{	String fileIn = "Users.txt" ;
				String directory = "/Users/lask0d3/Desktop/";
				userlist.add(user);
				try {
					File file =  new File(directory + fileIn);
					


					BufferedReader bur = new BufferedReader(new FileReader(file));
					String line;

					PrintWriter print = new PrintWriter(new FileWriter(file, true));
					

					while((line = bur.readLine()) != null){
						System.out.println(line);
					
					}

					if(!line.contains(username)){
						System.out.println("no match so writing");
						print.println("Username " + user.getUsername() +"\n" + "Password "+ user.getPassword());
					}
					else{
						System.out.println("Dont match");
					}
					System.out.println("success");
					
					print.close();
					bur.close();
					
				
				} catch (Exception e1) {	
					e1.getMessage();
				}
			
				
				System.out.print("User has successfully registered");
					for (Users users : userlist) 
					{
						System.out.println(users.getFirstName() + " " +users.getUsername() + " "+users.getPassword());
						label[13].setVisible(true);	
						label[14].setVisible(true);	
					}
					
					// label[13].setText(null);
					// label[14].setText(null);

			}
			else{
					System.out.print("Not registered");
				}
		}
	}
}

if(e.getSource() == registerBtn && e.getSource() == loginBtn){
	label[13].setVisible(false);	
	label[14].setVisible(false);	
}

/*****Login Method */
	if (e.getSource()==loginBtn ) 
	{	
		username = "sdsd";
		password = "password";

		user = new Users(firstnameln, lastnameln, email, username, password );
		
			if(usernameln.isEmpty()) 
			{
				System.out.println("Working");
				JOptionPane.showMessageDialog(this, "Username cannot be empty");
			}
			else if(passwordln.isEmpty())
				{
					JOptionPane.showMessageDialog(this, "Password cannot be empty");
				}

			else if(!user.getUsername().equals(usernameln) && !user.getPassword().equals(passwordln)) {
				JOptionPane.showMessageDialog(this, "User not registered");
			}
				
			else
			{	
				String fileIn = "Users.txt" ;
				String directory = "/Users/lask0d3/Desktop/";
				try {
					File file =  new File(directory + fileIn);
					// File[] files = file.listFiles();

				BufferedReader bur = new BufferedReader(new FileReader(file));
				String line;
			
				while((line = bur.readLine()) != null){
					if(line.contains(usernameln)){
						System.out.println("great match");
						
					}
					else{
						System.out.println("Dont match");
					}
				}
					
				
					

				bur.close();
				}
				catch(Exception e1){
					e1.getMessage();
				}	



					//  for (Users users : userlist) 
					//  {
					//  	if(users.getUsername().equals(usernameln) && users.getPassword().equals(passwordln)) {
					//  		System.out.println("Hello");
					//  	}
					// 	else if(users.getUsername().equals(usernameln) && !users.getPassword().equals(passwordln)){
					// 		System.out.println("Wrong password");
					// 	}
					//  	else{
					// 		System.out.println("Not registered");
					// 		label[5].setVisible(true);
					//  	}
					//  }
			}
	}

}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == label[0]){
			panel[4].setVisible(true);
			panel[5].setVisible(false);
		}
		if(e.getSource() == label[1]){
			panel[5].setVisible(true);
			panel[4].setVisible(false);
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void focusGained(FocusEvent e) {
		
		if(e.getSource() == usernametxt)
		{
			usernametxt.setText(null);
			usernametxt.setForeground(new Color(47,62,82));
			label[4].setForeground(new Color(149,70,93));
		}
		if(e.getSource() == passwordtxt)
		{
			passwordtxt.setText(null);
			passwordtxt.setForeground(new Color(47,62,82));
			label[5].setForeground(new Color(149,70,93));
		}
		
		if(e.getSource() ==  textField[0]) //First Name
		{
			textField[0].setText(null);
			textField[0].setForeground(new Color(47,62,82));
			label[6].setForeground(new Color(149,70,93));
		}

		if(e.getSource() ==  textField[1]) //Last Name
		{
			textField[1].setText(null);
			textField[1].setForeground(new Color(47,62,82));
			label[7].setForeground(new Color(149,70,93));
		}

		if(e.getSource() ==  textField[2]) //Email
		{
			textField[2].setText(null);
			textField[2].setForeground(new Color(47,62,82));
			label[8].setForeground(new Color(149,70,93));
		}

		if(e.getSource() ==  textField[3]) //Username
		{
			textField[3].setText(null);
			textField[3].setForeground(new Color(47,62,82));
			label[11].setForeground(new Color(149,70,93));
		}

		if(e.getSource() ==  textField[4]) //Password
		{
			textField[4].setText(null);
			textField[4].setForeground(new Color(47,62,82));
			label[12].setForeground(new Color(149,70,93));
		}

	}
	
	@Override
	public void focusLost(FocusEvent e) {

		if(e.getSource() == usernametxt){
				usernametxt.setText(usernametxt.getText());
				label[4].setForeground(new Color(230,230,230,255));
			}

			if(e.getSource() == passwordtxt)
			{
				passwordtxt.setText(String.valueOf(passwordtxt.getPassword()));
				label[5].setForeground(new Color(230,230,230,255));
			}

		if(e.getSource() ==  textField[0]) //First Name
		{
			textField[0].setText(textField[0].getText());
			label[6].setForeground(new Color(230,230,230,255));
		}

		if(e.getSource() ==  textField[1]) //Last Name
		{
			textField[1].setText(textField[1].getText());
			label[7].setForeground(new Color(230,230,230,255));
		}

		if(e.getSource() ==  textField[2]) //Email
		{
			textField[2].setText(textField[2].getText());
			label[8].setForeground(new Color(230,230,230,255));
		}

		if(e.getSource() ==  textField[3]) //Email
		{
			textField[3].setText(textField[3].getText());
			label[11].setForeground(new Color(230,230,230,255));
		}

		if(e.getSource() ==  textField[4]) //Email
		{
			textField[4].setText(textField[4].getText());
			label[12].setForeground(new Color(230,230,230,255));
		}

		
	}
}
