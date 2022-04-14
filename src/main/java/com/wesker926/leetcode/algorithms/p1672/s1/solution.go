// Package s1
// @author: wesker.gh
// @date: 2022/4/14
// @description: 遍历
package s1

func maximumWealth(accounts [][]int) int {
	ans := 0
	for i := 0; i < len(accounts); i++ {
		sum := 0
		for j := 0; j < len(accounts[0]); j++ {
			sum += accounts[i][j]
		}
		if sum > ans {
			ans = sum
		}
	}
	return ans
}
