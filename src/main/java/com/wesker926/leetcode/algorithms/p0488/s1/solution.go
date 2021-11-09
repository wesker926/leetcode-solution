// Package s1
// @author: wesker.gh
// @date: 2021/11/9
// @description: 暴力搜索
package s1

const big = 666

var (
	gHand   string
	handLen int
	cache   map[string]int
)

func findMinStep(board string, hand string) int {
	gHand = hand
	handLen = len(hand)
	cache = make(map[string]int)
	res := dfs(board, 0)
	if res == big {
		return -1
	}
	return res
}

func dfs(board string, cur int) int {
	if len(board) == 0 {
		return 0
	}
	if c, ok := cache[board]; ok {
		return c
	}
	nxt, res, nxtBoard := 0, big, ""
	for i := 0; i < handLen; i++ {
		if (cur>>i)&1 == 1 {
			continue
		}
		nxt = cur | (1 << i)
		for j := 0; j <= len(board); j++ {
			nxtBoard = remove(board[:j]+gHand[i:i+1]+board[j:], j)
			res = minInt(dfs(nxtBoard, nxt)+1, res)
		}
	}
	cache[board] = res
	return res
}

func remove(str string, i int) string {
	for i >= 0 && i < len(str) {
		l, r := i, i
		for ; l >= 0 && str[l] == str[i]; l-- {
		}
		for ; r < len(str) && str[r] == str[i]; r++ {
		}
		if r-l > 3 {
			str = str[:l+1] + str[r:]
			if l >= 0 {
				i = l
			} else {
				i = r
			}
		} else {
			break
		}
	}
	return str
}

func minInt(i, j int) int {
	if i <= j {
		return i
	}
	return j
}
