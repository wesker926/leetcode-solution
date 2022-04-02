// Package s2
// @author: wesker.gh
// @date: 2022/4/2
// @description: 分类讨论
package s2

import (
	"math/bits"
	"unicode"
)

func strongPasswordChecker(password string) int {
	n, lack, add, replace, sub, modCount := len(password), 0, 0, 0, 0, make([]int, 3)
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
			replace += (j - i) / 3
			modCount[(j-i)%3]++
		}
	}
	lack = 3 - bits.OnesCount(uint(lack))

	if n < 6 {
		add = 6 - n
		replace = maxInt(0, lack-add)
	} else if n <= 20 {
		replace = maxInt(replace, lack)
	} else {
		for i, step, count := 0, 0, 0; i < len(modCount) && n > 20; i, n, replace, sub = i+1, n-step, replace-count, sub+step {
			if i == 2 {
				modCount[i] = replace
			}
			count = minInt(modCount[i], (n-20)/(i+1))
			step = count * (i + 1)
		}
		sub, replace = sub+n-20, maxInt(replace, lack)
	}

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
