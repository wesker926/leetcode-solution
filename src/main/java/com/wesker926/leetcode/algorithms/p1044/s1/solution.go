// Package s1
// @author: wesker.gh
// @date: 2021/12/23
// @description: 二分 + Rabin-Karp算法
package s1

import (
	"math"
	"math/rand"
)

var (
	h1, h2         int
	a1, a2, m1, m2 = prepare()
)

func prepare() (int, int, int, int) {
	return randInt(26, 100), randInt(26, 100), randInt(1e9+7, math.MaxInt32), randInt(1e9+7, math.MaxInt32)
}

func randInt(a, b int) int {
	return a + rand.Intn(b-a)
}

func pow(a, b, m int) int {
	res := 1
	for ; b > 0; b >>= 1 {
		if b&1 != 0 {
			res = (res * a) % m
		}
		a = (a * a) % m
	}
	return res
}

func longestDupSubstring(s string) string {
	l, r, m, f := 1, len(s)-1, 0, 0
	ans, arr := []int{-1, -1}, make([]int, len(s))
	for i, c := range s {
		arr[i] = int(c - 'a')
	}

	for l <= r {
		m = l + (r-l)/2
		f = find(arr, m)
		if f != -1 {
			l = m + 1
			ans[0], ans[1] = f, m
		} else {
			r = m - 1
		}
	}

	if ans[0] == -1 {
		return ""
	}
	return s[ans[0] : ans[0]+ans[1]]
}

func find(arr []int, n int) int {
	h1, h2 = pow(a1, n, m1), pow(a2, n, m2)
	c1, c2 := 0, 0
	for _, c := range arr[:n] {
		c1 = (c1*a1 + c) % m1
		c2 = (c2*a2 + c) % m2
	}

	set := map[[2]int]bool{{c1, c2}: true}
	for start := n; start < len(arr); start++ {
		c1 = (c1*a1 - (arr[start-n] * h1) + arr[start]) % m1
		if c1 < 0 {
			c1 += m1
		}
		c2 = (c2*a2 - (arr[start-n] * h2) + arr[start]) % m2
		if c2 < 0 {
			c2 += m2
		}
		if set[[2]int{c1, c2}] {
			return start - n + 1
		}
		set[[2]int{c1, c2}] = true
	}
	return -1
}
