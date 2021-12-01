// Package s1
// @author: wesker.gh
// @date: 2021/12/1
// @description: 遍历
package s1

func maxPower(s string) int {
	max, cur := 1, 1
	for i := 1; i < len(s); i++ {
		if s[i] == s[i-1] {
			cur++
		} else {
			max = maxInt(max, cur)
			cur = 1
		}
	}
	return maxInt(max, cur)
}

func maxInt(i, j int) int {
	if i >= j {
		return i
	}
	return j
}
