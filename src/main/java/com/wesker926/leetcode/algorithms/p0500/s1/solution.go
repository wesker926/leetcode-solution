// Package s1
// @author: wesker.gh
// @date: 2021/10/31
// @description: character array
package s1

import "strings"

var chars = []int{2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3}

func findWords(words []string) []string {
	result := make([]string, 0, len(words))
	for _, word := range words {
		if check(word) {
			result = append(result, word)
		}
	}
	return result
}

func check(s string) bool {
	s = strings.ToLower(s)
	from := chars[s[0]-'a']
	for i := 1; i < len(s); i++ {
		if chars[s[i]-'a'] != from {
			return false
		}
	}
	return true
}
