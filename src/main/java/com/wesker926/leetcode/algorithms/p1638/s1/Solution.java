package com.wesker926.leetcode.algorithms.p1638.s1;

/**
 * @author wesker.gh
 * @date 2023/3/27
 * @description DP
 * 通过DP计算以当前位置结束的最长前后缀
 * 然后(dpl[-1] + 1) * (dpr[+1] + 1)即为当前位置（字符不同）所贡献的数
 * <p>
 * 1.枚举是最基本的解法
 * 2.当前解法中，转移方程可参考最长公共子序列
 * 3.可以从最长公共前缀LCP的角度进行DP，然后当前位置cur往后移动LCP[cur]+1后的新LCP值+1即为当前贡献的值
 * 4.DP的双层循环可以通过错位start来模拟，模拟过程中统计当前的LCP，ans加上之前的LCP，如果遇到字符不同，就替换LCP的cur和pre
 * 上述DP的思路本质上是一样的
 */
public class Solution {
    public int countSubstrings(String s, String t) {
        int m = s.length(), n = t.length(), ans = 0;
        int[][] dpl = new int[m + 1][n + 1], dpr = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dpl[i + 1][j + 1] = s.charAt(i) == t.charAt(j) ? dpl[i][j] + 1 : 0;
                dpr[m - 1 - i][n - 1 - j] = s.charAt(m - 1 - i) == t.charAt(n - 1 - j) ? dpr[m - i][n - j] + 1 : 0;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    ans += (dpl[i][j] + 1) * (dpr[i + 1][j + 1] + 1);
                }
            }
        }
        return ans;
    }
}
