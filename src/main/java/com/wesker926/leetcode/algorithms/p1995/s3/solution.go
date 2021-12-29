// Package s3
// @author: wesker.gh
// @date: 2021/12/29
// @description: 遍历 + 桶
package s3

func countQuadruplets(nums []int) int {
	n, ans, bucket := len(nums), 0, make([]int, 301)
	for b := n - 3; b >= 1; b-- {
		for d := n - 1; d > b+1; d-- {
			bucket[nums[d]-nums[b+1]+100]++
		}
		for a := 0; a < b; a++ {
			ans += bucket[nums[a]+nums[b]+100]
		}
	}
	return ans
}
