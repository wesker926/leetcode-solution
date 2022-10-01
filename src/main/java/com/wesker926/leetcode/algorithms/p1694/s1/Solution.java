package com.wesker926.leetcode.algorithms.p1694.s1;

/**
 * @author wesker.gh
 * @date 2022/10/1
 * @description 模拟
 * 大佬用正则可以炫技，但是不要在生产环境用
 */
public class Solution {
    public String reformatNumber(String number) {
        int[] nums = new int[number.length()];
        int idx = 0, cur;
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                nums[idx++] = c - '0';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (cur = 0; cur < idx - 4 || (idx % 3 == 0 && cur < idx); cur += 3) {
            sb.append(nums[cur]).append(nums[cur + 1]).append(nums[cur + 2]).append('-');
        }
        for (; cur < idx; cur += 2) {
            sb.append(nums[cur]).append(nums[cur + 1]).append('-');
        }
        return sb.substring(0, sb.length() - 1);
    }
}
