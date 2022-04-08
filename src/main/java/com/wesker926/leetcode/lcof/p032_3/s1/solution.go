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
	ans, layer, queue, count, order := make([][]int, 0), make([]int, 0), []*TreeNode{root}, 1, true
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
			if !order {
				layer = reverse(layer)
			}
			ans = append(ans, layer)
			layer = make([]int, 0)
			count = len(queue)
			order = !order
		}
	}
	return ans
}

func reverse(arr []int) []int {
	for i, j := 0, len(arr)-1; i < j; i, j = i+1, j-1 {
		arr[i], arr[j] = arr[j], arr[i]
	}
	return arr
}
