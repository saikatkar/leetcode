class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays (nums2, nums1);
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int total = (n1+n2+1)/2;
        int l1 = 0;
        int h1 = nums1.length;
        
        while (l1 <= h1) {
            int m1 = l1 + (h1-l1)/2;
            int m2 = total - m1;
            System.out.println(m1);
            System.out.println(m2);
            
            int maxLeft1 = m1 == 0 ? Integer.MIN_VALUE : nums1[m1-1];
            int maxLeft2 = m2 == 0 ? Integer.MIN_VALUE : nums2[m2-1];
            
            int minRight1 = m1 == n1  ? Integer.MAX_VALUE : nums1[m1];
            int minRight2 = m2 == n2 ? Integer.MAX_VALUE : nums2[m2];
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((n1 + n2) % 2 == 0) {
                    return (double)((Math.max(maxLeft1, maxLeft2) +
                        Math.min(minRight1, minRight2)) * 1.0)/2; 
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft2 > minRight1) {
                l1 = m1 +1;
            } else {
                h1 = m1 -1;
            }
        }
        return -1.00;
    }
}