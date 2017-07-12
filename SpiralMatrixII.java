public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        int rowStart = 0, rowEnd = n;
        int colStart = 0, colEnd = n;
        int count = 0;
        
        while(rowStart < rowEnd && colStart < colEnd) {
            for(int j = colStart; j < colEnd; ++j) {
                result[rowStart][j] = ++count;
            }
            rowStart++;
            
            for(int i = rowStart; i < rowEnd; ++i) {
                result[i][colEnd - 1] = ++count;
            }
            colEnd--;
            
            for(int j = colEnd - 1; j >= colStart; --j) {
                result[rowEnd - 1][j] = ++count;
            }
            rowEnd--;
            
            for(int i = rowEnd - 1; i >= rowStart; --i) {
                result[i][colStart] = ++count;
            }
            colStart++;
        }
        return result;
    }
}
