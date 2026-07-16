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