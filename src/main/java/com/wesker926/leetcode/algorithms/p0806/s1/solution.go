// Package s1
// @author: wesker.gh
// @date: 2022/4/12
// @description: 遍历
package s1

func numberOfLines(widths []int, s string) []int {
	count, width := 1, 0
	for _, c := range s {
		cw := widths[c-'a']
		if width+cw > 100 {
			width = 0
			count++
		}
		width += cw
	}
	return []int{count, width}
}
