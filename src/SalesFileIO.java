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


public class SalesFileIO {

    /**
     * Reads sales data from the specified file into a 2D double array.
     * Each non-empty line becomes one row; space-separated tokens become columns.
     *
     * @param filename path to the input text file
     * @return 2D array of sales values
     */
    public static double[][] readSalesData(String filename)
            throws IOException, NumberFormatException {

        List<double[]> rows = new ArrayList<>();

        Scanner fileScanner = new Scanner(new File(filename));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] tokens = line.split("\\s+");
            double[] row = new double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                row[i] = Double.parseDouble(tokens[i]);
            }
            rows.add(row);
        }
        fileScanner.close();

        // Convert list to array
        double[][] data = new double[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            data[i] = rows.get(i);
        }
        return data;
    }

    /**
     * Writes a formatted summary of sales statistics to the specified file.
     * Includes overall total, average, highest/lowest, row totals, and column totals.
     *
     * @param filename path to the output text file
     * @param 2D array of sales values
     */
    public static void writeSummary(String filename, double[][] data) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filename));

        double total   = SalesDataUtility.getTotal(data);
        double average = SalesDataUtility.getAverage(data);

        writer.printf("Total sales: %.2f%n", total);
        writer.printf("Average sale: %.2f%n", average);

        // Row totals
        for (int r = 0; r < data.length; r++) {
            writer.printf("Row %d total: %.2f%n", r, SalesDataUtility.getRowTotal(data, r));
        }

        // Determine maximum number of columns across all rows
        int maxCols = 0;
        for (double[] row : data) {
            if (row.length > maxCols) maxCols = row.length;
        }

        // Column totals
        for (int c = 0; c < maxCols; c++) {
            writer.printf("Column %d total: %.2f%n", c, SalesDataUtility.getColumnTotal(data, c));
        }

        writer.close();
    }
}