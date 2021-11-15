// Package s1
// @author: wesker.gh
// @date: 2021/11/15
// @description: 只有平方数会亮
package s1

import "math"

func bulbSwitch(n int) int {
	// 加0.5为了避免精度问题
	return int(math.Sqrt(float64(n) + 0.5))
}
