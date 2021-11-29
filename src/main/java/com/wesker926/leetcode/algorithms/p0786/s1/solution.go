// Package s1
// @author: wesker.gh
// @date: 2021/11/29
// @description: 优先级队列（堆）
package s1

import "container/heap"

func kthSmallestPrimeFraction(arr []int, k int) []int {
	n := len(arr)
	h := make(hp, 0, n-1)
	for i := 1; i < n; i++ {
		heap.Push(&h, []int{0, i, arr[0], arr[i]})
	}
	heap.Init(&h)
	var cur []int
	for i := 0; i < k; i++ {
		cur = heap.Pop(&h).([]int)
		if cur[1]-cur[0] > 1 {
			heap.Push(&h, []int{cur[0] + 1, cur[1], arr[cur[0]+1], arr[cur[1]]})
		}
	}
	return []int{cur[2], cur[3]}
}

type hp [][]int

func (h hp) Len() int {
	return len(h)
}

func (h hp) Less(i, j int) bool {
	return h[i][2]*h[j][3] < h[j][2]*h[i][3]
}

func (h hp) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *hp) Push(v interface{}) {
	*h = append(*h, v.([]int))
}

func (h *hp) Pop() interface{} {
	v := (*h)[len(*h)-1]
	*h = (*h)[:len(*h)-1]
	return v
}
