// Package s1
// @author: wesker.gh
// @date: 2022/2/16
// @description: DFS
package s1

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var ans, max int

func maxPathSum(root *TreeNode) int {
	ans, max = 0, root.Val
	dfs(root)
	if ans == 0 {
		return max
	}
	return ans
}

func dfs(node *TreeNode) int {
	if node == nil {
		return 0
	}

	max = maxInt(max, node.Val)
	l, r := dfs(node.Left), dfs(node.Right)
	res := maxInt(maxInt(maxInt(l, r), 0)+node.Val, 0)
	ans = maxInt(ans, maxInt(res, l+node.Val+r))
	return res
}

func maxInt(i, j int) int {
	if i >= j {
		return i
	}
	return j
}
