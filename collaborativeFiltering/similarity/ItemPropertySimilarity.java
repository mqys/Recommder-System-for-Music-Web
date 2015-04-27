package collaborativeFiltering.similarity;

import java.util.List;

public interface ItemPropertySimilarity {

	double getItemPropertySimilarity(List<Integer> propertylist1,List<Integer> propertylist2);
}
