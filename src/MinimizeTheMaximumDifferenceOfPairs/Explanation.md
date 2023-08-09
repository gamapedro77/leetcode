
## The Problem

You are given a 0-indexed integer array `nums` and an integer `p`. Find `p` pairs of indices of `nums` such that the maximum difference amongst all the pairs is minimized. Also, ensure no index appears more than once amongst the` p` pairs.

Note that for a pair of elements at the index `i` and `j`, the difference of this pair is `|nums[i] - nums[j]|`, where `|x| `represents the absolute value of `x`.

Return the minimum maximum difference among all `p` pairs. We define the maximum of an empty set to be zero.

## Explanation

Okay so this one took me some understading, I basically at first could not solve on my own without making a O(n*n) algorithm, so I decided to take a look at how people usually approach this problem and I think I stumbled upon people that also did not understood how to solve this but were just copying other peoples solutions so I started working my way into the algorithm with a pen and paper to actually understand not just HOW but WHY it worked.

## The Algorithm

The reason why I got so confused with the supposedly best solution of this problem is that people kept calling it "binary search with greedy pairing" and when I looked at the code I didn't actually see any binary search going on but they were using the convention names for the variables we usually have in a binary search, so it threw me off a lot. We had a `int high` an `int low` and also an `int mid` but what they meant with binary search here is not binary search inside the array nums, is binary search of the maximum difference possible to make with the amount of pairs that we had.<br>
So in human words what we are going to do is basically sort our array `nums` and get the largest difference that we can which is basically going to be `nums[length -1] - nums[0]` call it `h` and then we are going to get our smallest possible difference which we are just going to call `l` for now. <br> 
Now we have to pick a middle point, and we are going to do that by sum `l` with `h` and divide it by 2 and call it `m`, and then we are going to ask the computer "hey computer! *Can you make `p` pairs with absolute difference smaller or equal to this difference `m`?"*. <br>
And if our little computer fella responds with a *Yes, I can!*  we are going to say: *"Great, buddy! Now try again but with `h = m` please"*. <br>
Now if our computer responds with *"No, I cannot!"* we are going to go *"Hmmmm, then try again but with `l = m + 1`"*<br>
And in either of these cases the computer will recalculate our middle point `m` again with our new values of either `l` or `h` and then try again.<br>
If you think about it we are basically making guesses of what the maximum difference probably is everytime and checking if we are above or below the correct answear. And we are going to do that until we hit the bullseye which basically means until `l` > `h` .<br>

Now for the reason why this algorithm confused me so much is probably because I couldn't foresee how the values of `m` would fluctuate throught the process so let me give you the thought process with an example.

Basically for the array `nums` = `[1, 1, 2, 3, 7, 10]`, and `p` = `2` already sorted for us in this case.  So first our `l` = 0; and our `h` = `10 - 1` = `9`; which means `m` = `9 / 2` but sine we don't care for decimal points `m` = `4`;<br>

Now we politely ask, *"Computer, can you make 2 pairs of numbers with difference smaller than `m`"* and yes, the computer can do that, so you now know for sure that your `m` is larger than the answear, so what you do? You bring it down, baby! And we do that here by saing that our new maximum difference is equal to this `m` so `h = m`;<br>

With this new value of `h` we make a new guess of `m` and try again, in this case our new guess would be `m = 2`;

So you see, whenever you can make a pair it means `m` should decrease, and whenever you cannot make a pair `m` should increase. This formula does that for us `m = (l + h) / 2` as long as we update the values of `l` and `h` accordingly.

Now for the checking if we can make `p` pairs of numbers such that their `p2 - p1 <= m` part, this is a much much simpler, we start by initializing a counter `c` = `0`
and then we loop through `nums` checking consecutive pairs `nums[i + 1] - nums[i] <= m` we just have to be careful to not check two pairs that have the same index, remember the problem:  `"ensure no index appears more than once amongst the` p` pairs."` so what we do to guarantee we are not getting the same index twice:  If our current pair fits our criteria we now check the next `index + 1` else we just check the next `index`, and then we return `c >= p` and thats it.

At the end of that we just return `l` and there is your answear.

