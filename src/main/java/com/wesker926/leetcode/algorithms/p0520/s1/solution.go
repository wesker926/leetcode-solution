// Package s1
// @author: wesker.gh
// @date: 2021/11/13
// @description: 遍历
package s1

import "unicode"

func detectCapitalUse(word string) bool {
	first, up := unicode.IsUpper(rune(word[0])), 0
	for _, c := range word {
		if unicode.IsUpper(c) {
			up++
		}
	}
	return (first && up == len(word)) || (first && up == 1) || (!first && up == 0)
}
