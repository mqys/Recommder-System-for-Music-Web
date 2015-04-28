package collaborativeFiltering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import collaborativeFiltering.implement.model.CurrentTagModel;
import collaborativeFiltering.implement.model.FileModel;
import collaborativeFiltering.implement.model.TagListVoteModel;
import collaborativeFiltering.implement.recommeder.ItemTagBasedRecommender;
import collaborativeFiltering.implement.recommeder.MixedUserRecommender;
import collaborativeFiltering.implement.recommeder.UserTagBasedRecommender;
import collaborativeFiltering.implement.similarity.TanimotoCoefficientSimilarity;
import collaborativeFiltering.implement.tagVote.TagVoting;
import collaborativeFiltering.model.Model;
import collaborativeFiltering.model.Preference;
import collaborativeFiltering.model.TagModel;
import collaborativeFiltering.model.TagVoteModel;
import collaborativeFiltering.recommender.ItemTagBasedRecommend;
import collaborativeFiltering.recommender.UserTagBasedRecommend;
import collaborativeFiltering.similarity.ItemPropertySimilarity;
import collaborativeFiltering.tagVote.TagVote;




public class test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		long startTime=System.nanoTime();
		
		
//		Preference p1 = new Preference(1,1,3);
//		Preference p2 = new Preference(3,1,3);
//		Preference p3 = new Preference(3,2,3);
//		Preference p4 = new Preference(2,1,3);
//		
//		List<Preference> p_l = new ArrayList<Preference>();
//		p_l.add(p1);p_l.add(p2);p_l.add(p3);p_l.add(p4);
//		
//		
//		Collections.sort(p_l);
//		
//		for(Preference p : p_l)
//		{
////			System.out.println(p.getUid()+'-'+p.getOid()
////					+'-'+p.getScore());
//			System.out.println(p.getUid());
//		}

		//=================MAP TEST============================
//		Map<Integer,HashMap<Integer,Double>> m = 
//				new HashMap<Integer,HashMap<Integer,Double>>();
//		
//		HashMap<Integer,Double> mm  = new HashMap<Integer,Double>();
//		mm.put(1, 1.0);
//		mm.put(2, 2.0);
//		mm.put(3, 4.0);
//		
//		m.put(3, mm);
//		
//		System.out.println(mm.get(1));
//		System.out.println(m.get(3));
//		System.out.println(m);
//		System.out.println(m.containsKey(1));
//		
		//==============MODELLING==============================
		
//		Model m = new FileModel("u.data");
		
		//==============SIMILARITY CALCULATE=====================
//		HashMap<Integer,Double> up1 = new HashMap<Integer,Double>();
//		up1.put(1, 1.0);up1.put(2, 2.0);up1.put(3, 3.0);
//		HashMap<Integer,Double> up2 = new HashMap<Integer,Double>();
//		up2.put(1, 2.0);up2.put(2, 5.0);up2.put(3, 6.0);
////		up2.put(1, 1.0);up2.put(2, 2.0);up2.put(3, 3.0);
////		up2.put(4, 1.0);up2.put(5, 2.0);up2.put(6, 3.0);
////		up2.put(1, 100.0);up2.put(2, 50.0);up2.put(3, 1.0);
//
//		UserSimilarity us = new PearsonCorrelationSimilarity();
//		System.out.println(us.getUserSimilarity(up1, up2));
////		
		//===============TUPLE COMPARE============================
//		
//		HashMap<Tuple,Double>  h = new HashMap<Tuple,Double> ();
//		Tuple t1 = new Tuple(1,5);
//		Tuple t2 = new Tuple(5,1);
//		Tuple t3 = new Tuple(1,5);
//		Tuple t4 = new Tuple(2,4);
//		h.put(t1, 2.0);
////		System.out.println(h.containsKey(t2));
//		System.out.println(h.containsKey(t2));
//		System.out.println(t1.hashCode()== t4.hashCode());
//		System.out.println(t1.equals(t2));
//		System.out.println(t1.equals(t4));

		
		//=============MATRIX TEST===============================
//		Model m = new FileModel("u1.base");		
////		System.out.println(m.getPrefMap());
//
//		UserSimilarity us = new PearsonCorrelationSimilarity();
//		
//		SimilarityMatrix sm = new CalcuSimMatrix();
//		
//		//Tuple Matrix
////		HashMap<Tuple,Double> smm = sm.getTupleMatrix(m, us);
////		File f = new File("result");
////		FileWriter fw = new FileWriter(f);
////		BufferedWriter bw = new BufferedWriter(fw);
////		for(Entry<Tuple,Double> entry: smm.entrySet()){
////			bw.write(entry.getKey().getUid1()+"-"+entry.getKey().getUid2()+"="+entry.getValue());
////			bw.newLine();
////		}
////		bw.close();
//		
//		//full Matrix
//		HashMap<Integer,HashMap<Integer,Double>> fm = sm.calFullMatrix(m, us);
//		File ff = new File("fullRS");
//		FileWriter ffw = new FileWriter(ff);
//		BufferedWriter bfw = new BufferedWriter(ffw);
//		for(Entry<Integer,HashMap<Integer,Double>> entry: fm.entrySet()){
//			int uid1 = entry.getKey();
//			for(Entry<Integer,Double> en :entry.getValue().entrySet()){
//				bfw.write(uid1+"-"+en.getKey()+"="+en.getValue());
//				bfw.newLine();
//			}
//		}
//		bfw.close();
		
		//============HASHMAP ITERATE===================================
//		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
//		hm.put(1, 1);hm.put(2, 1);hm.put(3, 1);hm.put(4, 1);
////		Iterator it = hm.entrySet().iterator();
//		int u1=0,u2=0,o1=0,o2=0;
//		Collection<Integer> kl = hm.keySet();
//		List l = new ArrayList(kl);
////		for(Integer i1:kl){
////			for(Integer i2:kl){
////				if(i1 != i2)
////					System.out.println(hm.get(i1)+"=="+hm.get(i2));
////			}
////		}
//		for(int i1 = 0;i1<l.size()-1;i1++){
//			
//			for(int i2 = i1 +1;i2<l.size();i2++){
//				System.out.println(hm.get(l.get(i1))+"=="+hm.get(l.get(i1)));
//			}
//		}
		
		//==============NEIGHBORHOOD=============================
//		//Forming prefModel,itemSet,simMatrix(Timing)
//		Model m = new FileModel("u.data");
//		UserSimilarity us = new PearsonCorrelationSimilarity();//method class
//		SimilarityMatrix sm = new CalcuSimMatrix();
//		sm.calFullMatrix(m, us);//calcu SEPARATE CAL AND GET
//		
// 
//		//recommending
//		UserNeighborhood un = new NearestNUserNeighbor();//method class
////		un.getNeiFullMatrix(1, 2000, sm.getFullMatrix(m, us));
//		//get uid nearest 10 neighbor
//		System.out.println(un.getNeiFullMatrix(1, 10, sm.getFullMatrix()));
//		                                  
////		System.out.println(m.getItemSet());
//		
		
		//==============RECOMMEND================================
//		//Forming prefModel,itemSet,simMatrix(Timing)
//		Model m = new FileModel("u.data");//100k dataset
////		Model m = new FileModel("u1.base");//80k dataset
////		Model m = new FileModel("my.test");
//		long endTime=System.nanoTime(); 
//		System.out.println("MODEL  : "+(endTime-startTime)+"ns"); 
//		UserSimilarity us = new PearsonCorrelationSimilarity();//method class
////		SimilarityMatrix sm = new CalcuSimMatrix();
////		sm.calFullMatrix(m, us);//calcu SEPARATE CAL AND GET
//		SimilarityMatrix sm = new CalcuSimMatrix(m,us);
//		endTime=System.nanoTime(); 
//		System.out.println("MATRIX : "+(endTime-startTime)+"ns"); 
//		
//		UserNeighborhood un = new NearestNUserNeighbor();//method class
//		Recommend rc = new UserBasedRecommend();
//
//		
//		//getItemReco(uid,itemNum,neiNum, Model,SimilarityMatrix,UserNeighborhood)
//		System.out.println(rc.getItemReco(1, 10, 50, m, sm, un));
//		
//		endTime=System.nanoTime(); //recommend
//		System.out.println("RECOM : "+(endTime-startTime)+"ns"); 
		
		//==============PrefList MODELING==========================
//		List<Preference> prefL = new ArrayList<Preference>();
//		prefL.add(new Preference(1,1,1));
//		prefL.add(new Preference(1,2,2));
//		prefL.add(new Preference(1,3,3));
//		prefL.add(new Preference(2,1,1));
//		prefL.add(new Preference(2,2,2));
//		prefL.add(new Preference(2,3,3));
//		prefL.add(new Preference(2,4,1));
//		prefL.add(new Preference(3,1,3));
//		prefL.add(new Preference(3,2,2));
//		prefL.add(new Preference(3,3,1));
//		prefL.add(new Preference(3,5,5));
//		prefL.add(new Preference(4,1,1));
//		prefL.add(new Preference(4,2,2));
//		prefL.add(new Preference(4,3,2));
//		prefL.add(new Preference(4,7,3));
//		
//		Model m = new PrefListModel(prefL);
		Model m = new FileModel("u.data");//100k dataset
//		Model m = new FileModel("u1.base");//80k dataset
//		Model m = new FileModel("my.test");//15L
		
//		long endTime=System.nanoTime(); 
//		System.out.println("MODEL  : "+(endTime-startTime)+"ns"); 
//		
//		UserSimilarity us = new PearsonCorrelationSimilarity();//method class
//		SimilarityMatrix sm = new CalcuSimMatrix(m,us);
//		
//		endTime=System.nanoTime(); 
//		System.out.println("MATRIX : "+(endTime-startTime)+"ns"); 
//		
//		UserNeighborhood un = new NearestNUserNeighbor();//method class
//		UserBasedCFRecommend rc = new UserBasedCFRecommender();
//		
//		//getItemReco(uid,itemNum,neiNum, Model,SimilarityMatrix,UserNeighborhood)
//		System.out.println(rc.getItemReco(1, 10, 50, m, sm, un));
//		
//		endTime=System.nanoTime(); //recommend
//		System.out.println("RECOM  : "+(endTime-startTime)+"ns"); 
		
		//==============Tag Recommend==============================
		List<Preference> prefL = new ArrayList<Preference>();
		prefL.add(new Preference(1,1,1));prefL.add(new Preference(1,2,2));
		prefL.add(new Preference(1,3,3));prefL.add(new Preference(2,1,1));
		prefL.add(new Preference(2,2,2));prefL.add(new Preference(2,3,3));
		prefL.add(new Preference(2,4,1));prefL.add(new Preference(3,1,3));
		prefL.add(new Preference(3,2,2));prefL.add(new Preference(3,3,1));
		prefL.add(new Preference(3,5,5));prefL.add(new Preference(4,1,1));
		prefL.add(new Preference(4,2,2));prefL.add(new Preference(4,3,2));
		prefL.add(new Preference(4,7,3));
		//---------UserTag---------
		//user prefList ----UserTag
		List<Preference> userPrefList = new ArrayList<Preference>();
		userPrefList.add(new Preference(1,1,5));userPrefList.add(new Preference(1,5,0));
		//fullTagList
		HashMap<Integer,List<Integer>> fullTagList = new HashMap<Integer,List<Integer>>();
		List<Integer> li = new ArrayList<Integer>();li.add(1);li.add(2);li.add(3);
		fullTagList.put(1,li);fullTagList.put(2, li);
		List<Integer> l2 = new ArrayList<Integer>();l2.add(1);l2.add(3);l2.add(6);
		fullTagList.put(3, l2);fullTagList.put(4, l2);
		List<Integer> l3 = new ArrayList<Integer>();l3.add(2);l3.add(4);l3.add(5);
		fullTagList.put(5, l3);fullTagList.put(6, l3);
		//collection
		List<Integer> collection = new ArrayList<Integer>();
		collection.add(1);
		
//		//UserTagRecommend
//		TagVoteModel tvm = new TagListVoteModel(fullTagList, collection, userPrefList,1);
//		TagVote tv = new TagVoting(tvm, 10);
//		ItemPropertySimilarity ips = new TanimotoCoefficientSimilarity();
//		UserTagBasedRecommend utbr = new UserTagBasedRecommender(tvm, tv, ips, 10);
//		
//		System.out.println(utbr.getItemRecommend());
//		
		
		
		
		//------ItemTag-------
		List<Integer> currentItemTag = new ArrayList<Integer>();
		currentItemTag.add(1);currentItemTag.add(2);
		
		//-=-=-=-=-=-=-=OverAll Call Function=-=-=-=-=-=-=-=-=
		//ItemTagRecommend
		TagModel tm = new CurrentTagModel(fullTagList, currentItemTag, 100);
		ItemPropertySimilarity ips2 = new TanimotoCoefficientSimilarity();
		ItemTagBasedRecommend itbr = new ItemTagBasedRecommender(tm, ips2, 10);
		
		System.out.println("Item Reco : "+itbr.getRecomItem());
		
		//-------mixed User Recommend------
		MixedUserRecommender mur = new MixedUserRecommender(prefL, fullTagList, collection, 1);
		
		System.out.println("User Reco : "+mur.getUserRecommend());
		
		
		
		
		
		
		long endTime=System.nanoTime(); 
		System.out.println("TIME  : "+(endTime-startTime)+"ns"); 
	}

}
