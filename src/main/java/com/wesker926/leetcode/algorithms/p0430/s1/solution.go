// Package s1
// @author: wesker.gh
// @date: 2021/12/18
// @description: TODO
package s1

type Node struct {
	Val   int
	Prev  *Node
	Next  *Node
	Child *Node
}

func flatten(root *Node) *Node {
	dfs(root)
	return root
}

func dfs(root *Node) *Node {
	var last, t *Node
	for ; root != nil; last, root = root, root.Next {
		if root.Child == nil {
			continue
		}

		t = dfs(root.Child)
		t.Next = root.Next
		if t.Next != nil {
			t.Next.Prev = t
		}
		root.Next = root.Child
		root.Child.Prev = root
		root.Child = nil
		root = t
	}
	return last
}
