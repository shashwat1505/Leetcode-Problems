public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }
    private static int findFirst(int [] nums, int target) {
        int start = 0, end = nums.length - 1;
        int res = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res = mid;
                end = mid - 1;
            }
            else if(nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return res;
    }
    private static int findLast(int [] nums, int target) {
        int start = 0, end = nums.length - 1;
        int res = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res = mid;
                start = mid + 1;
            }
            else if(nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
     }
}
return res;
    }
}