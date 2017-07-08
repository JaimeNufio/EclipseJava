
public class expo {
	
	public static void main(String[] args){
		
		double num = 1;
		int count = 0;
		
		while (num <= Double.MAX_VALUE){
			count++;
			num = Math.pow(2,count);
			System.out.println("2 to the power of "+count+" is "+num);
		}
	}
}
