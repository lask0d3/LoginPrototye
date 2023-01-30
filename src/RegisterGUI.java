import javax.swing.*;
import java.awt.*;


public class RegisterGUI  extends JFrame {
    JFrame frame = new JFrame();
    public RegisterGUI(){
        frame.setSize(950, 570);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.getContentPane().setBackground(new Color(151,208,203));
        
        frame.setVisible(true);
    }
}
