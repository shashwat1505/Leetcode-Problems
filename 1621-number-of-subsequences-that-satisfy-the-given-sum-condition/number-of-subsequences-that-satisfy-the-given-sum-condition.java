import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        int MOD = 1_000_000_007;
        int n = nums.length;

        Arrays.sort(nums);
        int[] power2Mod = new int[n];
        power2Mod[0] = 1;
        for (int i = 1; i < n; i++) {
            power2Mod[i] = (power2Mod[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1;
        int result = 0;
while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + power2Mod[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
