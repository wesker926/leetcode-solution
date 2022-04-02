// Package s1
// @author: wesker.gh
// @date: 2022/4/2
// @description: 分类讨论 + 堆
package s1

import (
	"container/heap"
	"math/bits"
	"unicode"
)

func strongPasswordChecker(password string) int {
	n, lack, add, sub, replace, h := len(password), 0, 0, 0, 0, newHp()
	for i, j := 0, 0; i < n; i = j {
		ch := rune(password[i])
		if unicode.IsUpper(ch) {
			lack |= 1
		} else if unicode.IsLower(ch) {
			lack |= 2
		} else if unicode.IsDigit(ch) {
			lack |= 4
		}
		for j = i + 1; j < n && password[i] == password[j]; j++ {
		}
		if j-i > 2 {
			h.Push(j - i)
		}
	}
	lack = 3 - bits.OnesCount(uint(lack))

	if n < 6 {
		for i, cur, count := 0, 0, 6-n; i < h.Len(); i++ {
			cur = (h.arr[i]+1)/2 - 1
			h.arr[i] -= minInt(count, cur) * 2
			count = maxInt(0, count-cur)
		}
		add, lack = 6-n, maxInt(0, lack-(6-n))
	} else if n > 20 {
		heap.Init(h)
		for h.Len() != 0 && n > 20 {
			cur := heap.Pop(h).(int)
			step := minInt(n-20, (cur%3)+1)
			n, cur, sub = n-step, cur-step, sub+step
			if cur > 2 {
				heap.Push(h, cur)
			}
		}
		sub = sub + n - 20
	}

	for _, i := range h.arr {
		replace += i / 3
	}
	replace = maxInt(replace, lack)

	return add + replace + sub
}

func maxInt(i, j int) int {
	if i >= j {
		return i
	}
	return j
}

func minInt(i, j int) int {
	if i <= j {
		return i
	}
	return j
}

func newHp() *hp {
	return &hp{
		arr: make([]int, 0),
	}
}

type hp struct {
	arr []int
}

func (h *hp) Len() int {
	return len(h.arr)
}

func (h *hp) Less(i, j int) bool {
	return h.arr[i]%3 < h.arr[j]%3
}

func (h *hp) Swap(i, j int) {
	h.arr[i], h.arr[j] = h.arr[j], h.arr[i]
}

func (h *hp) Push(x interface{}) {
	h.arr = append(h.arr, x.(int))
}

func (h *hp) Pop() interface{} {
	v := h.arr[len(h.arr)-1]
	h.arr = h.arr[:len(h.arr)-1]
	return v
}
