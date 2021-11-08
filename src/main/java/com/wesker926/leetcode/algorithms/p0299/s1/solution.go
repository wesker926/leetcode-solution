// Package s1
// @author: wesker.gh
// @date: 2021/11/8
// @description: 哈希表
package s1

import "strconv"

func getHint(secret string, guess string) string {
	set, match, same := [10]int{}, 0, 0
	for i := 0; i < len(secret); i++ {
		set[secret[i]-'0']++
		if secret[i] == guess[i] {
			match++
		}
	}
	for i := 0; i < len(guess); i++ {
		if set[guess[i]-'0'] > 0 {
			set[guess[i]-'0']--
			same++
		}
	}
	same -= match
	return strconv.Itoa(match) + "A" + strconv.Itoa(same) + "B"
}
