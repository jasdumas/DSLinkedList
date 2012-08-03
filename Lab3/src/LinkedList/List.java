package LinkedList;

public class List {
	
	private ListNode first;
	private ListNode last;
	private int size;
	
	// constructor to create the list
	public List() {
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
	public void InsertNode(int data) {
		
		ListNode node = new LinkedList.ListNode(data);
		
		//node.next = first;
		if (first == null) {
			first = node;
			first.next = last;
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
	
	// return the size of the list
	public int ListSize() {
		return size;
	}
	
	// print the list
	public void printList() {
		
		ListNode currentNode = first;
		while (currentNode != null) {
			currentNode.printNode();
			currentNode = currentNode.next;
		}
	}
}



