// Package s1
// @author: wesker.gh
// @date: 2023/4/24
// @description: 后缀数组
// go语言自带后缀数组SA-IS算法实现
package s1

import (
	"index/suffixarray"
	"unsafe"
)

func lastSubstring(s string) string {
	sa := (*struct {
		_  []byte
		sa []int32
	})(unsafe.Pointer(suffixarray.New([]byte(s)))).sa
	return s[sa[len(s)-1]:]
}
