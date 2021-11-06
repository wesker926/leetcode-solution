// Package s3
// @author: wesker.gh
// @date: 2021/11/6
// @description: 求和公式
package s3

func missingNumber(nums []int) int {
	sum, n := 0, len(nums)
	for _, i := range nums {
		sum += i
	}
	return n*(n+1)/2 - sum
}
