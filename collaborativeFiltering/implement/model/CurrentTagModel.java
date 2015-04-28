package collaborativeFiltering.implement.model;

import java.util.HashMap;
import java.util.List;

import collaborativeFiltering.model.TagModel;

public class CurrentTagModel implements TagModel {

	private HashMap<Integer,List<Integer>> fullTagList;
	private List<Integer> currentItemTag;
	private int itemId;
	
	
	public CurrentTagModel(HashMap<Integer,List<Integer>> fullTagList
							,List<Integer> currentItemTag, int currentItemId) {
		super();
		// TODO Auto-generated constructor stub
		this.fullTagList = fullTagList;
		this.currentItemTag = currentItemTag;
		this.itemId = currentItemId;
		
	}

	@Override
	public int getCurrentItemId() {
		// TODO Auto-generated method stub
		return this.itemId;
	}

	@Override
	public List<Integer> getCurrentItemTag() {
		// TODO Auto-generated method stub
		return this.currentItemTag;
	}

	@Override
	public HashMap<Integer, List<Integer>> getFullTagList() {
		// TODO Auto-generated method stub
		return this.fullTagList;
	}

}
