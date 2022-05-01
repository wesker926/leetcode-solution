// Package s1
// @author: wesker.gh
// @date: 2022/4/8
// @description: 螺旋遍历（同主站-p0054）
package s1

func spiralOrder(matrix [][]int) []int {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return []int{}
	}
	m, n, x, y, ans := len(matrix), len(matrix[0]), 0, -1, make([]int, 0)
	steps := [][]int{{0, 1, n}, {1, 0, m - 1}, {0, -1, n - 1}, {-1, 0, m - 2}}
	for i := 0; steps[i][2] > 0; i = (i + 1) % 4 {
		step := steps[i]
		for j := 0; j < step[2]; j++ {
			x += step[0]
			y += step[1]
			ans = append(ans, matrix[x][y])
		}
		step[2] -= 2
	}
	return ans
}
