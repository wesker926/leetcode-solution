// Package s1
// @author: wesker.gh
// @date: 2021/11/18
// @description: dfs
package s1

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func findTilt(root *TreeNode) int {
	gradient, _ := dfs(root)
	return gradient
}

func dfs(root *TreeNode) (int, int) {
	if root == nil {
		return 0, 0
	}

	lg, ls := dfs(root.Left)
	rg, rs := dfs(root.Right)
	return lg + rg + abs(ls-rs), ls + rs + root.Val
}

func abs(i int) int {
	if i >= 0 {
		return i
	}
	return -i
}
