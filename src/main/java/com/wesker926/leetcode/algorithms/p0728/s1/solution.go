// Package s1
// @author: wesker.gh
// @date: 2022/3/31
// @description: 计算
package s1

var table = make([]int, 10001)

func selfDividingNumbers(left int, right int) []int {
	ans := make([]int, 0)
	for i := left; i <= right; i++ {
		if table[i] == 0 {
			table[i] = compute(i)
		}
		if table[i] == 1 {
			ans = append(ans, i)
		}
	}
	return ans
}

func compute(a int) int {
	for i := a; i != 0; i /= 10 {
		j := i % 10
		if j == 0 || (a%j) != 0 {
			return -1
		}
	}
	return 1
}
