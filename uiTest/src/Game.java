import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends JFrame{

	public static int snakeSize = 5, snakeStart = 5,
			frames = 10000, xMax = (int)Math.sqrt(frames)+1, speedMult = 5;
	
	
	public static JLabel map[] = new JLabel[frames];
	public static Boolean visible[] = new Boolean[frames];
	public static int currentSnake[] = new int[frames], newSnake[] = new int[frames];

	
	static Color one = Color.orange, two = Color.GRAY, three = Color.BLACK, fals = Color.WHITE, head = Color.RED;

	
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) throws InterruptedException {
		
		new Game().setVisible(true);
		
		for (int i = 0; i <  frames; i++){
			visible[i] = false;
		}
		
		constructSnake();
		updateLabels();
		

		
		boolean poof = true;
		
		while (poof){
			System.out.println("Update:");
			for (int i = 0; i < visible.length; i++){
				if (visible[i]){
					System.out.println(i+" Got "+visible[i]);
				}
			}
			moveSnake();
			updateLabels();
			Thread.sleep(100/speedMult);
		}
	}
	
	private Game(){ //constructor
		
		super("Snake Test");
		
		setSize(700,700);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(xMax,xMax));

		for (int i = 0; i < map.length; i++){
            map[i] = new JLabel("", JLabel.CENTER);
            map[i].setToolTipText(i+" label");
            map[i].computeVisibleRect(getBounds());
            map[i].setBackground(Color.red); //tells me what wasn't edited
            map[i].setOpaque(true);
        }
        
        for (int i = 0 ; i < map.length; i++){
            add(map[i]);
        }
	}

	public static void constructSnake(){//this method just establishes where to put what
		
		for (int i = 0; i < snakeSize; i++){ //number of parts, 5 to start
			currentSnake[i] = (int) (snakeStart+(Math.sqrt(frames)*i));
			//first seg of snake = snake start, plus row multiplier
			visible[currentSnake[i]] = true;
			//Orignally map[currentSnake[i]], but lets keep reffrences to map only in the update
		}
		
	}
	
	public static void updateLabels() {
		
		int count = 0;
		for (int i = 0; i < map.length; i++){
			if (visible[i]){
				count++;
				switch (count){
				
					case 1:
						map[i].setBackground(one);
						break;
					case 2:
						map[i].setBackground(two);
						break;
					case 3:
						map[i].setBackground(three);
						count = 0;
				}
			}else{
				map[i].setBackground(fals);
			}
			
			if (i == currentSnake[0]){
				map[i].setBackground(head);
			}
		}
		
	}
	

	public static void moveSnake(){
		int movement = 1;//-(xMax-1); //dir
		int old = currentSnake[snakeSize-1];
		
		//TODO determine the numbers that include going off screen currentSnake[0]+movement
		
		newSnake[0] = currentSnake[0]+movement;
		/*
		if (newSnake[0] == -1){
			newSnake[0] = 99;
			System.out.println("moved to 99");
		} else if (newSnake[0] == 1000){
			newSnake[0] = 9900;
		}
		*/
		
		if (!(visible[newSnake[0]])){
			System.out.println("Crashed at "+newSnake[0]);
			
		}
		
		if (newSnake[0] >= frames){ //case, out south in north
			newSnake[0] = newSnake[0]-frames;
		}
		
		if  (newSnake[0] < 0){ //case, out north, in south
			newSnake[0] = newSnake[0]+frames;
		}
		
		//max is 10000, 9999 is the last spot
		//edges follow format xx99
		for (int i = 0; i <100-1; i++){
			int num = (i*100); //but remember, if newSnake is equal to x100,  currentSnake is xx99
			
			if((newSnake[0] == num)&&(movement == 1)){ //case, out right, in left; make sure the snake is crossing for x99 to 100
				newSnake[0] = num-100;//newSnake[0];
				break;
			}
			if((newSnake[0] == num-1)&&(movement == -1)){
				System.out.println("moved left, "+num);
				newSnake[0] = num+99;
				break;
			}
			
		}
		
		
		
		//TODO Fix Collision, ensure that visible can detect where the snake is standing.
		
		//Moves Snake
		for (int i = 1; i < snakeSize; i++){ //define new snake piece as a step ahead of old snake, use snakeSize, an int to judge size
				newSnake[i] = currentSnake[i-1];
		}	
		
		//Updates Snake
		for (int i = 0; i < snakeSize; i++){
			currentSnake[i] = newSnake[i];
		}
		
		//Updates what is collidable
		for (int i = 0; i < snakeSize; i++){
			visible[currentSnake[i]] = true;
		}	
		
		visible[old] = false;
		
	}
	
}



