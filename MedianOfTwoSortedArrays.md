# Median of two sorted arrays

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index = ((nums1.length + nums2.length) - 1) / 2;

        int p1 = 0;
        int p2 = 0;
```

### Find the `index` of the median by adding up both arrays length, subtracting by 1, and dividing by 2. Initiate two pointers, `p1` for array `nums1` and `p2` for array `nums2`
