// Package s1
// @author: wesker.gh
// @date: 2022/4/7
// @description: DFS
package s1

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isSubStructure(A *TreeNode, B *TreeNode) bool {
	return A != nil && B != nil && (isSame(A, B) || isSubStructure(A.Left, B) || isSubStructure(A.Right, B))
}

func isSame(a, b *TreeNode) bool {
	return b == nil || (a != nil && a.Val == b.Val && isSame(a.Left, b.Left) && isSame(a.Right, b.Right))
}
