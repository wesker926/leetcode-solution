// Package s1
// @author: wesker.gh
// @date: 2021/12/10
// @description: 字母表 + 遍历
package s1

import (
	"strings"
	"unicode"
)

func shortestCompletingWord(licensePlate string, words []string) string {
	idx, min := 0, 16
	o := make([]int, 26)
	for _, c := range strings.ToLower(licensePlate) {
		if unicode.IsLetter(c) {
			o[c-'a']++
		}
	}

loop:
	for i, word := range words {
		t := make([]int, 26)
		for _, c := range word {
			t[c-'a']++
		}

		for j := 0; j < 26; j++ {
			if t[j] < o[j] {
				continue loop
			}
		}

		if len(word) < min {
			idx = i
			min = len(word)
		}
	}

	return words[idx]
}
