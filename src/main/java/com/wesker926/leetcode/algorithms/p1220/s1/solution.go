// Package s1
// @author: wesker.gh
// @date: 2022/1/17
// @description: DP
package s1

var (
	mod  = 1000000007
	next = [][]int{{1, 2, 4}, {0, 2}, {1, 3}, {2}, {2, 3}}
)

func countVowelPermutation(n int) int {
	dp, cur, pre := [][]int{{1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}}, 1, 0
	for i := 2; i <= n; i++ {
		for j, nxt := range next {
			dp[cur][j] = 0
			for _, k := range nxt {
				dp[cur][j] += dp[pre][k]
			}
			dp[cur][j] %= mod
		}
		cur, pre = pre, cur
	}

	ans := 0
	for _, count := range dp[pre] {
		ans = (ans + count) % mod
	}
	return ans
}
