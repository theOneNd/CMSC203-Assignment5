/*
 * Class: CMSC203 30295
 * Instructor: Professor Grigoriy Grinberg
 * Description: Console driver that prompts the user for input and output file names,
 *              reads sales data, computes statistics, and writes a summary file.
 * Due: 04/20/2026
 * Platform/compiler: Java
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Nebiyou Asrat
 */

import java.io.*;
import java.util.Scanner;

/**
 * SalesAppDriver is a console-based driver for the Store Sales Data Processor.
 * It prompts the user for an input file and an output file, then reads,
 * processes, and summarises the sales data.
 */
public class SalesAppDriver {


    public static void main(String[] args) throws IOException {
    	

	        Scanner keyboard = new Scanner(System.in);
	
	        // Prompt for input file
	        System.out.print("Enter input file name (e.g., salesdata.txt): ");
	        String inputFile = keyboard.nextLine().trim();
	
	        // Prompt for output file
	        System.out.print("Enter output file name (e.g., sales_summary.txt): ");
	        String outputFile = keyboard.nextLine().trim();
	
	        keyboard.close();
	
	        // Read data
	        double[][] data;
            data = SalesFileIO.readSalesData(inputFile);
        

	        System.out.println("\n--- Sales Report ---");
	        System.out.printf("Total sales: %.2f%n", SalesDataUtility.getTotal(data));
	        System.out.printf("Average sale: %.2f%n", SalesDataUtility.getAverage(data));
	        System.out.printf("Highest sale: %.2f%n", SalesDataUtility.getHighestInArray(data));
	        System.out.printf("Lowest sale: %.2f%n%n", SalesDataUtility.getLowestInArray(data));
	
	        // Row totals
	        for (int r = 0; r < data.length; r++) {
	            System.out.printf("Row %d total:  %.2f%n", r, SalesDataUtility.getRowTotal(data, r));
	        }
	
	        System.out.println();
	        
	        
	        // Determine total number of columns by determining length of longest row 
	        int totalColumns = SalesDataUtility.getLongestRowLength(data);
	
	        // Column totals
	        for (int c = 0; c < totalColumns; c++) {
	            System.out.printf("Column %d total: %.2f%n", c, SalesDataUtility.getColumnTotal(data, c));
	        }

            // Write summary to output file

            SalesFileIO.writeSummary(outputFile, data);
            System.out.println("\nSummary written to " + outputFile);
        
    }
}