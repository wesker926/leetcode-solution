// Package s1
// @author: wesker.gh
// @date: 2022/2/24
// @description: 模拟
package s1

func findBall(grid [][]int) []int {
	m, n := len(grid), len(grid[0])
	ans := make([]int, n)
	for k, i, j, v := 0, 0, 0, 0; k < n; k++ {
		for i, j, v = 0, k, 0; i < m; i++ {
			v = grid[i][j]
			j += v
			if j < 0 || j >= n || grid[i][j] != v {
				j = -1
				break
			}
		}
		ans[k] = j
	}
	return ans
}
