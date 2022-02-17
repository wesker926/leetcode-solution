// Package s2
// @author: wesker.gh
// @date: 2022/2/17
// @description: 栈（压入数字和括号）
// 这是一种更麻烦的写法
package s2

import "unicode"

func calculate(s string) int {
	data, idx := []byte(s), 0
	for j := 0; j < len(data); j++ {
		if data[j] != ' ' {
			data[idx] = data[j]
			idx++
		}
	}
	data = data[:idx]

	stack, sign := make([][]int, 0), 1
	for i := 0; i < len(data); i++ {
		if data[i] == '(' {
			stack = append(stack, []int{0, 1})
		} else if data[i] == ')' {
			if stack[len(stack)-2][1] == -1 {
				sign = -sign
			}
			stack = pushDigit(stack[:len(stack)-2], stack[len(stack)-1][1])
		} else if i == len(data)-1 || data[i+1] != '(' {
			num, st, cSign := 0, i, 1
			if data[i] == '+' || data[i] == '-' {
				st++
				if data[i] == '-' {
					cSign = -1
				}
			}
			num, i = getDigit(data, st)
			stack = pushDigit(stack, num*sign*cSign)
		} else if data[i] == '-' {
			sign, i = -sign, i+1
			stack = append(stack, []int{0, -1})
		}
	}
	return stack[0][1]
}

func pushDigit(stack [][]int, num int) [][]int {
	for cur := []int{}; len(stack) > 0; {
		cur = stack[len(stack)-1]
		if cur[0] == 0 {
			break
		}
		num, stack = num+cur[1], stack[:len(stack)-1]
	}
	return append(stack, []int{1, num})
}

func getDigit(data []byte, st int) (int, int) {
	ans, i := 0, st
	for ; i < len(data); i++ {
		if !unicode.IsDigit(rune(data[i])) {
			break
		}
		ans = ans*10 + (int)(data[i]-'0')
	}
	return ans, i - 1
}
