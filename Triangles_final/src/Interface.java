import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//********************************************************
//Program that calculates triangles from angles and sides
//********************************************************

public class Interface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// A lot of this code is just setting up the frame, skip to line 121.
	private JPanel contentPane;
	private JTextField[] textFields = new JTextField[6];
	private static double[] sides = new double[3], angles = new double[3];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAngle = new JLabel("Side A:");
		lblAngle.setBounds(10, 83, 46, 14);
		contentPane.add(lblAngle);
		
		textFields[0] = new JTextField();
		textFields[0].setBounds(57, 83, 86, 20);
		textFields[0].setColumns(10);
		contentPane.add(textFields[0]);
		
		JLabel lblSide = new JLabel("Side B:");
		lblSide.setBounds(10, 111, 46, 14);
		contentPane.add(lblSide);
		
		textFields[1] = new JTextField();
		textFields[1].setColumns(10);
		textFields[1].setBounds(57, 111, 86, 20);
		contentPane.add(textFields[1]);
		
		JLabel lblSide_1 = new JLabel("Side C:");
		lblSide_1.setBounds(10, 139, 46, 14);
		contentPane.add(lblSide_1);
		
		textFields[2] = new JTextField();
		textFields[2].setColumns(10);
		textFields[2].setBounds(57, 139, 86, 20);
		contentPane.add(textFields[2]);
		
		JLabel label_4 = new JLabel("Angle a:");
		label_4.setBounds(165, 83, 46, 14);
		contentPane.add(label_4);
		
		textFields[3] = new JTextField();
		textFields[3].setColumns(10);
		textFields[3].setBounds(215, 83, 86, 20);
		contentPane.add(textFields[3]);
		
		JLabel lblAngle_2 = new JLabel("Angle b:");
		lblAngle_2.setBounds(165, 111, 46, 14);
		contentPane.add(lblAngle_2);
		
		textFields[4] = new JTextField();
		textFields[4].setColumns(10);
		textFields[4].setBounds(215, 111, 86, 20);
		contentPane.add(textFields[4]);
		
		JLabel lblAngle_1 = new JLabel("Angle c:");
		lblAngle_1.setBounds(165, 139, 46, 14);
		contentPane.add(lblAngle_1);
		
		textFields[5] = new JTextField();
		textFields[5].setColumns(10);
		textFields[5].setBounds(215, 139, 86, 20);
		contentPane.add(textFields[5]);
		
		JLabel Instruction = new JLabel("<html>Enter two sides and an angle or one side and an angle of your triangle. <br>You can leave unknown data as 0 or blank. </html>\r\n");
		Instruction.setBounds(10, 11, 296, 51);
		contentPane.add(Instruction);
		
		JButton btnNewButton = new JButton("Enter your data");
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			
			///////////////////////////////////PROGRAM STARTS HERE!!!!!
			

			@Override
			public void mouseClicked(MouseEvent arg0) {//mouse clicked
				
				System.out.println("Got Values!"); //reading what was inputted, putting data into array
				for (int i = 0; i<3; i++){
					String z = textFields[i].getText();
					if (z.matches("[0-9]+") || textFields[i].getText().equals("")){
						if (textFields[i].getText().equals("") || textFields[i].getText().equals(null)){
							textFields[i].setText("0");
						}
						sides[i] = Math.abs(Double.parseDouble(textFields[i].getText()));
						System.out.println("Side "+i+": "+sides[i]);
					}
					else
						System.out.println( "INVALID INPUT" );
				}
				for (int i = 0; i < 3; i++){
					if (textFields[i+3].getText().equals("") || textFields[i+3].getText().equals(null)){
						textFields[i+3].setText("0");
					}
					angles[i] = Math.abs(Double.parseDouble(textFields[i+3].getText()));
					System.out.println("Angle "+(i)+": "+angles[i]);
				}
			
			int missingAngles = 0, missingSides = 0; //declaring varaibles, that are used later

			for (int i = 0; i < findZeros(angles).length; i++){  //tallies what is missing, so we know how much information we have
				if (findZeros(angles)[i])){
					System.out.println("Missing data for angle #"+i);
					missingAngles++;
					
				}
				if((findZeros(sides)[i])){
					System.out.println("Missing data for side #"+i);
					missingSides++;
				}
				
			}
			boolean pass = false;
			//TODO implement pass
			
			if ((missingAngles <= 1 && missingSides <= 2)||(missingSides <= 1 && missingAngles <= 2)){ //Determines if the input were logical
				JOptionPane.showMessageDialog(null, "Valid input!");
				pass = true;
			}else{
				JOptionPane.showMessageDialog(null, "Invalid input!");
				pass = false;
			}
			

			boolean[] masterSetEmpty = new boolean[6];
			double[] masterSet = {sides[0],angles[0],sides[1],angles[1],sides[2],angles[2]};
			
			//declaring two arrays, one for numbers, one for just infromation of what isn't blank
			
			//we use this system to keep track of values: Aa Bb Cc,
			//where spot 0 is A, and 5 is c and a capital is a side, where a lowercase is an angle
			
			for (int i = 0; i < masterSet.length; i++){ //true means the slot has a value we know
				if (masterSet[i] == 0){
					masterSetEmpty[i] = false;
				}else{
					masterSetEmpty[i] = true;
				}
			}
			
			
			int count = 0;
			
			do{ //do while loop!
				
				double totAngle = 180; //all triangles have 180 degrees
				double[] angles = {masterSet[1],masterSet[3],masterSet[5]}; //using angles array from before
				
				if (missingAngles == 1){ //if we have all but one angle, find it through subtraction
					for (int i = 0; i<angles.length; i++){
						totAngle=totAngle-angles[i];
						System.out.println(totAngle);
					}
					
					for (int i = 0; i<angles.length; i++){
						if ((angles[i] == 0)){ 
							angles[i] = totAngle;
							System.out.println("set angle "+(i+1)+" to "+totAngle);
						}
					}
					
				}

				
				for (int i = 0; i < findZeros(angles).length; i++){  //tallies how many angles we are missing
					if ((findZeros(angles)[i])){
						missingAngles++;
					}
				}
				
				masterSet[1] = angles[0];
				masterSet[3] = angles[1];
				masterSet[5] = angles[2];
				
				if ((missingAngles <= 1) && (missingSides == 1)){ //Scenario: 1 angle, at least two sides
					if (masterSet[0] == 0) //if side A misisng, run through isaiah's method
					{
						masterSet[0] = A(masterSet);
						missingSides++;
					}
					if (masterSet[2] == 0) //if side B missing, Isaiah method
					{
						masterSet[2] = B(masterSet);
						missingSides++;
					}
					if (masterSet[4] == 0)// ""
					{
						masterSet[4] = C(masterSet);
						missingSides++;
					}
					
					
				} 

					boolean ratioFound = false; //used to tell if we have a ratio (X over sinx)
					double[] ratio = {0,0}; //saves the ratio's values as {Side, Angle}
					
					//The law of sines has a really nice way of being able to calculate from just one pair of information!
					
					if (!(ratioFound)){
						for (int i = 0; i<5; i++){ 
							if (i%2 == 0){//0,2,4, the angles
								if (masterSet[i] != 0 && masterSet[i+1] != 0 && !ratioFound){ //if angle and its matching side aren't 0, and ratio isn't found
									ratio[0] = masterSet[i]; //set as ratio vales
									ratio[1] = masterSet[i+1];
									System.out.println("Ratio found to be: "+ratio[0]+" / Sin of "+ratio[1]); //print that informatio
									ratioFound = true;
									break;
								}
							}
						}
					}else{ //when the ratio is found do...
						
						for (int i = 0; i<masterSet.length; i++){ //go through all slots
							if (masterSet[i] == 0){ //is the slot empty?
								if (i%2 == 0){//Sides
									SideCalc(masterSet[i+1], ratio[1], ratio[0]); //solve side
								}else{
									AngleCalc(masterSet[i-1], ratio[1], ratio[0]); //solve angle
								}
							}
						}
						
					}
					
				
//				It's old code, but it checks out.				
//				if ((A && a && B) || (A && a && b) || (A && B && b) || (a && B && b)){// SinA/a = Sin B/b
//					masterSet = Abhishek.AaBb(masterSet);
//				}
//				if ((A && a && C) || (A && a && c) || (A && C && c) || (a && C && c)){// Sin A/a = Sin C/c
//					masterSet = Abhishek.AaCc(masterSet);
//				}
//				if ((B && b && C) || (B && b && c) || (C && c && b) || (C && c && B)){ //Sine B/b = Sine C/c
//					masterSet = Abhishek.BbCc(masterSet);
//				}
					
				
				for (int i = 0; i < masterSet.length; i++){ //I don't know why this is still here, its not really used
					if (masterSet[i] == 0){
						masterSetEmpty[i] = false;
					}else{
						masterSetEmpty[i] = true;
					}
				}
				
				System.out.println("cycle "+count);
				if (count > 25){ //Trial/error code, it was here because we used a while loop, not a for loop, and sometimes it hung
					System.out.println("Got stuck! Spitting out info so far!");
					break;
				}
				
			
			} while (!areAllPresent(masterSet) && pass); //Do while loop, because it'll do it at least once.
			

//			angles[0] = masterSet[1];
//			angles[1] = masterSet[3];
//			angles[2] = masterSet[5];

			if (k(masterSet) == 1){ //Equilateral brute force (because of estimations being weird sometimes)
				masterSet[1] = 60;
				masterSet[3] = 60;
				masterSet[5] = 60;
			}

			//final print of information!
			
				JOptionPane.showMessageDialog(null,"Side A: "+masterSet[0]+
							"\nAngle a: "+masterSet[1]+
							"\nSide B: "+masterSet[2]+
							"\nAngle b: "+masterSet[3]+
							"\nSide C: "+masterSet[4]+
							"\nSide c: "+masterSet[5]);
					System.out.println("This triangle is "+Isaiah.TRIangle[k(masterSet)]+".");
					System.out.println("This triangle is "+Isaiah.TriANGLE[i(masterSet)]+".");
					

		}});
		
		btnNewButton.setBounds(8, 183, 298, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel((new ImageIcon(getClass().getResource("/images/triangle.png"))));
		label.setBounds(316, 36, 183, 136);
		contentPane.add(label);
	}	
	
    //ISAIAH WROTE THIS TRIANGLE
    public static String [] TriANGLE = {"Right Triangle", "Obtuse Triangle", "Acute Triangle", "Not a Triangle"};                
    public static String [] TRIangle = {"Scalene", "Equilateral","Isoseles", " "};

    public static int i(double[] set)//Value for the TriANGLE Array
    {	
    	double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];
        if ((a == 90 || b == 90 || c == 90) && a+b+c == 180)
            return 0;
        else if ((a > 90 || b > 90 || c > 90) && a+b+c == 180)
            return 1;
        else if ( ( (a < 90) && (b < 90) && (c < 90) ) && a+b+c == 180)
            return 2;
        else
            return 3;
    }
    public static int k(double[] set)//Value for the TRIangle Array
    {
		double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];
        if (((a == b && b == c && c == a)) && a+b+c == 180)
            return 1;
        else if ((a == b || b == c || c == a) && a+b+c == 180)
            return 2;
        else if ((a != b && b != c) && a+b+c == 180)
            return 0;
        else
            return 3;
    }
    
    //for missing side and a/b is known
    public static double C(double[] set)//Finding Side C
    {
		double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];

            return Math.sqrt((A*A)+(B*B)-(2*A*B)*(Math.cos(Math.toRadians(c))));

    }
    
    public static double c(double[] set)//Finding Angle c
    {
		double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];
		
            return Math.acos(((C*C)-(A*A)-(B*B))/(-2*A*B));
            

    }
    
    public static double B(double[] set)//Finding Side B
    {
		double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];
		
            return Math.sqrt((A*A)+(C*C)-(2*A*C)*(Math.cos(Math.toRadians(b))));

    }
    
    public static double b(double[] set)//Finding Angle b
    {
		double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];
            return Math.acos(((B*B)-(A*A)-(C*C))/(-2*A*C));

    }
    
    public static double A(double[] set)//Finding Side A
    {
		double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];

            return  Math.sqrt((B*B)+(C*C)-(2*B*C)*(Math.cos(Math.toRadians(a))));

    }
    
    public static double a(double[] set)//Finding Angle a
    {
		double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];

            return Math.acos(((A*A)-(B*B)-(C*C))/(-2*B*C));

    }
    //ISaiah's code main ends here
	
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
	
	public static boolean isNotZero(double num){
		return num == 0;
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
	
	//double a, b, c, A, B, C ;	//Lowercase is angles, uppercase is sides, C is hypotenuse
	//archaic code, as it does nothing
//Abhishek originally had it input things in different "shapped" sets, but I ended up unifiying it with Arrays, -Jaime
	
public static double[] AaCc(double[] set){//Between A,a,C,c
	double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];
	
		if( a == 0 && A != 0 && c != 0 && C != 0 )
		{
			a = Math.toDegrees(Math.asin(A*(Math.sin(Math.toRadians(c))/C))) ;
		}
		if( A == 0 && C != 0 && a != 0 && c != 0 )
		{
			A = (C*(Math.sin(Math.toRadians(a)))/Math.sin(Math.toRadians(c))) ;
		}
		if( c == 0 && a != 0 && A != 0 && C != 0 )
		{
			c = Math.toDegrees(Math.asin(C*(Math.sin(Math.toRadians(a))/A))) ;
		}
		if( C == 0 && a != 0 && A != 0 && c != 0 )
		{
			C = (A*(Math.sin(Math.toRadians(c)))/Math.sin(Math.toRadians(a))) ;
		}
	double newset[] = {A,a,B,b,C,c};
	return newset;
	}

public static double[] AaBb(double[] set){//Between A,a,B,b
	double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];

		if( a == 0 && A != 0 && b != 0 && B != 0 )
		{
			a = Math.toDegrees(Math.asin(A*(Math.sin(Math.toRadians(b))/B))) ;
		}
		if( A == 0 && B != 0 && a != 0 && b != 0 )
		{
			A = (B*(Math.sin(Math.toRadians(a)))/Math.sin(Math.toRadians(b))) ;
		}
		if( b == 0 && B != 0 && a != 0 && A != 0 )
		{
			b = Math.toDegrees(Math.asin(B*(Math.sin(Math.toRadians(a))/A))) ;
		}
		if( B == 0 && A != 0 && b != 0 && a != 0 )
		{
			B = (A*(Math.sin(Math.toRadians(b)))/Math.sin(Math.toRadians(a))) ;
		}

	double newset[] = {A,a,B,b,C,c};
	return newset;
}
	

public static double[] BbCc(double[] set){//Between B,b,C,c REQUIRES BCC
	double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];

		if( b == 0 && B != 0 && c != 0 && C != 0 )
		{
			b = Math.toDegrees(Math.asin(B*(Math.sin(Math.toRadians(c))/C))) ;
		}
		if( B == 0 && C != 0 && b != 0 && c != 0 )
		{
			B = (C*(Math.sin(Math.toRadians(b)))/Math.sin(Math.toRadians(c))) ;
		}
		if( c == 0 && C != 0 && b != 0 && B != 0)
		{
			c = Math.toDegrees(Math.asin(C*(Math.sin(Math.toRadians(b))/B))) ;
		}
		if( C == 0 && B != 0 && c != 0 && b != 0 )
		{
			C = (B*(Math.sin(Math.toRadians(c)))/Math.sin(Math.toRadians(b))) ;
		}

	double newset[] = {A,a,B,b,C,c};
	return newset;
}

//Abhishek had written the code above, however, I streamlined it as the conditions were INSANE
//an artifact of this is still found in the code

public static double SideCalc(double knownAngle, double ratioAngle, double ratioSide){
	double side = ratioSide*(Math.sin(knownAngle)/Math.sin(ratioAngle));
	return side;//returns Angle, which is a stand in for the side being searched
}

public static double AngleCalc(double knownSide, double ratioAngle, double ratioSide){
	double angle = Math.asin(knownSide*(Math.sin(ratioAngle)/ratioSide));
	return Math.toRadians(angle);
		//returns angle, which is a stand in for the angle being searched
}
    
}


