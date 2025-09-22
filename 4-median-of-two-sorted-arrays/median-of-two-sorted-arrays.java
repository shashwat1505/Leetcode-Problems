class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        
        while (left <= right) {
            // Partition points
            int i = (left + right) / 2; // Partition in nums1
            int j = (m + n + 1) / 2 - i; // Partition in nums2
            
            // Get left and right elements for both arrays
            int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int left2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];
            
            // Check if partition is valid
            if (left1 <= right2 && left2 <= right1) {
                // If total length is odd
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }
                // If total length is even
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                // Move partition in nums1 to the left
                right = i - 1;
            } else {
                // Move partition in nums1 to the right
                left = i + 1;
            }
        }
        
        // If no valid partition is found (should not happen for valid inputs)
        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }
}