// Package s1
// @author: wesker.gh
// @date: 2021/11/1
// @description: set
package s1

func distributeCandies(candyType []int) int {
	set, c := [200001]bool{}, 0
	for _, i := range candyType {
		if !set[i+100000] {
			c++
			set[i+100000] = true
		}
	}
	return minInt(c, len(candyType)/2)
}

func minInt(i, j int) int {
	if i <= j {
		return i
	}
	return j
}
