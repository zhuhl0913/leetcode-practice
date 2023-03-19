// 这道题主要是要注意数据长短，注意middle平方要用long
// int -> -2^31 - 2^31 - 1
// int -> -2^63 - 2^63 -1
public class leetcode69 {
    public int mySqrt(int x) {
        // 三种情况
        int left = 0;
        int right = x;
        int ans = 0;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (x == (long)middle * middle) {    // middle平方恰好等于x，返回middle即可
                ans = middle;
                return ans;
            } else if (x > (long)middle * middle) {    // middle的平方绝对小于x，middle有可能是ans，但接下来考虑middle右边的区间
                ans = middle;
                left = middle + 1;
            } else {    // x < middle * middle,这种情况下ans必然小于middle，即考虑middle左边的区间
                right = middle - 1;
            }
        }
        return ans;
    }
}
