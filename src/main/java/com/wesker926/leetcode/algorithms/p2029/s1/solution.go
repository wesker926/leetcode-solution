// Package s1
// @author: wesker.gh
// @date: 2022/1/20
// @description: 博弈论
package s1

func stoneGameIX(stones []int) bool {
	count := make([]int, 3)
	for _, stone := range stones {
		count[stone%3]++
	}
	if (count[0] & 1) == 0 {
		return count[1] >= 1 && count[2] >= 1
	}
	return abs(count[1]-count[2]) > 2
}

func abs(i int) int {
	if i >= 0 {
		return i
	}
	return -i
}
