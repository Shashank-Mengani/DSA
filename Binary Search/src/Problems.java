
public class Problems {
    public static void main(String[] args) {
//        int[] nums = {-1,0,3,5,9,12};
//        int target = 9;
//        System.out.println(search(nums, target));

//        int[] nums = {1,3,5,6};
//        int target = 2;
//        System.out.println(searchInsert(nums, target));

//        int x = 9;
//        System.out.println(mySqrt(x));

//        int[] nums = {1, 2, 2, 2, 4, 5, 7};
//        int target = 2;
//        System.out.println(lowerBound(nums, target));

        int[] num = {1, 2, 2, 2, 4, 5, 7};
        int target = 3;
        System.out.println(upperBound(num, target));
    }

    //https://leetcode.com/problems/binary-search/?envType=problem-list-v2&envId=binary-search
    static int search(int[] num, int target){
        int s = 0;
        int e = num.length - 1;
        while (s <= e){
            int mid = s + (e - s) / 2;
            if (num[mid] < target){
                s = mid + 1;
            } else if (num[mid] > target) {
                e = mid - 1;
            } else{
                return mid;
            }
        }
        return -1;
    }

    //https://leetcode.com/problems/search-insert-position/submissions/2080673688/?envType=problem-list-v2&envId=binary-search
    static int searchInsert(int[] nums, int target){
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
    public static int lowerBound(int[] nums, int target){
        int s = 0;
        int e = nums.length;

        while (s < e){
            int mid = s + (e - s) / 2;

            if(nums[mid] >= target){
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    //https://www.geeksforgeeks.org/problems/implement-upper-bound/1
    public static int upperBound(int[] nums, int target){
        int s = 0;
        int e = nums.length;

        while (s < e){
            int mid = s + (e - s) / 2;

            if(nums[mid] <= target){
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }
}