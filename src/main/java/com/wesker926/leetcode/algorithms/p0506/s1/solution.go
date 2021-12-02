// Package s1
// @author: wesker.gh
// @date: 2021/12/2
// @description: 排序
package s1

import (
	"sort"
	"strconv"
)

var texts = []string{"Gold Medal", "Silver Medal", "Bronze Medal"}

func findRelativeRanks(score []int) []string {
	s := make([][]int, len(score))
	for idx, num := range score {
		s[idx] = []int{num, idx}
	}

	sort.Slice(s, func(i, j int) bool {
		return s[i][0] > s[j][0]
	})

	r := make([]string, len(s))
	for i := 0; i < len(texts) && i < len(s); i++ {
		r[s[i][1]] = texts[i]
	}
	for i := len(texts); i < len(s); i++ {
		r[s[i][1]] = strconv.Itoa(i + 1)
	}
	return r
}
