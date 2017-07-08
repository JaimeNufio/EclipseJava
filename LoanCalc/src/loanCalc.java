
public class loanCalc {

	public static double initial, salesTax, interestRate, tradeInValue, fees, 
	rebates, downpayment, totalPrice, loanAmount, amortization, principal,interest;
	
	public static int numMonths;
	
 
	public static void setLoanAmount(){
		totalPrice = (initial*(1+(salesTax/100)) + fees);
		loanAmount = (totalPrice - tradeInValue - rebates);
		interestRate = interestRate/12;
		principal = loanAmount;
		
		setAmortization();
		
		interest = ((amortization*numMonths)-totalPrice);
		loanAmount = amortization*(numMonths);
		
		System.out.printf("Money Loaned: $%s; Loan Amount: $%s; Total Interest: $%s; Interest Rate/Month: %s%n",
				totalPrice, roundToMoney(loanAmount),roundToMoney(interest),roundToMoney(interestRate)+"%");
		System.out.printf("Monthly payment: $%s\n\n",amortization);
		System.out.print("Date:\t\tPayment:\tPrincipal:\tInterest:\tTotal Interest:\t\tBalance:\n");
	}
	
	public static void setAmortization(){
		amortization = ((principal) *
				((Math.pow(1+interestRate, numMonths) * interestRate)
				/
				(Math.pow(1+interestRate, numMonths)-1)
				));
		amortization = Double.parseDouble(roundToMoney(amortization));

	}
	
	public static String findDate(int monthCount){
		String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
		int month = monthCount%12;
		int year = (int) Math.floor((monthCount/month+1) );
		
		return String.format("%s of Year %s", months[month],year);
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
		//loanAmount = (loanAmount*(1+(interestRate/100))) - amortization; //compound interest, then subtract payment
		double interestPaid = principal*(interestRate);
		double principalPaid = amortization-interestPaid;
		principal = principal-amortization;
		interest = interest-interestPaid;
		
		//Date \t\t\t" + "Payment \t\t" + "Principal \t\t" + "Interest \t\t" + "Total Interest \t\t" + "Balance\n";
		return String.format("%s%s\t$%s\t\t$%s\t\t$%s\t\t$%s",
				count, getPlace(count)+" Month", roundToMoney(amortization),roundToMoney(principalPaid),
				roundToMoney(interestPaid),roundToMoney(interest));
	}
	
	public static String roundToMoney(double value){
		value = ((int) (value*100));
		value = value/100;
		return value+"";
	}
	
	public static void main(String[] args){
		initial = 25000;
		salesTax = 0;
		interestRate = 4;
		tradeInValue = 0;
		fees = 000;
		rebates = 000;
		downpayment = 000;
		numMonths = 60;
		
		setLoanAmount();

		
		for (int i = 1; i< numMonths; i++){
			System.out.println(doMonth(i));
		}
		
	}
	
}
