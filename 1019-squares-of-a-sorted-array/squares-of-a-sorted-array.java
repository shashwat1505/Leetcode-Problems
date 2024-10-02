class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left=0, right=result.length-1;
        int pos=right;
        while(left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                result[pos] = nums[left]*nums[left];
                left += 1;
                pos -= 1;
            }
            else{
                result[pos] = nums[right]*nums[right];
                right -= 1;
                pos -= 1;
            }
        }
        return result;
    }
}