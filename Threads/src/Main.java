
public class Main {
	public static void main(String Args[]){
		Thread test = new MyThread(20,1), test1 = new MyThread(1,2);
		test.start();
		test1.start();
	}
}
