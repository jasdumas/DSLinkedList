package LinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lab3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedReader 	input;
		BufferedWriter 	output;
		ListNode 		node;
		int				data;
		int				listSize;
		String			z;
		
		//  Check for two command line arguments.
        //if (args.length != 2) {
        //    System.out.println("Usage:  java Recursion.LabTwo [input file]" +
        //        " [output file]");
        //    System.exit(1);
        //}
        
        //  Open the input and output files.
        //try {
        //    input = new BufferedReader(new FileReader(args[0]));
        //    output = new BufferedWriter(new FileWriter(args[1]));
        //} catch (Exception exception) {
        //    System.err.println(exception.toString());
        //    return;
        //}
		
        data = 2;
		node = new LinkedList.ListNode(data);
		List list = new List();
		
		//node.printNode();
		
		list.InsertNode(2);
		list.InsertNode(3);
		list.InsertNode(4);
		list.InsertNode(5);
		list.InsertNode(6);
		list.InsertNode(7);
		
		list.printList();
		System.out.println();
		
		listSize = list.ListSize();
		System.out.print("list size = " + listSize);
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
	private void writeOutput(int[][] intArray, int det, BufferedWriter output) {
		
		 try {
			 	output.write("The following matrix:");
			 	output.newLine();
			 	output.newLine();
			 	
			 	for (int i = 0; i < intArray.length; i++){
	        		for (int j = 0; j < intArray.length; j++){
	        			
	        			output.write(intArray[i][j] + " ");
	        		}
	        		
	        		output.newLine();
			 	}
			 	
			 	output.newLine();
			 	output.write("Has a determinant value of " + det + ".");
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

}
