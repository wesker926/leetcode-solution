// Package s1
// @author: wesker.gh
// @date: 2021/11/7
// @description: 最小值
package s1

func maxCount(m int, n int, ops [][]int) int {
	min := []int{m, n}
	for _, op := range ops {
		if op[0] < min[0] {
			min[0] = op[0]
		}
		if op[1] < min[1] {
			min[1] = op[1]
		}
	}
	return min[0] * min[1]
}
