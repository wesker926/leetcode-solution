// Package s1
// @author: wesker.gh
// @date: 2021/11/5
// @description: dp
package s1

func longestSubsequence(arr []int, difference int) int {
	max, cur, pre, dp := 0, 0, 0, make([]int, 20001)
	for _, i := range arr {
		cur = i + 10000
		pre = cur - difference
		if pre >= 0 && pre <= 20000 {
			dp[cur] = dp[pre] + 1
		} else {
			dp[cur] = 1
		}

		if max < dp[cur] {
			max = dp[cur]
		}
	}
	return max
}
