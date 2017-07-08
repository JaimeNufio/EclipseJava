import java.lang.reflect.Array;
import java.util.Scanner;

/* This Program is for the midterm, it is #1. It creates 3 columns from test scores taken in, and averages the grade
 * each loop
 */

public class Grades2 {
	
	
	public static String position(int n){
		String value;
		n = n%10;
		switch (n) {
			case 1:
				value = "st";
				break;
			case 2:
				value = "nd";
				break;
			case 3:
				value = "rd";
				break;
			default:
				value = "th";
				break;
		}
		
		return value;
	}
	
	public static String letterGrade(int n){
		
		String value = "";
		
		if (n >= 90){ //switch case was being weird, this is superior.
			value = "A";
		}else if (n >= 80){
			value = "B";
		}else if (n >= 70){
			value = "C";
		}else if (n >=65){
			value = "D";
		}
	
		return value;
	}

	
	public static void main(String[] args) {
		
		boolean pass = true; 
		double currentGrade, gradeSum = 0, count = 0; 
		String  Name, header;
		Scanner Scan = new Scanner(System.in);
		
		double[] grades = new double[999]; //Yeah... so you can't expand an array once created, so let's just start with a huge number.
		
		System.out.printf("What is the Student's name?\n");
		Name = Scan.nextLine();
		
		System.out.printf("This program will average grades for %s. Type in a negative value when you are done.\n",Name);
		header = "\nName:\tTest Scores:\tCount:\tAverage\tLetter Grade\n";
		
		while(pass){
			
			count++;
			
			System.out.printf("\nWhat is %s's "+(int)count+position((int)count)+" grade?\n",Name);
			currentGrade = Scan.nextDouble();
			
			if (currentGrade <= 0){
				break;
			}else{
				grades[(int) count-1] = currentGrade; //count is going to start at 0, need to fit array to count
				gradeSum =+ currentGrade;
			}
			
			
		}
			System.out.print("\n"+header);
			Scan.close();
			//Print(false,"Final Average of student is: "+gradeSum/(count));

	}

}


