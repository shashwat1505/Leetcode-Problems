class Solution {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1, ans = 0;
        while (start < end) {
            int h = Math.min(height[start], height[end]);
            int width = end - start;
            ans = Math.max(ans, h * width);
            if (height[start] < height[end])
                start++;
            else
                end--;
        }
        return ans;
    }
}
