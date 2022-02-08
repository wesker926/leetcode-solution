// Package s1
// @author: wesker.gh
// @date: 2022/2/8
// @description: 哈希表模拟
package s1

func gridIllumination(n int, lamps [][]int, queries [][]int) []int {
	m1, m2 := make(map[int]int), make(map[int]bool)
	for _, lamp := range lamps {
		if k := (lamp[0] << 32) | lamp[1]; !m2[k] {
			m1[lamp[0]<<32]++
			m1[(lamp[1]<<32)|1]++
			m1[((lamp[1]-lamp[0])<<32)|2]++
			m1[((lamp[1]+lamp[0])<<32)|3]++
			m2[(lamp[0]<<32)|lamp[1]] = true
		}
	}
	ans := make([]int, len(queries))
	for i, query := range queries {
		if m1[query[0]<<32] > 0 || m1[(query[1]<<32)|1] > 0 ||
			m1[((query[1]-query[0])<<32)|2] > 0 || m1[((query[1]+query[0])<<32)|3] > 0 {
			ans[i] = 1
		} else {
			ans[i] = 0
		}
		for x := -1; x <= 1; x++ {
			for y := -1; y <= 1; y++ {
				if k := ((query[0] + x) << 32) | (query[1] + y); m2[k] {
					delete(m2, k)
					m1[(query[0]+x)<<32]--
					m1[((query[1]+y)<<32)|1]--
					m1[((query[1]+y-query[0]-x)<<32)|2]--
					m1[((query[1]+y+query[0]+x)<<32)|3]--
				}
			}
		}
	}
	return ans
}
