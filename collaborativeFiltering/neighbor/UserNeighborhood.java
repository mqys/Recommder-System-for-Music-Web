package collaborativeFiltering.neighbor;

import java.util.HashMap;
import java.util.List;

import collaborativeFiltering.model.Tuple;



public interface UserNeighborhood {

	List<Integer> getNeiFullMatrix(int uid,int n,HashMap<Integer,HashMap<Integer,Double>> fullmatrix) throws Exception;

	List<Integer> getNeiTupleMatrix(int uid,int n,HashMap<Tuple,Double> matrix) throws Exception;
}
