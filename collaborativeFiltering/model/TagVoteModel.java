package collaborativeFiltering.model;

import java.util.HashMap;
import java.util.List;

public interface TagVoteModel {

	HashMap<Integer,List<Integer>> getLikeList();
	HashMap<Integer,List<Integer>> getDislikeList();
	HashMap<Integer,List<Integer>> getFullTagList();
	
}
