

public class multiplication {
	public static void main(String[] args){
		int ans = 0;
		//String text = "", ntext = "";
		for (int i = 1; i < 13; i++){
			for (int a = 1; a < 13; a++){
				ans = i*a;
				
				System.out.printf("%s x %s = %s\t\t %s x %s = %s\n",i+"",a+"",ans+"",i+1,a+"",(i+1)*a+"");
				
			}
	
		}
	}
}
