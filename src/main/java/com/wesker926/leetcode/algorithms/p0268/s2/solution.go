// Package s2
// @author: wesker.gh
// @date: 2021/11/6
// @description: 异或运算
package s2

func missingNumber(nums []int) int {
	var xor int
	for i := 0; i < len(nums); i++ {
		xor ^= i ^ nums[i]
	}
	return xor ^ len(nums)
}
