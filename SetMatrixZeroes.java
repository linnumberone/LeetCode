// Solution 1
// O(m+n) space
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length < 1)
            return;
        
        boolean[] isRowZero = new boolean[matrix.length];
        boolean[] isColZero = new boolean[matrix[0].length];
        
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                if(matrix[i][j] == 0) {
                    isRowZero[i] = true;
                    isColZero[j] = true;
                }
            }
        }
        
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                if(isRowZero[i] || isColZero[j])
                    matrix[i][j] = 0;
            }
        }
    }
}

// Solution 2:
// O(1) space
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length < 1)
            return;
        
        // Because the state of row0 and the state of column0 would occupy the same cell, I let it be the state of row0, and use another variable "col0" for column0
        int col0 = 1;
        for(int i = 0; i < matrix.length; ++i) {
            if(matrix[i][0] == 0)
                col0 = 0;
            for(int j = 1; j < matrix[i].length; ++j) {
                if(matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }
        
        // use bottom-up method can avoid the first row was manipulated by others
        for(int i = matrix.length - 1; i >= 0; --i) {
            for(int j = matrix[i].length - 1; j >= 1; --j) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if(col0 == 0)
                matrix[i][0] = 0;
        }
    }
}
