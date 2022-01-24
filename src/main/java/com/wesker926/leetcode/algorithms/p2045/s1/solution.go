// Package s1
// @author: wesker.gh
// @date: 2022/1/24
// @description: BFS
package s1

import "math"

func secondMinimum(n int, edges [][]int, time int, change int) int {
	e, p, q := make([][]int, n+1), make([][]int, n+1), [][]int{{1, 0}}
	for _, edge := range edges {
		e[edge[0]] = append(e[edge[0]], edge[1])
		e[edge[1]] = append(e[edge[1]], edge[0])
	}
	for i := 0; i <= n; i++ {
		p[i] = []int{math.MaxInt32, math.MaxInt32}
	}
	p[1][0] = 0

	for cur, val := []int{}, 0; len(q) > 0; {
		cur, q, val = q[0], q[1:], q[0][1]+1
		for _, nxt := range e[cur[0]] {
			if val < p[nxt][0] {
				p[nxt][0] = val
				q = append(q, []int{nxt, val})
			} else if val > p[nxt][0] && val < p[nxt][1] {
				p[nxt][1] = val
				q = append(q, []int{nxt, val})
			}
		}
	}

	ans := 0
	for i, d := 0, 0; i < p[n][1]; i++ {
		d = ans / change
		if (d & 1) == 1 {
			ans = (d + 1) * change
		}
		ans += time
	}
	return ans
}
