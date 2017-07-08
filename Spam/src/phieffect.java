
public class phieffect {

	public static String text = "", thing = "[><]";
	public static int number = 25;
	
	public static void fill(int spots){
		
		for (int i = 1; i <= spots; i++){
			text = text+"~";
		}
		
	}
	
	public static void main(String args[]) throws InterruptedException {
		
		while(true){
			Thread.sleep(10);
			for(int i = 1; i <=number; i++){
				Thread.sleep(10);
				text = "";
				fill(i);
				text = text+thing;
				fill((number+1)-i);
				fill((number+1)-i);
				text = text+thing;
				fill(i);
				System.out.println(text+"\n");
			}
			for(int i = 1; i <=number; i++){
				Thread.sleep(10);
				text = "";
				fill((number+1)-i);
				text = text+thing;
				fill(i);
				fill(i);
				text = text+thing;
				fill((number+1)-i);
				System.out.println(text+"\n");
			}
			
		}
		
	}
}

