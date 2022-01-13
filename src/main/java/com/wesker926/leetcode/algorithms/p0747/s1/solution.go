// Package s1
// @author: wesker.gh
// @date: 2022/1/13
// @description: 两次遍历
package s1

func dominantIndex(nums []int) int {
	max := 0
	for i := 1; i < len(nums); i++ {
		if nums[i] > nums[max] {
			max = i
		}
	}
	for i, num := range nums {
		if max != i && nums[max] < num<<1 {
			return -1
		}
	}
	return max
}
