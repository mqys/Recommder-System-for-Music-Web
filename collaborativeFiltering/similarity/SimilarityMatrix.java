package collaborativeFiltering.similarity;

import java.util.HashMap;

import collaborativeFiltering.model.Model;
import collaborativeFiltering.model.Tuple;


public interface SimilarityMatrix {

	HashMap<Tuple,Double> calTupleMatrix(Model m,UserSimilarity us) throws Exception;
	
	HashMap<Integer,HashMap<Integer,Double>> calFullMatrix(Model m,UserSimilarity us) throws Exception;

	HashMap<Tuple, Double> getSimilarityMatrix();
	
	HashMap<Integer, HashMap<Integer, Double>> getFullMatrix();

}
