package collaborativeFiltering.model;


public class Preference implements Comparable<Preference>{

	private int uid;
	private int oid;
	private double score;
	
	public Preference(int uid, int oid, double score) {
		super();
		this.uid = uid;
		this.oid = oid;
		this.score = score;
	}


	@Override
	public int compareTo(Preference o) {
		// TODO Auto-generated method stub
		
		return ((Integer)this.uid).compareTo(o.uid);
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public int getOid() {
		return oid;
	}


	public void setOid(int oid) {
		this.oid = oid;
	}


	public double getScore() {
		return score;
	}


	public void setScore(double score) {
		this.score = score;
	}
	
}
