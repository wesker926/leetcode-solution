// Package s1
// @author: wesker.gh
// @date: 2021/12/18
// @description: dfs
package s1

var (
	m, n   int
	matrix [][]byte
)

func countBattleships(board [][]byte) int {
	count := 0
	matrix = board
	m, n = len(board), len(board[0])
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if matrix[i][j] != '.' {
				count++
				dfs(i, j)
			}
		}
	}
	return count
}

func dfs(i, j int) {
	if i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] == '.' {
		return
	}
	matrix[i][j] = '.'
	dfs(i+1, j)
	dfs(i-1, j)
	dfs(i, j+1)
	dfs(i, j-1)
}
