//This class contains the law of Sines, and the naming stuff


public class newIsaiah {
    //ISAIAH WROTE TRIANGLE
    static String [] TriANGLE = {"Right Triangle", "Obtuse Triangle", "Acute Triangle", "Not a Triangle"};                
    static String [] TRIangle = {"Scalene", "Equilateral","Isoseles", " "};

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
}