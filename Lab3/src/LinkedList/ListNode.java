package LinkedList;

public class ListNode {
	
	int 		dataItem;
	Integer 	col;
	ListNode 	next;
	ListNode 	previous;
	
	/**
	 * Constructor - created a node object with the specified data item
	 * @param data The data value of the new node
	 */
	public ListNode(int data) {
		dataItem = data;
	}
	
	/**
	 * Prints the current node to the screen
	 */
	public void printNode() {
		System.out.print(dataItem + " ");
	}
	
	/**
	 * Returns the value of the node
	 * @return The value of the node
	 */
	public int value(){
		return dataItem;
	}
} 