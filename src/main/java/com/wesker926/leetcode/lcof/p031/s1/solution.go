// Package s1
// @author: wesker.gh
// @date: 2022/4/8
// @description: 模拟
package s1

func validateStackSequences(pushed []int, popped []int) bool {
	stack := make([]int, 0)
	for _, push := range pushed {
		stack = append(stack, push)
		for len(stack) > 0 && stack[len(stack)-1] == popped[0] {
			stack, popped = stack[:len(stack)-1], popped[1:]
		}
	}
	return len(stack) == 0
}
