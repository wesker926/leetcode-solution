// Package s1
// @author: wesker.gh
// @date: 2021/12/15
// @description: 构造图 + dfs
package s1

var (
	q        []int
	ans      []int
	relation [][]int
)

func loudAndRich(richer [][]int, quiet []int) []int {
	n := len(quiet)
	relation = make([][]int, n)
	for _, ints := range richer {
		relation[ints[1]] = append(relation[ints[1]], ints[0])
	}

	q, ans = quiet, make([]int, n)
	for i := 0; i < n; i++ {
		ans[i] = n
	}

	for i := 0; i < n; i++ {
		dfs(i)
	}
	return ans
}

func dfs(i int) {
	if ans[i] != len(q) {
		return
	}

	ans[i] = i
	for _, j := range relation[i] {
		dfs(j)
		if q[ans[i]] > q[ans[j]] {
			ans[i] = ans[j]
		}
	}
}
