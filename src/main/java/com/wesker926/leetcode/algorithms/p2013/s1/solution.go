// Package s1
// @author: wesker.gh
// @date: 2022/1/26
// @description: 哈希表（这题用数组会慢）
package s1

type DetectSquares struct {
	points map[int]map[int]int
}

func Constructor() DetectSquares {
	return DetectSquares{
		points: make(map[int]map[int]int),
	}
}

func (this *DetectSquares) Add(point []int) {
	ps, x, y := this.points, point[0], point[1]
	if ps[x] == nil {
		ps[x] = make(map[int]int)
	}
	ps[x][y]++
}

func (this *DetectSquares) Count(point []int) int {
	ps, x, y, ans, diff := this.points, point[0], point[1], 0, 0
	m1 := ps[x]
	for nx, m2 := range ps {
		if nx != x {
			diff = x - nx
			ans += m2[y] * m1[y+diff] * m2[y+diff]
			ans += m2[y] * m1[y-diff] * m2[y-diff]
		}
	}
	return ans
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Add(point);
 * param_2 := obj.Count(point);
 */
