package assignment2;



//feel free to add things to this file. Just don't remove anything

import java.util.*;
public class Node {
	
private int minDistance;
	private int nodeName;
	private ArrayList<Node> neighbors; 
	private ArrayList<Integer> weights;
	private ArrayList<Node> path;
	
public Node(int x) {
		nodeName = x;
		minDistance = Integer.MAX_VALUE;
		neighbors = new ArrayList<Node>();
		weights = new ArrayList<Integer>();
		path = new ArrayList<Node>();
		
	}
	
public void setNeighborAndWeight(Node n, Integer w) {
		neighbors.add(n);
		weights.add(w);
	}
	public void addToPath(ArrayList<Node> parentPath){
		path.addAll(0, parentPath);
	}
	public ArrayList<Node> getNeighbors(){
		return neighbors;
	}
	
public ArrayList<Integer> getWeights(){
		return weights;
	}
	
	public int getMinDistance() {
		return minDistance;
	}
	
	public void setMinDistance(int x) {
		minDistance = x;
	}
	
	public int getNodeName() {
		return nodeName;
	}
}

