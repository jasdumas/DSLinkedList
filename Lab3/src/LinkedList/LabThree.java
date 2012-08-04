package LinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LabThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedReader 	input;
		BufferedWriter 	output;
		ListNode 		node;
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
        } catch (Exception exception) {
            System.err.println(exception.toString());
            return;
        }
		
        //data = 2;
		//node = new LinkedList.ListNode(data);
		List list = new List();
		
		//node.printNode();
		
		//list.InsertNode(2);
		//list.InsertNode(3);
		//list.InsertNode(4);
		//list.InsertNode(5);
		//list.InsertNode(6);
		//list.InsertNode(7);
		
		//list.printList();
		//System.out.println();
		
		//listSize = list.ListSize();
		//System.out.print("list size = " + listSize);
		
		// pass in values from input to build the lists
		z = lab.readMatrix(input);
		dimension = 0;
		while (z != null) {
			
			try {
				dimension = Integer.parseInt(z);
			}catch (Exception e) {
				System.err.println(e.toString());
			}
			
			z = lab.readMatrix(input);
			
			// check for empty strings before parsing
        	if (z.length() == 0) {
        		continue;
        	}
        	
        	// build the lists
        	index = 0;
        	for (int i = 0; i < dimension; i++) {
        		
        		stringSplit = z.split(" ");	//split the string with a space delimiter
        		//System.out.println(stringSplit[index]);
        		data = Integer.parseInt(stringSplit[index]);	//set the data variable as the integer parsed from the string
        		
        		list.InsertNode(data); //insert each integer from the string as a new node in the list
        		
        		index++;
        	}
        	
        	System.out.println("The list is as follows:");
        	list.printList();
        	
        	// send data to output
        	//lab.writeOutput(list, output);
        	
        	z = lab.readMatrix(input);
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
	private void writeOutput(List list, BufferedWriter output) {
		 
		//String listString;
		
		//listString = list.printList();
		
		 try {
			 	output.write("The following matrix:");
			 	output.newLine();
			 	output.newLine();
			 	//output.write(list.printList());
	        	
			 	
	        } catch (IOException ioException) {
	            System.err.println(ioException.toString());
	            System.exit(3);
	        }
	        
	        return;
	}

}
