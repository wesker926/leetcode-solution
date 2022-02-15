// Package s1
// @author: wesker.gh
// @date: 2022/2/15
// @description: 遍历
package s1

func luckyNumbers(matrix [][]int) []int {
	m, n := len(matrix), len(matrix[0])
	ans, row, col := make([]int, 0), make([]int, m), make([]int, n)
	for i := 0; i < m; i++ {
		row[i] = -1
		for j := 0; j < n; j++ {
			row[i] = min(matrix, row[i], i, j)
			col[j] = max(col[j], matrix[i][j])
		}
	}
	for i, j := range row {
		if matrix[i][j] == col[j] {
			ans = append(ans, col[j])
		}
	}
	return ans
}

func min(matrix [][]int, oj, i, j int) int {
	if oj < 0 || matrix[i][oj] > matrix[i][j] {
		return j
	}
	return oj
}

func max(i, j int) int {
	if i >= j {
		return i
	}
	return j
}
