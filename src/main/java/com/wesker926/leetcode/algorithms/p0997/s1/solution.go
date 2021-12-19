// Package s1
// @author: wesker.gh
// @date: 2021/12/19
// @description: 遍历（图入度出度）
package s1

func findJudge(n int, trust [][]int) int {
	if n == 1 {
		return 1
	}

	bucket := make([]int, n+1)
	for _, ints := range trust {
		bucket[ints[0]]--
		bucket[ints[1]]++
	}

	for i := 1; i <= n; i++ {
		if bucket[i] == n-1 {
			return i
		}
	}
	return -1
}
