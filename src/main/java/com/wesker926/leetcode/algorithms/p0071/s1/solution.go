// Package s1
// @author: wesker.gh
// @date: 2022/1/6
// @description: 逐字符检查
package s1

func simplifyPath(path string) string {
	path += "/"
	res := make([]rune, 0, len(path))
	res = append(res, '/')
	for i, last, cur := 0, 0, 0; i < len(path); i++ {
		if path[i] != '/' {
			cur++
			res = append(res, rune(path[i]))
			continue
		}

		last = len(res) - 1
		if res[last] == '/' {
			continue
		}

		if res[last] != '.' || (cur == 2 && res[last-1] != '.') || cur > 2 {
			res = append(res, '/')
		} else if cur == 1 {
			res = res[:last]
		} else {
			res = res[:last-2]
			for last = len(res) - 1; last >= 0 && res[last] != '/'; last-- {
			}
			if last < 0 {
				last = 0
			}
			res = res[:last+1]
		}
		cur = 0
	}
	if len(res) != 1 && res[len(res)-1] == '/' {
		res = res[:len(res)-1]
	}
	return string(res)
}
