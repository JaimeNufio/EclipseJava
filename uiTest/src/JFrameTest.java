
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameTest extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new JFrameTest().setVisible(true);
	}
	
	private JFrameTest(){
		
		super("Hello, World");
		
		setSize(500,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,2));
		initialize();
	}
	
	private void initialize(){
		
		JButton btn1;
		
		btn1 = new JButton("Clicker");
		btn1.addActionListener(this);
		
		add(btn1);
		//pnl1.add(btn1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		
		if (name == "Clicker"){
			System.out.println("Test");
		}
	}

}
