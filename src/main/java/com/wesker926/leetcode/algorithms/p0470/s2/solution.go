// Package s2
// @author: wesker.gh
// @date: 2021/12/18
// @description: 拒绝采样 - 调用次数期望优化
package s2

func rand10() int {
	x, y, ans := 0, 0, 0
	for {
		x = rand7()
		y = rand7()
		ans = (x-1)*7 + y
		if ans <= 40 {
			return ((ans - 1) % 10) + 1
		}

		x = ans - 41
		y = rand7()
		ans = x*7 + y
		if ans <= 60 {
			return ((ans - 1) % 10) + 1
		}

		x = ans - 61
		y = rand7()
		ans = x*7 + y
		if ans <= 20 {
			return ((ans - 1) % 10) + 1
		}
	}
}

func rand7() int {
	return 0
}
