// Package s1
// @author: wesker.gh
// @date: 2021/12/3
// @description: 二分法：位运算路径
package s1

import "math"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func countNodes(root *TreeNode) int {
	h, cur := 0, root
	for ; cur != nil; cur = cur.Left {
		h++
	}
	if h < 2 {
		return h
	}

	l := int(math.Pow(float64(2), float64(h-1))) - 1
	r, m, mask := l*2, 0, 1<<(h-2)
	for l <= r {
		m = l + (r-l)/2
		if check(root, m+1, mask) {
			l = m + 1
		} else {
			r = m - 1
		}
	}
	return l
}

func check(node *TreeNode, bit, mask int) bool {
	for ; mask != 0; mask >>= 1 {
		if bit&mask == 0 {
			node = node.Left
		} else {
			node = node.Right
		}
	}
	return node != nil
}
