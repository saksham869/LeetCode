import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    private TrieNode root = new TrieNode();

    private void insert(String w) {
        TrieNode node = root;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isWord = true;
    }

    private boolean canBuild(String w) {
        TrieNode node = root;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            node = node.children[idx];
            if (node == null || !node.isWord) return false;
        }
        return true;
    }

    public String longestWord(String[] words) {
        for (String w : words) insert(w);
        String ans = "";
        for (String w : words) {
            if (canBuild(w)) {
                if (w.length() > ans.length() ||
                    (w.length() == ans.length() && w.compareTo(ans) < 0)) {
                    ans = w;
                }
            }
        }
        return ans;
    }
}
