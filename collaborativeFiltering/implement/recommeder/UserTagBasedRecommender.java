package collaborativeFiltering.implement.recommeder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import collaborativeFiltering.model.TagVoteModel;
import collaborativeFiltering.recommender.UserTagBasedRecommend;
import collaborativeFiltering.similarity.ItemPropertySimilarity;
import collaborativeFiltering.tagVote.TagVote;

public class UserTagBasedRecommender implements UserTagBasedRecommend {

	private List<Integer> recomItemList;
	
	public UserTagBasedRecommender(TagVoteModel tvm,TagVote tv 
								,ItemPropertySimilarity ips,int itemNum){
		
		HashMap<Integer,Double> itemSimList = new HashMap<Integer,Double>();
		List<Integer> topNTag = tv.getTopNTag();
		HashMap<Integer,List<Integer>> itemList = tvm.getFullTagList();
		HashMap<Integer,List<Integer>> likedList = tvm.getLikeList();
		
		//calculate similarity
		double sim = 0.0;
		for(Entry<Integer,List<Integer>> en:itemList.entrySet()){
			List<Integer> tagList = en.getValue();
			sim = ips.getTagListSimilarity(tagList, topNTag);
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
		int item =0;
		for(int i=0;i<sortItemSimList.size()&&i<itemNum;i++){
			//delete repeated item
			item = sortItemSimList.get(i).getKey();
			if(likedList.containsKey(item))
				continue;
			this.recomItemList.add(sortItemSimList.get(i).getKey());
		}
	}
	
	@Override
	public List<Integer> getItemRecommend() {
		// TODO Auto-generated method stub
		return this.recomItemList;
	}

}
