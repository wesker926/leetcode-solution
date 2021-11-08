// Package s1
// @author: wesker.gh
// @date: 2021/11/4
// @description: 二分
package s1

func isPerfectSquare(num int) bool {
	if num == 1 {
		return true
	}

	if num < 4 {
		return false
	}

	l, r, m, s := 2, num/2, 0, 0
	for l <= r {
		// go语言中，int在64位系统下是int64
		m = l + (r-l)/2
		s = m * m
		if num == s {
			return true
		}

		if num > s {
			l = m + 1
		} else {
			r = m - 1
		}
	}
	return false
}
