// Package s1
// @author: wesker.gh
// @date: 2022/1/10
// @description: 爆搜
// 因int(64-bit)足够满足用例数据，故未使用字符串解决大数问题
package s1

var arr []int

func isAdditiveNumber(num string) bool {
	if len(num) < 3 {
		return false
	}

	arr = make([]int, len(num))
	for i, c := range num {
		arr[i] = int(c - '0')
	}

	for i := 1; i < len(arr)-1; i++ {
		for j := i + 1; j < len(arr); j++ {
			if check(0, i, j) {
				return true
			}
			if arr[i] == 0 {
				break
			}
		}
		if arr[0] == 0 {
			break
		}
	}

	return false
}

func check(a, b, c int) bool {
	if len(arr)-c < maxInt(b-a, c-b) {
		return false
	}

	for x, y, k := 0, 0, 0; c < len(arr); a, b, c = b, c, k {
		x = getNum(a, b) + getNum(b, c)
		k = c + getLen(x)
		y = getNum(c, k)
		if x != y {
			return false
		}
	}
	return true
}

func getNum(i, j int) int {
	num := 0
	for ; i < j && i < len(arr); i++ {
		num = num*10 + arr[i]
	}
	return num
}

func getLen(i int) int {
	l := 1
	for ; i >= 10; l, i = l+1, i/10 {
	}
	return l
}

func maxInt(i, j int) int {
	if i >= j {
		return i
	}
	return j
}
