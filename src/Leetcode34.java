// 这道题应该是704和35的结合版，作为第一版代码我写的暴力解法，但这忽略了题目中说的一定要O(logN)的算法复杂度解答
// 第二版我结合35，先后查找一下左边界和有边界
// 目前采用的是分别找左右边界，关键在于if else的判定上做了修改
// 我还看到一种解法，感觉也是不错的，而且容易想到：
// 1. 正常binary search查询数组中是否存在target，不存在直接返回{-1,-1}即可
// 2. 存在的话，会找到一个是target的元素的下标，然后左右滑动下标确认相同元素的区间即可，具体实现用一下while就行,while部分复杂度应该是O(1)的
public class Leetcode34 {
 //   public int[] searchRange(int[] nums, int target) {
 //       // 暴力解法
 //       int start = -1;
 //       int end = -1;
 //       for (int i = 0; i < nums.length; i++){
 //          if(nums[i] == target){
 //              start = i;
 //              break;
 //          }
 //       }
 //       if(start == -1){
 //           return new int[] {-1,-1};
 //       }
 //       for(int j = start; j < nums.length; j++){
 //           if(nums[j] != target){
 //               end = j - 1;
 //               break;
 //           }
 //       }
 //       int[] ans = {start, end} ;
 //       return ans;
 //   }

    /********************************************************************************************************/
    public int[] searchRange(int[] nums, int target){
        int leftBorder = searchLeftBorder(nums, target);
        int rightBorder = searchRightBorder(nums, target);
        // 情况一：target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
        if(leftBorder == -2 | rightBorder == -2){return new int[] {-1, -1};}
       // 情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
       // 情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
        // 小妙招：先考虑情况三，再把剩下的当作情况二
        // 情况三：
        if(rightBorder - leftBorder >= 2){return new int[] {leftBorder + 1, rightBorder - 1};}
        return new int[] {-1, -1};
    }

    int searchRightBorder(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int rightBorder = -2;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else { // 这里将剩余两种情况一起考虑了，对于==的情况，让rightBorder=left,使得情况三中，右边界在实际右边界的更右边一格
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }
    int searchLeftBorder(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int leftBorder = -2;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else { // 这里将剩余两种情况一起考虑了，对于==的情况，让leftBorder=right,使得情况三中，左边界在实际左边界的更左边一格
                right = middle - 1;
                leftBorder = right;
            }
        }
        return leftBorder;
    }
}
