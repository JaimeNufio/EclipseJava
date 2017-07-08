
public class ProjectOne {
	public static void main(String[] args){
		Rational a = new Rational(1,6);
		Rational b = new Rational(1,5);
		
		System.out.println(a.gcd(a, b));
	}
}

class Rational{
	
	double num,denom;
	
	Rational(double num, double denom){
		setDenom(denom);
		setNum(num);
	}
	
	public String toString(){
		return this.getNum()+"/"+this.getDenom();
	}
	
	private void setNum(double num){
		this.num = num;
	}
	
	private void setDenom(double denom){
		this.denom = denom;
	}
	
	public double getNum(){
		return this.num;
	}
	
	public double getDenom(){
		return this.denom;
	}
	
	public Rational add(Rational one,Rational two){
		double comDenom = one.getDenom()*two.getDenom();
		double num1,num2;
		num1 = one.getNum()*two.getDenom(); num2 = two.getNum()*one.getDenom();
		return new Rational(num1+num2,comDenom);
	}
	
	public Rational sub(Rational one,Rational two){ // a - b
		double comDenom = one.getDenom()*two.getDenom();
		double num1,num2;
		num1 = one.getNum()*two.getDenom(); num2 = two.getNum()*one.getDenom();
		return new Rational(num1-num2,comDenom);
	}
	
	public Rational mult(Rational one,Rational two){
		return new Rational(one.getNum()*two.getNum(),one.getDenom()*two.getDenom());
	}

	public Rational div(Rational one,Rational two){ // a/b
		return new Rational(one.getNum()*two.getDenom(),one.getDenom()*two.getNum());
	}
	
	public double gcd(Rational one, Rational two){
		double a,b;
		a = one.getDenom(); b = two.getDenom();
		
		while (b!=0){
			a = b;
			b = a%b;
		}
		
		return a;
	}
}