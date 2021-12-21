// Package s1
// @author: wesker.gh
// @date: 2021/12/21
// @description: 计算闰年
package s1

var days = []int{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}

func dayOfYear(date string) int {
	nums, n := make([]int, 0, 3), 0
	for i := 0; i < len(date); i++ {
		if date[i] == '-' {
			nums = append(nums, n)
			n = 0
			continue
		}
		n = n*10 + int(date[i]-'0')
	}
	nums = append(nums, n)

	ans := nums[2]
	if nums[1] > 2 && isLeapYear(nums[0]) {
		ans += 1
	}
	for i := 0; i < nums[1]-1; i++ {
		ans += days[i]
	}
	return ans
}

func isLeapYear(year int) bool {
	if year%400 == 0 {
		return true
	}

	if year%100 == 0 {
		return false
	}

	return year%4 == 0
}
