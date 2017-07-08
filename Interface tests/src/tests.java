import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class tests extends JFrame {

	public ButtonGroup group = new ButtonGroup();
	private JPanel contentPane;
	public static JRadioButton radio1 = new JRadioButton("New radio button"), radio0 = new JRadioButton("New radio button");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tests frame = new tests();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tests() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		radio0.setBounds(6, 7, 109, 23);
		radio0.setMnemonic(KeyEvent.VK_1); 
		contentPane.add(radio0);
		
		radio1.setBounds(6, 44, 109, 23);
		contentPane.add(radio1);
		
			group.add(radio0);
			group.add(radio1);
		    

	}
	
	public static void linkButtons(){
		
		(radio0).addActionListener(this {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("One");
			}
		});

		System.out.println("Buttons Linked");
		
	}
	
	
}
