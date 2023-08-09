package MinimizeTheMaximumDifferenceOfPairs;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(minimizeMax(new int[] {10,1,2,7,1,3}, 2));
    }
    public  static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int length = nums.length;
        int maximumDiff = nums[length - 1] - nums[0];
        int minimumDiff = 0;

        while(minimumDiff < maximumDiff) {
            int middleDiff = (minimumDiff + maximumDiff) / 2;
            if(canFormPairs(nums, middleDiff, p)) {
                maximumDiff = middleDiff;
            } else {
                minimumDiff = middleDiff + 1;
            }
        }
        return minimumDiff;
        
    }

    public static boolean canFormPairs(int[] nums, int middleDiff, int p) {
        int count = 0;
        for(int i = 0; i < nums.length - 1 && count < p;) {
            if(nums[i + 1] - nums[i] <= middleDiff) {
                count++;
                i+=2;
            } else {
                i++;
            }
        }
        return count >= p;
    }
}
