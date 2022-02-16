// Package s1
// @author: wesker.gh
// @date: 2022/2/16
// @description: 构造 + 检查
package s1

import "math"

func checkWays(pairs [][]int) int {
	graph := make([][]int, 501)
	for i := 0; i < 501; i++ {
		graph[i] = make([]int, 501)
	}
	for _, pair := range pairs {
		graph[pair[0]][pair[1]], graph[pair[1]][pair[0]] = 1, 1
		graph[pair[0]][0]++
		graph[pair[1]][0]++
	}

	rootCount, root := getRoot(graph)
	if rootCount == 0 {
		return 0
	} else if rootCount >= 2 {
		return 2
	}

	res := 1
	for i, node := range graph {
		if i == root || node[0] == 0 {
			continue
		}

		parent, parentCount := 0, math.MaxInt32
		for j, v := range node {
			if v > 0 && graph[j][0] >= node[0] && graph[j][0] < parentCount {
				parentCount = graph[j][0]
				parent = j
			}
		}
		if parent == 0 {
			return 0
		}
		if parentCount == node[0] {
			res = 2
		}

		for j, v := range node {
			if v > 0 && j != parent && graph[parent][j] == 0 {
				return 0
			}
		}
	}
	return res
}

func getRoot(graph [][]int) (int, int) {
	nodeCount, rootCount, root := 0, 0, 0
	for i := 0; i < 501; i++ {
		if graph[i][0] != 0 {
			nodeCount++
		}
	}
	for i := 0; i < 501; i++ {
		if graph[i][0] == nodeCount-1 {
			root = i
			rootCount++
		}
	}
	return rootCount, root
}
