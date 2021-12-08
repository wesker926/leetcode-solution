// Package s1
// @author: wesker.gh
// @date: 2021/12/8
// @description: 滑动窗口
package s1

func maxSumOfThreeSubarrays(nums []int, k int) []int {
	sum, max, idx, ans := make([]int, 3), make([]int, 3), make([]int, 3), ([]int)(nil)

	for i := 0; i < k-1; i++ {
		sum[0] += nums[i]
		sum[1] += nums[i+k]
		sum[2] += nums[i+k*2]
	}

	for i := k*3 - 1; i < len(nums); i++ {
		sum[0] += nums[i-k*2]
		sum[1] += nums[i-k]
		sum[2] += nums[i]

		if sum[0] > max[0] {
			max[0] = sum[0]
			idx[0] = i - k*3 + 1
		}

		if max[0]+sum[1] > max[1] {
			max[1] = max[0] + sum[1]
			idx[1] = idx[0]
			idx[2] = i - k*2 + 1
		}

		if max[1]+sum[2] > max[2] {
			max[2] = max[1] + sum[2]
			ans = []int{idx[1], idx[2], i - k + 1}
		}

		sum[0] -= nums[i-k*3+1]
		sum[1] -= nums[i-k*2+1]
		sum[2] -= nums[i-k+1]
	}

	return ans
}
