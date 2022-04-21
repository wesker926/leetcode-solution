// Package s1
// @author: wesker.gh
// @date: 2022/4/7
// @description: DP（同主站-p0010）
package s1

func isMatch(s string, p string) bool {
	len1, len2 := len(s), len(p)
	dp := make([][]bool, len1+1)
	for i := 0; i <= len1; i++ {
		dp[i] = make([]bool, len2+1)
	}
	dp[0][0] = true

	for i := 0; i <= len1; i++ {
		for j := 0; j <= len2; j++ {
			if j == 0 {
				continue
			}
			if p[j-1] != '*' {
				if i != 0 && (s[i-1] == p[j-1] || p[j-1] == '.') {
					dp[i][j] = dp[i-1][j-1]
				}
				continue
			}

			if j == 1 {
				continue
			}
			dp[i][j] = dp[i][j-2]
			if i != 0 && (s[i-1] == p[j-2] || p[j-2] == '.') {
				dp[i][j] = dp[i][j] || dp[i-1][j]
			}
		}
	}
	return dp[len1][len2]
}
