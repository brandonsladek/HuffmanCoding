package lab1;

import java.util.HashMap;
import java.util.Map.Entry;

public class PriorityQueue {
	
	public class Node {
		char ch;
		int freq;
		Node left, right;
		
		//constructor
		public Node(char c, int f, Node l, Node r) {
			ch = c;
			freq = f;
			left = l;
			right = r;
		}
		// for non-character nodes
		public Node(int f, Node l, Node r) {
			freq = f;
			left = l;
			right = r;
		}
	} // end of nested Node class
	
	// array in sorted order, from max at 0 to min at size-1
	private int maxSize;
	private Node[] queArray;
	private int numItems;
	//-------------------------------------------------------------
	public PriorityQueue(int s) // constructor
	{
		maxSize = s;
		queArray = new Node[maxSize];
		numItems = 0;
	}
	//-------------------------------------------------------------
	public void insert(Node item) // insert item
	{
		int j;
		if(numItems==0) // if no items,
			queArray[numItems++] = item; // insert at 0
		else // if items,
		{
			for(j=numItems-1; j>=0; j--) // start at end,
			{
				if( item.freq > queArray[j].freq ) // if new item larger,
					queArray[j+1] = queArray[j]; // shift upward
				else // if smaller,
					break; // done shifting
			} // end for
			queArray[j+1] = item; // insert it
			numItems++;
		} // end else (nItems > 0)
	} // end insert()
	//-------------------------------------------------------------
	public Node remove() // remove minimum item
	{ return queArray[--numItems]; }
	//-------------------------------------------------------------
	public Node peekMin() // peek at minimum item
	{ return queArray[numItems-1]; }
	//-------------------------------------------------------------
	public boolean isEmpty() // true if queue is empty
	{ return (numItems==0); }
	//-------------------------------------------------------------
	public boolean isFull() // true if queue is full
	{ return (numItems == maxSize); }
	//-------------------------------------------------------------
	public int getNumItems() {
		return numItems;
	}
	
	public void createQueue() {
		HashMap<Character, Integer> hash = HuffmanCoding.createFreqMap(HuffmanCoding.frequencyTable);
		for (Entry<Character, Integer> e : hash.entrySet()) {
			Node node = new Node(e.getKey(), e.getValue(), null, null);
			this.insert(node);
		}
	}
	
	public Node mergeNodes(Node first, Node second) {
		int newFreq = first.freq + second.freq;
		Node newNode;
		if (first.freq < second.freq) {
			newNode = new Node(newFreq, first, second);
		} else {
			newNode = new Node(newFreq, second, first);
		}
		return newNode;
	}
	
} // end class PriorityQueue
