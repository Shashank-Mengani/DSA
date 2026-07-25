
public class Problems {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }

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
}