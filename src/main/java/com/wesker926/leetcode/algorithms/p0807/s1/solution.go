// Package s1
// @author: wesker.gh
// @date: 2021/12/13
// @description: 模拟遍历
package s1

func maxIncreaseKeepingSkyline(grid [][]int) int {
	maxXs, maxYs := make([]int, len(grid)), make([]int, len(grid))
	for i := range grid {
		for j := range grid[i] {
			maxXs[i] = maxInt(maxXs[i], grid[i][j])
			maxYs[j] = maxInt(maxYs[j], grid[i][j])
		}
	}
	sum, n := 0, 0
	for i := range grid {
		for j := range grid[i] {
			n = maxInt(grid[i][j], minInt(maxXs[i], maxYs[j]))
			sum += n - grid[i][j]
		}
	}
	return sum
}

func maxInt(i, j int) int {
	if i >= j {
		return i
	}
	return j
}

func minInt(i, j int) int {
	if i <= j {
		return i
	}
	return j
}
