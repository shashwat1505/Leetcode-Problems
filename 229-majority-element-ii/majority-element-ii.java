import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        // First pass: find potential candidates
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) {
                cnt1++;
            } else if (nums[i] == el2) {
                cnt2++;
            } else if (cnt1 == 0) {
                el1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                el2 = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Second pass: verify the candidates
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == el1) cnt1++;
            if (num == el2) cnt2++;
        }

        List<Integer> result = new ArrayList<>();
        if (cnt1 > n / 3) result.add(el1);
        if (cnt2 > n / 3) result.add(el2);
        return result;
    }
}
