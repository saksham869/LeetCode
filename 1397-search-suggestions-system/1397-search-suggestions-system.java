class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    private TrieNode root = new TrieNode();

    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
            if (node.suggestions.size() < 3) {
                node.suggestions.add(word);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for (String word : products) {
            insert(word);
        }

        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;

        for (char c : searchWord.toCharArray()) {
            if (node != null) node = node.children[c - 'a'];
            result.add(node == null ? new ArrayList<>() : node.suggestions);
        }
        return result;
    }
}
