// Package s1
// @author: wesker.gh
// @date: 2021/12/29
// @description: 直接遍历
package s1

func countQuadruplets(nums []int) int {
	n, ans := len(nums), 0
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			for k := j + 1; k < n; k++ {
				for l := k + 1; l < n; l++ {
					if nums[i]+nums[j]+nums[k] == nums[l] {
						ans++
					}
				}
			}
		}
	}
	return ans
}
