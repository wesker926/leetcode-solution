// Package s1
// @author: wesker.gh
// @date: 2021/10/28
// @description: dfs
package s1

func reorderedPowerOf2(n int) bool {
	if n&(n-1) == 0 {
		return true
	}

	nums := make([]int, 0, 10)
	for ; n != 0; n /= 10 {
		nums = append(nums, n%10)
	}
	return dfs(nums, 0)
}

func dfs(nums []int, start int) bool {
	if start >= len(nums) {
		return check(nums)
	}

	for i := start; i < len(nums); i++ {
		if start == 0 && nums[i] == 0 {
			continue
		}

		if start != i && nums[start] == nums[i] {
			continue
		}

		swap(nums, start, i)
		if dfs(nums, start+1) {
			return true
		}
		swap(nums, start, i)
	}
	return false
}

func swap(nums []int, i, j int) {
	t := nums[i]
	nums[i] = nums[j]
	nums[j] = t
}

func check(nums []int) bool {
	n, m := 0, 1
	for i := len(nums) - 1; i >= 0; i-- {
		n += nums[i] * m
		m *= 10
	}

	if n&(n-1) == 0 {
		return true
	}
	return false
}
