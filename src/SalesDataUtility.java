/*
 * Class: CMSC203 30295
 * Instructor: Professor Grigoriy Grinberg
 * Description: Utility class providing static methods to compute totals, averages,
 *              and min/max values on a ragged 2D array of sales data.
 * Due: 04/20/2026
 * Platform/compiler: Java
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Nebiyou Asrat
 */


public class SalesDataUtility {

    /**
     * Computes the sum of all elements in the ragged 2D array.
     *
     * @param 2D array of sales values
     * @return total of all sales values
     */
    public static double getTotal(double[][] data) {
        double total = 0.0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }
    
    
    

    /**
     * Computes the average of all elements in the 2D array.
     * Returns 0 if the array has no elements.
     *
     * @param 2D array of sales values
     * @return average of all sales values
     */
    public static double getAverage(double[][] data) {
        int count = 0;
        for (double[] row : data) {
            count += row.length;
        }
        if (count == 0) return 0.0;
        return getTotal(data) / count;
    }
    
    
    

    /**
     * Computes the total of all elements in a specific row.
     *
     * @param 2D array of sales values
     * @param row  index of the row to total
     * @return sum of all values in the specified row
     */
    public static double getRowTotal(double[][] data, int row) {
        double total = 0.0;
        for (double value : data[row]) {
            total += value;
        }
        return total;
    }

    
    
    
    /**
     * Computes the total of all elements in a specific column.
     * Rows that do not have the specified column index are skipped.
     *
     * @param 2D array of sales values
     * @param col  index of the column to total
     * @return sum of all values in the specified column
     */
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0.0;
        for (double[] row : data) {
            if (col < row.length) {
                total += row[col];
            }
        }
        return total;
    }

    
    
    
    /**
     * Returns the highest value in a specific row.
     *
     * @param 2D array of sales values
     * @param row  index of the row to search
     * @return highest value in the specified row
     */
    public static double getHighestInRow(double[][] data, int row) {
        double highest = data[row][0];
        for (double value : data[row]) {
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }
    
    
    

    /**
     * Returns the lowest value in a specific row.
     *
     * @param 2D array of sales values
     * @param row  index of the row to search
     * @return lowest value in the specified row
     */
    public static double getLowestInRow(double[][] data, int row) {
        double lowest = data[row][0];
        for (double value : data[row]) {
            if (value < lowest) {
                lowest = value;
            }
        }
        return lowest;
    }

    
    
    
    /**
     * Returns the highest value across the entire 2D array.
     *
     * @param 2D array of sales values
     * @return highest value in the array
     */
    public static double getHighestInArray(double[][] data) {
        double highest = data[0][0];
        for (double[] row : data) {
            for (double value : row) {
                if (value > highest) {
                    highest = value;
                }
            }
        }
        return highest;
    }
    
    
    
    

    /**
     * Returns the lowest value across the entire 2D array.
     *
     * @param 2D array of sales values
     * @return lowest value in the array
     */
    public static double getLowestInArray(double[][] data) {
        double lowest = data[0][0];
        for (double[] row : data) {
            for (double value : row) {
                if (value < lowest) {
                    lowest = value;
                }
            }
        }
        return lowest;
    }
}
