import java.util.Scanner;

public class twopointsix {
	/*
	 * PP 2.6 Write a program that converts grams to pounds. (One pound
     * equals 453.592 grams.) Read the grams value from the user as a
     * floating point value.
	 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Float grams, pound;
		
		System.out.println("Convert grams to pounds! Input number of grams:");
		grams = Float.parseFloat(scan.nextLine());
		pound = (float) (grams/(453.596));
		System.out.println(grams+" grams is equal to "+pound+" pounds.");
		scan.close();
	}
}
