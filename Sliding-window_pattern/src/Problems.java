public class Problems {

    public static void main(String[] args) {
//        int[] nums = {1,12,-5,-6,50,3};
//        int k = 4;
//        System.out.println(findMaxAverage(nums, k));

        String s = "leetcode";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    //643. Maximum Average Subarray I
    public static double findMaxAverage(int[] nums, int k){

        double maxAvg = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            if (right - left + 1 > k){
                sum -= nums[left];
                left++;
            }
            if (right - left + 1 == k) {
                maxAvg = Math.max(maxAvg, sum);
            }
        }
        return maxAvg / k;
    }

    //1456. Maximum Number of Vowels in a Substring of Given Length
    public static int maxVowels(String s, int k) {

        int countVowel = 0;
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++){
            if (isVowel(s.charAt(right))){
                countVowel++;
            }
            if (right - left + 1 > k){
                if (isVowel(s.charAt(left))){
                    countVowel--;
                }
                left++;
            }
            if(right - left + 1 == k) {
                maxLen = Math.max(maxLen, countVowel);
            }
        }
        return maxLen;
    }

    private static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
