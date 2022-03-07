// Package s1
// @author: wesker.gh
// @date: 2022/3/7
// @description: 计算
package s1

import "strconv"

func convertToBase7(num int) string {
	ans := 0
	for i := 1; num != 0; num, i = num/7, i*10 {
		ans += i * (num % 7)
	}
	return strconv.Itoa(ans)
}
