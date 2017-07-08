//
//public class SpecialTriangles {
//	
//	  public static double[] Right1(double[] set)// 30/60/90
//	    {
//			double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];
//				if (A == 0 && B != 0 && C != 0)
//				{
//					A = Math.sqrt((B*B)-(C*C));
//				}
//				if (B == 0 && C != 0 && A != 0)
//				{
//					B = Math.sqrt((A*A)-(C*C));
//				}
//				if (C == 0 && B != 0 && A != 0)
//				{
//					C = Math.sqrt((A*A)+(B*B));
//				}
//				
//	            double newset[] = {A,a,B,b,C,c};
//	    		return newset;
//	    }
//	    
////	    public static double Right2(double[] set)//Finding Angle c
////	    {
////			double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];
////			
////	           	if (true){
////	           		
////	           	}
////	            
////
////	    }
//	    
//	    public static double B(double[] set)//Finding Side B
//	    {
//			double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];
//			
//	            return Math.sqrt((A*A)+(C*C)-(2*A*C)*(Math.cos(Math.toRadians(b))));
//
//	    }
//	    
//	    public static double b(double[] set)//Finding Angle b
//	    {
//			double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];
//	            return Math.acos(((B*B)-(A*A)-(C*C))/(-2*A*C));
//
//	    }
//	    
//	    public static double A(double[] set)//Finding Side A
//	    {
//			double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];
//
//	            return  Math.sqrt((B*B)+(C*C)-(2*B*C)*(Math.cos(Math.toRadians(a))));
//
//	    }
//	    
//	    public static double a(double[] set)//Finding Angle a
//	    {
//			double A = set[0], a = set[1], B = set[2], b = set[3], C = set[4], c = set[5];
//
//	            return Math.acos(((A*A)-(B*B)-(C*C))/(-2*B*C));
//
//	    }
//
//
//}
