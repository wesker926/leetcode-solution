// Package s1
// @author: wesker.gh
// @date: 2021/11/28
// @description: 滑动窗口 + 判断优化
package s1

func findAnagrams(s string, p string) []int {
	table, result := make([]int, 26), make([]int, 0)
	for _, c := range p {
		table[c-'a']++
	}

	count, right, temp := len(p), 0, 0
	for l, r := 0, 0; r < len(s); r++ {
		temp = int(s[r] - 'a')
		if table[temp] > 0 {
			right++
		}
		table[temp]--

		if right == count {
			result = append(result, l)
		}

		if r-l+1 >= count {
			temp = int(s[l] - 'a')
			if table[temp] >= 0 {
				right--
			}
			table[temp]++
			l++
		}
	}
	return result
}
