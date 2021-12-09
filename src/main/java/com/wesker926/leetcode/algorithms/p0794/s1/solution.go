// Package s1
// @author: wesker.gh
// @date: 2021/12/9
// @description: 检查
package s1

var check = [][]int{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}}

func validTicTacToe(board []string) bool {
	count1, count2, b := 0, 0, make([]int, 9)
	for i, s := range board {
		for j, c := range s {
			k := i*3 + j
			if c == 'X' {
				count1++
				b[k] = 1
			} else if c == 'O' {
				count2++
				b[k] = 2
			}
		}
	}

	if count2 > count1 || count1-count2 > 1 {
		return false
	}

	finish := make([]int, 0, 2)
	for _, ints := range check {
		if b[ints[0]] != 0 && b[ints[0]] == b[ints[1]] && b[ints[0]] == b[ints[2]] {
			finish = append(finish, b[ints[0]])
		}
	}

	if len(finish) == 0 {
		return true
	}

	if count1 == count2 {
		return len(finish) == 1 && finish[0] == 2
	}

	return (len(finish) == 2 && finish[0] == finish[1]) || (len(finish) == 1 && finish[0] == 1)
}
