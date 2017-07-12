// version 1
public void rotate(int[][] matrix) {
    int size = matrix.length;
    // transpose matrix[i][j] = matrix[j][i]
    for(int i = 0; i < size; ++i) {
        for(int j = i; j < size; ++j) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }

    // reverse
    for(int i = 0; i < size; ++i) {
        for(int j = 0; j < size / 2; ++j) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][size - j - 1];
            matrix[i][size - j - 1] = temp;
        }
    }
}    

// version 2
public void rotate(int[][] matrix) {
	int row = matrix.length;
	int col = matrix[0].length;

	int[][] rotateMatrix = new int[row][col];
	for(int i = 0; i < col; ++i) {
		for(int j = 0; j < row; ++j) {
			rotateMatrix[i][j] = matrix[row - j - 1][i];
		}
	}
	for(int i = 0; i < col; ++i) {
		for(int j = 0; j < row; ++j) {
			matrix[i][j] = rotateMatrix[i][j];
		}
	}
}
