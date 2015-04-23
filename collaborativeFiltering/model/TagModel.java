package collaborativeFiltering.model;

import java.util.HashMap;
import java.util.List;

public interface TagModel {

	
	HashMap<Integer,List<Integer>> getFullTagList();
	List<Integer> getCurrentItemTag();
	
}
