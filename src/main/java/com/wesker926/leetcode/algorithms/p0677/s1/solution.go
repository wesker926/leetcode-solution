// Package s1
// @author: wesker.gh
// @date: 2021/11/14
// @description: trie字典树
package s1

type MapSum struct {
	root *node
	m    map[string]int
}

func Constructor() MapSum {
	return MapSum{
		root: newNode(-1),
		m:    make(map[string]int),
	}
}

func (this *MapSum) Insert(key string, val int) {
	nv := val
	if ov, ok := this.m[key]; ok {
		nv -= ov
	}
	this.m[key] = val

	idx, cur := 0, this.root
	for _, c := range key {
		idx = int(c - 'a')
		if cur.children[idx] == nil {
			cur.children[idx] = newNode(nv)
		} else {
			cur.children[idx].val += nv
		}
		cur = cur.children[idx]
	}
}

func (this *MapSum) Sum(prefix string) int {
	idx, cur := 0, this.root
	for _, c := range prefix {
		idx = int(c - 'a')
		cur = cur.children[idx]
		if cur == nil {
			return 0
		}
	}
	return cur.val
}

type node struct {
	val      int
	children []*node
}

func newNode(val int) *node {
	return &node{
		val:      val,
		children: make([]*node, 26),
	}
}

/**
 * Your MapSum object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(key,val);
 * param_2 := obj.Sum(prefix);
 */
