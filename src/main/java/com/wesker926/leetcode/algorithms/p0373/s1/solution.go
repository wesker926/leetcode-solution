// Package s1
// @author: wesker.gh
// @date: 2022/1/14
// @description: 优先级队列
package s1

import "container/heap"

var n1, n2 []int

func kSmallestPairs(nums1 []int, nums2 []int, k int) [][]int {
	n1, n2 = nums1, nums2
	ans, h := make([][]int, 0, k), &Heap{arr: make([][]int, 0, len(n1))}
	heap.Init(h)
	for i := range n1 {
		heap.Push(h, []int{i, 0})
	}
	for idx, cur := 0, []int{}; h.Len() != 0 && idx < k; idx++ {
		cur = (heap.Pop(h)).([]int)
		ans = append(ans, []int{n1[cur[0]], n2[cur[1]]})
		if cur[1] < len(n2)-1 {
			heap.Push(h, []int{cur[0], cur[1] + 1})
		}
	}
	return ans
}

type Heap struct {
	arr [][]int
}

func (h *Heap) Len() int {
	return len(h.arr)
}

func (h *Heap) Less(i, j int) bool {
	return n1[h.arr[i][0]]+n2[h.arr[i][1]] < n1[h.arr[j][0]]+n2[h.arr[j][1]]
}

func (h *Heap) Swap(i, j int) {
	h.arr[i], h.arr[j] = h.arr[j], h.arr[i]
}

func (h *Heap) Push(x interface{}) {
	h.arr = append(h.arr, x.([]int))
}

func (h *Heap) Pop() interface{} {
	v := h.arr[len(h.arr)-1]
	h.arr = h.arr[:len(h.arr)-1]
	return v
}
