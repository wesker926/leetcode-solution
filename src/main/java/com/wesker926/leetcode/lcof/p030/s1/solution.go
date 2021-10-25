// Package s1
// @author: wesker.gh
// @date: 2021/10/26
// @description: stack
package s1

type MinStack struct {
	cnt int
	val []int
	min []int
}

/** initialize your data structure here. */
func Constructor() MinStack {
	return MinStack{
		cnt: 0,
		val: make([]int, 0),
		min: make([]int, 0),
	}
}

func (this *MinStack) Push(x int) {
	this.val = append(this.val, x)
	if this.cnt == 0 || this.min[this.cnt-1] >= x {
		this.min = append(this.min, x)
	} else {
		this.min = append(this.min, this.min[this.cnt-1])
	}
	this.cnt++
}

func (this *MinStack) Pop() {
	if this.cnt > 0 {
		this.cnt--
		this.val = this.val[:this.cnt]
		this.min = this.min[:this.cnt]
	}
}

func (this *MinStack) Top() int {
	if this.cnt > 0 {
		return this.val[this.cnt-1]
	}
	return 0
}

func (this *MinStack) Min() int {
	if this.cnt > 0 {
		return this.min[this.cnt-1]
	}
	return 0
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.Min();
 */
