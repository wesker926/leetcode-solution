// Package s1
// @author: wesker.gh
// @date: 2022/4/8
// @description: BFS
package s1

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func levelOrder(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	ans, queue := make([]int, 0), []*TreeNode{root}
	for ; len(queue) != 0; queue = queue[1:] {
		cur := queue[0]
		ans = append(ans, cur.Val)
		if cur.Left != nil {
			queue = append(queue, cur.Left)
		}
		if cur.Right != nil {
			queue = append(queue, cur.Right)
		}
	}
	return ans
}
