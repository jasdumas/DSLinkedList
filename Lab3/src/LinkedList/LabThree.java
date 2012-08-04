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
		List[]		listArray;
		LabThree		lab;
		String []		stringSplit;
		int				data;
		int				listSize;
		int				dimension;
		int 			size;
		int				index;
		String			z;
		
		lab = new LabThree();
		
		//  Check for two command line arguments.
        if (args.length != 2) {
            System.out.println("Usage:  java Recursion.LabThree [input file]" +
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
		
		List list = new List();
		
		//listSize = list.ListSize();
		//System.out.print("list size = " + listSize);
		
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
        		//List testList = listArray[i];
        		//testList.printList();
        		
        		
        		//list.printList();
        		list.clearList();
        		z = lab.readMatrix(input);
        	}
        	       	
        	//System.out.println("The list is as follows:");
        	//list.printList();
        	
        	// send data to output
        	lab.writeOutput(listArray, output);
		}
	}
	
	/**
	 * Read in the strings of integers from the input file.
	 * @param input		the first string in the input file.
	 * @return The first string of integers.
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
		List list;
		
		size = listArray.length;
		System.out.println(size);
		
		List testList = listArray[0];
		System.out.println(testList.matrixSize());
		testList.printList();
		
		 try {
			 	output.write("The following matrix:");
			 	output.newLine();
			 	output.newLine();
			 	
			 	for (int i = 0; i < size; i++) {
			
			 		list = listArray[i];
			 		
			 		list.printList();
			 		
			 		output.write(list.nodeValue(list, i));
			
			 	}
	        	
	        } catch (IOException ioException) {
	            System.err.println(ioException.toString());
	            System.exit(3);
	        }
	        
	        return;
	}

}
