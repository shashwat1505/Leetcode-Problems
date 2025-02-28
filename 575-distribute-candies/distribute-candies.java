class Solution {
    public int distributeCandies(int[] c) {
        
        int n=c.length;
        HashSet<Integer> st = new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(c[i]);
        }
        int m=st.size();
        int ans=Integer.min(n/2,m);
        return ans;


    }
}