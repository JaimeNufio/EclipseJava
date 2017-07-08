import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Place extends JLabel {
	
	public String name;
	public int pos;
	public int[] vector2 = new int[2];
	public boolean isBlack;
	public Color tint;
	public static final String blackHorse = "/knight.png",whiteHorse = "/knight1.png";
	public String horsey;
	
	
	private Color colorMe(int pos){
		Color roll = Color.CYAN;
		pos++;
		if (pos > 16){
			pos = pos%16;
		}
		if (pos <= 8 && pos != 0){
			if (pos%2 == 1){
				roll = Color.white;
			}else{
				roll = Color.black;
			}
		}else if (pos <= 16){
			if (pos%2 == 0){
				roll = Color.white;
			}else{
				roll = Color.black;
			}
		}
		
		return roll;
	}
	
	public void setVector(int pos){
		this.vector2[0] = pos%8;
		this.vector2[1] = (int) Math.ceil(pos/8);
	}
	
	Place(int position){
		
		name = "Tile # "+position;
		pos = position;
		tint = colorMe(pos);
		
		setSize(100,100);
		setVisible(true);
		setBorder(BorderFactory.createLineBorder(Color.gray));
		setBackground(tint);
		
		if (tint == Color.BLACK){
			isBlack = true;
			horsey = whiteHorse;
		}else{
			isBlack = false;
			horsey = blackHorse;
		}
		
		setVector(pos);
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLayout(new GridLayout(3,3));

		addMouseListener(new MouseAdapter()   {   
	        public void mouseClicked(MouseEvent e){   
	        	System.out.println(name+"Found At("+vector2[0]+","+vector2[1]+")");

	        	
	    		setIcon(new ImageIcon(getClass().getResource(horsey)));
	        }   
		});
		//this.setBackground(new Color(pos,pos,pos));
		setOpaque(true);

	}
}
