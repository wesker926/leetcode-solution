// Package s1
// @author: wesker.gh
// @date: 2021/12/31
// @description: 遍历
package s1

import "math"

func checkPerfectNumber(num int) bool {
	if num == 1 {
		return false
	}

	sum, t := 1, 0
	for i := 2; i <= int(math.Sqrt(float64(num))); i++ {
		if num%i == 0 {
			sum += i
			if t = num / i; t != i {
				sum += t
			}
		}
		if sum > num {
			return false
		}
	}
	return sum == num
}
