// Package s1
// @author: wesker.gh
// @date: 2022/1/5
// @description: 遍历 + 替换
package s1

func modifyString(s string) string {
	cs := []rune(s)
	for i := 0; i < len(cs); i++ {
		if cs[i] != '?' {
			continue
		}
		for c := 'a'; c < 'd'; c++ {
			if (i != 0 && cs[i-1] == c) || (i != len(cs)-1 && cs[i+1] == c) {
				continue
			}
			cs[i] = c
			break
		}
	}
	return string(cs)
}
