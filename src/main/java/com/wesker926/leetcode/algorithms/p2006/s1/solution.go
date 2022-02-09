// Package s1
// @author: wesker.gh
// @date: 2022/2/9
// @description: 桶 + 遍历
package s1

func countKDifference(nums []int, k int) int {
	bucket, ans := make([]int, 300), 0
	for _, num := range nums {
		ans += bucket[num+100+k] + bucket[num+100-k]
		bucket[num+100]++
	}
	return ans
}
