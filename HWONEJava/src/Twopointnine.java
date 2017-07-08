import java.util.Scanner;

public class Twopointnine {
	//CS 113 Section 002, Jaime Nufio
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] units = {"hours","minutes","seconds"};
		double[] unitsSec = new double[3];
		double mag,step,seconds = 0;
		
		
		System.out.println("How many seconds do you have?");
		seconds = scan.nextDouble();
		
		System.out.println("Got:");
		for (int i = 0; i<3;i++){
			mag = (Math.pow(60, 2-i)); //Convert to the power of 60 we're using
			step = seconds-(seconds%mag); // get the dividend
			unitsSec[i] = step/mag; // divide dividend by magnitude to get # of that unit
			seconds -= unitsSec[i]*mag; // adjust sum of the base unit
			
			System.out.println(units[i]+": "+unitsSec[i]);
		}
		
		
		scan.close();
	}

}
