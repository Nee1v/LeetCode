# Median of two sorted arrays

### The idea behind my solution is to simulate both sorted arrays being merged without them being merged. If we were to have a merged sorted array and we needed to find the median we simply go to the middle so we calculate a median index and find which array / arrays contains that median.

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index = ((nums1.length + nums2.length) - 1) / 2;

        int p1 = 0;
        int p2 = 0;
```

### Find the `index` of the median by adding up both arrays length, subtracting by 1, and dividing by 2. Initiate two pointers, `p1` for array `nums1` and `p2` for array `nums2`

# 

```java
while(p1 + p2 < index) {
    if(p1 < nums1.length) {
        if(p2 < nums2.length) { 
            if(nums1[p1] == nums2[p2]) { 
                p1++;
            } else if(nums1[p1] < nums2[p2]) { 
                p1++;
            } else { 
                p2++;
            }
        } else { 
            p1 += (index - p2 - p1); 
        }
    } else { 
        p2 += (index - p1 - p2); 
    }
}
```

### Now (while `p1` + `p2` is < `index` (the index of the median) ), we continously compare `nums1[p1]` and `nums2[p2]`. Initially check if both pointers `p1` and `p2` are valid within their corresponding arrays. If one of the pointers is not valid (it is out of bounds) then we know the median can only lie within the other array, since the array we just checked is fully exhausted. Knowing that we simply calculate the difference from `(index - p2 - p1)` and add it to whichever pointer is not invalid. Now the other case is that both pointers are valid in which case we will perform a series of comparisons between both arrays. We check if `nums1[p1] == nums2[p2]`, if so we increment `p1` since both are equal it does not matter which we increment. Wr check if `nums1[p1] < nums2[p2]`, if so we increment `p1`. If the first two "if" statements return false then we know `nums2[p2] < nums1[p1]`, so we increment `p2`. The end goal of this is that we are guaranteed to have the median either at index `p1` of `nums1` or `p2` of `nums2`.

#

```java
double sum = 0;
int count = 1;

if((nums1.length + nums2.length) % 2 == 0) {
    count = 2;
}
```

### Initiate double `sum` to 0, this will store the median. Initiate int `count` to 1. Count is a variable to determine how many times the for loop to calculate the median is run. `count` needs to be either 1 or 2 since if the length of both the sorted arrays combined is odd the median is simply the middle of the "merged array". In the case the length of both sorted arrays combined is even we need the two values in the middle, to add them up and divide them to get the median. So we will always assume we need to run the for loop at least 1 time (case for odd length arrays) and we will set it to 2 if the length is even.

#

```java
for(int i = 0; i < count; i++) {
    if(p1 < nums1.length) {
        if(p2 < nums2.length) { 
            if(nums1[p1] == nums2[p2]) { 
                sum += nums1[p1];
                p1++;
             } else if(nums1[p1] < nums2[p2]) {
                sum += nums1[p1];
                p1++;
             } else { //nums2[p2] is less than nums1[p1]
                sum += nums2[p2];
                p2++;
            }
        } else { 
            sum += nums1[p1];
            p1++;
        }
    } else { 
        sum += nums2[p2];
        p2++;
    }
}

if((nums1.length + nums2.length) % 2 == 0)
sum /= 2;

return sum;
```

### Now we initiate a for loop to run `count` amount of times. Within this for loop we are performing the exact same comparisons as before.
- If both pointers are valid
    - And `nums1[p1] == nums2[p2]` then add `nums1[p1]` to `sum`
    - And `nums1[p1] < nums2[p2]` then add `nums1[p1]` to `sum`
    - And `nums2[p2] < nums1[p1]` then add `nums2[p2]` to `sum`
 - If only pointer `p1` is valid then add `nums1[p1]` to `sum` since we know the median is within `nums1`
 - If only pointer `p2` is valid then add `nums2[p2]` to `sum` since we know the median is within `nums2`
### Finally if the length of the two arrays combined is even divide `sum` by 2 for the median value then return.
