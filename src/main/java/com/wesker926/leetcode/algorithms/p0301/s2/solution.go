// Package s2
// @author: wesker.gh
// @date: 2021/10/27
// @description: bfs
package s2

func removeInvalidParentheses(s string) []string {
	result, set := make([]string, 0), make(map[string]interface{})
	var temp map[string]interface{}

	set[s] = nil
	for {
		for k, _ := range set {
			if valid(k) {
				result = append(result, k)
			}
		}

		if len(result) != 0 {
			return result
		}

		temp = make(map[string]interface{})
		for k, _ := range set {
			for i := 0; i < len(k); i++ {
				if i != 0 && k[i] == k[i-1] {
					continue
				}

				if k[i] == '(' || k[i] == ')' {
					temp[k[:i]+k[i+1:]] = nil
				}
			}
		}
		set = temp
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
