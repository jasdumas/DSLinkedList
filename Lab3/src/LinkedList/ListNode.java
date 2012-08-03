package LinkedList;

public class ListNode {
	
	int dataItem;
	ListNode next;
	ListNode previous;
	
	// constructor
	public ListNode(int data) {
		dataItem = data;
	}
	
	// print the current node
	public void printNode() {
		System.out.print("| " + dataItem + " |");
	}
} 