
public class Spam {

	public static void main(String[] args) {
	
		String text, alphabeta = "\n\t 1234567890-+=_abcdefghijklmnopqrstuvwxyz?!.,@#$%^&*()/\\><";
		String prefix[] = {"\\\\","Exporting: ","$SUDO: ","###?:",".exe","!!!"," ABORT"};
		int num;
		
		while(true){
			
			text = "";
			num = (int) (Math.random()*alphabeta.length());
			
			if (Math.random() > 0.9){
				text = prefix[(int)Math.random()*prefix.length];
			}
			
			System.out.print(alphabeta.charAt(num)+text);
			
		}

	}

}
