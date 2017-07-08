import java.util.Scanner;

public class twopointfour {

	/*
	2.4 Write a program that prompts for and reads a course name, its
	credits and reference book. Then print the following paragraph,
	inserting the appropriate data:
	This semester, a new course on course_name has been added
	to the curriculum. It consists of credits credits and
	the reference book for this course is reference_book. 
	 */
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		String[] Prompts = {"course name","credit value","reffrence book"};
		String[] Values = new String[3];
		
		for(int i = 0; i<3;i++){
			System.out.println("What is the "+Prompts[i]+"?");
			Values[i] = scan.nextLine();
		}
		String text = String.format("This semester, a new course on %s has been added to the curriculum. It consists of %s credits and the reference book for this course is %s.",
				Values[0],Values[1],Values[2]);
		System.out.println(text);
		
		scan.close();
		
	}
}
