// Package s2
// @author: wesker.gh
// @date: 2021/11/21
// @description: bfs
package s2

type Node struct {
	Val      int
	Children []*Node
}

func maxDepth(root *Node) int {
	if root == nil {
		return 0
	}

	max, idx, count, queue := 0, 0, 1, append(make([]*Node, 0, 10000), root)
	for ; idx < len(queue); idx++ {
		for _, child := range queue[idx].Children {
			queue = append(queue, child)
		}
		count--
		if count == 0 {
			count = len(queue) - idx - 1
			max++
		}
	}
	return max
}
