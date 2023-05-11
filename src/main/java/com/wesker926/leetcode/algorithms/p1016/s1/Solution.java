package com.wesker926.leetcode.algorithms.p1016.s1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2023/5/11
 * @description 暴力哈希
 * O(mlogn)
 * 实际上只需要判断[2 ^ k, n]和[n / 2 + 1, 2 ^ k - 1]，其中k为n的二进制长度减一，时间复杂度可达到O(m)
 * 参考：
 * https://leetcode.cn/problems/binary-string-with-substrings-representing-1-to-n/solutions/2265097/san-chong-suan-fa-cong-bao-li-dao-you-hu-nmtq/
 */
public class Solution {
    public boolean queryString(String s, int n) {
        Set<Integer> set = new HashSet<>();
        for (int l = 1; l <= Integer.toBinaryString(n).length(); l++) {
            for (int mask = (1 << l) - 1, num = 0, i = 0; i < s.length(); i++) {
                num = ((num << 1) | (s.charAt(i) - '0')) & mask;
                if (num <= n && num > 0) {
                    set.add(num);
                }
            }
        }
        return set.size() == n;
    }
}
