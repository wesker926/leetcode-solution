// Package s1
// @author: wesker.gh
// @date: 2022/4/6
// @description: 快慢指针
package s1

type ListNode struct {
	Val  int
	Next *ListNode
}

func getKthFromEnd(head *ListNode, k int) *ListNode {
	cur := head
	for i := 1; i < k && cur != nil; i++ {
		cur = cur.Next
	}
	if cur == nil {
		return nil
	}

	for cur.Next != nil {
		head = head.Next
		cur = cur.Next
	}
	return head
}
