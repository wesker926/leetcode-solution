// Package s1
// @author: wesker.gh
// @date: 2022/1/27
// @description: 切分 + 遍历检查
package s1

import (
	"strings"
	"unicode"
)

func countValidWords(sentence string) int {
	sp, ans := strings.Fields(sentence), 0
	for _, s := range sp {
		ans += check(s)
	}
	return ans
}

func check(s string) int {
	h := false
	for i, c := range s {
		if unicode.IsDigit(c) {
			return 0
		} else if unicode.IsLetter(c) {
			continue
		} else if c == '-' {
			if h || i == 0 || i == len(s)-1 || !unicode.IsLetter(rune(s[i-1])) || !unicode.IsLetter(rune(s[i+1])) {
				return 0
			}
			h = true
		} else {
			if i != len(s)-1 {
				return 0
			}
		}
	}
	return 1
}
