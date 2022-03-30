// Package s1
// @author: wesker.gh
// @date: 2022/3/30
// @description: 双堆
package s1

import "container/heap"

func busiestServers(k int, arrival []int, load []int) []int {
	free, busy, count, max, ans := newHp(), newHp(), make([]int, k), 0, make([]int, 0)
	for i := 0; i < k; i++ {
		free.Push([]int{i})
	}
	heap.Init(free)
	heap.Init(busy)
	for i, t := range arrival {
		for busy.Len() != 0 && busy.Peek().([]int)[0] <= t {
			cur := heap.Pop(busy).([]int)
			heap.Push(free, []int{i + ((cur[1]-i)%k+k)%k})
		}
		if free.Len() == 0 {
			continue
		}
		cur := heap.Pop(free).([]int)[0] % k
		count[cur]++
		if count[cur] > max {
			max = count[cur]
			ans = []int{cur}
		} else if count[cur] == max {
			ans = append(ans, cur)
		}
		heap.Push(busy, []int{t + load[i], cur})
	}
	return ans
}

func newHp() *hp {
	return &hp{
		arr: make([][]int, 0),
	}
}

type hp struct {
	arr [][]int
}

func (h *hp) Peek() interface{} {
	return h.arr[0]
}

func (h *hp) Len() int {
	return len(h.arr)
}

func (h *hp) Less(i, j int) bool {
	return h.arr[i][0] < h.arr[j][0]
}

func (h *hp) Swap(i, j int) {
	h.arr[i], h.arr[j] = h.arr[j], h.arr[i]
}

func (h *hp) Push(x interface{}) {
	h.arr = append(h.arr, x.([]int))
}

func (h *hp) Pop() interface{} {
	v := h.arr[len(h.arr)-1]
	h.arr = h.arr[:len(h.arr)-1]
	return v
}
