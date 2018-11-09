package assignment2;


import java.util.ArrayList;
import java.util.*;

public class Graph {
	private ArrayList<Node> vertices; //this is a list of all vertices, populated by Driver class.
	private Heap minHeap; 	//this is the heap to use for Dijkstra
	public Graph(int numVertices) {
		minHeap = new Heap();
		vertices = new ArrayList<Node>();
    // feel free to add anything else you may want	
	}



  // findShortestPathLength
  //
  // Returns the distance of the shortest path from root to x
  public int findShortestPathLength(Node root, Node x) {
	  ArrayList<Node> path = findAShortestPath(root,x);
	  if (path == null)
		  return -1;
	  int distance = 0;
	  for (int i = 0; i < path.size()-1; i++) {
		  int neighborIndex = path.get(i).getNeighbors().indexOf(path.get(i+1));
		  distance += path.get(i).getWeights().get(neighborIndex);
	  }
	  return distance;
  }

  // findAShortestPath
  //
  // Returns a list of nodes represent one of the shortest paths
  // from root to x
  public ArrayList<Node> findAShortestPath(Node root, Node x){
	  
	  
	  return null;
  }

  // eachShortestPathLength
  //
  // Returns an ArrayList of Nodes, where minDistance of each node is the
  // length of the shortest path from it to the root. This ArrayList
  // should contain every Node in the graph. Note that 
  // root.getMinDistance() = 0
  public ArrayList<Node> findEveryShortestPathLength(Node root) {
	  int rootName = root.getNodeName();
	  for (int i = 0; i < vertices.size(); i++) {
		  if (vertices.get(i).getNodeName() == rootName) {
			  vertices.get(i).setMinDistance(0);
		  }
		  else {
			  vertices.get(i).setMinDistance(Integer.MAX_VALUE);
		  }
	  }
	 
	  minHeap.buildHeap(vertices); //heap of uninitialized distances and root at root
	  while (!minHeap.isEmpty()) {
		  Node thisRoot = minHeap.extractMin();
		  int thisDist = thisRoot.getMinDistance();
		  ArrayList<Node> neigh = thisRoot.getNeighbors();
		  ArrayList<Integer> weights = thisRoot.getWeights();
		  for(int i = 0; i < neigh.size(); i++){
		  	if (thisDist != Integer.MAX_VALUE && neigh.get(i).getMinDistance() > (weights.get(i) + thisDist)){
				neigh.get(i).setMinDistance(weights.get(i) + thisDist);
				int neighName = neigh.get(i).getNodeName();
				int neighIndex = findNodeIndex(neighName);
				if(neighIndex != 0)
					reHeapify(neighIndex);
			}
		  }
		  
		  
		  
		  
		  
		  
		  
	  }
	  
	  
	  
	  
	  
	  
	  return null;
  }
  
  //returns edges and weights in a string.
  public String toString() {
    String o = "";
    for(Node v: vertices) {
      boolean first = true;
      o += "Node ";
      o += v.getNodeName();
      o += " has neighbors: ";
      ArrayList<Node> ngbr = v.getNeighbors();
      for(Node n : ngbr) {
        o += first ? n.getNodeName() : ", " + n.getNodeName();
        first = false;
      }
      first = true;
      o += " with weights ";
      ArrayList<Integer> wght= v.getWeights();
      for (Integer i : wght) {
        o += first ? i : ", " + i;
        first = false;
      }		
      o += System.getProperty("line.separator");
    
    }

    return o;
  }
  
///////////////////////////////////////////////////////////////////////////////
//                           DANGER ZONE                                     //
//                everything below is used for grading                       //
//                      please do not change :)                              //
///////////////////////////////////////////////////////////////////////////////

  public Heap getHeap() {
    return minHeap;
  }
    
  public ArrayList<Node> getAllNodes(){
    return vertices;
  }
     
	//used by Driver class to populate each Node with correct neighbors and corresponding weights
	public void setEdge(Node curr, Node neighbor, Integer weight) {
		curr.setNeighborAndWeight(neighbor, weight);
	}
    //This is used by Driver.java and sets vertices to reference an ArrayList of all nodes.
  public void setAllNodesArray(ArrayList<Node> x) {
    vertices = x;	
  }    
}

