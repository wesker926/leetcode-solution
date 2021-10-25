// Package s1
// @author: wesker.gh
// @date: 2021/10/26
// @description: stack
package s1

type CQueue struct {
	f []int
	s []int
}

func Constructor() CQueue {
	return CQueue{
		f: make([]int, 0),
		s: make([]int, 0),
	}
}

func (this *CQueue) AppendTail(value int) {
	this.f = append(this.f, value)
}

func (this *CQueue) DeleteHead() int {
	r := -1
	if len(this.s) > 0 {
		r = this.s[len(this.s)-1]
		this.s = this.s[:len(this.s)-1]

	} else if len(this.f) > 0 {
		r = this.f[0]
		for i := len(this.f) - 1; i > 0; i-- {
			this.s = append(this.s, this.f[i])
		}
		this.f = this.f[:0]
	}
	return r
}

/**
 * Your CQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AppendTail(value);
 * param_2 := obj.DeleteHead();
 */
