// Package s1
// @author: wesker.gh
// @date: 2021/12/28
// @description: 字典树 + dfs
package s1

import "sort"

var t *trie

func findAllConcatenatedWordsInADict(words []string) []string {
	t = newTrie()
	sort.Slice(words, func(i, j int) bool {
		return len(words[i]) <= len(words[j])
	})
	if len(words[0]) == 0 {
		words = words[1:]
	}

	ans := make([]string, 0)
	for _, word := range words {
		if dfs(word, 0) {
			ans = append(ans, word)
		} else {
			t.add(word)
		}
	}
	return ans
}

func dfs(s string, start int) bool {
	if len(s) == start {
		return true
	}

	cur := t.root
	for i := start; i < len(s); i++ {
		cur = cur.children[s[i]-'a']
		if cur == nil {
			return false
		}
		if cur.isWord && dfs(s, i+1) {
			return true
		}
	}
	return false
}

func newTrie() *trie {
	return &trie{
		root: newNode(),
	}
}

type trie struct {
	root *node
}

func (t *trie) add(s string) {
	cur, idx := t.root, 0
	for _, c := range s {
		idx = int(c - 'a')
		if cur.children[idx] == nil {
			cur.children[idx] = newNode()
		}
		cur = cur.children[idx]
	}
	cur.isWord = true
}

func newNode() *node {
	return &node{
		children: make([]*node, 26),
	}
}

type node struct {
	children []*node
	isWord   bool
}
