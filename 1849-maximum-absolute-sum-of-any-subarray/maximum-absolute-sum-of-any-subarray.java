class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEndingHere = 0; // Represents the maximum subarray sum ending at the current position
        int minEndingHere = 0; // Represents the minimum subarray sum ending at the current position
        int maxAbsoluteSum = 0;
        for (int num : nums) {
            maxEndingHere = Math.max(maxEndingHere + num, 0);minEndingHere = Math.min(minEndingHere + num, 0);
            maxAbsoluteSum = Math.max(maxAbsoluteSum, Math.max(maxEndingHere, Math.abs(minEndingHere)));
        }

        // Return the overall maximum absolute subarray sum found
        return maxAbsoluteSum;
    }
}
