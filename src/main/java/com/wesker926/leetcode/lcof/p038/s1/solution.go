// Package s1
// @author: wesker.gh
// @date: 2022/4/14
// @description: 递归（交换）
package s1

func permutation(s string) []string {
	return recursion(([]byte)(s), 0, make([]string, 0))
}

func recursion(str []byte, idx int, ans []string) []string {
	if idx == len(str) {
		ans = append(ans, string(str))
		return ans
	}

	set := make([]bool, 256)
	for i := idx; i < len(str); i++ {
		if set[str[i]] {
			continue
		}
		set[str[i]] = true
		str[idx], str[i] = str[i], str[idx]
		ans = recursion(str, idx+1, ans)
		str[idx], str[i] = str[i], str[idx]
	}
	return ans
}
