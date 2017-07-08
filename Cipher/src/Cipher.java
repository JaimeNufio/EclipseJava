
public class Cipher {

		char[] originalList = new char[26], newList = new char[26];
		
		
	Cipher(){
	
	}
	
	void calibrate(int move){
		int phase = move;
		
		for (int i = 97; i < 123; i++){
			
			int shift = (i+phase);
			
			if (phase > 0){
				if (shift > 122){
					shift = i+phase-26;
				}
			}else{
				if (shift < 97){
					shift = i+phase+26;
				}
			}
			
			originalList[i-97] = (char) i;
			newList[i-97] = (char) shift;
		//	System.out.println(newList[i-97]);
		}
	}
	
	int findInArray(char alpha, char[] array){
		
		int pos = -1;
		
		for (int i = 0; i < array.length; i++){
			if (alpha == array[i]){
				pos = i;
				break;
			}
		}
		
		return pos;
	}
	
	String switchText(String text){
		
		text = text.toLowerCase();
		String newText = "";
		
		for (int i = 0; i < text.length(); i++){
			
			int currentIndex = text.codePointAt(i);
			
			if (currentIndex >= 97 && currentIndex <= 122){
				newText+=Character.toString(newList[findInArray((char) currentIndex,originalList)]);
			}else{
				newText+=((char) currentIndex);
				
			}
		}
		
		return newText;
	}
	
	
	public static void main(String[] args){
	
		Cipher test = new Cipher();
		test.calibrate(10);
		System.out.println(test.switchText("ixu qbmqoi teui, cqd."));

	}
}
