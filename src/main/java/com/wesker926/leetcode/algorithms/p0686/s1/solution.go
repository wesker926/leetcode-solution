// Package s1
// @author: wesker.gh
// @date: 2021/12/22
// @description: KMP + 循环索引
package s1

func repeatedStringMatch(a string, b string) int {
	l1, l2, idx := len(a), len(b), kmp(a, b)
	if idx == -1 {
		return -1
	}
	if l1-idx >= l2 {
		return 1
	}
	return (l2+idx-1)/l1 + 1
}

func kmp(a, b string) int {
	m, n := len(a), len(b)
	pre := make([]int, n)
	for i, j := 1, 0; i < n; i++ {
		for ; j > 0 && b[i] != b[j]; j = pre[j-1] {
		}
		if b[j] == b[i] {
			j++
		}
		pre[i] = j
	}

	for i, j := 0, 0; i-j < m; i++ {
		for ; j > 0 && a[i%m] != b[j]; j = pre[j-1] {
		}
		if a[i%m] == b[j] {
			j++
		}
		if j == n {
			return i - n + 1
		}
	}
	return -1
}
