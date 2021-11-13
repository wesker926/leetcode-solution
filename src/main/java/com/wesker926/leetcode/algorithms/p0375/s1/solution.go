// Package s1
// @author: wesker.gh
// @date: 2021/11/13
// @description: dp
package s1

func getMoneyAmount(n int) int {
	dp := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]int, n+1)
	}

	for y := 2; y <= n; y++ {
		for x := y - 1; x > 0; x-- {
			min := dp[x][y-1] + y
			for i := x; i < y; i++ {
				min = minInt(min, maxInt(dp[x][i-1], dp[i+1][y])+i)
			}
			dp[x][y] = min
		}
	}
	return dp[1][n]
}

func minInt(i, j int) int {
	if i <= j {
		return i
	}
	return j
}

func maxInt(i, j int) int {
	if i >= j {
		return i
	}
	return j
}
