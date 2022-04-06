// Package s1
// @author: wesker.gh
// @date: 2022/4/6
// @description: 拓扑排序
package s1

func findMinHeightTrees(n int, edges [][]int) []int {
	if n == 1 {
		return []int{0}
	}

	degree, edge := make([]int, n), make([][]int, n)
	for _, e := range edges {
		edge[e[0]] = append(edge[e[0]], e[1])
		edge[e[1]] = append(edge[e[1]], e[0])
		degree[e[0]]++
		degree[e[1]]++
	}

	queue := make([]int, 0)
	for i, v := range degree {
		if v == 1 {
			queue = append(queue, i)
		}
	}

	for left, count := n, 0; left > 2; left -= count {
		count = len(queue)
		for i := 0; i < count; i++ {
			for _, nxt := range edge[queue[i]] {
				if degree[nxt]--; degree[nxt] == 1 {
					queue = append(queue, nxt)
				}
			}
		}
		queue = queue[count:]
	}
	return queue
}
