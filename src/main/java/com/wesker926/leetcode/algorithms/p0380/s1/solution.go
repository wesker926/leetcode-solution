// Package s1
// @author: wesker.gh
// @date: 2022/4/13
// @description: 变长数组 + 哈希表
package s1

import "math/rand"

type RandomizedSet struct {
	nums []int
	m    map[int]int
}

func Constructor() RandomizedSet {
	return RandomizedSet{
		nums: make([]int, 0),
		m:    make(map[int]int),
	}
}

func (this *RandomizedSet) Insert(val int) bool {
	if _, ok := this.m[val]; ok {
		return false
	}
	this.m[val] = len(this.nums)
	this.nums = append(this.nums, val)
	return true
}

func (this *RandomizedSet) Remove(val int) bool {
	if idx, ok := this.m[val]; !ok {
		return false
	} else {
		lastIdx := len(this.nums) - 1
		this.m[this.nums[lastIdx]] = idx
		this.nums[idx] = this.nums[lastIdx]
		delete(this.m, val)
		this.nums = this.nums[:lastIdx]
		return true
	}
}

func (this *RandomizedSet) GetRandom() int {
	return this.nums[rand.Intn(len(this.nums))]
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Insert(val);
 * param_2 := obj.Remove(val);
 * param_3 := obj.GetRandom();
 */
