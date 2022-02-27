// Package s1
// @author: wesker.gh
// @date: 2022/2/27
// @description: 遍历
package s1

import "strconv"

func optimalDivision(nums []int) string {
	if len(nums) == 1 {
		return strconv.Itoa(nums[0])
	} else if len(nums) == 2 {
		return strconv.Itoa(nums[0]) + "/" + strconv.Itoa(nums[1])
	}

	ans := append(append([]rune{}, []rune(strconv.Itoa(nums[0]))...), '/', '(')
	for i := 1; i < len(nums)-1; i++ {
		ans = append(append(ans, []rune(strconv.Itoa(nums[i]))...), '/')
	}
	return string(append(append(ans, []rune(strconv.Itoa(nums[len(nums)-1]))...), ')'))
}
