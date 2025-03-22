class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] rearrangedArray = new int[nums.length]; 
        int posIndex = 0, negIndex = 1;


    for(int n : nums){
        if (n > 0){
            rearrangedArray[posIndex] = n;
            posIndex += 2;
        } else{
            rearrangedArray[negIndex] = n;
            negIndex +=2;
        }
    }
    return rearrangedArray;
    }
}