// Package s2
// @author: wesker.gh
// @date: 2021/11/19
// @description: 贪心
package s2

func integerReplacement(n int) int {
	var c int
	for n > 1 {
		if n&1 == 0 {
			n >>= 1
			c++
			continue
		}

		if (n>>1)&1 == 0 {
			n >>= 1
		} else {
			if n == 3 {
				return c + 2
			}
			n = (n >> 1) + 1
		}
		c += 2
	}
	return c
}
