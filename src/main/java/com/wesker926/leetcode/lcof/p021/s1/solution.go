// Package s1
// @author: wesker.gh
// @date: 2022/4/6
// @description: 双指针
package s1

func exchange(nums []int) []int {
	for i, j := 0, 0; j < len(nums); j++ {
		if (nums[j] & 1) == 1 {
			nums[i], nums[j] = nums[j], nums[i]
			i++
		}
	}
	return nums
}
