// Package s1
// @author: wesker.gh
// @date: 2021/12/18
// @description: 拒绝采样
package s1

func rand10() int {
	x, y, ans := 0, 0, 0
	for {
		x = rand7()
		y = rand7()
		ans = (x-1)*7 + y
		if ans <= 40 {
			return ((ans - 1) % 10) + 1
		}
	}
}

func rand7() int {
	return 0
}
