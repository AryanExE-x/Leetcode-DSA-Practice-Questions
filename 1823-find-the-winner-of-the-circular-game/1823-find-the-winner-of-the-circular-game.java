class Solution {
    public int findTheWinner(int n, int k) {

        //k-1 remove and add in queue 
        //remove 
        //repeat till queue size is 1 and return that WINNER

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        while(q.size()>1){
            for(int i=0;i<k-1;i++){
                q.add(q.remove());
            }
            q.remove();
        }
        return q.peek();

    }
}