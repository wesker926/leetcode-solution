// Package s1
// @author: wesker.gh
// @date: 2022/2/25
// @description: TODO
package s1

import "strconv"

func complexNumberMultiply(num1 string, num2 string) string {
	arr1, arr2 := toArr(num1), toArr(num2)
	return strconv.Itoa(arr1[0]*arr2[0]-arr1[1]*arr2[1]) + "+" + strconv.Itoa(arr1[0]*arr2[1]+arr1[1]*arr2[0]) + "i"
}

func toArr(s string) []int {
	arr, si := make([]int, 0, 2), 1
	for i, n := 0, 0; i < len(s); i++ {
		if s[i] == '-' {
			si = -1
		} else if s[i] == '+' || s[i] == 'i' {
			arr = append(arr, n*si)
			n, si = 0, 1
		} else {
			n = n*10 + int(s[i]-'0')
		}
	}
	return arr
}
