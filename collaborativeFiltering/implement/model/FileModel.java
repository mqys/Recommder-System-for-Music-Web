package collaborativeFiltering.implement.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import collaborativeFiltering.model.Model;



public class FileModel implements Model {

	private Map<Integer, HashMap<Integer, Double>> preMap;
	private Set<Integer> itemSet;
	
	//create model 
	public FileModel(String filePath)throws IOException{
		this(new File(filePath));
	}
	
	public FileModel(File file) throws IOException{
		if(file.exists() == false)
			throw new IOException("file error");
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		this.preMap = new HashMap<Integer, HashMap<Integer, Double>>();
		this.itemSet = new HashSet<Integer>();
		
		int uid;
		int oid;
		double score;
		HashMap<Integer,Double> score_map;
		
		while(br.ready()){
			String line = br.readLine();
			//System.out.println(line);
			String[] data = line.split("\t");
			
			uid = Integer.parseInt(data[0]);
			oid = Integer.parseInt(data[1]);
			score = Double.parseDouble(data[2]);
			
			this.itemSet.add(oid);
			
			if(preMap.containsKey(uid))
				score_map = preMap.get(uid);
			else
				score_map = new HashMap<Integer,Double>();
			
			score_map.put(oid, score);
			preMap.put(uid, score_map);
		
		}
	}

	
	@Override
	public Map<Integer, HashMap<Integer, Double>> getPrefMap() {
		// TODO Auto-generated method stub
		return this.preMap;
	}

	@Override
	public Set<Integer> getItemSet() {
		// TODO Auto-generated method stub
		return this.itemSet;
	}

}
