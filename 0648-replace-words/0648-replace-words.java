class Node {
    Node[] child;
    boolean isRoot;

    Node() {
        child = new Node[26];
        isRoot = false;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.child[idx] == null) node.child[idx] = new Node();
            node = node.child[idx];
        }
        node.isRoot = true;
    }

    String findRoot(String word) {
        Node node = root;
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.child[idx] == null) break;
            sb.append(c);
            node = node.child[idx];
            if (node.isRoot) return sb.toString();
        }
        return word;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String root : dictionary) trie.insert(root);

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = trie.findRoot(words[i]);
        }

        return String.join(" ", words);
    }
}

