// Package s1
// @author: wesker.gh
// @date: 2021/11/2
// @description: 顶替
package s1

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteNode(node *ListNode) {
	node.Val = node.Next.Val
	node.Next = node.Next.Next
}
