// Package s1
// @author: wesker.gh
// @date: 2021/11/23
// @description: 遍历
package s1

func buddyStrings(s string, goal string) bool {
	if len(s) != len(goal) {
		return false
	}

	n, same, diff, set := len(s), false, make([]int, 0), make([]bool, 26)
	for i := 0; i < n; i++ {
		if s[i] != goal[i] {
			diff = append(diff, i)
		}

		if set[s[i]-'a'] {
			same = true
		}
		set[s[i]-'a'] = true
	}

	return (len(diff) == 0 && same) || (len(diff) == 2 && s[diff[0]] == goal[diff[1]] && s[diff[1]] == goal[diff[0]])
}
