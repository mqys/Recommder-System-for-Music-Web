package collaborativeFiltering.similarity;

import java.util.HashMap;

public interface UserSimilarity {

	double getUserSimilarity(HashMap<Integer, Double> up1
			,HashMap<Integer, Double> up2) throws Exception;

	
}
