// Package s1
// @author: wesker.gh
// @date: 2021/12/4
// @description: 字母表
package s1

func canConstruct(ransomNote string, magazine string) bool {
	if len(magazine) < len(ransomNote) {
		return false
	}

	table := make([]int, 26)
	for _, c := range magazine {
		table[int(c-'a')]++
	}

	for _, c := range ransomNote {
		if table[int(c-'a')]--; table[int(c-'a')] < 0 {
			return false
		}
	}
	return true
}
