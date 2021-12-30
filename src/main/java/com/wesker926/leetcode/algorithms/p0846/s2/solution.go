// Package s2
// @author: wesker.gh
// @date: 2021/12/30
// @description: 聚合 + 排序 + 滑动窗口
package s2

import (
	"runtime/debug"
	"sort"
)

func init() {
	debug.SetGCPercent(-1)
}

func isNStraightHand(hand []int, groupSize int) bool {
	m := make(map[int]int)
	for _, n := range hand {
		m[n]++
	}
	arr := make([][]int, 0, len(m))
	for k, v := range m {
		arr = append(arr, []int{k, v})
	}
	sort.Slice(arr, func(i, j int) bool {
		return arr[i][0] <= arr[j][0]
	})

	l, r := 0, groupSize-1
	for r < len(arr) {
		arr[l][1]--
		for i := l + 1; i <= r; i++ {
			if arr[i][0] != arr[i-1][0]+1 || arr[i][1] == 0 {
				return false
			}
			arr[i][1]--
		}
		for ; l < len(arr) && arr[l][1] == 0; l++ {
		}
		r = l + groupSize - 1
	}
	return l == len(arr)
}
