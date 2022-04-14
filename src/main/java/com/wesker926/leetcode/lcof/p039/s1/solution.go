// Package s1
// @author: wesker.gh
// @date: 2022/4/14
// @description: Boyer-Moore 投票算法
package s1

func majorityElement(nums []int) int {
	ans, count := nums[0], 1
	for i := 1; i < len(nums); i++ {
		if ans == nums[i] {
			count++
		} else if count > 0 {
			count--
		} else {
			ans, count = nums[i], 1
		}
	}
	return ans
}
