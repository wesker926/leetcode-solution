// Package s1
// @author: wesker.gh
// @date: 2022/4/7
// @description: 迭代合并
package s1

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	head := &ListNode{}
	cur := head
	for ; l1 != nil && l2 != nil; cur = cur.Next {
		if l1.Val <= l2.Val {
			cur.Next = l1
			l1 = l1.Next
		} else {
			cur.Next = l2
			l2 = l2.Next
		}
	}
	if l1 != nil {
		cur.Next = l1
	} else {
		cur.Next = l2
	}
	return head.Next
}
