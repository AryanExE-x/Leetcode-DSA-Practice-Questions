class Solution {
    public int maximalRectangle(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] height = new int[m][n];
        for(int j=0;j<n;j++){
            if(mat[0][j]=='1'){
                height[0][j]=1;
            }
        }

        for(int i=1;i<m;i++){ //2nd row se
            for(int j=0;j<n;j++){
                if(mat[i][j]=='1') height[i][j] = height[i-1][j] + 1;
                else height[i][j] = 0;
            }
        }
        int max=0;
        for(int[] row : height){
            int area=largestRectangleArea(row);
            max=Math.max(max,area);
        }
        return max;
    }
    public int largestRectangleArea(int[] arr) {
            int n = arr.length;
            Stack<Integer> st = new Stack<>();
            //next smaller element
            int[] nse = new int[n];
            st.push(n-1);
            nse[n-1]=n;
            for(int i=n-2;i>=0;i--){
                while(st.size()>0 && arr[i]<=arr[st.peek()]) st.pop();
                if(st.size()==0){
                    nse[i] = n;
                } 
                else{
                    nse[i]=st.peek();
                }
                st.push(i);
            }
            while(st.size()>0) st.pop(); //stack empty krdo

            //previous smaller element
            int[] pse = new int[n];
            pse[0]=-1;
            st.push(0);
            for(int i=1;i<=n-1;i++){
                while(st.size()>0 && arr[i]<=arr[st.peek()]) st.pop();
                if(st.size()==0){
                    pse[i] = -1;
                } 
                else{
                    pse[i]=st.peek();
                }
                st.push(i);
            }
            int maxArea= 0;
            for(int i=0;i<n;i++){
                int area= arr[i]*(nse[i]-pse[i]-1);
                maxArea=Math.max(maxArea,area);
            }
            return maxArea;
        }
}