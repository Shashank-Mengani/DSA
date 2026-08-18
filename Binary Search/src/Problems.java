import java.util.Arrays;

public class Problems {
    public static void main(String[] args) {
//        int[] nums = {-1,0,3,5,9,12};
//        int target = 9;
//        System.out.println(BinarySearch(nums, target));

//        int[] nums = {1,3,5,6};
//        int target = 2;
//        System.out.println(searchInsert(nums, target));

//        int x = 9;
//        System.out.println(mySqrt(x));

//        int[] nums = {1, 2, 2, 2, 4, 5, 7};
//        int target = 2;
//        System.out.println(lowerBound(nums, target));

//        int[] num = {1, 2, 2, 2, 4, 5, 7};
//        int target = 3;
//        System.out.println(upperBound(num, target));
//
//        int[] nums = {5,7,7,8,8,10};
//        int target = 8;
//        System.out.println(Arrays.toString(searchRange(nums, target)));

//        int[] nums = {3,4,5,1,2};
//        System.out.println(findMin(nums));

//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 0;
//        System.out.println(search(nums, target));

        int[] piles = {30,11,23,4,20};
        int h = 5;
        System.out.println(minEatingSpeed(piles, h));
    }

    //https://leetcode.com/problems/binary-search/?envType=problem-list-v2&envId=binary-search
    static int BinarySearch(int[] num, int target) {
        int s = 0;
        int e = num.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (num[mid] < target) {
                s = mid + 1;
            } else if (num[mid] > target) {
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //https://leetcode.com/problems/search-insert-position/submissions/2080673688/?envType=problem-list-v2&envId=binary-search
    static int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] < target) {
                s = mid + 1;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return s;
    }

    //https://leetcode.com/problems/sqrtx/submissions/2082253363/?envType=problem-list-v2&envId=binary-search
    static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        long s = 0;
        long e = x;

        while (s <= e) {
            long mid = s + (e - s) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return (int) e;
    }

    //https://www.geeksforgeeks.org/problems/implement-lower-bound/1
    public static int lowerBound(int[] nums, int target) {
        int s = 0;
        int e = nums.length;

        while (s < e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] >= target) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    //https://www.geeksforgeeks.org/problems/implement-upper-bound/1
    public static int upperBound(int[] nums, int target) {
        int s = 0;
        int e = nums.length;

        while (s < e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] <= target) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }

    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=problem-list-v2&envId=binary-search
    public static int[] searchRange(int[] nums, int target) {
        int lower = lowerBoundRange(nums, target);

        int upper = upperBoundRange(nums, target) - 1;

        if (lower == nums.length || nums[lower] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{lower, upper};
    }

    static int lowerBoundRange(int[] nums, int target) {
        int s = 0;
        int e = nums.length;

        while (s < e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] >= target) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    static int upperBoundRange(int[] nums, int target) {
        int s = 0;
        int e = nums.length;

        while (s < e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] > target) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/?envType=problem-list-v2&envId=binary-search
    public static int findMin(int[] nums){
        int s = 0;
        int e = nums.length - 1;

        while (s < e){
            int mid = s + (e - s) / 2;

            if (nums[mid] > nums[e]){
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return nums[s];
    }

    //https://leetcode.com/problems/search-in-rotated-sorted-array/?envType=problem-list-v2&envId=binary-search
    public static int search(int[] nums, int target){
        int s = 0;
        int e = nums.length - 1;

        while (s <= e){
            int mid = s + (e - s) / 2;

            if(nums[mid] == target){
                return mid;
            }
            if(nums[s] <= nums[mid]){
                if(nums[s] <= target && target < nums[mid]){
                    e = mid - 1;
                } else{
                    s = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[e]){
                    s = mid + 1;
                } else{
                    e = mid - 1;
                }
            }
        }
        return -1;
    }

    //https://leetcode.com/problems/koko-eating-bananas/?envType=problem-list-v2&envId=binary-search
    public static int minEatingSpeed(int[] piles, int h){
        int s = 0;
        int e = 0;
        for (int pile: piles){
            e = Math.max(e, pile);
        }

        while (s < e){
            int mid = s + (e - s) / 2;
            int requiredHrs = 0;

            for (int pile: piles) {
                requiredHrs += (pile + mid - 1) / mid;
            }

            if(requiredHrs <= h){
                e = mid;
            } else{
                s = mid + 1;
            }
        }
        return s;
    }
}