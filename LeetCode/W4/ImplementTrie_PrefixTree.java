class TrieNode {
  public boolean isWord;
  public TrieNode[] children = new TrieNode[26];
  public TrieNode() {}
}

class Trie {

  private TrieNode root;

  //We initialize our TrieNode data structure here
    public Trie() {
      this.root = new TrieNode();
    }

    public void insert(String word) {
      TrieNode node = root;

      for (char c : word.toCharArray()) {
        if (node.Con)
      }

    }
    
    public boolean search(String word) {
 
    }
    
    public boolean startsWith(String prefix) {

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */