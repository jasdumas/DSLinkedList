package LinkedList;

public class List {
	
	private ListNode header;
	private ListNode first;
	private ListNode last;
	private int size;
	
	// constructor to create the list
	public List() {
		header = null;
		first = null;
		last = null;
		size = 0;
	}
	
	// checks if list is empty - returns true if empty
	public boolean isEmpty() {
		
		if (first == null) {
			return true;
		}
		else return false;
	}
	
	// insert node at end of list - increment the size of the list
	public void InsertNode(int data, Integer col) {
		
		ListNode node = new LinkedList.ListNode(data, col);
		
		//node.next = first;
		if (first == null) {
			first = node;
			first.next = last;
			first.previous = header;
		}
		else if (last == null) {
			last = node;
			last.previous = first;
			first.next = last;
		}
		else
			last.next = node;
			node.previous = last;
			last = node;
		
		size = size+1;
	}
	
	// set the header node as the passed-in value - this will be used as the row number
	public void setHeader(int data, Integer col) {
		
		ListNode headerNode = new LinkedList.ListNode(data, col);
		
		header = headerNode;
		header.next = first;
	}
	
	// get the row number of the node
	public ListNode getRow() {
		return header;
	}
	
	// get the column number of the node - NEEDS TO BE UPDATED!
	public ListNode getCol() {
		return header;
	}
	
	// return the size of the list
	public int matrixSize() {
		return size;
	}
		
	// print the list
	public void printList() {
		
		ListNode currentNode = first;
	
		while (currentNode != null) {
			
		currentNode.printNode();
		currentNode = currentNode.next;
		}
		
		System.out.println();
	}
	
	// clear the list
	public void clearList() {
		
		ListNode currentNode = first;
		ListNode nextNode = null;
		
		first = null;
		header = null;
		
		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = currentNode.previous = null;
			currentNode = nextNode;
		}
	}
	
	public int nodeValue(List list, int position){
		
		int size = list.matrixSize();
		ListNode currentNode = first;
		
		if (position == 0) {
			return currentNode.value();
		}
		else
			//for (int i = 0; i < size; i++) {
			//}
			return -1;
	}
}



