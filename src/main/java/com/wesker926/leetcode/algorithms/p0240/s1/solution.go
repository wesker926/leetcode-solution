// Package s1
// @author: wesker.gh
// @date: 2021/10/25
// @description: BST
package s1

func searchMatrix(matrix [][]int, target int) bool {
	l, r := len(matrix[0])-1, 0
	for l >= 0 && r < len(matrix) {
		if matrix[r][l] == target {
			return true
		} else if matrix[r][l] > target {
			l--
		} else {
			r++
		}
	}
	return false
}
