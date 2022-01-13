// Package s2
// @author: wesker.gh
// @date: 2022/1/13
// @description: 一次遍历
package s2

func dominantIndex(nums []int) int {
	max := []int{0, -1}
	for i := 1; i < len(nums); i++ {
		if nums[i] > nums[max[0]] {
			max[0], max[1] = i, nums[max[0]]
		} else if nums[i] > max[1] {
			max[1] = nums[i]
		}
	}
	if nums[max[0]] >= max[1]<<1 {
		return max[0]
	}
	return -1
}
