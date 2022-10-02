package com.wesker926.leetcode.algorithms.p0777.s1;

/**
 * @author wesker.gh
 * @date 2022/10/2
 * @description 双指针
 * 脑筋急转弯
 * L可以向左归拢，R可以向右归拢
 * 如果忽略X后对应的位的字母相同，且end的L比start的更靠左，R更靠右，则可以变换
 */
public class Solution {
    public boolean canTransform(String start, String end) {
        for (int i = 0, j = 0; i < start.length() || j < end.length(); ) {
            if (i < start.length() && start.charAt(i) == 'X') {
                i++;
                continue;
            }
            if (j < end.length() && end.charAt(j) == 'X') {
                j++;
                continue;
            }
            if (i >= start.length() || j >= end.length()
                    || start.charAt(i) != end.charAt(j)
                    || (start.charAt(i) == 'L' && i < j)
                    || (start.charAt(i) == 'R' && i > j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
