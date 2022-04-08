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

func isSymmetric(root *TreeNode) bool {
	return root == nil || dfs(root.Left, root.Right)
}

func dfs(a, b *TreeNode) bool {
	return (a == nil && b == nil) || (a != nil && b != nil && a.Val == b.Val && dfs(a.Left, b.Right) && dfs(a.Right, b.Left))
}
