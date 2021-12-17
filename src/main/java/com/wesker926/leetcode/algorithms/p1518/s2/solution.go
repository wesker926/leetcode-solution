// Package s2
// @author: wesker.gh
// @date: 2021/12/17
// @description: 数学
package s2

func numWaterBottles(numBottles int, numExchange int) int {
	if numBottles < numExchange {
		return numBottles
	}
	return numBottles + (numBottles-numExchange)/(numExchange-1) + 1
}
