// Package s1
// @author: wesker.gh
// @date: 2021/10/28
// @description: print linked list
package s1

type ListNode struct {
	Val  int
	Next *ListNode
}

func reversePrint(head *ListNode) []int {
	count, cur := 0, head
	for cur != nil {
		count++
		cur = cur.Next
	}

	cur = head
	result := make([]int, count)
	for i := count - 1; cur != nil; i-- {
		result[i] = cur.Val
		cur = cur.Next
	}

	return result
}
