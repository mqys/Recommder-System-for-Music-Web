package collaborativeFiltering.implement.recommeder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import collaborativeFiltering.implement.model.PrefListModel;
import collaborativeFiltering.implement.model.TagListVoteModel;
import collaborativeFiltering.implement.neighbor.NearestNUserNeighbor;
import collaborativeFiltering.implement.similarity.CalcuSimMatrix;
import collaborativeFiltering.implement.similarity.PearsonCorrelationSimilarity;
import collaborativeFiltering.implement.similarity.TanimotoCoefficientSimilarity;
import collaborativeFiltering.implement.tagVote.TagVoting;
import collaborativeFiltering.model.Model;
import collaborativeFiltering.model.Preference;
import collaborativeFiltering.model.TagVoteModel;
import collaborativeFiltering.neighbor.UserNeighborhood;
import collaborativeFiltering.recommender.UserBasedCFRecommend;
import collaborativeFiltering.recommender.UserTagBasedRecommend;
import collaborativeFiltering.similarity.ItemPropertySimilarity;
import collaborativeFiltering.similarity.SimilarityMatrix;
import collaborativeFiltering.similarity.UserSimilarity;
import collaborativeFiltering.tagVote.TagVote;

public class MixedUserRecommender {

	private List<Integer> itemList;
	
	
	
	public MixedUserRecommender(List<Preference> fullPrefList
			,HashMap<Integer,List<Integer>> fullTagList
			,List<Integer> collectionList
			,int uid) throws Exception{
		super();
		// TODO Auto-generated constructor stub
		this.itemList = new ArrayList<Integer>();
//		Set<Integer> itemSet = new TreeSet<Integer>();
		
		//collaborative filtering
		Model m = new PrefListModel(fullPrefList);
		UserSimilarity us = new PearsonCorrelationSimilarity();
		SimilarityMatrix sm = new CalcuSimMatrix(m,us);
		UserNeighborhood un = new NearestNUserNeighbor();
		UserBasedCFRecommend ubcfr = new UserBasedCFRecommender();
		
		this.itemList.addAll(ubcfr.getItemReco(uid, 10, 20, m, sm, un));
		
		//UserTag recommender
		TagVoteModel tvm = new TagListVoteModel(fullTagList, collectionList, fullPrefList, uid);
		TagVote tv = new TagVoting(tvm,10);
		ItemPropertySimilarity ips = new TanimotoCoefficientSimilarity();
		UserTagBasedRecommend utbr = new UserTagBasedRecommender(tvm, tv, ips, 10);
		
		//delete repeated item and keep the order
		for(Integer i: utbr.getItemRecommend()){
			if(this.itemList.contains(i))
				continue;
			this.itemList.add(i);
		}
	}



	public List<Integer> getUserRecommend() {
		return this.itemList;
	}
}
