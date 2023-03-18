public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int middle;
        while (left <= right){
            middle = left + (right - left)/2; // 防止溢出，主要是left+right的时候可能会有溢出
            if (nums[middle] < target){
                left = middle + 1;
            }
            else if (nums[middle] > target){
                right = middle - 1;
            }
            else{
                return middle;
            }
        }
        // 目标值在数组所有元素之前  [0, -1]
        // 目标值等于数组中某一个元素  return middle;
        // 目标值插入数组中的位置 [left, right]，return  right + 1
        // 目标值在数组所有元素之后的情况 [left, right]， 因为是右闭区间，所以 return right + 1
        return right + 1;
    }
}
