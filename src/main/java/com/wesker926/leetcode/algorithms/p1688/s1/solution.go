// Package s1
// @author: wesker.gh
// @date: 2022/1/25
// @description: 模拟
package s1

func numberOfMatches(n int) int {
	ans := 0
	for ; n > 1; n = (n + 1) >> 1 {
		ans += n >> 1
	}
	return ans
}
