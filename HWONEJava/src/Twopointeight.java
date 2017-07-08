import java.util.Scanner;

public class Twopointeight {
	//CS 113 Section 002, Jaime Nufio
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] units = {"hours","minutes","seconds"};
		double step,seconds = 0;
		
		for (int i = 0; i<3;i++){
			System.out.println("Enter a time amount in "+units[i]+":");
			step = scan.nextDouble();
			seconds += step*Math.pow(60,(2-i));
		}
		
		System.out.println("Got: "+seconds+" Seconds.");
		
		scan.close();
	}

}
