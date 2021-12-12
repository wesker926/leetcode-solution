// Package s1
// @author: wesker.gh
// @date: 2021/12/12
// @description: ...
package s1

var diff = 'A' - 'a'

func toLowerCase(s string) string {
	result := make([]byte, 0, len(s))
	for _, c := range s {
		if c >= 'A' && c <= 'Z' {
			result = append(result, byte(c-diff))
		} else {
			result = append(result, byte(c))
		}
	}
	return string(result)
}
