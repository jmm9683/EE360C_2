package assignment2;

import java.util.ArrayList;


public class Heap {

	private ArrayList<Node> minHeap; // do not remove

	public Heap() {
		minHeap = new ArrayList<Node>(); // do not remove
	}
	private int parent(int i) {return (i-1)/2;};
	private int left(int i) { return (2*i + 1); };
	private int right(int i) { return (2*i + 2); };
	
	// buildHeap
  //
  // Given an ArrayList of Nodes, build a minimum heap keyed on each
  // Node's minDistance
  //
  // Time Complexity Requirement: theta(n)
	public void buildHeap(ArrayList<Node> nodes) {
		ArrayList<Node> copy = nodes;
		for (int i = copy.size()/2-1; i>=0; i--) {
			minHeapify(copy, i);
		}
		minHeap = copy;

  }
	private void minHeapify(ArrayList<Node> copy, int i) {
		int smallest = i; // Initialize smallest as root 
        int l = left(i); // left = 2*i + 1 
        int r = right(i); // right = 2*i + 2 
  
        // If left child is smaller than root 
        if (l < copy.size() && copy.get(l).getMinDistance() < copy.get(smallest).getMinDistance()) 
            smallest = l; 
        else if (l < copy.size() && copy.get(l).getMinDistance() == copy.get(smallest).getMinDistance()) {
        	if (copy.get(l).getNodeName() < copy.get(smallest).getNodeName()) {
        		smallest = l;
        	}
        }
        // If right child is smaller than smallest so far 
        if (r < copy.size() && copy.get(r).getMinDistance() < copy.get(smallest).getMinDistance())
            smallest = r; 
  
        else if (r < copy.size() && copy.get(r).getMinDistance() == copy.get(smallest).getMinDistance()) {
        	if (copy.get(r).getNodeName() < copy.get(smallest).getNodeName()) {
        		smallest = r;
        	}
        }
        // If smallest is not root 
        if (smallest != i) 
        { 
            Node swap = copy.get(i); 
            copy.set(i, copy.get(smallest)); 
            copy.set(smallest, swap);
  
            // Recursively heapify the affected sub-tree 
           minHeapify(copy, smallest); 
        } 
	}

  // insertNode
  //
  // Insert a Node into the heap
  //
  // Time Complexity Requirement: theta(log(n))
	public void insertNode(Node in) {
		minHeap.add(in);
		int index = minHeap.size()-1;
		while (index != 0 && minHeap.get(parent(index)).getMinDistance() > minHeap.get(index).getMinDistance()) {
			Node swap = minHeap.get(index); 
            minHeap.set(index, minHeap.get(parent(index))); 
            minHeap.set(parent(index), swap);
			index = parent(index);
		}
	
	}
	
  // findMin
  //
  // Returns the minimum element of the heap
  //
  // Time Complexity Requirement: theta(1)
	public Node findMin() {
		return minHeap.get(0);
	}

  // extractMin
  //
  // Removes and returns the minimum element of the heap
  //
  // Time Complexity Requirement: theta(log(n))
	public Node extractMin() {
		if (minHeap.size() == 1) {
			Node min = minHeap.remove(0);
			return min;
		}
		Node min = minHeap.remove(0);
		minHeap.add(0, minHeap.get(minHeap.size()-1));
		minHeap.remove(minHeap.size()-1);
		minHeapify(minHeap, 0);
		return min;
	}
	public boolean isEmpty() {
		return minHeap.size() <= 0;
	}
	
  public String toString() {
		String output = "";
		for(int i = 0; i < minHeap.size(); i++) {
			output+= minHeap.get(i).getNodeName() + " ";
		}
		return output;
	}
	
///////////////////////////////////////////////////////////////////////////////
//                           DANGER ZONE                                     //
//                everything below is used for grading                       //
//                      please do not change :)                              //
///////////////////////////////////////////////////////////////////////////////

	public ArrayList<Node> toArrayList() {
		return minHeap;
	}
}

