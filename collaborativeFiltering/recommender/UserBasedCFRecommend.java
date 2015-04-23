package collaborativeFiltering.recommender;

import java.util.List;

import collaborativeFiltering.model.Model;
import collaborativeFiltering.neighbor.UserNeighborhood;
import collaborativeFiltering.similarity.SimilarityMatrix;



public interface UserBasedCFRecommend {

	List<Integer> getItemReco(int uid,int itemNum,int neiNum,Model m,SimilarityMatrix sm,UserNeighborhood un) throws Exception;
	
}
