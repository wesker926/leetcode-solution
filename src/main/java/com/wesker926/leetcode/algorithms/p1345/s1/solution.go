// Package s1
// @author: wesker.gh
// @date: 2022/1/21
// @description: 哈希表 + 广度优先搜索
package s1

import "runtime/debug"

func minJumps(arr []int) int {
	m, n := make(map[int][]int), len(arr)
	for i, k := range arr {
		m[k] = append(m[k], i)
	}
	queue, visit := [][]int{{0, 0}}, make([]bool, n)
	visit[0] = true
	for cur := []int{}; len(queue) > 0; {
		cur, queue = queue[0], queue[1:]
		if cur[0] == n-1 {
			return cur[1]
		}
		k := cur[1] + 1
		for j := cur[0] - 1; j <= cur[0]+1; j += 2 {
			if j >= 0 && !visit[j] {
				visit[j] = true
				queue = append(queue, []int{j, k})
			}
		}
		for _, j := range m[arr[cur[0]]] {
			if !visit[j] {
				visit[j] = true
				queue = append(queue, []int{j, k})
			}
		}
		// 已经访问过的节点没必要再访问，移除哈希表相应的KV避免重复
		delete(m, arr[cur[0]])
	}
	return -1
}

func init() {
	debug.SetGCPercent(-1)
}
