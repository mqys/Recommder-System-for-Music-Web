package collaborativeFiltering.implement.model;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import collaborativeFiltering.model.Model;
import collaborativeFiltering.model.Preference;

public class PrefListModel implements Model {

	private Map<Integer, HashMap<Integer, Double>> preMap;
	private Set<Integer> itemSet;
	
	public PrefListModel(List<Preference> prefList) throws Exception{
		if(prefList.isEmpty())
			throw new Exception("empty preference list");
		
		this.preMap = new HashMap<Integer, HashMap<Integer, Double>>();
		this.itemSet = new HashSet<Integer>();
		
		int uid;
		int oid;
		double score;
		HashMap<Integer,Double> score_map;
		
		for(Preference pf:prefList){
			uid = pf.getUid();
			oid = pf.getOid();
			score = pf.getScore();
			
			this.itemSet.add(oid);
			
			if(preMap.containsKey(uid))
				score_map = preMap.get(uid);
			else
				score_map = new HashMap<Integer,Double>();
			
			score_map.put(oid, score);
			preMap.put(uid, score_map);
		
		}
	}
	
	
	@Override
	public Set<Integer> getItemSet() {
		// TODO Auto-generated method stub
		return this.itemSet;
	}

	@Override
	public Map<Integer, HashMap<Integer, Double>> getPrefMap() {
		// TODO Auto-generated method stub
		return this.preMap;
	}

}
