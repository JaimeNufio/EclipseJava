
public class Jaime { //these are my "bridge" methods, used to link the other code

	public static double newLargest(double[] numbers){
		double a = numbers[0], b = numbers[1], c = numbers[2], S = 0;
		if (a > b){
			S = a;
		}else{
			S = b;
		}
		if (c > S){
			S = c;
		}
		
		return S;
	}
	
	public static double secondLargest(double[] numbers, double knownLargest){
		double a = numbers[0], b = numbers[1], c = numbers[2], S = 0, X = knownLargest;
		
		if (a > b && a != X){
			S = a;
		}else if (b != X){
			S = b;
		}
		if (c > S && c != X){
			S = c;
		}
		return S;
	}
	
	public static int smallestOfThree(double[] numbers, double knownLargest, double SecondKnownLargest){
		double S = -1, X = knownLargest, Y = SecondKnownLargest;
		
		for (int i = 0; i<numbers.length; i++){
			if (i != X && i != Y){
				S = i;
			}
		}
		return (int) S;
	}
	
	
	public static boolean isValuePresent(double[] set, double value){
		boolean state = false;
		for (int i = 0; i<set.length;i++){
			if (set[i] == value){
				state = true;
				break;
			}
		}
		return state;
	}
	
	public static boolean[] findZeros(double[] set){
		boolean[] zerosFound = new boolean[set.length];
		
		for (int i = 0; i < set.length; i++){
			if (set[i] == 0){
				zerosFound[i] = true;
			}
		}
		
		return zerosFound;
	}
	
	public static boolean areAllPresent(double[] set){
		boolean state = true;
		for (int i = 0; i < set.length; i++){
			if (set[i] == 0){
				state = false;
//				System.out.println("Zero found at region "+i+" of set.");
				break;
			}
		}
		return state;
	}

	//LOL at myself trying to make this an near-AI type thing 
	
//	static boolean[][][] Types = { 
//		//ASA = 
//			{{true,true,false,true,false,false},{true,true,false,true,false,false},{false,true,true,true,false,false},
//			{false,true,true,false,false,true},{false,true,false,false,true,true},{false,true,false,true,true,false}},
//		//AAS =
//			{{true,true,false,false,false,true},{true,true,false,true,false,false},{false,true,true,true,false,false},
//			{false,false,true,true,false,true},{false,false,false,true,true,true},{false,true,false,false,true,true}},
//		//SSA = 
//			{{true,true,false,false,true,false},{true,false,false,false,true,true},{true,true,true,false,false,false},
//			{true,false,true,true,false,false},{false,false,true,true,true,false},{false,false,true,false,true,true}},
//		//CoSine
//		//SAS=
//			{{true,false,false,true,true,false},{true,false,false,true,true,false},{false,true,true,false,false,true}},
//		//SSS=
//			{{true,false,true,false,true,false}}};
//	
//	public String problemform(int spot){
//		String text = "";
//		switch(spot){
//		case 0:
//			text = "ASA";
//			break;
//		case 1:
//			text = "AAS";
//			break;
//		case 2:
//			text = "SSA";
//			break;
//		case 3:
//			text = "SAS";
//			break;
//		case 4:
//			text = "SSS";
//			break;
//		default:
//			text = "This is not a valid input";
//			break;
//		}
//		return text;
//	}
	
//	public int[] formsolve(boolean[] set){
//		int form = -1, specificForm = -1;
//		for (int x = 0; x < Types.length;x++){ //types of forms
//			for(int y = 0; y < Types[x].length;y++){ //specific forms
//				int count = 0;
//				for(int z = 0; z < Types[x][y].length;z++){//individual places of forms
//
//						if (set[z] == true && Types[x][y][z] == true){
//							count++;
//					}
//				}
////				System.out.println("Count is "+count);
//				if (count == 3){
//					form = x;
//					specificForm = y;
//					System.out.println("Identified location as ("+x+","+y+")");
//					for(int i = 0; i < Types[x][y].length; i++){
//						Types[x][y][i] = false;
//					}
//				}
//			}	
//		}
//		System.out.println("Got place of: ("+form+","+specificForm+")");
//		int[] placeSet = {form,specificForm};
//		return placeSet;
//	}
	
	public int whichIsMissing(double[] set){
		int state = -1;
		for (int i = 0; i < set.length; i++){
			if (set[i] == 0){
				state = i;
				System.out.println("Zero found at region "+i+" of set.");
				break;
			}
		}
		return state;
	}
	
	public double quickAdd(double[] set){
		double num = 0;
		for (int i = 0; i<set.length; i++){
			num = num+set[i];
		}
		return num;
	}
	
	public String triangleType(double[] numbers, double largest){
		String Type = "Indeterminate";
		
		if (Jaime.areAllPresent(numbers)){
			int a =(int)Math.pow((double)numbers[0],2), b = (int)Math.pow((double)numbers[1],2), c = (int)Math.pow((double)numbers[2],2);
			if((a+b)==c){ //right
				Type = "right";
			}else if ((a+b)<c){//obtuse
				Type = "obtuse";
			}else if((a+b)>c){//acute
				Type = "acute";
			}
			if(numbers[0] == numbers[1] && numbers[1] == numbers[2]){
				Type = "equilateral";
			}
		}
		
		return Type;
	}
}


