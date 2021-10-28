// Package s3
// @author: wesker.gh
// @date: 2021/10/28
// @description: count and compare
package s3

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
	cs := make([]byte, 10)
	for ; n != 0; n /= 10 {
		cs[n%10]++
	}
	return string(cs)
}
