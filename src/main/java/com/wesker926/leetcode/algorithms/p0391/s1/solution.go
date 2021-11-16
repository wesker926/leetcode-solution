// Package s1
// @author: wesker.gh
// @date: 2021/11/16
// @description: 扫描线
package s1

import "sort"

func isRectangleCover(rectangles [][]int) bool {
	n := len(rectangles)
	lines := make([][]int, 0, n*2)
	for _, r := range rectangles {
		lines = append(lines, []int{r[0], r[1], r[3], 0}, []int{r[2], r[1], r[3], 1})
	}
	sort.Slice(lines, func(i, j int) bool {
		if lines[i][0] != lines[j][0] {
			return lines[i][0] < lines[j][0]
		} else {
			return lines[i][1] < lines[j][1]
		}
	})

	n *= 2
	var tl *[][]int
	ll, rl := make([][]int, 0), make([][]int, 0)
	for l, r := 0, 0; l < n; l = r {
		for r = l + 1; r < n && lines[l][0] == lines[r][0]; r++ {
		}

		ll, rl = ll[:0], rl[:0]
		for i := l; i < r; i++ {
			cur := []int{lines[i][1], lines[i][2]}

			tl = &ll
			if lines[i][3] == 1 {
				tl = &rl
			}

			if len(*tl) == 0 {
				*tl = append(*tl, cur)
				continue
			}

			pre := (*tl)[len(*tl)-1]
			if cur[0] < pre[1] {
				return false
			} else if cur[0] == pre[1] {
				pre[1] = cur[1]
			} else {
				*tl = append(*tl, cur)
			}
		}

		if l == 0 || r == n {
			if len(ll)+len(rl) != 1 {
				return false
			}
		} else {
			if len(ll) != len(rl) {
				return false
			}
			for i := 0; i < len(ll); i++ {
				if ll[i][0] != rl[i][0] || ll[i][1] != rl[i][1] {
					return false
				}
			}
		}
	}
	return true
}
