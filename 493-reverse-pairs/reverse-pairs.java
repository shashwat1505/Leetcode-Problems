import java.util.*;

public class Solution {

    // This variable will store the total count of reverse pairs
    private int count = 0;

    // The public method that the driver calls
    public int reversePairs(int[] nums) {
        this.count = 0; // Reset count for each call
        mergeSort(nums, 0, nums.length - 1);
        return this.count;
    }

    // Recursive merge sort function
    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2; // Avoids potential overflow for large low/high

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        
        // This is where we count reverse pairs before merging
        countReversePairs(nums, low, mid, high);

        // Then, perform the merge operation to sort the array
        merge(nums, low, mid, high);
    }

    // Helper method to count reverse pairs during the merge step
    private void countReversePairs(int[] nums, int low, int mid, int high) {
        int rightPtr = mid + 1;
        for (int i = low; i <= mid; i++) {
            // Use 2L to ensure the multiplication is done with a long to prevent overflow
            // before comparison, especially for large integer values.
            while (rightPtr <= high && nums[i] > (2L * nums[rightPtr])) {
                rightPtr++;
            }
            // Add the number of elements in the right subarray that satisfy the condition
            this.count += (rightPtr - (mid + 1));
        }
    }

    // Helper method to merge two sorted subarrays
    private void merge(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }
}