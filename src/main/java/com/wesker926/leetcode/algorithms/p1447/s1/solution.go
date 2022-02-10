// Package s1
// @author: wesker.gh
// @date: 2022/2/10
// @description: GCD
package s1

import "fmt"

func simplifiedFractions(n int) []string {
	ans := make([]string, 0)
	for i := 2; i <= n; i++ {
		for j := 1; j < i; j++ {
			if gcd(j, i) == 1 {
				ans = append(ans, fmt.Sprintf("%d/%d", j, i))
			}
		}
	}
	return ans
}

func gcd(a, b int) int {
	for a != 0 {
		a, b = b%a, a
	}
	return b
}
