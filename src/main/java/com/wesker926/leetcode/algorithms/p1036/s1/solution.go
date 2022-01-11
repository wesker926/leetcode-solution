// Package s1
// @author: wesker.gh
// @date: 2022/1/11
// @description: 限制步数的DFS（BFS亦可）
package s1

var (
	c   int
	l   int
	s   int64
	t   int64
	v   map[int64]bool
	b   map[int64]bool
	max = 1000000
	d   = [][]int{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}
)

func isEscapePossible(blocked [][]int, source []int, target []int) bool {
	c, l = 0, len(blocked)*(len(blocked)-1)/2
	s, t = encode(source[0], source[1]), encode(target[0], target[1])
	v, b = make(map[int64]bool), make(map[int64]bool)
	for _, block := range blocked {
		b[encode(block[0], block[1])] = true
	}
	r1, r2 := dfs(source[0], source[1], true)
	if r1 {
		return true
	}
	if !r2 {
		return false
	}

	c, v = 0, make(map[int64]bool)
	r1, r2 = dfs(target[0], target[1], false)
	if r1 {
		return true
	}
	return r2
}

func dfs(i, j int, mode bool) (bool, bool) {
	code := encode(i, j)
	v[code] = true
	c++
	if (mode && code == t) || (!mode && code == s) {
		return true, false
	}
	if c > l {
		return false, true
	}
	for _, di := range d {
		ni, nj := i+di[0], j+di[1]
		nCode := encode(ni, nj)
		if !b[nCode] && !v[nCode] && ni >= 0 && ni < max && nj >= 0 && nj < max {
			r1, r2 := dfs(ni, nj, mode)
			if r1 {
				return true, false
			}
			if r2 {
				return false, true
			}
		}
	}
	return false, false
}

func encode(i, j int) int64 {
	return (int64(i) << 20) | int64(j)
}
