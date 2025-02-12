class Solution {

    /**
     * Finds the first common element in two sorted arrays.
     *
     * If a common element is found, this method returns that element.
     * If there are no common elements, the method returns -1.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int getCommon(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1Length && index2 < nums2Length) {
            if (nums1[index1] == nums2[index2]) {
                return nums1[index1];
            }
            if (nums1[index1] < nums2[index2]) {
                ++index1;
            } else {
                ++index2;
            }
        }
        return -1;
    }
}