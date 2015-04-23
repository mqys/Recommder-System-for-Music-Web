package collaborativeFiltering.implement.similarity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import collaborativeFiltering.similarity.UserSimilarity;


public class PearsonCorrelationSimilarity implements UserSimilarity {

	@Override
	public double getUserSimilarity(HashMap<Integer, Double> up1
			,HashMap<Integer, Double> up2) throws Exception {

		//build common item list
		List<Integer> common_list = new ArrayList<Integer>();
		
		Iterator<Entry<Integer, Double>> it = 
							up1.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer, Double> entry =
				(Map.Entry<Integer, Double>)it.next();
			int oid = entry.getKey();
			
			if(up2.containsKey(oid))
				common_list.add(oid);
		}
		//calculate
		int len = common_list.size();
		if(len == 0)                                    
			return 0;
		double sum1 = 0.0,sum2= 0.0
				,sum1Sq= 0.0,sum2Sq= 0.0,sum12= 0.0
				,sco1 = 0.0,sco2 =0.0;
		for(int i = 0; i< len; i++){
			sco1 = up1.get(common_list.get(i));
			sco2 = up2.get(common_list.get(i));
			sum1 += sco1;
			sum2 += sco2;
			sum12 += sco1 * sco2;
			sum1Sq += Math.pow(sco1, 2);
			sum2Sq += Math.pow(sco2, 2);
		}
		
		double top = sum12 - (sum1*sum2)/len;
		double bot = Math.sqrt((sum1Sq - Math.pow(sum1, 2)/ len)
				*(sum2Sq - Math.pow(sum2, 2)/ len));
		
		if(bot == 0)
			return 0;
		
		return top / bot;
	}

}
