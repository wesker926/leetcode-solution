// Package s1
// @author: wesker.gh
// @date: 2022/4/12
// @description: 递归检查
package s1

func verifyPostorder(postorder []int) bool {
	return check(postorder, 0, len(postorder)-1)
}

func check(post []int, s, e int) bool {
	if s >= e {
		return true
	}

	m := s
	for ; m < e; m++ {
		if post[m] >= post[e] {
			break
		}
	}
	for i := m + 1; i < e; i++ {
		if post[i] <= post[e] {
			return false
		}
	}
	return check(post, s, m-1) && check(post, m, e-1)
}
