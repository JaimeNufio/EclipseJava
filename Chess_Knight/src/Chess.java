import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chess extends JFrame {

	private JPanel contentPane;
	public static Place[] spot =  new Place[64];

	private Chess() {
		
		super("Hello, World");
		
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(8,8));
		
		for (int i = 0; i < spot.length; i++){
			spot[i] = new Place(i);
        }
        
        for (int i = 0 ; i < spot.length; i++){
            add(spot[i]);
    	//	spot[i].addMouseListener(new MouseAdapter()   {   
//    	        public void mouseClicked(MouseEvent e){   
//    	        	System.out.println(this.);
//    	        }   
//    		});
        }
	}
	
	
	
	public static void main(String[] args) {
		new Chess().setVisible(true);
	}
	
//		getContentPane().setLayout(new GridLayout(8,8));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 640, 640);
//		contentPane = new JPanel();
//		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		for (int i = 1; i<(spot.length+1); i++){
//			spot[i-1] = new Place(i);
//			contentPane.add(spot[i-1]);
//		}

}
