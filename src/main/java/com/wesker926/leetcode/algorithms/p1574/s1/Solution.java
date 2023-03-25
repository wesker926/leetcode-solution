package com.wesker926.leetcode.algorithms.p1574.s1;

/**
 * @author wesker.gh
 * @date 2023/3/25
 * @description 同向双指针（不定长滑动窗口）
 * 设左非递减部分的右端点为i，右非递减部分的左端点为j，显然要满足arr[i] <= arr[j]
 * 如果i向右移动，arr[j - 1] < arr[i] <= arr[i + 1]，显然j不可能向左移动，因此具备了同向双指针的条件
 * <p>
 * 变种题：
 * 1.至少修改多少个数，使得修改后的数组是非递减的？（等价于删除一个最短的子序列）
 * 先计算最长非递减子序列，再用n减去这个子序列的长度，就得到了删除子序列的最短长度。
 * <p>
 * 2.至少修改多少个数，使得修改后的数组是严格递增的？（修改与删除不等价）
 * arr[i] − arr[j] >= i − j 可变形为 arr[i] − i >= arr[j] − j
 * 故构造b[i] = arr[i] − i，求b的最长非递减子序列，再用n减去这个子序列的长度，就得到了答案。
 * 为什么不能直接求arr的最长严格递增子序列？试试arr = [1,2,2,3]，必须修改2个数才能变成严格递增数组。
 * 注意在严格递增情况下，修改和删除不是等价的。
 */
public class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, i = 0, j = n - 1, ans;
        for (; j >= 1 && arr[j] >= arr[j - 1]; j--) ;
        if ((ans = j) != 0) {
            for (; i == 0 || arr[i] >= arr[i - 1]; i++) {
                for (; j < n && arr[j] < arr[i]; j++) ;
                ans = Math.min(ans, j - i - 1);
            }
        }
        return ans;
    }
}
