package collaborativeFiltering.implement.similarity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import collaborativeFiltering.similarity.ItemPropertySimilarity;

public class TanimotoCoefficientSimilarity implements ItemPropertySimilarity {

	@Override
	public double getItemPropertySimilarity(List<Integer> propertylist1,
			List<Integer> propertylist2) {
		// TODO Auto-generated method stub
		Set<Integer> intersection = new HashSet<Integer>();
		Set<Integer> union = new HashSet<Integer>();
		
		for(Integer i:propertylist1){
			for(Integer j:propertylist2){
				if(i.intValue()== j.intValue())
					intersection.add(j);
				union.add(j);
			}
			union.add(i);
		}
		if(union.size()>0)
			return (double)intersection.size() / (double)union.size();
		else
			return 0.0;
	}

	
	
//	@Test
//	public void test(){
//		List<Integer> l1 = new ArrayList<Integer>();l1.add(1);l1.add(2);l1.add(3);
//		List<Integer> l2 = new ArrayList<Integer>();l2.add(1);l2.add(2);l2.add(4);
//
//		System.out.println(getTagListSimilarity(l1, l2));
//	}
}
