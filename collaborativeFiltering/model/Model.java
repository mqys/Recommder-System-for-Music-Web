package collaborativeFiltering.model;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



public interface Model {
	
	Map<Integer,HashMap<Integer,Double>> getPrefMap();
	
	Set<Integer> getItemSet();
	
}
