// Package s1
// @author: wesker.gh
// @date: 2022/4/12
// @description: DFS
package s1

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var (
	tar  int
	path []int
	ans  [][]int
)

func pathSum(root *TreeNode, target int) [][]int {
	path, ans, tar = make([]int, 0), make([][]int, 0), target
	dfs(root, 0)
	return ans
}

func dfs(node *TreeNode, cur int) {
	if node == nil {
		return
	}

	cur += node.Val
	path = append(path, node.Val)
	if node.Left == nil && node.Right == nil {
		if cur == tar {
			temp := make([]int, len(path))
			copy(temp, path)
			ans = append(ans, temp)
		}
	} else {
		dfs(node.Left, cur)
		dfs(node.Right, cur)
	}
	path = path[:len(path)-1]
}
