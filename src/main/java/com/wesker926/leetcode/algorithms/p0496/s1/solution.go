// Package s1
// @author: wesker.gh
// @date: 2021/10/26
// @description: map + stack
package s1

func nextGreaterElement(nums1 []int, nums2 []int) []int {
	var m [10001]int
	for i := 0; i < len(m); i++ {
		m[i] = -1
	}
	stack := make([]int, 0)

	for _, cur := range nums2 {
		for len(stack) > 0 && stack[len(stack)-1] < cur {
			m[stack[len(stack)-1]] = cur
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, cur)
	}

	result := make([]int, len(nums1))
	for i := 0; i < len(nums1); i++ {
		result[i] = m[nums1[i]]
	}
	return result
}
