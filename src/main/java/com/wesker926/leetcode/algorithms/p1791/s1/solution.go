// Package s1
// @author: wesker.gh
// @date: 2022/2/18
// @description: 奇葩题
package s1

func findCenter(edges [][]int) int {
	if edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] {
		return edges[0][0]
	}
	return edges[0][1]
}
