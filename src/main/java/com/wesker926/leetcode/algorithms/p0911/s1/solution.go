// Package s1
// @author: wesker.gh
// @date: 2021/12/11
// @description: TODO
package s1

type TopVotedCandidate struct {
	time   []int
	record []int
}

func Constructor(persons []int, times []int) TopVotedCandidate {
	record := make([]int, len(times))
	bucket := make([]int, 5000)
	max := 0

	for i := range times {
		bucket[persons[i]]++
		if bucket[persons[i]] >= max {
			max = bucket[persons[i]]
			record[i] = persons[i]
		} else {
			record[i] = record[i-1]
		}
	}

	return TopVotedCandidate{
		time:   times,
		record: record,
	}
}

func (this *TopVotedCandidate) Q(t int) int {
	l, r, m := 0, len(this.record)-1, 0
	for l <= r {
		m = l + (r-l)/2
		if this.time[m] == t {
			return this.record[m]
		} else if this.time[m] < t {
			l = m + 1
		} else {
			r = m - 1
		}
	}

	// t >= time[0], so r >= 0
	return this.record[r]
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * obj := Constructor(persons, times);
 * param_1 := obj.Q(t);
 */
