// Package s1
// @author: wesker.gh
// @date: 2022/1/7
// @description: 遍历
package s1

func maxDepth(s string) int {
	max, cur := 0, 0
	for _, c := range s {
		if c == '(' {
			cur++
			if cur > max {
				max = cur
			}
		} else if c == ')' {
			cur--
		}
	}
	return max
}
