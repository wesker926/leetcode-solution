// Package s1
// @author: wesker.gh
// @date: 2021/12/17
// @description: 模拟
package s1

func numWaterBottles(numBottles int, numExchange int) int {
	ans, d, m := 0, 0, 0
	for numBottles >= numExchange {
		d = numBottles / numExchange
		m = numBottles - numExchange*d
		ans += numBottles - m
		numBottles = d + m
	}
	return ans + numBottles
}
