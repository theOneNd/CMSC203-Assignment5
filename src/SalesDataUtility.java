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


/**
 * Static utility methods for computing statistics on a ragged 2D sales array.
 */

public class SalesDataUtility {

	
    /**
     * Returns the sum of all elements in the array.
     * @param data ragged 2D array of sales values
     * @return total of all values
     */
	
    public static double getTotal(double[][] data) {
    	double total = 0.0;
    	
    	for (int i = 0; i < data.length; i++) {
    		for (int j = 0; j < data[i].length; j++) {
    			total += data[i][j];
    		}
    	}
    	return total;
    }
   
    
    /**
     * Returns the average of all elements in the array.
     * @param data ragged 2D array of sales values
     * @return average of all values
     */
    
    public static double getAverage(double[][] data) {
    	double total = 0.0;
    	int count = 0;
    	
    	for (int i = 0; i < data.length; i++) {
    		for (int j = 0; j < data[i].length; j++) {
    			total += data[i][j];
    			count++;
    		}
    	}
    	return total / count;    	
    }
    
    
    
    
    /**
     * Returns the sum of all elements in the specified row.
     * @param data ragged 2D array of sales values
     * @param row  zero-based row index
     * @return total of all values in that row
     */
  
    public static double getRowTotal(double[][] data, int row) {
    	double total = 0.0;
    	
    	for (int j = 0; j < data[row].length; j++) {
    		total += data[row][j];
    	}

    	return total;    	
    }
    
    
    /**
     * Returns the sum of all elements in the specified column.
     * @param data ragged 2D array of sales values
     * @param col  zero-based column index; must exist in every row
     * @return total of all values in that column
     */
    
    public static double getColumnTotal(double[][] data, int col) {
        
    	double total = 0.0;
    	
    	for (int i = 0; i < data.length; i++) {
    		
            /// check to see if row's length is shorter than the column number given
            /// if so, skip as there won't be an entry there'
            if (data[i].length <= col) {
            	continue;
            }
            total += data[i][col];
    	}
    	return total;    	
    }
    
    
    
    /**
     * Returns the highest value in the specific row.
     * @param data ragged 2D array of sales values
     * @param row  zero-based row index
     * @return maximum value in that row
     */    
    
    public static double getHighestInRow(double[][] data, int row) {
    	double highest = data[row][0];
    	
    	for (int j = 1; j < data[row].length; j++) {
    		if (data[row][j] > highest) {    			
    			highest = data[row][j];
    		}
    	}

    	return highest;      	
    }
    
    
    /**
     * Returns the lowest value in the specific row.
     * @param data ragged 2D array of sales values
     * @param row  zero-based row index
     * @return minimum value in that row
     */
    
    public static double getLowestInRow(double[][] data, int row) {
    	double lowest = data[row][0];
    	
    	for (int j = 1; j < data[row].length; j++) {
    		if (data[row][j] < lowest) {    			
    			lowest = data[row][j];
    		}
    	}

    	return lowest;      	
    }
    
    
    /**
     * Returns the highest value in the entire array.
     * @param data ragged 2D array of sales values
     * @return maximum value across all rows and columns
     */
    
    public static double getHighestInArray(double[][] data) {
    	double highest = data[0][0];

    	for (int i = 0; i < data.length; i++) {
    		for (int j = 0; j < data[i].length; j++) {
    			if (data[i][j] > highest) {    			
    				highest = data[i][j];
    			}
    		}
    	}    	

    	return highest;      	
    }
    
    
    /**
     * Returns the lowest value in the entire array.
     * @param data ragged 2D array of sales values
     * @return minimum value across all rows and columns
     */
    
    public static double getLowestInArray(double[][] data) {
    	double lowest = data[0][0];

    	for (int i = 0; i < data.length; i++) {
    		for (int j = 0; j < data[i].length; j++) {
    			if (data[i][j] < lowest) {    			
    				lowest = data[i][j];
    			}
    		}
    	}    	

    	return lowest;      	  	
    }
    
    
    /**
     * Returns the length of the longest row in the array.
     * @param data ragged 2D array of sales values
     * @return length of the longest row
     */
    
    public static int getLongestRowLength(double[][] data) {
    	int longestRowLength = 0;
    	
    	for (double[] row : data) {
    		if (row.length > longestRowLength) {
    			longestRowLength = row.length;
    		}
    	}
    	return longestRowLength;
    }
    
    
}
