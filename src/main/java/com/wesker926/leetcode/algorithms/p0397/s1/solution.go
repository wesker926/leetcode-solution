// Package s1
// @author: wesker.gh
// @date: 2021/11/19
// @description: dfs+缓存
package s1

var m = map[int]int{1: 0}

func integerReplacement(n int) int {
	if r, ok := m[n]; ok {
		return r
	}

	var cur int
	if n&1 == 0 {
		cur = integerReplacement(n>>1) + 1
	} else {
		cur = minInt(integerReplacement(n>>1), integerReplacement((n>>1)+1)) + 2
	}
	m[n] = cur
	return cur
}

func minInt(i, j int) int {
	if i <= j {
		return i
	}
	return j
}
