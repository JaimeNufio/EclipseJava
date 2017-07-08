import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends JFrame{

	public static boolean[] currentWorld = new boolean[100], newWorld = new boolean[100];
	public static int[] edge = new int[5], middle = new int[8], corner = new int[3],
			conditionedStart = {15,14,13};
	public static JLabel[] map = new JLabel[100];
	public static String tru = "X", fals = " ";
	public static boolean Center = false, State = false, Corner,
			startwithrules = true;
	
	
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) throws InterruptedException {
		
		new Game().setVisible(true);

		while (true){
			Thread.sleep(500);
			update();
		}
	}
	
	
	private Game(){
		
		super("Hello, World");
		
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(11,11));

		for (int i = 0; i < map.length; i++){
            map[i] = new JLabel(i+"", JLabel.CENTER);
        }
        
        for (int i = 0 ; i < map.length; i++){
            add(map[i]);
        }
        
		if (!startwithrules){ //random
			for (int i = 0; i < currentWorld.length; i++){
				if (Math.random() < .5 ){
					currentWorld[i] = true;
				}else{
					currentWorld[i] = false;
				}
			}
		}else{
			for (int i = 0; i < currentWorld.length; i++){
				for (int k = 0; k < conditionedStart.length; k++){
					if (i == conditionedStart[k]){
						currentWorld[i] = true;
						map[i].setText(tru);
						System.out.println(i+" is true");
					}else{
						//currentWorld[i] = false;
//						map[i].setText(fals);
					}
						map[i].setToolTipText("This is cell "+i);
				}
			}
		}
	}
	
	public static int determineArea(int spot){
		
		int x = 0;
		
		if (spot % 10 == 9){
			
			x = 1; //right edge
		} else if ((spot % 10 == 0) && !(spot == 0)){
			x = 2; //left edge
		} else if (spot < 10){
			x = 3; //top
		} else if (spot > 90){
			x = 4; //bottom
		} else{
			x = 5; //failed all tests, neutral
			
		}
		
		if((spot == 0)||(spot == 9)||(spot == 90)||(spot == 99)){
			x = 6; //Special case, corner
		}
		
		return x; 
		
	}
	
	public static void right(int spot){ //identifies neighbors
		//Starts at 12, going counter clockwise
		edge[0] =  spot-10; edge[1] = spot-9; edge[2] = spot-1; edge[3] = spot+9; edge[4] = spot+10;
	}
	
	public static void left(int spot){
		//starts at 12, going clockwise
		edge[0] = spot-10; edge[1] = spot-9; edge[2] = spot+1; edge[3] = spot+11; edge[4] = spot+10;
	}
	
	public static void top(int spot){
		//clockwise
		edge[0] = spot+1; edge[1] = spot+11; edge[2] = spot+10; edge[3] = spot+9; edge[4] = spot-1;
	}
	
	public static void bottom(int spot){
		//counterclockwise
//		System.out.println("bottom");
		edge[0] = spot-1; edge[1] = spot-11; edge[3] = spot-10; edge[3] = spot-9; edge[4] = spot+1;
	}
	
	public static void neutral(int spot){
		//clockwise
		middle[0] = spot-10; middle[1] = spot-9; middle[2] = spot+1; middle[3] = spot+11; 
		middle[4] = spot+10; middle[5] = spot+9; middle[6] = spot-1; middle[7] = spot-11;
		Center = true;
	}
	
	public static void corner(int spot){
		//clockwise
		Corner = true;
		if (spot == 0){
			corner[0] = 1; corner[1] = 11; corner[2] = 10;
		}else if (spot == 9){
			corner[0] = 20; corner[1] = 19; corner[2] = 9;
		}else if (spot == 90){
			corner[0] = 80; corner[1] = 81; corner[2] = 91;
		}else if (spot == 99){
			corner[0] = 98; corner[1] = 88; corner[2] = 89;
		}
	}
	
	public static boolean checkliving(int[] cluster){
		
		boolean value = true;
		int num = 0;
		
		for (int i = 0; i < cluster.length; i++){
//			System.out.println("cluster spot ["+i+"] stored "+cluster[i]);
			if (currentWorld[cluster[i]]){
				num++;//tally true
			}
		}
		
		if ((num < 2) || (num > 3 )){
			value = false; //everything else would give a true case, which implies life, even in the "dead"
		} else if ((num == 2) || (num == 3)){
			value = true;
		}
		
		return value;
	}

	public static void update(){
		
		for (int i = 0; i < map.length; i++){
			
			Corner = Center = false;
//			System.out.println("Space "+i);
			switch(determineArea(i)){//determine pos
				case 1:
					right(i); //right
					break;
				case 2:
					left(i);//left
					break;
				case 3:
					top(i);//top
					break;
				case 4:
					bottom(i);//bottom
					break;
				case 5:
					neutral(i); //neutral
					break;
				default:
					corner(i);
					break;
			} //the clusters are set!
			
			if (Corner){
				State = checkliving(corner);
			}else if (Center){ //statement decides what state to send the 
				State = checkliving(middle);
			}else{
				State = checkliving(edge);
			}
			newWorld[i] = State; //setup new world, from State
			//this way we have a stamp for the future to replace the currentWorld
		}
		//after this point, the newWorld has been defined
		for (int i = 0; i < currentWorld.length; i++){
			
			currentWorld[i] = newWorld[i];
			
			if (currentWorld[i]){
				map[i].setText(tru);
			}else{
				map[i].setText(fals);
			}
		} //flush out the new
	}
}
