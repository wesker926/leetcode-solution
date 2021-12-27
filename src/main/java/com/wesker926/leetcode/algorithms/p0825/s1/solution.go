// Package s1
// @author: wesker.gh
// @date: 2021/12/27
// @description: 前缀和
package s1

func numFriendRequests(ages []int) int {
	pre := make([]int, 121)
	for _, age := range ages {
		pre[age]++
	}
	for i, sum := 0, 0; i < len(pre); i++ {
		sum += pre[i]
		pre[i] = sum
	}

	ans := 0
	for i, j := 15, 0; i < len(pre); i++ {
		j = pre[i] - pre[i-1]
		if j > 0 {
			ans += j * (pre[i] - pre[(i>>1)+7] - 1)
		}
	}
	return ans
}
