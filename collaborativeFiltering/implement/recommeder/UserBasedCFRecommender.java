package collaborativeFiltering.implement.recommeder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import collaborativeFiltering.model.Model;
import collaborativeFiltering.neighbor.UserNeighborhood;
import collaborativeFiltering.recommender.UserBasedCFRecommend;
import collaborativeFiltering.similarity.SimilarityMatrix;


public class UserBasedCFRecommender implements UserBasedCFRecommend {

	private List<Integer> itemList;
	private HashMap<Integer,Double> predict;
	
	@Override
	public List<Integer> getItemReco(int uid, int itemNum,int neiNum, Model m,
			SimilarityMatrix sm, UserNeighborhood un) throws Exception {
		// TODO Auto-generated method stub
		Map<Integer,HashMap<Integer,Double>> prefModel = m.getPrefMap();
		Set<Integer> itemSet = m.getItemSet();
		List<Integer> neiList = un.getNeiFullMatrix(uid, neiNum, sm.getFullMatrix());//calcu
		HashMap<Integer,Double> myPref = prefModel.get(uid);
		HashMap<Integer,Double> mySim  = sm.getFullMatrix().get(uid);
		HashMap<Integer,Double> neiPref = null;
		this.predict = new HashMap<Integer,Double>();//store prediction
		this.itemList = new ArrayList<Integer>();
		
//		System.out.println(neiList);
		for(Integer item: itemSet){
			if(myPref.containsKey(item))
				continue;
			double simSum = 0.0;
			double rankingSum = 0.0;
			for(Integer nei: neiList){
				neiPref = prefModel.get(nei);
				if(neiPref.containsKey(item)){
					simSum += mySim.get(nei);
					rankingSum += neiPref.get(item) * mySim.get(nei);
				}
			}
			if(simSum > 0)
				this.predict.put(item, rankingSum/simSum);
			
//			System.out.println(item+"-"+rankingSum/simSum);
		}

		//form the recommend item list
		List<Map.Entry<Integer, Double>> hashToList =
		    new ArrayList<Map.Entry<Integer, Double>>(this.predict.entrySet());
		Collections.sort(hashToList,new Comparator<Map.Entry<Integer,Double>>(){
			@Override
			public int compare(Entry<Integer, Double> o1,
					Entry<Integer, Double> o2) {
				// TODO Auto-generated method stub
				if(o1.getValue() > o2.getValue())
					return -1;
				return 1;
			}
		});
		for(int i=0;i<hashToList.size()&&i<itemNum;i++){
			this.itemList.add(hashToList.get(i).getKey());
		}
		
//		for(int j=0;j<hashToList.size();j++){
//			System.out.println(uid+"-"+hashToList.get(j).getKey()
//						+"="+hashToList.get(j).getValue());
//		}
		return this.itemList;
	}

}
