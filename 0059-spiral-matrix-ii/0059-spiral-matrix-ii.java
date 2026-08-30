class Solution {
    public int[][] generateMatrix(int n) {
    int[][] arr = new int[n][n];

    int firstRow = 0;
    int lastRow = n - 1;
    int firstCol = 0;
    int lastCol = n - 1;
    int val = 1;

    while(firstCol <= lastCol && firstRow <= lastRow) {

        for(int j = firstCol; j <= lastCol; j++) {
            arr[firstRow][j] = val++;
        }
        firstRow++;

        if(firstRow > lastRow || firstCol > lastCol) break;

        for(int i = firstRow; i <= lastRow; i++) {
            arr[i][lastCol] = val++;
        }
        lastCol--;

        if(firstRow > lastRow || firstCol > lastCol) break;

        for(int j = lastCol; j >= firstCol; j--) {
            arr[lastRow][j] = val++;
        }
        lastRow--;

        if(firstRow > lastRow || firstCol > lastCol) break;

        for(int i = lastRow; i >= firstRow; i--) {
            arr[i][firstCol] = val++;
        }
        firstCol++;
    }

    return arr;
}
}