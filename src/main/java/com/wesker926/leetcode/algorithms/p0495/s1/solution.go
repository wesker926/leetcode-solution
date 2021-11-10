// Package s1
// @author: wesker.gh
// @date: 2021/11/10
// @description: 遍历
package s1

func findPoisonedDuration(timeSeries []int, duration int) int {
	sum := 0
	for i := 0; i < len(timeSeries)-1; i++ {
		sum += minInt(timeSeries[i+1]-timeSeries[i], duration)
	}
	return sum + duration
}

func minInt(i, j int) int {
	if i <= j {
		return i
	}
	return j
}
