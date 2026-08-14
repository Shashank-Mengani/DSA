# 1. Binary Search
## Idea
Maintain two pointers, `start` and `end`.
- Calculate the middle index.
  - If the middle element is the target, return its index.
  - If the target is greater, move `start` to `mid + 1`.
  - If the target is smaller, move `end` to `mid - 1`.
  - Repeat until the target is found or the search space becomes empty.
  - Return `-1` if the target is not found.

## Complexity
Time: O(log n),
Space: O(1)

# 2. Search Insert Position
## Idea
Maintain two pointers, `start` and `end`.
- Calculate the middle index.
  - If the middle element is the target, return its index.
  - If the target is greater, move `start` to `mid + 1`.
  - If the target is smaller, move `end` to `mid - 1`.
  - Continue until the search space becomes empty.
  - Return `start`, which is the correct position to insert the target while keeping the array sorted.

## Complexity
Time: O(log n),
Space: O(1)

# 3. Sqrt(x)
## Idea
Maintain two pointers, `start` and `end`.
- Calculate the middle value.
  - If `mid * mid` is equal to the target, return `mid`.
  - If `mid * mid` is smaller than the target, move `start` to `mid + 1`.
  - If `mid * mid` is greater than the target, move `end` to `mid - 1`.
  - Continue until the search space becomes empty.
  - Return `end`, which is the correct integer square root of the target value.

## Complexity
Time: O(log n),
Space: O(1)

# 4.Lower Bound
## Idea
Maintain two pointers, `start` and `end`.
- Calculate the middle index.
  - If the middle element is greater than or equal to the target, move end to mid.
  - If the middle element is smaller than the target, move start to mid + 1.
  - Repeat until start and end meet.
  - Return start, which is the first index where the element is greater than or equal to the target.
  
## Complexity
Time: O(log n),
Space: O(1)