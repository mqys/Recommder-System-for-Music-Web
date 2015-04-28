package collaborativeFiltering.implement.model;

import java.util.HashMap;
import java.util.List;

import collaborativeFiltering.model.Preference;
import collaborativeFiltering.model.TagVoteModel;

public class TagListVoteModel implements TagVoteModel {
	
	private HashMap<Integer, List<Integer>> fullTagList;
	private HashMap<Integer, List<Integer>> likeList;
	private HashMap<Integer, List<Integer>> dislikeList;

	
	public TagListVoteModel(HashMap<Integer,List<Integer>> fullTagList
							,List<Integer> collectionList
							,List<Preference> prefLIst) {
		super();
		// TODO Auto-generated constructor stub
		this.fullTagList = fullTagList;
		this.likeList = new HashMap<Integer,List<Integer>>();
		this.dislikeList = new HashMap<Integer,List<Integer>>();
		
		//collection-like
		for(Integer i : collectionList){
			this.likeList.put(i, this.fullTagList.get(i));
		}
		//preference
		for(Preference p : prefLIst){
			if(p.getScore()>0)//like
				this.likeList.put(p.getOid(), this.fullTagList.get(p.getOid()));
			else//dislike
				this.dislikeList.put(p.getOid(), this.fullTagList.get(p.getOid()));
		}
		
	}

	
	
	@Override
	public HashMap<Integer, List<Integer>> getDislikeList() {
		// TODO Auto-generated method stub
		return this.dislikeList;
	}

	@Override
	public HashMap<Integer, List<Integer>> getFullTagList() {
		// TODO Auto-generated method stub
		return this.fullTagList;
	}

	@Override
	public HashMap<Integer, List<Integer>> getLikeList() {
		// TODO Auto-generated method stub
		return this.likeList;
	}

}
