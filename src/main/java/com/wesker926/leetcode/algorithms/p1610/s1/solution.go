// Package s1
// @author: wesker.gh
// @date: 2021/12/16
// @description: 坐标转换 + 滑动窗口
package s1

import (
	"math"
	"sort"
)

func visiblePoints(points [][]int, angle int, location []int) int {
	same, polars := 0, make([]float64, 0, len(points)*2)
	for _, point := range points {
		if point[0] == location[0] && point[1] == location[1] {
			same++
		} else {
			polars = append(polars, math.Atan2(float64(point[1]-location[1]), float64(point[0]-location[0])))
		}
	}

	n := len(polars)
	sort.Slice(polars, func(i, j int) bool {
		return polars[i] < polars[j]
	})
	for i := 0; i < n; i++ {
		polars = append(polars, polars[i]+2*math.Pi)
	}

	scope, max := float64(angle)/180*math.Pi, 0
	for i, j := 0, 0; i < n; i++ {
		for ; j < len(polars) && polars[j] <= polars[i]+scope; j++ {
		}
		if j-i > max {
			max = j - i
		}
	}
	return max + same
}
