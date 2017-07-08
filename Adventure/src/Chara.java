
public class Chara {
	int hp, maxhp, atk, def, spec, dex,special;
	
	public void build(int num){
		switch(num){
		case (1):
			buildWarrior();
			break;
		case (2):
			buildRouge();
			break;
		case (3):
			buildArcher();
			System.out.println("archer built");
			break;
		case (4):
			buildMage();
			break;
		}
	}
	// I have no idea how many points I'll use... lets say 25
	//10 hp is worth 1 point
	
	public void buildWarrior(){
		hp = 150;
		atk = 5;
		def = 5;
		spec = 2;
		dex = 3;
		maxhp = hp;
		special = 1;
	}
	
	public void buildMage(){
		hp = 100;
		atk = 5;
		def = 2;
		spec = 10;
		dex = 3;
		maxhp = hp;
		special = 2;
	}
	
	public void buildRouge(){
		hp = 100;
		atk = 7;
		def = 2;
		spec = 2;
		dex = 14;
		special = 3;
	}
	
	public void buildArcher(){
		hp = 100;
		atk = 5;
		def = 4;
		spec = 6;
		dex = 10;
		special = 4;
	}
	
	public void doDamage(){
		
	}
	
	public void shield(){
		
	}
	
	public void parry(){
		
	}
	
}
