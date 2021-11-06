// Package s1
// @author: wesker.gh
// @date: 2021/11/6
// @description: 原地标记
package s1

func missingNumber(nums []int) int {
	var t int
	for i := 0; i < len(nums); i++ {
		t = nums[i]
		if t < 0 {
			t = -t - 1
		}
		if t == len(nums) {
			continue
		}
		nums[t] = -nums[t] - 1
	}
	for i := 0; i < len(nums); i++ {
		if nums[i] >= 0 {
			return i
		}
	}
	return len(nums)
}
