// Package s1
// @author: wesker.gh
// @date: 2021/10/30
// @description: xor
package s1

func singleNumber(nums []int) []int {
	xor, bit := 0, 0
	for _, n := range nums {
		xor ^= n
	}
	bit = (xor & (xor - 1)) ^ xor

	result := make([]int, 2)
	for _, n := range nums {
		if (n & bit) != 0 {
			result[0] ^= n
		} else {
			result[1] ^= n
		}
	}
	return result
}
