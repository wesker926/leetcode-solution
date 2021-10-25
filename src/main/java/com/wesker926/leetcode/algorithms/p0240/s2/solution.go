// Package s2
// @author: wesker.gh
// @date: 2021/10/25
// @description: 双维度二分
package s2

func searchMatrix(matrix [][]int, target int) bool {
	l, r, t, b, mode := 0, len(matrix[0])-1, 0, len(matrix)-1, true
	for l <= r && t <= b {
		b, l = binary(matrix, l, r, t, b, target, mode)
		if b >= t && l <= r && matrix[b][l] == target {
			return true
		}
		mode = !mode
	}
	return false
}

func binary(matrix [][]int, l, r, t, b, tar int, mode bool) (int, int) {
	var m1, m2, v int
	for l <= r && t <= b {
		if mode {
			m1, m2 = b, l+(r-l)/2
		} else {
			m1, m2 = t+(b-t)/2, l
		}

		v = matrix[m1][m2]
		if v == tar {
			return m1, m2
		}

		if mode {
			if v > tar {
				r = m2 - 1
			} else {
				l = m2 + 1
			}
		} else {
			if v > tar {
				b = m1 - 1
			} else {
				t = m1 + 1
			}
		}
	}
	return b, l
}
