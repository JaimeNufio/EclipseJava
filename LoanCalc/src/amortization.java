import java.util.Scanner;

/*
 * Program To Calculate amortization on a loan given no downpayment.
 * Variables are Term in months, loan amount, and interest rate annually
 * 
 */

public class amortization {
	public static double borrowed, interest, loanAmount, interestAmount, principal, monthlyPay;
	public static int term;
	
	public static void setAmortization(double borrowedAMNT,double interestRT,int termMNTH){
		borrowed = borrowedAMNT;
		interest = interestRT/12;//lets set it to the monthly rate. 5% annual to -> .33% month
		term = termMNTH;
		principal = borrowed; //initial principal
		
		monthlyPay = (principal*interest)*( (Math.pow((1+interest),term)) / (Math.pow(1+interest,term)-1));
		
		loanAmount = monthlyPay*term; //principal PLUS total interest
		interestAmount = loanAmount-principal; //total interest incurred on loan
		
		System.out.printf("Initial Principal: $%s; Total Loan: $%s; Total Interest: $%s; Monthly Payment: $%s%n%n",
				roundToMoney(principal),roundToMoney(loanAmount),roundToMoney(interestAmount),roundToMoney(monthlyPay));
		System.out.println("Date:\t\tPayment:\tPrincipal:\tInterest:\tInterest Due:\tBalance:");
		
		for (int i = 1; i<=term; i++){
			System.out.println(doMonth(i));
		}
		
	}
	
	public static String roundToMoney(double value){
		String money;
		value = ((int) (value*100));
		value = value/100;
		
		money = value+"";
		
		//lets force it to have 2 decimal places
		int spot = money.indexOf(".");
		if (money.substring(spot+2).equals("")){
			money = money+"0";
		}
		
		return money;
	}
	
	public static String getPlace(int num){
		boolean normal = true;
		int[] list = {11,12,13};
		String text = "th";
		
		for (int i = 0; i< list.length; i++){
			if (num == list[i]){
				normal = false;
			}
		}
		
		if (normal){
			switch(num%10){
			case 1:
				text = "st";
				break;
			case 2:
				text = "nd";
				break;
			case 3:
				text = "rd";
				break;
			}
		}
		
		return text;
	}
	
	public static String doMonth(int count){
		
		double principalPaid, interestPaid;
		interestPaid = principal*(interest);
		principalPaid = monthlyPay-interestPaid;
		principal = principal-principalPaid;
		interestAmount = interestAmount-interestPaid;
		
			int tabs = 1; //little hack so that the rows line up nicely.
			if (roundToMoney(interestAmount).length() <= 6){
				tabs = 2;
			}
			
			String tab = "";
			for (int i = 0; i<tabs;i++){
				tab = tab+"\t";
			}
		
		return String.format("%s\t$%s\t\t$%s\t\t$%s\t\t$%s%s",
				count+getPlace(count)+" Month",roundToMoney(monthlyPay),roundToMoney(principalPaid),roundToMoney(interestPaid),
				roundToMoney(interestAmount),tab+"$"+roundToMoney(principal));
	}
	
	public static double collectData(String Q,Scanner sc){
		System.out.println(Q);
		double value = (sc.nextDouble());
		return value;
	}
	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		borrowed = collectData("How much are you looking to borrow?",sc);
		interest = collectData("What is the annual interest rate on this loan?",sc)/100;
		term = (int) collectData("How long is the term of the loan? (In months)",sc);
		setAmortization(borrowed,interest,term);
	}
	
}
