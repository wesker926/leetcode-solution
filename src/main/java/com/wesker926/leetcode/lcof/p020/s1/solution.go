// Package s1
// @author: wesker.gh
// @date: 2022/4/7
// @description: 遍历判断（同主站-p0065）
package s1

import (
	"strings"
	"unicode"
)

func isNumber(s string) bool {
	s = strings.TrimSpace(s)
	if len(s) == 0 {
		return false
	}
	for i, p, c := 0, false, rune(0); i < len(s); i++ {
		if c = rune(s[i]); c == '+' || c == '-' {
			if i != 0 || i == len(s)-1 || (!unicode.IsDigit(rune(s[i+1])) && s[i+1] != '.') {
				return false
			}
		} else if c == '.' {
			if p || ((i == 0 || !unicode.IsDigit(rune(s[i-1]))) && (i == len(s)-1 || !unicode.IsDigit(rune(s[i+1])))) {
				return false
			}
			p = true
		} else if unicode.ToLower(c) == 'e' {
			return i != 0 && i != len(s)-1 && isInt(s[i+1:])
		} else if !unicode.IsDigit(c) {
			return false
		}
	}
	return true
}

func isInt(s string) bool {
	idx := 0
	if first := rune(s[0]); first == '+' || first == '-' {
		idx = 1
	}
	if len(s)-idx <= 0 {
		return false
	}
	for ; idx < len(s); idx++ {
		if !unicode.IsDigit(rune(s[idx])) {
			return false
		}
	}
	return true
}
