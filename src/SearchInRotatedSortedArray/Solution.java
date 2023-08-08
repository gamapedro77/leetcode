package SearchInRotatedSortedArray;

public class Solution {
    public static void main(String[] args) throws Exception {
       System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    }

   public static int search(int[] nums,int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = Math.abs((low + high) / 2);
            //we found it
            if(nums[mid] == target) {
                return mid;
            }
            //left half is sorted
            if(nums[low] <= nums[mid]) {
                //target should be located within the left half
                if(target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                }
                //target should be located within the right half
                else {
                    low = mid + 1;
                }
            } else {
                if(target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
