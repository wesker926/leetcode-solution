// Package s1
// @author: wesker.gh
// @date: 2022/2/17
// @description: DP
package s1

var POS = [][]int{{-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}}

func knightProbability(n int, k int, row int, column int) float64 {
	dp := [][]float64{make([]float64, n*n), make([]float64, n*n)}
	dp[0][column+row*n] = 1
	for i := 0; i < k; i++ {
		for j := 0; j < len(dp[1]); j++ {
			dp[1][j] = 0
			nx, ny := j/n, j%n
			for _, p := range POS {
				x, y := nx+p[0], ny+p[1]
				if x >= 0 && y >= 0 && x < n && y < n {
					dp[1][j] += dp[0][y+x*n]
				}
			}
			dp[1][j] /= 8
		}
		dp[0], dp[1] = dp[1], dp[0]
	}
	ans := float64(0)
	for _, v := range dp[0] {
		ans += v
	}
	return ans
}
