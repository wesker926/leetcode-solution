// Package s1
// @author: wesker.gh
// @date: 2021/11/11
// @description: dp
package s1

func kInversePairs(n int, k int) int {
	if k == 0 {
		return 1
	}

	dp := [][]int{make([]int, k+1), make([]int, k+1)}
	dp[0][0], dp[1][0] = 1, 1
	max, cur := 0, 1
	for i := 1; i <= n; i++ {
		max = minInt(i*(i-1)/2, k)
		for j := 1; j <= max; j++ {
			dp[cur][j] = dp[cur][j-1] + dp[1-cur][j]
			if j >= i {
				dp[cur][j] -= dp[1-cur][j-i]
			}
			dp[cur][j] = mod(dp[cur][j])
		}
		cur = 1 - cur
	}
	return dp[1-cur][k]
}

func minInt(i, j int) int {
	if i <= j {
		return i
	}
	return j
}

func mod(i int) int {
	if i >= 1000000007 {
		return i - 1000000007
	} else if i < 0 {
		return i + 1000000007
	}
	return i
}
