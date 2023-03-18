// 有序数组 且 无重复元素
// 二分搜索

public class Leetcode704 {
   // public static int search(int[] nums, int target) {
   //     for(int i = 0; i < nums.length; i++){
   //         if (nums[i] == target){
   //             return i;
   //         }
   //     }
   //     return -1;
   // }

    public static int search(int[] nums, int target){
       int left = 0;
       int right = nums.length - 1;
        while (left <= right){
            int middle = (left + right)/2;
            if(nums[middle] > target){
                right = middle - 1;
            }
            else if (nums[middle] < target){
                left = middle + 1;
            }
            else {
                return middle;
            }
        }
        return -1;
    }
    public static void main(String[] args){
       // int[] nums = {-1,0,3,5,9,12};
       // int target = 9;
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        System.out.println(search(nums, target));
    }
}