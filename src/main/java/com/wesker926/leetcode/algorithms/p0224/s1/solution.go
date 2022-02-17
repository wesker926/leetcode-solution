// Package s1
// @author: wesker.gh
// @date: 2022/2/17
// @description: 栈（压入符号）
// 最简单的写法只需要压当前括号外的公共符号入栈
// 将数字与括号压栈也可解决，但是相对麻烦
// 没有乘除，无需转换成逆波兰
package s1

import "unicode"

func calculate(s string) int {
	stack, sign, ans := []int{1}, 1, 0
	for i := 0; i < len(s); i++ {
		if s[i] == ' ' {
			continue
		} else if s[i] == '+' {
			sign = stack[len(stack)-1]
		} else if s[i] == '-' {
			sign = -stack[len(stack)-1]
		} else if s[i] == '(' {
			stack = append(stack, sign)
		} else if s[i] == ')' {
			stack = stack[:len(stack)-1]
		} else {
			num := 0
			for ; i < len(s); i++ {
				if !unicode.IsDigit(rune(s[i])) {
					break
				}
				num = num*10 + (int)(s[i]-'0')
			}
			ans, i = ans+num*sign, i-1
		}
	}
	return ans
}
