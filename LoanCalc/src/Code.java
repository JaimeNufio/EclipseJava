import java.util.*;
public class Code {

	public enemy numberOne;
	
	public static void main(String args[]){
	

		double cost, interest, months;				//doubles certain values
		double meh5 = 1;							//another double value
		int meh4;									//an integer 
		String statement1 = "" ;
		double statement2 = 0;
		double statement3 = 0;
		double statement4 = 0;
		String Payment, Totalint, Interest, Balance, Date, Principal;			//string predetermined words
		Scanner sc = new Scanner (System.in);									//Imports a scanner
		
		System.out.println("What is the car's price?");							//Asks the user a question of how much the car costs
		Double meh = sc.nextDouble();											//allows the user to input a value
		
		System.out.println("What is the car's interest rate in terms of percent?");		//asks the user the interest rate of the car
		double meh2 = sc.nextDouble();													//allows the user to input value
		
		System.out.println("How many month's is the payment plan?");					//asks the user how many months the payment is for
		int meh3 = sc.nextInt();														//allows user to input value
		
		System.out.println("How much you paying each month?");							//asks the user how much they are paying each month
		double pay = sc.nextDouble(); 													//allows user to input value
		
	
		 
		for ( meh4 = 1; meh4 <= meh3; meh4++ )											//fist for loop on number of months the payment is for
		{
			
			
			statement1 = "\nmonth" + meh4;
			
			System.out.println( statement1);
		}
		
		
		for (meh4 = 1; meh4 <= meh3; meh4++){
			statement2 = pay;
			System.out.println( "\t$" + statement2);
		}
		
		
	
		for (meh4 = 1; meh4 <=meh3; meh4++){
			double tax = meh*(meh2/100);
			statement3 = tax;
			
			System.out.println( "\t$" + statement3 );
			
			double principal = meh - tax; 
			statement4 =principal;
			System.out.println(  "\t$" + statement4);
			
			meh = meh + tax - pay;
			
			if(meh <= 0){
				break;
			}
			
		}
		
		
		

	
	}
		
	}

