// Package s1
// @author: wesker.gh
// @date: 2021/11/20
// @description: 哈希表
package s1

func findLHS(nums []int) int {
	m := make(map[int]int)
	for _, n := range nums {
		m[n]++
	}

	max := 0
	for n, cur := range m {
		if nxt, ok := m[n+1]; ok && cur+nxt > max {
			max = cur + nxt
		}
	}
	return max
}
