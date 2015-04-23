package collaborativeFiltering.implement.neighbor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import collaborativeFiltering.model.Tuple;
import collaborativeFiltering.neighbor.UserNeighborhood;


public class NearestNUserNeighbor implements UserNeighborhood {

	List<Integer> NeighborID = null;

	@Override
	public List<Integer> getNeiFullMatrix(int uid, int n
				, HashMap<Integer,HashMap<Integer,Double>> fullmatrix)
			throws Exception {
		// TODO Auto-generated method stub
		HashMap<Integer,Double> sim = fullmatrix.get(uid);

		List<Map.Entry<Integer, Double>> list =
		    new ArrayList<Map.Entry<Integer, Double>>(sim.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<Integer,Double>>(){
			@Override
			public int compare(Entry<Integer, Double> o1,
					Entry<Integer, Double> o2) {
				// TODO Auto-generated method stub
				if(o1.getValue() > o2.getValue())
					return -1;
				return 1;
			}
		});
		
		this.NeighborID = new ArrayList<Integer>();
		double neiSim = 0.0;
		for(int i=0;i<list.size()&&i<n;i++){
			neiSim = list.get(i).getValue();
			if(neiSim > 0)
				this.NeighborID.add(list.get(i).getKey());
		}
		return this.NeighborID;
	}

	
	
	@Override
	public List<Integer> getNeiTupleMatrix(int uid, int n,
			HashMap<Tuple,Double> matrix) throws Exception {
		// TODO Auto-generated method stub
		
		return null;
	}

}
