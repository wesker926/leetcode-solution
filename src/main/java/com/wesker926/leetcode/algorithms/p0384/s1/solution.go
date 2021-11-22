// Package s1
// @author: wesker.gh
// @date: 2021/11/22
// @description: Fisher-Yates 洗牌算法
package s1

import "math/rand"

type Solution struct {
	origin []int
}

func Constructor(nums []int) Solution {
	return Solution{
		origin: append([]int{}, nums...),
	}
}

func (this *Solution) Reset() []int {
	return append([]int{}, this.origin...)
}

func (this *Solution) Shuffle() []int {
	n, r := len(this.origin), append([]int{}, this.origin...)
	for i, j := 0, 0; i < n; i++ {
		j = rand.Intn(n-i) + i
		r[i], r[j] = r[j], r[i]
	}
	return r
}

/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.Reset();
 * param_2 := obj.Shuffle();
 */
