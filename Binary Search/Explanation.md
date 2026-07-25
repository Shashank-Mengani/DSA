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