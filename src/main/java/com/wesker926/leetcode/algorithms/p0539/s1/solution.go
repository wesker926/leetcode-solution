// Package s1
// @author: wesker.gh
// @date: 2022/1/18
// @description: 鸽巢优化 + 排序遍历
package s1

import "sort"

func findMinDifference(timePoints []string) int {
	if len(timePoints) > 1440 {
		return 0
	}
	times := make([]int, 0, len(timePoints))
	for _, point := range timePoints {
		times = append(times, toInt(point))
	}
	sort.Ints(times)
	ans := times[0] - times[len(times)-1] + 1440
	for i := 1; i < len(times); i++ {
		ans = minInt(ans, times[i]-times[i-1])
	}
	return ans
}

func minInt(i, j int) int {
	if i <= j {
		return i
	}
	return j
}

func toInt(s string) int {
	return (int(s[0]-'0')*10+int(s[1]-'0'))*60 + int(s[3]-'0')*10 + int(s[4]-'0')
}
