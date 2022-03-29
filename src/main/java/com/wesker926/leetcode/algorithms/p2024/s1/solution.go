// Package s1
// @author: wesker.gh
// @date: 2022/3/29
// @description: 两次滑动窗口
package s1

func maxConsecutiveAnswers(answerKey string, k int) int {
	return maxInt(replace(answerKey, k, 'T'), replace(answerKey, k, 'F'))
}

func replace(answerKey string, k int, tar uint8) int {
	ans, n := 0, len(answerKey)
	for i, j, c := 0, 0, 0; j < n; j++ {
		if answerKey[j] == tar {
			c++
		}
		if c > k {
			for ; answerKey[i] != tar; i++ {
			}
			c--
			i++
		}
		ans = maxInt(j-i+1, ans)
	}
	return ans
}

func maxInt(i, j int) int {
	if i >= j {
		return i
	}
	return j
}
