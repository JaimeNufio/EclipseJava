import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;


public class Game {

	static int movement = 0;// Atk = 1, Def = 2, Par = 3, Esc = 4
	public static String[][] battle = {{"Attack","Defend","Parry","Special"},{"Attack with a physical blow.","Raise your defense to block the next blow.","Attempt to parry the attack, returing 1.5x of damage that would have been dealt to you.","This attack costs SPIRIT, if your SPIRIT is lacking, it will fail."}},
			classes = {{"Warrior","Rouge","Archer","Mage"},{"Bulky character, slower, but makes up for that in deffense and strength.","Fast, nimble, but deals little damage.","The Archer is a well rounded character.","The Mage relies heavily on SPIRIT for his strength."}},
			Continue = {{"Continue","Continue","Continue","Continue"},{"Press any button.","Press any button.","Press any button.","Press any button."}},
			items = {{"Vigor Potion","Piety Book","Hero's Cloak","Champions Blade"},{"Have a larger maximum health.","Restore SPIRIT faster.","Become more evasive.","Tougher steel. Harder hits."}};
	
 	public static void linkButtons(TheFrame frame){
		
		((JButton) frame.btnAtk).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				movement = 1;
				System.out.println("Movement is now "+movement);
			}
		});
		
		((JButton) frame.btnDef).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				movement = 2;
				System.out.println("Movement is now "+movement);
			}
		});
		
		((JButton) frame.btnPar).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				movement = 3;
				System.out.println("Movement is now "+movement);
			}
		});
		
		((JButton) frame.btnEsc).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				movement = 4;
				System.out.println("Movement is now "+movement);
			}
		});
		
		System.out.println("Buttons Linked");
		
	}
	
	public static String typer(int number, String text){
		String newText = "";
		newText = text.substring(0,number);
		return newText;
		
		/*
		 * 	String text = "Hello, World!";
		 *	for (int i = 0; i <= text.length(); i++){
		 *		System.out.println(typer(i,text));
		 *	}
		 *
		 */
	}
	
	public static void type(String text, JLabel box) throws InterruptedException{
		for (int i = 0; i <= text.length(); i++){
			//System.out.println("trying to change text");
		 	box.setText(typer(i,text));
		 	Thread.sleep(100);
		}
	}
	
	/*		Code for checking a change in input, and then typing
	 * 		while (true){
			Thread.sleep(50);
			System.out.println("?");
			if (!(movement == 0)){
				System.out.println("Not blanks");
				type("Hello World! This is a test!",frame.labelSpeech);
				movement = 0;
			}
		}
	 */
	
	public static int move(String[][] classes) throws InterruptedException{
		int number = 0;
		while (true){
			Thread.sleep(50);
			if (!(movement == 0)){
				number = movement;
				break;
			}
		}
		System.out.println(classes[0][number-1]);
		movement = 0;
		return number;
	}
	
	public static void setSelectMode(TheFrame frame,String[][] option){
		movement = 0;
		frame.btnAtk.setText(option[0][0]);
		frame.btnAtk.setToolTipText(option[1][0]);
		frame.btnDef.setText(option[0][1]);
		frame.btnDef.setToolTipText(option[1][1]);
		frame.btnPar.setText(option[0][2]);
		frame.btnPar.setToolTipText(option[1][2]);
		frame.btnEsc.setText(option[0][3]);	
		frame.btnEsc.setToolTipText(option[1][3]);
	}
	
	public static void main(String[] args) throws InterruptedException  {
		
		int Number = 0;
		TheFrame frame = new TheFrame();
		setSelectMode(frame,Continue);
		linkButtons(frame);
		
		Chara player = new Chara();
		
		type("Welcome, yonder traveler!",frame.labelSpeech);
		Number = move(Continue);
		
		setSelectMode(frame,classes);
		type("Select a class to begin with!",frame.labelSpeech);
		Number = move(classes);
		
		setSelectMode(frame,Continue);
		type("You have selected the class of "+classes[0][Number-1]+"!",frame.labelSpeech);
		player.build(Number);
		Number = move(Continue);
		
		
		
	}

}
