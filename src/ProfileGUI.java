import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ProfileGUI  extends JFrame
{
	
	JFrame frame = new JFrame("Welcome");

	private JLabel labelWelcm = new JLabel("Welcome to your Profile");
	private JLabel labelImage = new JLabel();
	private JLabel labelUser = new JLabel();
	private JPanel panelTop = new JPanel();
	private JPanel panelCentre = new JPanel();
	private ImageIcon icon = new ImageIcon("user.png");
	//Fonts
	private Font font = new Font("SansSerif", Font.ITALIC, 30);
	private Font font2 = new Font("SansSerif", Font.ITALIC, 18);
	
	public ProfileGUI(){
		frame.setSize(500, 450);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new  BorderLayout());

		// Users user = new Users(Users.username, Users.password);
		
		frame.add(panelTop, BorderLayout.NORTH);
		labelImage.setIcon(icon);
		panelTop.add(labelImage);
		

		panelTop.setPreferredSize(new Dimension(500, 225));

		frame.add(panelCentre, BorderLayout.CENTER);
		panelCentre .setLayout(new GridBagLayout());
		panelCentre.setPreferredSize(new Dimension(500, 50));
		panelCentre.setBackground(new Color(30,129,176));
		GridBagConstraints gbc = new GridBagConstraints();
		// gbc.insets = new Insets(0,0,0,0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		labelWelcm.setFont(font);
		labelWelcm.setForeground(Color.white);	
		panelCentre.add(labelWelcm, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		// labelUser.setText("User: " + user.getUsername());
		labelUser.setFont(font2);
		labelUser.setForeground(Color.white);	
		panelCentre.add(labelUser, gbc);
	
	
		frame.setVisible(true);

	}
	
}


