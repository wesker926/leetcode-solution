// Package s1
// @author: wesker.gh
// @date: 2022/4/14
// @description: 逐位统计
package s1

func countDigitOne(n int) int {
	ans := 0
	for i := 1; n >= i; i *= 10 {
		d, m := n/i, n%i
		ans += d / 10 * i
		if t := d % 10; t > 1 {
			ans += i
		} else if t == 1 {
			ans += m + 1
		}
	}
	return ans
}
