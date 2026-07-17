import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Problems {

    public static void main(String[] args) {
//        int[] nums = {1,12,-5,-6,50,3};
//        int k = 4;
//        System.out.println(findMaxAverage(nums, k));

//        String s = "leetcode";
//        int k = 3;
//        System.out.println(maxVowels(s, k));

//        String s = "xyzzaz";
//        System.out.println(countGoodSubstrings(s));

//        String s = "pwwkew";
//        System.out.println(lengthOfLongestSubstring(s));

        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    //https://leetcode.com/problems/maximum-average-subarray-i/description/I
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

    //https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
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

    //https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/
    public static int countGoodSubstrings(String s){

        if(s.length() < 3){
            return 0;
        }

        int[] freq = new int[26];  // New frequency array
        int distinct = 0;
        int ans = 0;

        //first window and Expand first 3 characters
        for (int i = 0; i < 3; i++) {
            int index = s.charAt(i) - 'a';
            if (freq[index] == 0){
                distinct++;
            }
            freq[index]++;
        }
        if (distinct == 3){
            ans++;
        }

        //slide the window
        for (int j = 3; j < s.length(); j++) {
            // Shrink: remove leftmost character
            int remove = s.charAt(j - 3) - 'a';
            freq[remove]--;
            if (freq[remove] == 0){
                distinct--;
            }

            // Expand: add new rightmost character
            int add = s.charAt(j) - 'a';
            if (freq[add] == 0){
                distinct++;
            }
            freq[add]++;
            if (distinct == 3){
                ans++;
            }
        }
        return ans;
    }

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public static int lengthOfLongestSubstring(String s) {
//        int maxLen = 0;
//        int left = 0;
//
//        HashSet<Character> set = new HashSet<>();
//
//        //Expand the window
//        for (int right = 0; right < s.length(); right++){
//
//            //Shrink while the window is invalid
//            while (set.contains(s.charAt(right))){
//                set.remove(s.charAt(left));
//                left++;
//            }
//            //Add the current character
//            set.add(s.charAt(right));
//
//            //Update the answer (window is valid)
//            maxLen = Math.max(maxLen, right - left + 1);
//        }
//        return maxLen;

        int maxLen = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If character is already present, move left pointer
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            // Store/update latest index of character
            map.put(ch, right);

            // Update answer
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    //https://leetcode.com/problems/permutation-in-string/description/?envType=problem-list-v2&envId=sliding-window
    public static boolean checkInclusion(String s1, String s2){

        if (s1.length() > s2.length()) {
            return false;
        }

        //freq Array
        int[] freqS1 = new int[26];
        int[] freqWindow = new int[26];

        // 1. Build freqS1
        for (int i = 0; i < s1.length(); i++) {
            int idx = s1.charAt(i) - 'a';
            freqS1[idx]++;
        }

        // 2. Build first window
        for (int i = 0; i < s1.length(); i++) {
            int window = s2.charAt(i) - 'a';
            freqWindow[window]++;
        }

        // 3. Compare first window
        if(Arrays.equals(freqS1, freqWindow)){
            return true;
        }

        // 4. Slide the window
        for (int i = s1.length(); i < s2.length(); i++) {
           int remove = s2.charAt(i - s1.length()) - 'a';
           freqWindow[remove]--;

           int add = s2.charAt(i) - 'a';
           freqWindow[add]++;

            // 5. Compare each window
           if (Arrays.equals(freqS1, freqWindow)){
               return true;
           }
        }
        // 6. Return false
        return false;
    }
    }