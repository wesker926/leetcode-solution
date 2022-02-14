// Package s1
// @author: wesker.gh
// @date: 2022/2/14
// @description: 二分查找
package s1

func singleNonDuplicate(nums []int) int {
	l, r, m := 0, len(nums)-1, 0
	for l < r {
		m = l + (r-l)/2
		if m&1 != 0 {
			m--
		}
		if nums[m] == nums[m+1] {
			l = m + 2
		} else {
			r = m
		}
	}
	return nums[l]
}
