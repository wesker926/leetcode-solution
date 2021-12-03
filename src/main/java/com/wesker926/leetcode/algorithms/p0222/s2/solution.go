// Package s2
// @author: wesker.gh
// @date: 2021/12/3
// @description: 二分法：子树递归
package s2

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func countNodes(root *TreeNode) int {
	if root == nil {
		return 0
	}
	l, r := getDepth(root.Left), getDepth(root.Right)
	if l == r {
		return (1 << l) + countNodes(root.Right)
	}
	return (1 << r) + countNodes(root.Left)
}

func getDepth(node *TreeNode) int {
	depth := 0
	for ; node != nil; node = node.Left {
		depth++
	}
	return depth
}
