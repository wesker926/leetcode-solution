// Package s1
// @author: wesker.gh
// @date: 2022/4/14
// @description: 遍历
package s1

func maxSubArray(nums []int) int {
	ans, cur := nums[0], 0
	for _, num := range nums {
		cur += num
		if ans < cur {
			ans = cur
		}
		if cur < 0 {
			cur = 0
		}
	}
	return ans
}
