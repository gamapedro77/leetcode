## The Problem

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is `[nums[k]`, `nums[k+1]`, ..., `nums[n-1]`, `nums[0]`, `nums[1]`, ..., `nums[k-1]] `(0-indexed). For example, `[0,1,2,4,5,6,7]` might be rotated at pivot index 3 and become `[4,5,6,7,0,1,2]`.

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

## The Abstraction

Basically given an array of sorted numbers rotated by an unknown pivot our goal is to find the target number and return its index.
This problem is written in a way to make it look more complicated than it actually is, because at first it looks like you will need to figure out a way to compensate for this unkown pivot *K* in order to implement any search algorithm that is not a linear search, but turns out you can actually implement a classical Binary Search with one simple tweak.

#### The Tweak

It took me a while to understand this, and I would not have been able to figure it out at first glance on my own, hopefully some gentle folks explained it to me. Basically when you do this kind of rotation to a sorted array it retains one very important propertie of sorted arrays which is that we know for sure that at least one of its halfs will always be sorted, so for example `[5,6,7,0,1,2,3,4]` the right half `[1,2,3,4]` is sorted. So what we do is simply check which side is the sorted one and check there first.

## The Pseudo-Code

1- We initialize two integers to keep track of the *low* and *high* values: `int low = 0;int high = nums.length - 1;`<br>
2 - Now we do a while loop as long as low is less or equal than high;<br>
3 - We get our mid point of the array by doing: `int mid = Math.abs(low + high) / 2;`<br>
4 - We check if the mid point is our target and if it is we return *mid* here.<br>
5 - We now move on to checking if the left half of the array is sorted by checking if `nums[low]` is less or equal than `nums[mid]`.<br>
5.1 - If it is sorted we check if our target should be located in here by looking if our target is greater than or equal `nums[low]` and less than or equal to `nums[mid]` and if it is located in this section then we make `high = mid - 1` so that we look for it in here.<br>
5.2 - If it isn't sorted then it should be on the other half so we make `low = mid + 1`.<br>
6 - We can just go *else* now because we already know that if the left half isn't sorted then the right half must be.<br>
6.1 - Now we check if the target should be here using the same logic: our target should be greater or equal than `nums[mid]` and less than `nums[high]` if it is then we make `low = mid + 1`.<br>
6.2 - Else we make `high = mid - 1;`<br>
7 - We now return -1 because this must mean that the target is NOT inside this array list.
