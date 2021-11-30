// Package s1
// @author: wesker.gh
// @date: 2021/11/30
// @description: 计算数与位
package s1

import "math"

func findNthDigit(n int) int {
	d := 1
	for i := 9; n > i*d; i, n, d = i*10, n-i*d, d+1 {
	}
	cur := int(math.Pow(float64(10), float64(d-1))) + (n-1)/d
	pos := d - ((n - 1) % d) - 1
	for ; pos > 0; pos, cur = pos-1, cur/10 {
	}
	return cur % 10
}
