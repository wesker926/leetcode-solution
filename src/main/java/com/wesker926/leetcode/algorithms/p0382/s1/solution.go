// Package s1
// @author: wesker.gh
// @date: 2022/1/16
// @description: 水塘抽样法
package s1

import "math/rand"

type ListNode struct {
	Val  int
	Next *ListNode
}

type Solution struct {
	head *ListNode
}

func Constructor(head *ListNode) Solution {
	return Solution{
		head: head,
	}
}

func (this *Solution) GetRandom() int {
	ans := 0
	for cur, count := this.head, 0; cur != nil; cur = cur.Next {
		count++
		if (rand.Intn(count) + 1) == count {
			ans = cur.Val
		}
	}
	return ans
}

/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(head);
 * param_1 := obj.GetRandom();
 */
