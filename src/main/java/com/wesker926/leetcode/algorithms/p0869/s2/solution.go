// Package s2
// @author: wesker.gh
// @date: 2021/10/28
// @description: sort and compare
package s2

import (
	"sort"
	"strconv"
)

var cache = initCache()

func initCache() map[string]interface{} {
	c, n := make(map[string]interface{}), 1
	for ; n <= 1000000000; n <<= 1 {
		c[numToStr(n)] = nil
	}
	return c
}

func reorderedPowerOf2(n int) bool {
	_, ok := cache[numToStr(n)]
	return ok
}

func numToStr(n int) string {
	r := []byte(strconv.Itoa(n))
	sort.Slice(r, func(i, j int) bool {
		if r[i] < r[j] {
			return true
		}
		return false
	})
	return string(r)
}
