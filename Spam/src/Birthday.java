import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Birthday {

	public static int Days[] = new int[365],doubleDays[] = new int[365];
	public static boolean markedDays[] = new boolean[365];
	public static boolean firstDouble = false;
	public static int globalCount = 0, firstDoubleNum, firstDoubleTrial;


	public static void setYear(){
		for (int i = 0; i< Days.length; i++){
			Days[i] = i+1;
//			System.out.println(Days[i]);
		}
	}
	
	public static void drawDay(){
		globalCount++;
		int day = (1 + (int)(Math.random() * ((365 - 1) + 1)));
		System.out.println("Got birthday of: "+day+" on trial: "+globalCount);
		
		for (int i = 0; i< Days.length; i++){
			if (Days[i] == day){
				if (markedDays[i] == false){
					markedDays[i] = true;
					System.out.println("Unique birtday on day "+i);
				}
				doubleDays[i]++;
				if (doubleDays[i] > 1){
					if (!(firstDouble)){
						firstDouble = true;
						firstDoubleNum = i;
						firstDoubleTrial = globalCount;
					}
					System.out.println("This day has "+doubleDays[i]+" birthdays shared on it.");
				}
			}
		}
	}
	
	public static boolean continueLoop(){
		boolean value = true;
		int check = 0;
		for (int i = 0; i< markedDays.length; i++){
			if (markedDays[i] == true){
				check++;
			}
		}
		
		if (check == 365){
			value = false;
		}
		
		return value;
	}
	
	public static void output() throws FileNotFoundException{
		
		String text = "This is the distribution of birthdays:\n";
		
		for (int i = 0; i < doubleDays.length; i++){
			text = text+"\nDay "+(i+1)+" had "+doubleDays[i]+" birthdays. ";
			if (i == firstDoubleNum){
				text = text+" This was the first day to get a double on trial "+firstDoubleTrial+".";
			}
		}
		
		try(  PrintWriter out = new PrintWriter( "output.txt" )  ){
		    out.print( text );
		}
	}

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		setYear();
		
		while (continueLoop()){
			Thread.sleep(5);
			drawDay();
		}
		
		System.out.println("Everyone in a room sized "+globalCount+" had a birthday on a 365 day year.");
		
		output();
	}

}
