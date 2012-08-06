package LinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class LabThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedReader 	input;
		BufferedWriter 	output;
		ListNode 		node;
		ListNode		row;
		ListNode		col;
		List			list;
		List[]			listArray;
		LabThree		lab;
		String []		stringSplit;
		int				data;
		int				listSize;
		int				dimension;
		int 			size;
		int				index;
		int				det;
		String			z;
		
		lab = new LabThree();
		
		//  Check for two command line arguments.
        if (args.length != 2) {
            System.out.println("Usage:  java LinkedList.LabThree [input file]" +
                " [output file]");
            System.exit(1);
        }
        
        //  Open the input and output files.
        try {
            input = new BufferedReader(new FileReader(args[0]));
            output = new BufferedWriter(new FileWriter(args[1]));
        } catch (IOException exception) {
            System.err.println(exception.toString());
            return;
        }
		
		// pass in values from input to build the lists
		z = lab.readMatrix(input);
		dimension = 0;
		while (z != null) {
			
			try {
				dimension = Integer.parseInt(z);
			}catch (Exception e) {
				System.err.println(e);
			}
			
			z = lab.readMatrix(input);
			
			// check for empty strings before parsing
        	if (z.length() == 0) {
        		continue;
        	}
        	
        	// build the lists
        	stringSplit = null;
        	listArray = new List[dimension];
        	for (int i = 0; i < dimension; i++) {
        		
        		list = new List();
        		
        		try{
        			list.setHeader(i, null);
        			stringSplit = z.split(" ");
        		} catch (Exception exception) {
        			System.err.println(exception);
        		}
        		
        		//System.out.println(stringSplit[index]);
        		index = 0;
        		
        		for (int j = 0; j < dimension; j++) {
        		
        			try {
        				data = Integer.parseInt(stringSplit[index]);	//set the data variable as the integer parsed from the string
                		list.InsertNode(data, j); 						//insert each integer from the string as a new node in the list
        			} catch (Exception e) {
        				System.err.println(e);
        			}
        			
            		index++;
        		}
        		
        		//using getRow() method to determine the row the list is representing
        		//row = list.getRow();
        		//row.printNode();
        		
        		listArray[i] = list;
        	        		
        		//list.clearList();
        		z = lab.readMatrix(input);
        		
        		//lab.writeOutput(list, output);
        	}
        	       	
        	//List testList = listArray[0];
        	//testList.deleteNode(testList, 2);
        	//System.out.println("The list after deletion is: ");
        	//testList.printList();
        	
        	//compute the minor/determinant of the matrix
        	//lab.Minor(listArray, 1);
        	det = lab.Determinant(listArray);
        	System.out.println("The determinant is " + det);
        	
        	// send data to output
        	//System.out.println(Arrays.deepToString(listArray));
        	lab.writeOutput(listArray, output);
		}
		
		// Close the input and output files and return to OS.
        try {
            input.close();
            output.close();
        } catch (Exception exception) {
            System.err.println(exception.toString());
        }
        return;
	}
	
	/**
	 * Read in the strings of integers from the input file.
	 * @param input		the string in the input file.
	 * @return The string of integers.
	 */
	private String readMatrix(BufferedReader input) {
		
		String z = "";
		
        try {
             z = input.readLine();
        } catch (IOException ioException) {
            System.err.println(ioException.toString());
            System.exit(2);
        }
        
        return z;
	}
	
	/**
	 * Write the results to the output file in an easy-to-read format.
	 * @param intArray	the original matrix passed into the program
	 * @param det		the value of the determinant for the matrix.
	 * @param output	the output file.
	 */
	private void writeOutput(List[] listArray, BufferedWriter output) {
		 
		int size;
		int listSize;
		int nodeValue;
		List list;
		
		size = listArray.length;
		//System.out.println(Arrays.deepToString(listArray));
		//System.out.println(size);
		
		//List testList = listArray[0];
		//System.out.print(testList.isEmpty());
		//testList.printList();
		
		 try {
			 	output.write("The following matrix:");
			 	output.newLine();
			 	output.newLine();
			 	
			 	for (int i = 0; i < size; i++) {
			
			 		list = listArray[i];
			 		
			 		listSize = list.listSize();
			 		//System.out.println(listSize);
			 		//System.out.print(list.isEmpty());
			 		//list.printList();
			 		
			 		for (int j = 0; j < listSize; j++) {
			 		
				 		nodeValue = list.nodeValue(j);
				 		output.write(nodeValue + " ");
			 		}
			 		
			 		output.newLine();
			 	}
			 	
			 	output.newLine();
			 	output.write("Has a determinant value of " + " " + ".");
			 	output.newLine();
			 	output.newLine();
			 	output.write("---------------------------------------");
			 	output.newLine();
			 	output.newLine();
	        	
	        } catch (IOException ioException) {
	            System.err.println(ioException.toString());
	            System.exit(3);
	        }
	        
	        return;
	}
	
	/**
	 * Compute the minor of the matrix passed into the application.
	 * @param listArray	The matrix passed into the method.
	 * @param j			The column value to be removed to compute the minor.
	 * @return The minor of the passed-in matrix.
	 */
	public List[] Minor (List[] listArray, int j) {
		
		int		p;
		int		matrixDimension;
		List	list;
		List	minorList;
		List	tempList;
		List[]	minor;
		
		matrixDimension = listArray[0].listSize();
		System.out.println("the array length is " + matrixDimension);
		minorList = listArray[0];
		System.out.println("the minor list is:");
		minorList.printList();
		//minor = new List[matrixDimension];
		
		// if the matrix is 1x1 - return the value in the matrix as the minor.
		// else calculate the minor of the matrix by creating a new array of lists (the minor) which excludes
		// the first row and jth column from the original matrix.
		if (matrixDimension == 1) {
			minor = listArray;
			System.out.println(Arrays.deepToString(minor));
			System.out.println("test");
			return minor;
		}
		else
			minor = new List[matrixDimension-1];
			System.out.println("the length of the minor is " + minor.length);
			
			p = 0;
			for (int i = 0; i < matrixDimension; i++) {
				
				list = listArray[i];
				
				if (i == 0)
					continue;
				
				for (int z = 0; z < list.listSize(); z++) {
					
					System.out.println("j is " + j);
					list.deleteNode(list, j);
					list.printList();
					minor[p] = list;
				}
					
				p++;
			}
			
			//tempList = minor[0];
			//tempList.printList();
			//System.out.println(Arrays.deepToString(minor));
			
			return minor;
	}
	
	/**
	 * Compute the determinant of the matrix passed into the application
	 * @param intArray	The original matrix passed into the program and each subsequent matrix created by the method 'minor'.
	 * @return The value of the determinant of the matrix.
	 */
	public int Determinant (List[] listArray) {
				
		List[]		minor;
		List		list;
		int			det;
		int			i;
		int			element;
		
		det = 0;
		i = 0;
		list = listArray[0];
		
		System.out.println("the list is:");
		list.printList();
		
		// if the matrix is 1x1 - return that value as the determinant.
		// else compute the sum of the products and return the determinant.
		for (int j = 0; j < listArray[0].listSize(); j++) {
			
			if (list.listSize() == 1) {
				return list.nodeValue(0);
			}
			else
				element = list.nodeValue(j);
				minor = this.Minor(listArray, j);
				det += (int) Math.pow(-1, (i + j))*element*Determinant(minor);
			}

		return det;
	}

}
