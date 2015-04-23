package collaborativeFiltering.similarity;

import java.util.List;

public interface ItemPropertySimilarity {

	double getTagListSimilarity(List<Integer> propertylist1,List<Integer> propertylist2);
}
