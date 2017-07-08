import java.util.Scanner;

public class Twopointfive {
	//CS 113 Section 002, Jaime Nufio
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double far;
		
		System.out.println("Enter a temperature in Fahrenheit to convert to Celsius:");
		
		far = Double.parseDouble(scan.next());
		System.out.println(((5*(far-32))/9)+" Degrees Celsius");
		
		scan.close();
	}

}
