// Package s1
// @author: wesker.gh
// @date: 2021/12/7
// @description: dfs
package s1

var (
	m, n, ti, tj int
	g            [][]int
	v            [][]bool
	pos          = [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}
)

func colorBorder(grid [][]int, row int, col int, color int) [][]int {
	g = grid
	m, n, ti, tj = len(g), len(g[0]), row, col
	v = make([][]bool, m)
	for i, _ := range v {
		v[i] = make([]bool, n)
	}
	dfs(row, col)

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if v[i][j] && check(i, j) {
				grid[i][j] = color
			}
		}
	}
	return grid
}

func dfs(i, j int) {
	if i < 0 || i >= m || j < 0 || j >= n || v[i][j] || g[i][j] != g[ti][tj] {
		return
	}

	v[i][j] = true
	for _, p := range pos {
		dfs(i+p[0], j+p[1])
	}
}

func check(i, j int) bool {
	if i == 0 || i == m-1 || j == 0 || j == n-1 {
		return true
	}

	for _, p := range pos {
		if !v[i+p[0]][j+p[1]] {
			return true
		}
	}

	return false
}
