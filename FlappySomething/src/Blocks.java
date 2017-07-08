import java.awt.Color;

import javax.swing.JLabel;

public class Blocks extends JLabel{

	public void move(){
		if (this.getLocation().x > 0) {
			this.setBounds( (int) (this.getLocation().getX()-1), (int) (this.getLocation().getY()), this.getSize().width, this.getSize().height);
		}else{
			this.setBounds(0, this.getLocation().y, this.getSize().width-1, this.getSize().height);
		}
		
		if (this.getSize().getWidth() <= 2){
			this.remove(this);
		}
	}
	
	public void place(int x, int y) throws InterruptedException{
		int maxX = 450-x, maxY = 300-y;
		this.setBounds(maxX, maxY , x, y);
	}
	
	Blocks(){
		super();
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		setVisible(true);
		setOpaque(true);
		setBounds(23,25,50,50);
	}

}
