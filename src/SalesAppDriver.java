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

    /**
     * Entry point for the console application.
     * Prompts for file names, reads sales data, displays statistics,
     * and writes a summary file.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
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
        try {
            data = SalesFileIO.readSalesData(inputFile);
        } catch (IOException ex) {
            System.out.println("ERROR: Input file not found: " + inputFile);
            return;
        } catch (NumberFormatException ex) {
            System.out.println("ERROR: Invalid number found in data file.");
            return;
        }

        System.out.println("\n--- Sales Report ---");
        System.out.printf("Total sales:   %.2f%n", SalesDataUtility.getTotal(data));
        System.out.printf("Average sale:  %.2f%n", SalesDataUtility.getAverage(data));
        System.out.printf("Highest sale:  %.2f%n", SalesDataUtility.getHighestInArray(data));
        System.out.printf("Lowest sale:   %.2f%n%n", SalesDataUtility.getLowestInArray(data));

        // Row totals
        for (int r = 0; r < data.length; r++) {
            System.out.printf("Row %d total:  %.2f%n", r, SalesDataUtility.getRowTotal(data, r));
        }

        // Determine max columns for column totals
        int maxCols = 0;
        for (double[] row : data) {
            if (row.length > maxCols) maxCols = row.length;
        }

        System.out.println();

        // Column totals
        for (int c = 0; c < maxCols; c++) {
            System.out.printf("Column %d total: %.2f%n", c, SalesDataUtility.getColumnTotal(data, c));
        }

        // Write summary to output file
        try {
            SalesFileIO.writeSummary(outputFile, data);
            System.out.println("\nSummary written to " + outputFile);
        } catch (IOException ex) {
            System.out.println("ERROR writing summary: " + ex.getMessage());
        }
    }
}