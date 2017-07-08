import java.awt.GridLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TicTacToe extends JFrame {
	
	/*
	 *   0 1 2
	 *   3 4 5
	 *   6 7 8
	 */
	//the buttons
	public static myButton[] map = new myButton[9]; 
	
	public static int[][] winConditions = {
			{0,1,2},{3,4,5},{6,7,8},
			{0,3,6},{1,4,7},{2,5,8},
			{0,4,8},{6,4,2}
		};
	
	//map the priority, possibly use this for ties
	public static int[] priority = new int[8];
	
	//mapping the positions of both parties
	public static boolean[] player = new boolean[9], comp = new boolean[9];
	
	
	private TicTacToe(){
		
		super("Hello, World");
		
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,3));

		for (int i = 0; i < map.length; i++){
			map[i] = new myButton(i+"",i);
        }
        
        for (int i = 0 ; i < map.length; i++){
            add(map[i]);
        }
	}
	
	public static void updateGui(myButton button){
		if (button.state == 1 ){
			button.setText("X");
			//System.out.println(button.getState());
		}else if (button.state == 2){
			button.setText("O");
			//System.out.println(button.getState());
		}else{
			button.setText("");
		}
		
		int Num = button.getState();
		int Name = button.getNumber();
		
		if (Num == 2){
			comp[Name] = true;
			System.out.println("Comp played on spot "+Name);
		}else if (Num == 1){
			player[Name] = true;
			System.out.println("Player played on spot "+Name);
		}
		
	}
	
	public static boolean isFoundInList(int num, int[] list){
		boolean state = false;
		for (int i = 0; i<list.length; i++){
			if (num == list[i]){
				state = true;
				break;
			}
		}
		return state;
	}
	
	public static void predict(){
		int[] playerPos = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
		
		for (int i = 0; i<9; i++){
			if (player[i] == true){
				playerPos[i] = i;
			}
		}
		
		//that should set an array of positions
		
//		for (int i = 0; i<9;i++){
//			System.out.println(playerPos[i]);
//		}
		double counter = 0, spot = 0;
		for (int i = 0; i<winConditions.length; i++){
			counter = 0;
			spot = i;
			for (int j = 0; j<playerPos.length; j++){
				if (isFoundInList(j,winConditions[i])){
					counter++;
					System.out.println(counter);
				}
			}
			if (counter == 2){
				System.out.println("Priority found to be set as condtion"+spot);
				break;
			}
		}
		

	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		new TicTacToe().setVisible(true);

		while (true){
			
			Thread.sleep(2000);
			
			for (int i = 0; i < map.length; i++){
				updateGui(map[i]);
			}
			System.out.println("New Cycle:");
			predict();
			

		}
		
	}

}
