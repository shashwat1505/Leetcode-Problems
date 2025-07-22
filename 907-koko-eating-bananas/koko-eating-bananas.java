import java.util.*;
public class Solution {
    public static int minEatingSpeed(int[] piles, int h) {
        return minimumRateToEatBananas(piles, h);
    }
        public static int calculateTotalHours(int[] piles, int hourly) {
            int totalH = 0;
            for (int pile : piles) {
            totalH += Math.ceil((double)pile / hourly);
        }
        return totalH;
    }
    public static int findMax(int[] piles) {
        int maxi = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxi = Math.max(maxi, pile);
        }
        return maxi;
    }
        public static int minimumRateToEatBananas(int[] piles, int h) {
            int low = 1; 
            int high = findMax(piles);
            while (low <= high) {
                int mid = (low + high) / 2;
                int totalH = calculateTotalHours(piles, mid);
                if (totalH <= h) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
}