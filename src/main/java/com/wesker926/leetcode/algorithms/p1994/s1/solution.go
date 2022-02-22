// Package s1
// @author: wesker.gh
// @date: 2022/2/22
// @description: DP + 状态压缩
package s1

var (
	limit  = 30
	mod    = 1000000007
	primes = []int{2, 3, 5, 7, 11, 13, 17, 19, 23, 29}
)

func numberOfGoodSubsets(nums []int) int {
	freq := make([]int, limit+1)
	for _, num := range nums {
		freq[num]++
	}
	dp := make([]int, 1<<len(primes))
	dp[0] = 1
	for i := 0; i < freq[1]; i++ {
		dp[0] = (dp[0] * 2) % mod
	}

	for i := 2; i <= limit; i++ {
		if freq[i] == 0 {
			continue
		}

		x, bits, check := i, 0, true
		for j, p := range primes {
			if x%(p*p) == 0 {
				check = false
				break
			} else if x%p == 0 {
				bits |= 1 << j
			}
		}

		if !check {
			continue
		}

		for mask := 1 << len(primes); mask > 0; mask-- {
			if (mask & bits) == bits {
				dp[mask] = (dp[mask] + dp[mask^bits]*freq[i]) % mod
			}
		}
	}

	ans := 0
	for i := 1; i < len(dp); i++ {
		ans = (ans + dp[i]) % mod
	}
	return ans
}
