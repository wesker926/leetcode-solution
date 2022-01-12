// Package s2
// @author: wesker.gh
// @date: 2022/1/12
// @description: 优化贪心
package s2

import "math"

func increasingTriplet(nums []int) bool {
	n := []int{nums[0], math.MaxInt32}
	for i := 1; i < len(nums); i++ {
		if nums[i] > n[1] {
			return true
		} else if nums[i] > n[0] {
			n[1] = nums[i]
		} else {
			n[0] = nums[i]
		}
	}
	return false
}
