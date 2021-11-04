// Package s2
// @author: wesker.gh
// @date: 2021/11/4
// @description: 牛顿迭代法
package s2

func isPerfectSquare(num int) bool {
	cur, nxt := float64(num), float64(0)
	for {
		nxt = (cur + float64(num)/cur) / 2
		if cur-nxt < 1e-6 {
			break
		}
		cur = nxt
	}
	return int(nxt)*int(nxt) == num
}
