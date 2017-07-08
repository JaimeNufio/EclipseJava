import java.util.Scanner;

public class twopointfive {

	/*
	PP 2.5 Create a version of the UnitConverter application to convert
	from inches to foot. Read the inches value from the user.
	*/
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Double inches,feet;
		
		System.out.println("Convert Inches to Feet! Input number of Inches:");
		inches = Double.parseDouble(scan.nextLine());
		feet = inches/12;
		System.out.println(inches+" inches is equal to "+feet+" feet.");
		scan.close();
	}

}
