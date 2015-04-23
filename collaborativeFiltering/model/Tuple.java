package collaborativeFiltering.model;

public class Tuple {

	private int uid1;
	private int uid2;
	public Tuple(int uid1, int uid2) {
		super();
		this.uid1 = uid1;
		this.uid2 = uid2;
	}
	
	
	//define equal
	@Override
	public boolean equals(Object o){
		Tuple t = (Tuple) o;
		if((this.uid1 == t.uid1)&&(this.uid2 == t.uid2))
			return true;
		else if((this.uid1 == t.uid2)&&(this.uid2 == t.uid1))
			return true;
		
		return false;
	}
	@Override 
	public int hashCode(){
		return this.uid1 ^ this.uid2;
	}
	
	public int getUid1() {
		return uid1;
	}
	public void setUid1(int uid1) {
		this.uid1 = uid1;
	}
	public int getUid2() {
		return uid2;
	}
	public void setUid2(int uid2) {
		this.uid2 = uid2;
	}
	
	
}
