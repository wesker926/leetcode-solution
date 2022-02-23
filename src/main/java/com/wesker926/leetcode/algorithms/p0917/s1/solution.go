// Package s1
// @author: wesker.gh
// @date: 2022/2/23
// @description: 双指针
package s1

import "unicode"

func reverseOnlyLetters(s string) string {
	cs := []byte(s)
	for i, j := 0, len(cs)-1; i < j; i, j = i+1, j-1 {
		for ; i < j && !unicode.IsLetter(rune(cs[i])); i++ {
		}
		for ; i < j && !unicode.IsLetter(rune(cs[j])); j-- {
		}
		cs[i], cs[j] = cs[j], cs[i]
	}
	return string(cs)
}
