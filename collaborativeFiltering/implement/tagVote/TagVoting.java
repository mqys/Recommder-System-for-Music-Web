package collaborativeFiltering.implement.tagVote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import collaborativeFiltering.model.TagVoteModel;
import collaborativeFiltering.tagVote.TagVote;

public class TagVoting implements TagVote {

	private List<Integer> topNTag;
	
	public TagVoting(TagVoteModel tvm,int topN) {
		super();
		// TODO Auto-generated constructor stub
		HashMap<Integer, List<Integer>> likeList = tvm.getLikeList();
		HashMap<Integer, List<Integer>> dislikeList = tvm.getDislikeList();
		HashMap<Integer,Integer> voteList = new HashMap<Integer,Integer>();
		
		//like list
		for(Entry<Integer, List<Integer>> en : likeList.entrySet()){
			List<Integer> tagList = en.getValue();
			for(Integer tagId: tagList){
				if(voteList.containsKey(tagId))
					voteList.put(tagId, voteList.get(tagId)+1);
				else
					voteList.put(tagId,1);
			}
		}
		//dislike list
		for(Entry<Integer,List<Integer>> en : dislikeList.entrySet()){
			List<Integer> disLikeTagList = en.getValue();
			for(Integer dislikeTagId: disLikeTagList){
				if(voteList.containsKey(dislikeTagId))
					voteList.put(dislikeTagId, voteList.get(dislikeTagId)-1);
			}
		}
		//sort
		List<Map.Entry<Integer, Integer>> votedlist =
		    new ArrayList<Map.Entry<Integer, Integer>>(voteList.entrySet());
		Collections.sort(votedlist,new Comparator<Map.Entry<Integer,Integer>>(){
			@Override
			public int compare(Entry<Integer, Integer> o1,
					Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				if(o1.getValue() > o2.getValue())
					return -1;
				return 1;
			}
		});
		//get TopN
		this.topNTag = new ArrayList<Integer>();
		for(int i=0;i<votedlist.size()&&i<topN;i++){
			this.topNTag.add(votedlist.get(i).getKey());
		}
	}


	@Override
	public List<Integer> getTopNTag() {
		// TODO Auto-generated method stub
		return this.topNTag;
	}
	
}
