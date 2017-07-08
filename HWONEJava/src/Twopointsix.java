import java.util.Scanner;

public class Twopointsix {
	//CS 113 Section 002, Jaime Nufio
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float miles,cFactor = 1.60935f;
		
		System.out.println("Enter an amount in miles to convert to Kilometers:");

		miles = Float.parseFloat(scan.next());
		System.out.println(miles*cFactor);
		scan.close();
	}

}
