package collaborativeFiltering.recommender;

import java.util.HashMap;
import java.util.List;

import collaborativeFiltering.tagVote.TagVote;

public interface UserTagBasedRecommend {

	List<Integer> getItemRecommend();
}
