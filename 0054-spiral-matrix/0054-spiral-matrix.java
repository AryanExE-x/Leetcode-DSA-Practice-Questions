
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length; int n = matrix[0].length;
        int firstRow=0; int lastRow=m-1; int firstCol=0; int lastCol=n-1;
        while(firstRow<=lastRow && firstCol<=lastCol){
            for(int j=firstCol;j<=lastCol;j++){ //right
                ans.add(matrix[firstRow][j]);
            }
            firstRow++;
            if(firstRow>lastRow || firstCol>lastCol) break;
            for(int i=firstRow;i<=lastRow;i++){ //down
                ans.add(matrix[i][lastCol]);
            }
            lastCol--;
            if(firstRow>lastRow || firstCol>lastCol) break;
            for(int j=lastCol;j>=firstCol;j--){ //left
                ans.add(matrix[lastRow][j]);
            }
            lastRow--;
            if(firstRow>lastRow || firstCol>lastCol) break;
            for(int i=lastRow;i>=firstRow;i--){ //up
                ans.add(matrix[i][firstCol]);
            }
            firstCol++;
        }
        return ans;
    }
}