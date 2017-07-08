
public class Main {

	public static void main(String[] args) throws InterruptedException{
		Imaginairy number = new Imaginairy(1.2,.3);
		double[] temp = new double[2];
		
		System.out.println("Mandlebrot set");
		
		int reps = 100;
		for (int i = 0; i < reps; i++){
			number.print(i);
			temp = number.squareThis();
			number.set(temp);
		}
		
	}
}