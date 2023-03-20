public class Leetcode27 {
   // public int removeElement(int[] nums, int val) {
   //     // 暴力法：第一遍遍历数组确定非重复元素数量，然后新建一个数组
   //     // 再次遍历nums，将非重复元素存到新数组中
   //     // 将遍历新数组，将新数组中的值一个个存回到nums中
   //     int counting = 0;
   //     for(int i = 0; i < nums.length; i++){
   //         if(nums[i] != val){
   //             counting++;
   //         }
   //     }

   //     int[] tempArray = new int[counting];

   //     int j = 0;
   //     for(int i = 0; i < nums.length; i++){
   //        if(nums[i] != val) {
   //            tempArray[j] = nums[i];
   //            j++;
   //        }
   //     }

   //     for(int i = 0; i < tempArray.length; i++){
   //         nums[i] = tempArray[i];
   //     }
   //     return counting;
   // }
    // 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
    // 因此这个O(n)复杂度的”暴力解法“实际上是不可行的，关键在于原地修改输入数组



   // public int removeElement(int[] nums, int val) {
   // //  两层for循环
   //     int counting = 0;
   //     for (int i = 0; i < nums.length; i++){
   //         if(nums[counting] != val){
   //             counting++;
   //         }
   //         else{
   //            for(int j = counting; j < nums.length - 1; j++){
   //                nums[j] = nums[j+1];
   //            }
   //         }
   //     }
   //     return counting;
   // }

    public int removeElement(int[] nums, int val){
        // 双指针，一快一慢，快指针遍历nums，慢指针指向新数组最后一个元素
        int low = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != val){
                nums[low] = nums[fast];
                low++;
            }
        }
        return low;
    }
}
