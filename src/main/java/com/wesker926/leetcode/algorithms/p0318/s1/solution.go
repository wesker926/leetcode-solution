// Package s1
// @author: wesker.gh
// @date: 2021/11/17
// @description: 主要考察字符串的bit表示
package s1

func maxProduct(words []string) int {
	m := make(map[int]int)
	for _, w := range words {
		bit := 0
		for _, c := range w {
			bit |= 1 << (c - 'a')
		}
		m[bit] = maxInt(m[bit], len(w))
	}

	max := 0
	for k1, v1 := range m {
		for k2, v2 := range m {
			max = maxInt(max, compute(k1, v1, k2, v2))
		}
	}
	return max
}

func compute(k1, v1, k2, v2 int) int {
	if k1&k2 != 0 {
		return 0
	}
	return v1 * v2
}

func maxInt(i, j int) int {
	if i >= j {
		return i
	}
	return j
}
