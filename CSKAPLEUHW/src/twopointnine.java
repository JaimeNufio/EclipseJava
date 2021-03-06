import java.util.Scanner;

public class twopointnine {
	
	/*
	 * PP 2.9 Create a version of the previous project that reverses the computation.
 	 * That is, read a value representing the weight in milligrams,
	 * then print the equivalent weight as a combination of
	 * kilograms, grams, and milligrams. (For example, 90,70,056
	 * milligrams is equivalent to 9 kilograms, 70 grams, and
	 * 56 milligrams.)
	 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		@SuppressWarnings("unused")
		double milli = 0;
		
		System.out.println("How many Milligrams do you want to convert?");
		milli = scan.nextDouble();
		
		String[] names = {" Kilograms"," Grams"," Milligrams"};
		//6 3 0
		for (int i = 0; i<3;i++){
			int step =(int) (milli/Math.pow(10, 6-(3*i) ));
			milli-=step*Math.pow(10, 6-(3*i) );
			System.out.println("There are "+step+names[i]+".");
		}
		
		scan.close();
	}
}
