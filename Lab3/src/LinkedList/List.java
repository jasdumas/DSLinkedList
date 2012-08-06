package LinkedList;

public class List {
	
	private ListNode header;
	private ListNode first;
	private ListNode last;
	private int matrixSize;
	private int listSize;
	
	// constructor to create the list
	public List() {
		header = null;
		first = null;
		last = null;
		matrixSize = 0;
		listSize = 0;
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
		
		matrixSize = matrixSize+1;
	}
	
	// delete node in specified column
	public ListNode deleteNode(List list, int col) {
		
		//System.out.println("the column is " + col);
		//System.out.println("the list is:");
		//list.printList();
		
		ListNode currentNode = first;
		ListNode temp = null;
		int size = list.listSize();
		int lastItem = size-1;
		
		if (list.isEmpty()) {
			System.err.println("ERROR: Cannot delete from an empty list.");
			return null;
		}
		
		// if there is only one node - clear the list and return that node
		if (size == 1) {
			list.clearList();
			return currentNode;
		}
		
		if (col == 0) {
				
			temp = currentNode;
			
			first = currentNode.next;
			currentNode.next.previous = header;
			currentNode = null;
				
			return temp;
		}
		else if (col == lastItem) {
			
			temp = last;
			
			last = temp.previous;
			last.next = null;
			
			return temp;
		}
		else
			for (int i = 1; i < size; i++) {
				
				currentNode = currentNode.next;
				//currentNode.printNode();
				
				if (col == i) {
						
					temp = currentNode;
						
					currentNode.previous.next = currentNode.next;
					currentNode.next.previous = currentNode.previous;
					currentNode = null;
						
					return temp;
						
				}
			}
		
		// if this point is reached then we have asked to delete a node that is not in the scope of the list
		return null;
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
	
	// get the column number of the node - NEEDS TO BE UPDATED! - may not be needed
	//public ListNode getCol() {
	//	return header;
	//}
	
	// return the size of the matrix
	public int matrixSize() {
		return matrixSize;
	}
	
	// return the size of the individual list
	public int listSize() {
		
		ListNode currentNode = first;
		listSize = 0;
		while (currentNode != null) {
			
			currentNode = currentNode.next;
			listSize++;
		}
		
		return listSize;
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
	
	// return the value of the node in the specified position of the list
	public int nodeValue(int col){
		
		ListNode currentNode = first;
		int index = 0;
		
		while (currentNode != null) {
			
			if (col == index) {
				return currentNode.value();
			}
			else
				currentNode = currentNode.next;
				index++;
		}
		
		// if this point is reached then we have asked for a node that is not in the scope of the list
		return -1;
	}
}



