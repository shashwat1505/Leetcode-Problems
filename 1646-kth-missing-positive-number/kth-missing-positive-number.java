import java.util.*;
public class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length; // size/length of array:
        int low = 0; 
        int high = n - 1; //initialize high as n - 1:
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }
}