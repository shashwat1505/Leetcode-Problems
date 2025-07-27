import java.util.*;

public class Solution {
    
    // Helper function to check if a divisor is feasible
    public static boolean isFeasible(int[] nums, int divisor, int limit) {
        long sum = 0;
        for (int num : nums) {
            // Calculate the sum of the divisions, rounding up
            sum += Math.ceil((double) num / divisor);
            if (sum > limit) return false; // Early exit if limit exceeded
        }
        return sum <= limit;
    }

    public static int smallestDivisor(int[] nums, int limit) {
        int n = nums.length;
        
        // Edge case: if array size exceeds limit, return -1
        if (n > limit) return -1;

        // Find the maximum value in nums to set the upper bound for the binary search
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        // Binary search for the smallest divisor
        int low = 1, high = maxi, result = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isFeasible(nums, mid, limit)) {
                result = mid; // Store the smallest feasible divisor
                high = mid - 1; // Try for a smaller divisor
            } else {
                low = mid + 1; // Increase the divisor
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    } 
       
}
