// Package s1
// @author: wesker.gh
// @date: 2021/12/6
// @description: 遍历
package s1

func truncateSentence(s string, k int) string {
	result := make([]byte, 0, len(s))
	for _, c := range s {
		if c == ' ' {
			k--
			if k == 0 {
				break
			}
		}
		result = append(result, byte(c))
	}
	return string(result)
}
