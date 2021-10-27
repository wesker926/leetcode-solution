// Package s1
// @author: wesker.gh
// @date: 2021/10/27
// @description: dfs
package s1

var result []string

func removeInvalidParentheses(s string) []string {
	lr, rr := 0, 0
	for i := 0; i < len(s); i++ {
		if s[i] == '(' {
			lr++
		} else if s[i] == ')' {
			if lr == 0 {
				rr++
			} else {
				lr--
			}
		}
	}

	result = make([]string, 0)
	dfs(s, 0, 0, 0, lr, rr)
	return result
}

func dfs(str string, start, lc, rc, lr, rr int) {
	if lr == 0 && rr == 0 {
		if valid(str) {
			result = append(result, str)
		}
		return
	}

	var r bool
	for i := start; i < len(str); i++ {
		if str[i] != '(' && str[i] != ')' {
			continue
		}

		if len(str)-i < lr+rr {
			return
		}

		left := str[i] == '('
		if i == start || str[i] != str[i-1] {
			if lr > 0 && left {
				dfs(str[:i]+str[i+1:], i, lc, rc, lr-1, rr)
			}

			if rr > 0 && !left {
				dfs(str[:i]+str[i+1:], i, lc, rc, lr, rr-1)
			}
		}

		if lc, rc, r = countAndCut(str[i], lc, rc); !r {
			return
		}
	}
}

func valid(str string) bool {
	count := 0
	for i := 0; i < len(str); i++ {
		if str[i] == '(' {
			count++
		} else if str[i] == ')' {
			count--
			if count < 0 {
				return false
			}
		}
	}

	if count == 0 {
		return true
	}
	return false
}

func countAndCut(c byte, lc, rc int) (int, int, bool) {
	if c == '(' {
		lc++
	} else {
		rc++
	}

	r := rc <= lc
	return lc, rc, r
}
