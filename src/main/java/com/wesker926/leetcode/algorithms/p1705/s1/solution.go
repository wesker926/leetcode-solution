// Package s1
// @author: wesker.gh
// @date: 2021/12/24
// @description: 优先级队列
package s1

import "container/heap"

func eatenApples(apples []int, days []int) int {
	ans := 0
	h := &Heap{
		arr: make([][]int, 0),
	}
	heap.Init(h)

	for i := 0; i < len(apples) || h.Len() > 0; i++ {
		if i < len(apples) && apples[i] != 0 {
			heap.Push(h, []int{i + days[i], apples[i]})
		}
		for h.Len() > 0 && (h.arr[0][0] <= i || h.arr[0][1] == 0) {
			heap.Pop(h)
		}
		if h.Len() > 0 {
			ans++
			h.arr[0][1]--
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
	return h.arr[i][0] <= h.arr[j][0]
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
