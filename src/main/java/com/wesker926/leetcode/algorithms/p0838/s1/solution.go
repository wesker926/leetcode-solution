// Package s1
// @author: wesker.gh
// @date: 2022/2/21
// @description: 双指针
package s1

func pushDominoes(dominoes string) string {
	cs, n, i, j := []byte(dominoes), len(dominoes), 0, 0
	for ; j < n; j++ {
		for ; j < n && cs[j] == '.'; j++ {
		}

		if j >= n || cs[j] == 'R' {
			for i++; i < n && i < j; i++ {
				cs[i] = cs[i-1]
			}
			i = j
			continue
		}

		if cs[i] == 'R' {
			for k := j; i < k; i, k = i+1, k-1 {
				cs[i], cs[k] = 'R', 'L'
			}
		} else {
			for ; i < j; i++ {
				cs[i] = 'L'
			}
		}
		i = j + 1
	}
	return string(cs)
}
