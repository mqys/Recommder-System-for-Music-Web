package collaborativeFiltering.implement.similarity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import collaborativeFiltering.model.Model;
import collaborativeFiltering.model.Tuple;
import collaborativeFiltering.similarity.SimilarityMatrix;
import collaborativeFiltering.similarity.UserSimilarity;


public class CalcuSimMatrix implements SimilarityMatrix {

	HashMap<Tuple,Double> similarityMatrix;
	HashMap<Integer,HashMap<Integer,Double>> fullMatrix;

	
	public CalcuSimMatrix(Model m,UserSimilarity us) throws Exception {
		super();
		// TODO Auto-generated constructor stub
		this.calFullMatrix(m, us);
	}


	public CalcuSimMatrix() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public HashMap<Tuple,Double> calTupleMatrix(Model m,UserSimilarity us) throws Exception {

		Map<Integer, HashMap<Integer, Double>> prefModel = m.getPrefMap();
		if(prefModel.isEmpty())
			return null;
		
		this.similarityMatrix = new HashMap<Tuple,Double>();
		int uid1=0,uid2=0;
		HashMap<Integer,Double> up1 = null,up2 = null;
//		Map.Entry<Integer, HashMap<Integer,Double>> pair = null;
		
		
		
		//带副作用，破坏PrefMap
//		while(prefModel.size() != 1){
//			
//			Iterator it =  prefModel.entrySet().iterator();
//			if(it.hasNext()){
//				pair = (Entry<Integer, HashMap<Integer, Double>>) it.next();
//				uid1 = pair.getKey();
//				up1 = pair.getValue();
//			}
//			
//			while(it.hasNext()){
//				pair = (Entry<Integer, HashMap<Integer, Double>>) it.next();
//				uid2 = pair.getKey();
//				up2 = pair.getValue();
//				
//				Tuple t = new Tuple(uid1,uid2);
//				if(!(this.similarityMatrix.containsKey(t)))
//						this.similarityMatrix.put(t, us.getUserSimilarity(up1, up2));
//			}
//			prefModel.remove(uid1);
//		}
		
		
		//无副作用，不破坏prefModel
//		Set<Integer> keylist = prefModel.keySet();
//		for(Integer k1:keylist){
//			up1 = prefModel.get(k1);
//			for(Integer k2:keylist){
//				if(k2 == k1)
//					continue;
//				if(this.similarityMatrix.containsKey(new Tuple(k1,k2)))
//					continue;
//				up2 = prefModel.get(k2);
//				this.similarityMatrix.put(new Tuple(k1,k2), us.getUserSimilarity(up1, up2));
//			}
//		}

		
		//优化无副作用
		List<Integer> l = new ArrayList<Integer>(prefModel.keySet());
		for(int i = 0;i<l.size()-1;i++){
			uid1 = l.get(i);
			up1 = prefModel.get(uid1);
			for(int j = i +1;j<l.size();j++){
				uid2 = l.get(j);
				up2 = prefModel.get(l.get(j));
				this.similarityMatrix.put(new Tuple(uid1,uid2),us.getUserSimilarity(up1, up2));
			}
		}
		return similarityMatrix;
	}


	//FULL Matrix
	@Override
	public HashMap<Integer, HashMap<Integer, Double>> calFullMatrix(Model m,
			UserSimilarity us) throws Exception {
		// TODO Auto-generated method stub
		Map<Integer, HashMap<Integer, Double>> prefModel = m.getPrefMap();
		if(prefModel.isEmpty())
			return null;
		
		this.fullMatrix = new HashMap<Integer,HashMap<Integer,Double>>();
		int uid1=0,uid2=0;
		HashMap<Integer,Double> up1 = null,up2 = null;
		HashMap<Integer,Double> sim = null;
		
		//未优化
//		List<Integer> l = new ArrayList(prefModel.keySet());
//		for(int i=0;i<l.size();i++){
//			uid1 = l.get(i);
//			up1 = prefModel.get(uid1);
//			
//			for(int j=0;j<l.size();j++){
//				if(j==i)
//					continue;
//				uid2 = l.get(j);
//				up2 = prefModel.get(l.get(j));
//				if(this.fullMatrix.containsKey(uid1)){
//					sim = this.fullMatrix.get(uid1);
//					sim.put(uid2, us.getUserSimilarity(up1, up2));
//					this.fullMatrix.put(uid1, sim);
//				}
//				else{
//					sim = new HashMap<Integer,Double>();
//					sim.put(uid2, us.getUserSimilarity(up1, up2));
//					this.fullMatrix.put(uid1, sim);
//				}
//			}
//		}
		
		//优化后
		List<Integer> l = new ArrayList<Integer>(prefModel.keySet());
		double score = 0.0;
		for(int i=0;i<l.size();i++){
			uid1 = l.get(i);
			up1 = prefModel.get(uid1);
			
			for(int j=0;j<l.size();j++){
				if(j==i)
					continue;
				uid2 = l.get(j);
				up2 = prefModel.get(l.get(j));
				
				if(this.fullMatrix.containsKey(uid1))
					sim = this.fullMatrix.get(uid1);
				else
					sim = new HashMap<Integer,Double>();
				
				//repeated calcu
				if(j < i){
					score = this.fullMatrix.get(uid2).get(uid1);
					sim.put(uid2, score);
				}
				else
					sim.put(uid2, us.getUserSimilarity(up1, up2));
					
				this.fullMatrix.put(uid1, sim);
			}
		}
		
//		System.out.println(this.fullMatrix);
		
		return this.fullMatrix;
	}


	public HashMap<Tuple, Double> getSimilarityMatrix() {
		return this.similarityMatrix;
	}

	public HashMap<Integer, HashMap<Integer, Double>> getFullMatrix() {
		return this.fullMatrix;
	}



}
