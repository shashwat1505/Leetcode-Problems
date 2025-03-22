class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length]; 
        int posIndex = 0, negIndex = 1;


    for(int n : nums){
        if (n > 0){
            ans[posIndex] = n;
            posIndex += 2;
        } else{
            ans[negIndex] = n;
            negIndex +=2;
        }
    }
    return ans;
    }
}