// Package s1
// @author: wesker.gh
// @date: 2021/12/20
// @description: 双数组遍历
package s1

import (
	"math"
	"sort"
)

func findRadius(houses []int, heaters []int) int {
	sort.Ints(houses)
	sort.Ints(heaters)

	max := 0
	for i, j := 0, 0; i < len(houses); i++ {
		a := math.Abs(float64(houses[i] - heaters[j]))
		for ; j < len(heaters)-1 && a >= math.Abs(float64(houses[i]-heaters[j+1])); j++ {
		}

		if int(a) > max {
			max = int(a)
		}
	}
	return max
}
