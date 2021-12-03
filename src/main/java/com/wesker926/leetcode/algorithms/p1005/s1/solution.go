// Package s1
// @author: wesker.gh
// @date: 2021/12/3
// @description: 贪心 + 桶排序
package s1

func largestSumAfterKNegations(nums []int, k int) int {
	bucket := make([]int, 201)
	for _, num := range nums {
		bucket[num+100]++
	}

	sum, min := 0, 100
	for i, c := range bucket {
		if c == 0 {
			continue
		}

		num := i - 100
		if num >= 0 {
			sum += num * c
		} else {
			if k >= c {
				sum += (-num) * c
				k -= c
			} else {
				sum += (-num) * k
				sum += num * (c - k)
				k = 0
			}
			num = -num
		}

		if num < min {
			min = num
		}
	}

	if k&1 == 0 {
		return sum
	}
	return sum - min*2
}
