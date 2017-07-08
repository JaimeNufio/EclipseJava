import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class myButton extends JButton {
	
	Color PressedColor = Color.RED, NormalColor = Color.BLACK, RollOverColor = Color.BLACK;
	int state = 0, number = 0; //0 - empty, 1 - player, 2 - computer
	public myButton(String Name,int num){
		
		//super (Name);
		setText(Name);
        setFont(new Font("Arial", Font.PLAIN, 40)); //90
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setBorderPainted(true);
        setName(Name);
        state = 0; //start empty
        number = num;
        

        
        addChangeListener(new ChangeListener() {
        	@Override
        	public void stateChanged(ChangeEvent evt) {
        		if (getModel().isPressed() ) {
        			setBackground(PressedColor);
        			if (state == 0){
        				state = 1;
        			}
        		}else if(getModel().isRollover()) {
        			setBackground(RollOverColor);
        		}else{
        			setBackground(NormalColor);
        		}
        	}
        });
	}

	public int getState() {
		return state;
	}

	public int getNumber() {
		return number;
	}

}
