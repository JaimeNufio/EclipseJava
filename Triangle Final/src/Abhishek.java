//this class contains the Law of CoSines


import java.lang.Math ;

public class Abhishek
{

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
				A = C*(Math.sin(Math.toRadians(a))/Math.sin(Math.toRadians(c))) ;
			}
			if( c == 0 && a != 0 && A != 0 && C != 0 )
			{
				c = Math.toDegrees(Math.asin(C*(Math.sin(Math.toRadians(a))/A))) ;
			}
			if( C == 0 && a != 0 && A != 0 && c != 0)
			{
				C = A*(Math.sin(Math.toRadians(c))/Math.sin(Math.toRadians(a))) ;
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
				A = B*(Math.sin(Math.toRadians(a))/Math.sin(Math.toRadians(b))) ;
			}
			if( b == 0 && B != 0 && a != 0 && A != 0 )
			{
				b = Math.toDegrees(Math.asin(B*(Math.sin(Math.toRadians(a))/A))) ;
			}
			if( B == 0 && A != 0 && b != 0 && a != 0 )
			{
				B = A*(Math.sin(Math.toRadians(b))/Math.sin(Math.toRadians(a))) ;
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
				B = C*(Math.sin(Math.toRadians(b))/Math.sin(Math.toRadians(c))) ;
			}
			if( c == 0 && C != 0 && b != 0 && B != 0)
			{
				c = Math.toDegrees(Math.asin(C*(Math.sin(Math.toRadians(b))/B))) ;
			}
			if( C == 0 && B != 0 && c != 0 && b != 0 )
			{
				C = B*(Math.sin(Math.toRadians(c))/Math.sin(Math.toRadians(b))) ;
			}
	
		double newset[] = {A,a,B,b,C,c};
		return newset;
	}

}
