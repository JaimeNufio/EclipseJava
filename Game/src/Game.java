import java.awt.Color;
import java.util.Random;

import javax.swing.JLabel;

public class Game {

	public static int valA = 0, valB = 0, score = 0, max = 3, min = 0,
	count = 0, lossCount = 0, level = 1, streak = 0;
	
	public static Color[] Rainbow = {Color.RED,Color.ORANGE,Color.GREEN,Color.BLUE,new Color (255,0,255),Color.YELLOW};
	public static String[] congratulations = {"Good!","Excellent!","Fantastic!","Superb!","Outstanding!"};
	
	public static Random rand = new Random();
	
	public static int num(int high, int low){
		return rand.nextInt((high-low)+1)+low;
	}
	
	public static void updateRange(){
		max = level+2;
	}
	
	public static void updateVal(){
		
		int oldA = valA, oldB = valB;
		valA = num(max, min);
		valB = num(max, min);
		
		if ((oldA == valA) && (oldB == valB)) {
			updateVal();
		}
		
	}
	
	
	public static boolean answerState(String text){
		return valA*valB == Double.parseDouble(text);
	}
	
	public static void checkAnswer(String text){
		if (answerState(text)) {
			count++;
			streak++;
			score++;
//			System.out.println("correct! streak of "+count);
		}else{
			count = 0;
			lossCount++;
			streak = 0;
			score--;
//			System.out.println("wrong! losing steak of "+lossCount);
		}
		
		if (count == 5){
			level++;
			score++;
			updateRange();
			count = 0;
//			System.out.println("Level up!");
		}else if (lossCount == -5){
			if (level != 0){
				level--;
			}
			updateRange();
			lossCount = 0;
		}

	}
	
	public static String updateText(){
		return valA+" x "+valB+" = ?";
	}
	
	public static void generalUpdate(JLabel box,String text){
		box.setText(text);
	}
	
	public static Color colors(){
		return Rainbow[(int)num(Rainbow.length-1,0)];
	}
	
	public static String strings(){
		return congratulations[(int)num(congratulations.length-1,0)];
	}
	
}
