// Package s1
// @author: wesker.gh
// @date: 2022/4/8
// @description: BFS
package s1

type Node struct {
	Val      int
	Children []*Node
}

func levelOrder(root *Node) [][]int {
	if root == nil {
		return [][]int{}
	}
	queue, count, ans, layer := []*Node{root}, 1, make([][]int, 0), make([]int, 0)
	for len(queue) != 0 {
		cur := queue[0]
		queue = queue[1:]
		count--
		layer = append(layer, cur.Val)
		queue = append(queue, cur.Children...)
		if count == 0 {
			ans = append(ans, layer)
			layer = make([]int, 0)
			count = len(queue)
		}
	}
	return ans
}
