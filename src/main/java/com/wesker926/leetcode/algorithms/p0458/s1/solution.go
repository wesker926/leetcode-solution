// Package s1
// @author: wesker.gh
// @date: 2021/11/25
// @description: 维度（进制）计算
package s1

import "math"

func poorPigs(buckets int, minutesToDie int, minutesToTest int) int {
	n := (minutesToTest / minutesToDie) + 1
	y := math.Log2(float64(buckets)) / math.Log2(float64(n))
	if y == math.Trunc(y) {
		return int(y)
	}
	return int(y) + 1
}
