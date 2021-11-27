// Package s1
// @author: wesker.gh
// @date: 2021/11/27
// @description: 哈希空位映射
package s1

import "math/rand"

type Solution struct {
	m     int
	n     int
	size  int
	table map[int]int
}

func Constructor(m int, n int) Solution {
	return Solution{
		m:     m,
		n:     n,
		size:  m * n,
		table: make(map[int]int),
	}
}

func (this *Solution) Flip() []int {
	idx := rand.Intn(this.size)
	this.size--

	realIdx := idx
	if t, ok := this.table[idx]; ok {
		realIdx = t
	}

	replace := this.size
	if t, ok := this.table[this.size]; ok {
		replace = t
	}
	this.table[idx] = replace

	return []int{realIdx / this.n, realIdx % this.n}
}

func (this *Solution) Reset() {
	this.size = this.m * this.n
	this.table = make(map[int]int)
}

/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(m, n);
 * param_1 := obj.Flip();
 * obj.Reset();
 */
