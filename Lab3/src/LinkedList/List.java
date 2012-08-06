package LinkedList;

public class List {
	
	private ListNode header;
	private ListNode first;
	private ListNode last;
	private int matrixSize;
	private int listSize;
	
	/**
	 * Constructor to create the list object
	 */
	public List() {
		header = null;
		first = null;
		last = null;
		matrixSize = 0;
		listSize = 0;
	}
	
	/**
	 * Checks if list is empty
	 * @return True if empty
	 */
	public boolean isEmpty() {
		
		if (first == null) {
			return true;
		}
		else return false;
	}
	
	/**
	 * Insert a node at the end of the list containing the specified data
	 * Increment the size of the list each time
	 * @param data	The data value of the new node
	 */
	public void InsertNode(int data) {
		
		ListNode node = new LinkedList.ListNode(data);
		
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
	
	/**
	 * Delete the node in the specified column position
	 * @param list	The list to delete the node from
	 * @param col	The column position of the node to be deleted
	 * @return	The node deleted from the list
	 */
	public ListNode deleteNode(List list, Integer col) {
		
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
	
	/**
	 * Sets the header node as the passed-in value
	 * The header node contains the row number
	 * @param data	The row number of the list
	 */
	public void setHeader(int data) {
		
		ListNode headerNode = new LinkedList.ListNode(data);
		
		header = headerNode;
		header.next = first;
	}
	
	/**
	 * Gets the row number of the node
	 * @return The row number
	 */
	public ListNode getRow() {
		return header;
	}
	
	/**
	 * Returns the full size of the matrix (number of nodes in matrix)
	 * @return The number of nodes in the matrix
	 */
	public int matrixSize() {
		return matrixSize;
	}
	
	/**
	 * Returns the size of the individual list
	 * @return The size of the list
	 */
	public int listSize() {
		
		ListNode currentNode = first;
		listSize = 0;
		while (currentNode != null) {
			
			currentNode = currentNode.next;
			listSize++;
		}
		
		return listSize;
	}
		
	/**
	 * Prints the list to the screen
	 */
	public void printList() {
		
		ListNode currentNode = first;
	
		while (currentNode != null) {
			
			currentNode.printNode();
			currentNode = currentNode.next;
		}
		
		System.out.println();
	}
	
	/**
	 * Sets all of the values of the list to null -- clearing the list
	 */
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
	
	/**
	 * Returns the value of the node in the specified column (position) of the list
	 * @param col The column of the node whose value is being returned
	 * @return The value of the node
	 */
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



