# 1. Maximum Average Subarray I
## Idea
Maintain a window of size `k`.
- Calculate the sum of the first `k` elements.
- Add the next element when moving the window.
- Remove the element that leaves the window.
- Keep track of the maximum window sum.
- Divide the maximum sum by `k` to get the maximum average.

## Complexity
Time: O(n),
Space: O(1)


# 2. Maximum Number of Vowels in a Substring of Given Length
## Idea
Maintain a window of size k.
- Add right character.
- If it is a vowel, increase count.
- Remove left character when window exceeds k.
- Track maximum vowels.

## Complexity
Time: O(n),
Space: O(1)

# 3. Substrings of Size Three with Distinct Characters
## Idea
Maintain a window of size 3.
- Build the first window using a frequency array.
- Count the number of distinct characters.
- If distinct == 3, increment the answer.
- Slide the window:
    - Remove the left character.
    - Add the right character.
    - Update the distinct count.
- If distinct == 3, increment the answer.

## Complexity
Time: O(n),
Space: O(1)

# 4. Longest Substring Without Repeating Characters
## Idea
Maintain a variable-size sliding window.
- Expand the window by adding the right character.
- Use a frequency array/map to track characters in the current window.
- If a duplicate character appears, shrink the window:
  - Remove the left character.
  - Update its frequency.
  - Continue shrinking until all characters are unique.
- Track the maximum window length.
- Update the answer with the current valid window size.

## Complexity
Time: O(n),
Space: O(1) (using frequency array of size 128)

# 5. Permutation in String
## Idea
Maintain a fixed-size sliding window of length `s1.length()`.
- Build the frequency array for `s1`.
- Build the first window in `s2` using another frequency array.
- Compare both frequency arrays.
- Slide the window:
  - Remove the left character.
  - Add the right character.
  - Update the window frequency array.
  - Compare both frequency arrays.
- If the frequency arrays match, return `true`.
- If no window matches, return `false`.

## Complexity
Time: O(n),
Space: O(1)

# 6. Minimum Size Subarray Sum
## Idea
Maintain a sliding window.
- Expand the window by adding the next element.
- Once the window sum is greater than or equal to `target`, update the minimum window length.
- Remove the leftmost element while the window is still valid.
- Repeat until the end of the array.
- Return the minimum window length, or `0` if no valid subarray exists.

## Complexity
Time: O(n),  
Space: O(1)

# 7. Longest Repeating Character Replacement
## Idea
Maintain a variable-size sliding window.
- Expand the window by adding the next character and update its frequency.
- Track the maximum frequency of any character inside the current window.
- The window is valid if:
  - window size - max frequency <= k
    because the remaining characters are the ones we need to replace.
- If the window becomes invalid, move the left pointer and remove characters until the window becomes valid again.
- After making the window valid, update the maximum window length.
- Repeat until the end of the string.
- Return the maximum length found.

## Complexity
Time: O(n),  
Space: O(1)  // fixed frequency array of size 26
