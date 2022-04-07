// Package s1
// @author: wesker.gh
// @date: 2022/4/7
// @description: 搜索子串
package s1

import "strings"

func rotateString(s string, goal string) bool {
	return len(s) == len(goal) && strings.Contains(s+s, goal)
}
