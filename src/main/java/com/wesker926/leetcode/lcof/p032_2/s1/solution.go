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

func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	ans, layer, queue, count := make([][]int, 0), make([]int, 0), []*TreeNode{root}, 1
	for len(queue) != 0 {
		cur := queue[0]
		queue = queue[1:]
		layer = append(layer, cur.Val)
		if cur.Left != nil {
			queue = append(queue, cur.Left)
		}
		if cur.Right != nil {
			queue = append(queue, cur.Right)
		}
		count--
		if count == 0 {
			ans = append(ans, layer)
			layer = make([]int, 0)
			count = len(queue)
		}
	}
	return ans
}
