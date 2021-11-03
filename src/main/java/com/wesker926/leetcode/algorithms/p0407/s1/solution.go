// Package s1
// @author: wesker.gh
// @date: 2021/11/3
// @description: dijkstra
package s1

func trapRainWater(heightMap [][]int) int {
	m, n := len(heightMap), len(heightMap[0])
	if m <= 2 || n <= 2 {
		return 0
	}

	heap := newHeap(m * n)
	visit := make([][]bool, m)
	for i := 0; i < m; i++ {
		visit[i] = make([]bool, n)
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if i == 0 || i == m-1 || j == 0 || j == n-1 {
				heap.offer(newNode(heightMap[i][j], i, j))
				visit[i][j] = true
			}

		}
	}

	var cur *node
	result, dir, nx, ny := 0, []int{-1, 0, 1, 0, -1}, 0, 0
	for heap.isNotEmpty() {
		cur = heap.poll()
		for i := 0; i < 4; i++ {
			nx, ny = cur.x+dir[i], cur.y+dir[i+1]
			if nx < 0 || nx >= m || ny < 0 || ny >= n || visit[nx][ny] {
				continue
			}
			if heightMap[nx][ny] < cur.val {
				result += cur.val - heightMap[nx][ny]
			}
			heap.offer(newNode(maxInt(cur.val, heightMap[nx][ny]), nx, ny))
			visit[nx][ny] = true
		}
	}
	return result
}

func maxInt(i, j int) int {
	if i >= j {
		return i
	}
	return j
}

type node struct {
	val int
	x   int
	y   int
}

func newNode(v, x, y int) *node {
	return &node{
		val: v,
		x:   x,
		y:   y,
	}
}

type heap struct {
	array []*node
}

func newHeap(cap int) *heap {
	return &heap{
		array: make([]*node, 0, cap),
	}
}

func (h *heap) offer(n *node) {
	h.array = append(h.array, n)
	h.up(len(h.array) - 1)
}

func (h *heap) poll() *node {
	v := h.array[0]
	h.swap(0, len(h.array)-1)
	h.array = h.array[:len(h.array)-1]
	h.down(0)
	return v
}

func (h *heap) up(i int) {
	var p int
	for i != 0 {
		p = (i - 1) / 2
		if h.array[p].val <= h.array[i].val {
			break
		}
		h.swap(p, i)
		i = p
	}
}

func (h *heap) down(i int) {
	for {
		l, r, min := i*2+1, i*2+2, i
		if l < len(h.array) && h.array[l].val < h.array[min].val {
			min = l
		}
		if r < len(h.array) && h.array[r].val < h.array[min].val {
			min = r
		}
		if min == i {
			break
		}
		h.swap(min, i)
		i = min
	}
}

func (h *heap) swap(i, j int) {
	h.array[i], h.array[j] = h.array[j], h.array[i]
}

func (h *heap) isNotEmpty() bool {
	return len(h.array) != 0
}
