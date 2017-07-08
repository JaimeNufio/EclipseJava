import java.util.Scanner;

public class twopointeight {
	
	/*
	 * PP 2.8 Write a program that reads values representing the weight in
	 * kilograms, grams, and milligrams and then prints the equivalent
	 * weight in milligrams. (For example, 1 kilogram, 50 grams, and
	 * 42 milligrams is equivalent to 10,50,042 milligrams.)
	 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double milli = 0;
		
		String[] names = {"Kilograms","Grams","Milligrams"};
		
		for (int i = 0; i<3;i++){
			System.out.println("Input ammount to be added in "+names[i]+":");
			double val = Double.parseDouble(scan.nextLine()); 
			milli+=((val)*Math.pow(10, (i*3)));
		}
		
		System.out.println("The sum is "+milli+" milligrams.");
		scan.close();
	}
}