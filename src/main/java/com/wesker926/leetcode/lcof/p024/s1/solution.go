// Package s1
// @author: wesker.gh
// @date: 2021/10/28
// @description: reverse linked list
package s1

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}

	head = &ListNode{
		Next: head,
	}
	cur, nxt := head.Next, head.Next.Next
	for ; nxt != nil; nxt = cur.Next {
		cur.Next = nxt.Next
		nxt.Next = head.Next
		head.Next = nxt
	}
	return head.Next
}
