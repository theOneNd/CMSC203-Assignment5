/*
 * Class: CMSC203 30295
 * Instructor: Professor Grigoriy Grinberg
 * Description: File I/O helper class that reads sales data from a text file into
 *              a ragged 2D array and writes a formatted summary to an output file.
 * Due: 04/20/2026
 * Platform/compiler: Java
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Nebiyou Asrat
 */

import java.io.*;
import java.util.*;


/**
 * Handles reading sales data from a file and writing a summary to a file.
 */

public class SalesFileIO {

	
    /**
     * Reads space-separated sales values from a file into a ragged 2D array.
     * Each line becomes one row; values on each line become the columns.
     * @param filename path to the input file
     * @return ragged 2D array of sales values
     * @throws IOException if the file cannot be read
     */
	
	public static double[][] readSalesData(String filename) throws IOException {
		
		try (Scanner inputFile = new Scanner(new File(filename))) {
			
	        ArrayList<double[]> rows = new ArrayList<double[]>();

	        while (inputFile.hasNextLine()) {

	            String inputLine = inputFile.nextLine();


	            String[] stringList = inputLine.split(" ");

	            double[] row = new double[stringList.length];

	            for (int i = 0; i < stringList.length; i++) {
	                row[i] = Double.parseDouble(stringList[i]);
	            }

	            rows.add(row);
	        }

	        return rows.toArray(new double[0][]);			
		}
	}
	
	
	
    /**
     * Appends a sales summary (total, average, row totals, column totals) to a file.
     * @param filename path to the output file
     * @param data ragged 2D array of sales values
     * @throws IOException if the file cannot be written
     */
	
	public static void writeSummary(String filename, double[][] data) throws IOException {
		
		try (PrintWriter pw = new PrintWriter(new FileWriter(filename, true))) {
			
			int totalRows = data.length;

			pw.printf("Total sales: %.2f%n", SalesDataUtility.getTotal(data));
			pw.printf("Average sale: %.2f%n", SalesDataUtility.getAverage(data));
			
			/// for each row
			for (int i = 0; i < totalRows; i++) {				
				pw.printf("Row %d total: %.2f%n", i, SalesDataUtility.getRowTotal(data, i));
			}			
			
			/// for each column
			int totalColumns = SalesDataUtility.getLongestRowLength(data);
			for (int i = 0; i < totalColumns; i++) {
				
				pw.printf("Column %d total: %.2f%n", i, SalesDataUtility.getColumnTotal(data, i));
			}
			pw.println();

			
		}
	}
}

