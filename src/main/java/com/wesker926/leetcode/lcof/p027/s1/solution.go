// Package s1
// @author: wesker.gh
// @date: 2022/4/8
// @description: DFS
package s1

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func mirrorTree(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	root.Left, root.Right = root.Right, root.Left
	mirrorTree(root.Left)
	mirrorTree(root.Right)
	return root
}
