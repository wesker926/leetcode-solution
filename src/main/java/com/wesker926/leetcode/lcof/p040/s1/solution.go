// Package s1
// @author: wesker.gh
// @date: 2022/4/14
// @description: 快速选择
package s1

func getLeastNumbers(arr []int, k int) []int {
	for s, e, t, c := 0, len(arr)-1, k, 0; ; {
		c = quickSelect(arr, s, e)
		if c == t || c == t+1 {
			break
		} else if c > t {
			e = s + c - 2
		} else {
			t -= c
			s += c
		}
	}
	return arr[:k]
}

func quickSelect(arr []int, s, e int) int {
	i := s
	for j, k := s, arr[e]; j <= e; j++ {
		if arr[j] <= k {
			arr[i], arr[j] = arr[j], arr[i]
			i++
		}
	}
	return i - s
}
