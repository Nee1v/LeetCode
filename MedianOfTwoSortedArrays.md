# Median of two sorted arrays

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index = ((nums1.length + nums2.length) - 1) / 2;

        int p1 = 0;
        int p2 = 0;
```

### Find the `index` of the median by adding up both arrays length, subtracting by 1, and dividing by 2. Initiate two pointers, `p1` for array `nums1` and `p2` for array `nums2`

```java
while(p1 + p2 < index) {
            if(p1 < nums1.length) {
                if(p2 < nums2.length) { //both p1 and p2 are valid pointers within the corresponding arrays nums1 and nums2
                    if(nums1[p1] == nums2[p2]) { //both nums1[p1] and nums2[p2] are the same
                        p1++;
                    } else if(nums1[p1] < nums2[p2]) { //nums1[p1] is less than nums2[p2]
                        p1++;
                    } else { //nums2[p2] is less than nums1[p1]
                        p2++;
                    }
                } else { //p1 is a valid pointer within nums1 but p2 is not a valid pointer within nums2
                    p1 += (index - p2 - p1); //Could just calculate how much too add
                }
            } else { //p2 is a valid pointer within nums2 but p1 is not a valid pointer within nums1
                p2 += (index - p1 - p2); //Could just calculate how much to add
            }
        }
```
