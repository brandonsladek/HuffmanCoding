package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

import lab1.PriorityQueue.Node;

public class HuffmanCoding {
	
	static Scanner scanner = new Scanner(System.in);
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static char[] textString;
	static int[] frequencyTable = new int[28];
	// frequencyTable follows convention: a0, b1, c2, d3, e4, f5, g6, h7, i8, j9, k10, l11, m12, n13, o14, p15, q16, r17
	// s18, t19, u20, v21, w22, x23, y24, z25, space26, newline27
	static boolean done = false;
	static String text;
	static HashMap<Character, Integer> freqMap;
	static PriorityQueue pq = new PriorityQueue(28);
	static Node huffmanRoot;
	static HashMap<Character, String> encodingMap;
	static String encodedMessage;
	
	
	public static void main(String[] args) {
		
		// variable for scanner input, main five functions
		String choice;
		
		// while user doesn't input "quit"
		while(!done) {
			System.out.print("Enter word: enter, show, encode, decode, quit: ");
			// read in user input
			choice = scanner.next();
			switch(choice) {
			case "enter":
				try {
					enter();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break; 
				
			case "show":
				show();
				break;
				
			case "encode":
				encode();
				break;
				
			case "decode":
				decode();
				break;
				
			case "quit":
				done = true;
				break;
				
			} // end main switch
		} // end while
		scanner.close();
	} // end main
	
	private static void enter() throws IOException {
		
	System.out.print("Enter text lines, terminate with $ ");
	System.out.print(">>> ");
	
	// blank string for user input
	text = "";
	
	// clear frequency table to all zeros
	cleanFrequencyTable();
	boolean dollarSignStop = false;
	
	// while $ has not been parsed from text string
	while(!dollarSignStop) {
		// read from in buffer
		char c = (char) in.read();
		if((int) c == 36)
			// dollar sign parsed
			dollarSignStop = true;
		else {
		// append character to text string
		text += c;
		}
	}
	textString = text.toCharArray();
	
	for(int i = 0; i < textString.length; i++) {
		// add to frequency table
		switch(textString[i]) {
		case 'a':
			frequencyTable[0] = frequencyTable[0] + 1;
			break;
		case 'b':
			frequencyTable[1] = frequencyTable[1] + 1;
			break;
		case 'c':
			frequencyTable[2] = frequencyTable[2] + 1;
			break;
		case 'd':
			frequencyTable[3] = frequencyTable[3] + 1;
			break;
		case 'e':
			frequencyTable[4] = frequencyTable[4] + 1;
			break;
		case 'f':
			frequencyTable[5] = frequencyTable[5] + 1;
			break;
		case 'g':
			frequencyTable[6] = frequencyTable[6] + 1;
			break;
		case 'h':
			frequencyTable[7] = frequencyTable[7] + 1;
			break;
		case 'i':
			frequencyTable[8] = frequencyTable[8] + 1;
			break;
		case 'j':
			frequencyTable[9] = frequencyTable[9] + 1;
			break;
		case 'k':
			frequencyTable[10] = frequencyTable[10] + 1;
			break;
		case 'l':
			frequencyTable[11] = frequencyTable[11] + 1;
			break;
		case 'm':
			frequencyTable[12] = frequencyTable[12] + 1;
			break;
		case 'n':
			frequencyTable[13] = frequencyTable[13] + 1;
			break;
		case 'o':
			frequencyTable[14] = frequencyTable[14] + 1;
			break;
		case 'p':
			frequencyTable[15] = frequencyTable[15] + 1;
			break;
		case 'q':
			frequencyTable[16] = frequencyTable[16] + 1;
			break;
		case 'r':
			frequencyTable[17] = frequencyTable[17] + 1;
			break;
		case 's':
			frequencyTable[18] = frequencyTable[18] + 1;
			break;
		case 't':
			frequencyTable[19] = frequencyTable[19] + 1;
			break;
		case 'u':
			frequencyTable[20] = frequencyTable[20] + 1;
			break;
		case 'v':
			frequencyTable[21] = frequencyTable[21] + 1;
			break;
		case 'w':
			frequencyTable[22] = frequencyTable[22] + 1;
			break;
		case 'x':
			frequencyTable[23] = frequencyTable[23] + 1;
			break;
		case 'y':
			frequencyTable[24] = frequencyTable[24] + 1;
			break;
		case 'z':
			frequencyTable[25] = frequencyTable[25] + 1;
			break;
		case 'A':
			frequencyTable[0] = frequencyTable[0] + 1;
			break;
		case 'B':
			frequencyTable[1] = frequencyTable[1] + 1;
			break;
		case 'C':
			frequencyTable[2] = frequencyTable[2] + 1;
			break;
		case 'D':
			frequencyTable[3] = frequencyTable[3] + 1;
			break;
		case 'E':
			frequencyTable[4] = frequencyTable[4] + 1;
			break;
		case 'F':
			frequencyTable[5] = frequencyTable[5] + 1;
			break;
		case 'G':
			frequencyTable[6] = frequencyTable[6] + 1;
			break;
		case 'H':
			frequencyTable[7] = frequencyTable[7] + 1;
			break;
		case 'I':
			frequencyTable[8] = frequencyTable[8] + 1;
			break;
		case 'J':
			frequencyTable[9] = frequencyTable[9] + 1;
			break;
		case 'K':
			frequencyTable[10] = frequencyTable[10] + 1;
			break;
		case 'L':
			frequencyTable[11] = frequencyTable[11] + 1;
			break;
		case 'M':
			frequencyTable[12] = frequencyTable[12] + 1;
			break;
		case 'N':
			frequencyTable[13] = frequencyTable[13] + 1;
			break;
		case 'O':
			frequencyTable[14] = frequencyTable[14] + 1;
			break;
		case 'P':
			frequencyTable[15] = frequencyTable[15] + 1;
			break;
		case 'Q':
			frequencyTable[16] = frequencyTable[16] + 1;
			break;
		case 'R':
			frequencyTable[17] = frequencyTable[17] + 1;
			break;
		case 'S':
			frequencyTable[18] = frequencyTable[18] + 1;
			break;
		case 'T':
			frequencyTable[19] = frequencyTable[19] + 1;
			break;
		case 'U':
			frequencyTable[20] = frequencyTable[20] + 1;
			break;
		case 'V':
			frequencyTable[21] = frequencyTable[21] + 1;
			break;
		case 'W':
			frequencyTable[22] = frequencyTable[22] + 1;
			break;
		case 'X':
			frequencyTable[23] = frequencyTable[23] + 1;
			break;
		case 'Y':
			frequencyTable[24] = frequencyTable[24] + 1;
			break;
		case 'Z':
			frequencyTable[25] = frequencyTable[25] + 1;
			break;
		case (char) 32:
			frequencyTable[26] = frequencyTable[26] + 1;
			break;
		case (char) 10: 
			frequencyTable[27] = frequencyTable[27] + 1;
			break;
		} // end case e switch
	  } // end for
	
	// see the comments for these methods below
	createFreqMap(frequencyTable);
	buildHuffmanTree();
	buildEncodingMap();
	
	System.out.println("------------------------------------------------------------");
	System.out.println("FREQUENCY TABLE: ");
	System.out.println();
	for(int i = 0; i < frequencyTable.length-2; i++) {
		System.out.println((char) (i+65) + ": " + frequencyTable[i]);
	} 
	System.out.println("sp: " + frequencyTable[26]);
	System.out.println("nl: " + frequencyTable[27]);
	System.out.println("------------------------------------------------------------");
	System.out.println();
	} // end of enter method
	
	private static void show() {
		// display a graphic of the huffman tree
		displayTree();
		System.out.println("------------------------------------------------------------");
		System.out.println();
	} // end of show method
	
	private static void encode() {
		encodedMessage = "";
		// convert text input string to uppercase char array (uc because encodingMap hash keys are uc)
		String preMessageString = text.toUpperCase();
		char[] preMessageArray = preMessageString.toCharArray();
		
		// current character to be encoded
		char currentChar;
		
		// loop through char array
		for (int i = 0; i < preMessageArray.length; i++) {
			if ((int) preMessageArray[i] != 0) {
			currentChar = preMessageArray[i];
			// append code for character, retrieved from hashmap
			encodedMessage += encodingMap.get(currentChar);
			}
		} 
		System.out.println("------------------------------------------------------------");
		System.out.println();
		System.out.println("ENCODING TABLE: ");
		// see method description
		displayEncodingMap(encodingMap);
		System.out.println();
		System.out.println("NOTE: Any characters besides a-z, A-Z, space, ");
		System.out.println("and newline will be encoded as null values.");
		System.out.println("THE ENCODED MESSAGE IS: ");
		
		for (int i = 0; i < encodedMessage.length(); i++) {
			// keep the width of the console output at 60
			if (i%60 == 0) {
				System.out.println();
			}
            System.out.print(encodedMessage.charAt(i));
			
		} System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println();
	} // end of encode method
	
	private static void decode() {
		// convert binary string to char array
		char[] incomingMessage = encodedMessage.toCharArray();
		
		// string for decoded message
		String outgoingMessage = "";
		
		Node current = huffmanRoot;
		
		for (int i = 0; i < incomingMessage.length; i++) {
			// traverse the tree and print out value each time a leaf is reached
			char c = incomingMessage[i];
			switch(c) {
				case '0':
					current = current.left;
					break;
				case '1':
					current = current.right;
					break;
				default:
					break;
			} // end of switch statement
			
			// if node has no children, it is a leaf, thus a character node
			if (current.left == null & current.right == null) {
				// append character to decoded message string
				outgoingMessage += current.ch;
				
				// reset current at root of huffman tree
				current = huffmanRoot;
			}
			
		} // end of for loop
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("NOTE: Any characters besides a-z, A-Z, space, and newline ");
		System.out.println("will not be included in the decoded message.");
		System.out.println("THE DECODED MESSAGE IS: ");
		
		for (int i = 0; i < outgoingMessage.length(); i++) {
			// keep the width of the console output at 60
			if (i%60 == 0) {
				System.out.println();
				System.out.print(outgoingMessage.charAt(i));
			} else {
				System.out.print(outgoingMessage.charAt(i));
			}
		} System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println();
	} // end of decode method
	
	// refresh all frequencies to 0
	private static void cleanFrequencyTable() {
		for(int i = 0; i < frequencyTable.length; i++) {
			frequencyTable[i] = 0;
		}
	} // end of cleanFrequencyTable method
	
	// create a hash map that maps characters to their frequencies
	public static HashMap<Character, Integer> createFreqMap(int[] freqTable) {
		freqMap = new HashMap<Character, Integer>();
		
		// fill hash map
		for (int i = 0; i < freqTable.length-2; i++) {
			freqMap.put((char) (i+65), freqTable[i]);
		}
		freqMap.put((char) 32, freqTable[26]); // 32 is space
		freqMap.put((char) 10, freqTable[27]); // 10 is newline
		// freqMap should have 28 entries
		return freqMap;
	}  // end of createFreqMap method
	
	// create priority queue, build tree, determine root
	private static void buildHuffmanTree() {
		pq.createQueue();
		// remove two nodes with lowest frequency
		while(pq.getNumItems() > 1) {
			Node node1 = pq.remove();
			Node node2 = pq.remove();
			
			// combine node1 and node2 and insert the parent back into the priority queue
			Node node3 = pq.mergeNodes(node1, node2);
			pq.insert(node3);
		}
		// the last node left is the root of the huffman tree
		huffmanRoot = pq.remove();
	} // end of buildHuffmanTree method
	
	// traverse the huffman tree and build the encoding map
	private static HashMap<Character, String> buildEncodingMap() {
		encodingMap = new HashMap<Character, String>();
		traverseTree("", encodingMap, huffmanRoot);
		return encodingMap;
	} // end of buildEncodingMap method
	
	// recursively traverse the huffman tree, build codes, and store in hash map parameter
	private static void traverseTree(String code, HashMap<Character, String> hash, Node root) {
		// if the node has no children, it is a leaf, thus a character node
		if(root.left == null && root.right == null)
			hash.put(root.ch, code);
		if(root.left != null)
			traverseTree(code + "0", hash, root.left);
		if(root.right != null)
			traverseTree(code + "1", hash, root.right);
	} // end of traverseTree method
	
	// print out the character encoding map
	private static void displayEncodingMap(HashMap<Character, String> hash) {
		for (Entry<Character, String> e : hash.entrySet()) {
			// if character is not newline or space
			if ((int) e.getKey() != 10 && (int) e.getKey() != 32) {
			System.out.println(e.getKey() + " --> " + e.getValue());
			} // if character is newline, print nl
			else if ((int) e.getKey() == 10) {
				System.out.println("nl" + " -> " + e.getValue());
			} // if character is space, print sp
			else {
				System.out.println("sp" + " -> " + e.getValue());
			}
		}
	} // end of displayEncodingMap method
	
	/**
	 * From tree.java file
	 * Changes made:
	 * 	- changed node in globalStack.push to huffmanRoot
	 * 	- changed ch, left, and right fields for Nodes
	 */
	public static void displayTree() {
			Stack<Node> globalStack = new Stack<Node>();
			globalStack.push(huffmanRoot);
			int nBlanks = 32;
			boolean isRowEmpty = false;
			System.out.println(".............................................................");
			
			while(isRowEmpty==false) {
				Stack<Node> localStack = new Stack<Node>();
				isRowEmpty = true;
				for(int j=0; j<nBlanks; j++)
					System.out.print(' ');
				
				while(globalStack.isEmpty()==false) {
					Node temp = (Node)globalStack.pop();
					
					if(temp != null) {
						// if the character is not a newline or space, print character
						if((int)temp.ch != 10 && (int)temp.ch != 32) {
						System.out.print((char)temp.ch +""+ (int)temp.freq);
						} // if character is space, print sp
						else if((int)temp.ch == 32) {
							System.out.print("sp" + (int)temp.freq);
						} // if character is newline, print nl
						else {
							System.out.print("nl" + (int)temp.freq);
						}
						localStack.push(temp.left);
						localStack.push(temp.right);
						
						if(temp.left != null ||
								temp.right != null)
									isRowEmpty = false;
					}
					else {
						System.out.print("--");
						localStack.push(null);
						localStack.push(null);
					}
					
					for(int j=0; j<nBlanks*2-2; j++)
						System.out.print(' ');
				} // end while globalStack not empty
				System.out.println();
				nBlanks /= 2;
				
				while(localStack.isEmpty()==false)
					globalStack.push(localStack.pop());
			} // end while isRowEmpty is false
			System.out.println(".............................................................");
		} // end displayTree()
	
 } // end of HuffmanTree class