package collaborativeFiltering.implement.recommeder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import collaborativeFiltering.model.TagModel;
import collaborativeFiltering.recommender.ItemTagBasedRecommend;
import collaborativeFiltering.similarity.ItemPropertySimilarity;

public class ItemTagBasedRecommender implements ItemTagBasedRecommend {

	private List<Integer> recomItemList;
	
	public ItemTagBasedRecommender(TagModel tm,ItemPropertySimilarity ips,int itemNum) {
		super();
		// TODO Auto-generated constructor stub
		HashMap<Integer,Double> itemSimList = new HashMap<Integer,Double>();
		List<Integer> presentItemTag = tm.getCurrentItemTag();
		HashMap<Integer,List<Integer>> itemList = tm.getFullTagList();
		int currentItemId = tm.getCurrentItemId(); 
		
		double sim = 0.0;
		for(Entry<Integer,List<Integer>> en:itemList.entrySet()){
			List<Integer> tagList = en.getValue();
			sim = ips.getItemPropertySimilarity(tagList, presentItemTag);
			itemSimList.put(en.getKey(), sim);
		}
		//sort
		List<Map.Entry<Integer, Double>> sortItemSimList =
		    new ArrayList<Map.Entry<Integer, Double>>(itemSimList.entrySet());
		Collections.sort(sortItemSimList,new Comparator<Map.Entry<Integer,Double>>(){
			@Override
			public int compare(Entry<Integer, Double> o1,
					Entry<Integer, Double> o2) {
				if(o1.getValue() > o2.getValue())
					return -1;
				return 1;
			}
		});
		//get topN
		this.recomItemList = new ArrayList<Integer>();
		int tmpItem = 0;
		for(int i=0;i<sortItemSimList.size()&&i<itemNum;i++){
			//delete repeated item
			tmpItem = sortItemSimList.get(i).getKey();
			if(tmpItem == currentItemId)
				continue;
			this.recomItemList.add(tmpItem);
		}
	}



	@Override
	public List<Integer> getRecomItem() {
		// TODO Auto-generated method stub
		return this.recomItemList;
	}

}
