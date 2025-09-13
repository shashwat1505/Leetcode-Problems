import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || t < 0 || nums == null || nums.length < 2) return false;

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long curr = (long) nums[i];

            // Find the smallest number >= curr - t
            Long floor = set.ceiling(curr - t);
            if (floor != null && floor <= curr + t) {
                return true;
            }

            set.add(curr);

            // Remove the element outside the sliding window
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}
