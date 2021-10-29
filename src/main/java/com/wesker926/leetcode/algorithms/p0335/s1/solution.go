// Package s1
// @author: wesker.gh
// @date: 2021/10/29
// @description: 螺旋判断
package s1

func isSelfCrossing(distance []int) bool {
	if len(distance) <= 3 {
		return false
	}

	// 大螺旋
	var i int
	for i = 2; i < len(distance); i++ {
		if distance[i] <= distance[i-2] {
			break
		}
	}
	if i >= len(distance)-1 {
		return false
	}

	// 大螺旋转小螺旋
	limit := distance[i-1]
	if (i >= 4 && distance[i] >= distance[i-2]-distance[i-4]) || (i == 3 && distance[i] == distance[i-2]) {
		limit -= distance[i-3]
	}

	if distance[i+1] >= limit {
		return true
	}

	for i += 2; i < len(distance); i++ {
		if distance[i] >= distance[i-2] {
			return true
		}
	}

	return false
}
