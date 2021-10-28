// Package s1
// @author: wesker.gh
// @date: 2021/10/28
// @description: copy random linked list
package s1

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

func copyRandomList(head *Node) *Node {
	if head == nil {
		return nil
	}

	cur, nxt := head, head
	for cur != nil {
		nxt = cur.Next
		cur.Next = &Node{
			Val:  cur.Val,
			Next: nxt,
		}
		cur = nxt
	}

	cur = head
	for ; cur != nil; cur = cur.Next.Next {
		nxt = cur.Next
		if cur.Random != nil {
			nxt.Random = cur.Random.Next
		}
	}

	result := head.Next
	cur, nxt = head, head.Next
	for cur != nil {
		cur.Next = nxt.Next
		cur = cur.Next
		if cur != nil {
			nxt.Next = cur.Next
		}
		nxt = nxt.Next
	}

	return result
}
