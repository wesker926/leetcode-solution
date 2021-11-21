// Package s1
// @author: wesker.gh
// @date: 2021/11/21
// @description: dfs
package s1

type Node struct {
	Val      int
	Children []*Node
}

func maxDepth(root *Node) int {
	if root == nil {
		return 0
	}

	max := 0
	for _, child := range root.Children {
		if t := maxDepth(child); t > max {
			max = t
		}
	}
	return max + 1
}
