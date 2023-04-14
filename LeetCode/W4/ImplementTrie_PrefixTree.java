package W4;

class TrieNode {

  //determins when the word completes
  public boolean isWord;
  public TrieNode[] children;
  
  public TrieNode() {
    this.children = new TrieNode[26];
    this.isWord = false;
  }

}

class Trie {

  private TrieNode root;

  //Constructor
    public Trie() {
      this.root = new TrieNode();
    }

    public void insert(String word) {

      TrieNode node = root;

      for (char c : word.toCharArray()) {
        //Substract unicode of the character from a to calculate index in the array
        int index = c - 'a';
        if (node.children[index] == null) {
          node.children[index] = new TrieNode();
        }
        node = node.children[index];
      }
      node.isWord = true;

    }
    
    public boolean search(String word) {
      TrieNode node = root;

      for (char c : word.toCharArray()) {

        //Substract unicode of the character from a to calculate index in the array
        int index = c - 'a';
        if (node.children[index] == null) {
          return false;
        }
        node = node.children[index];

      }
      //If the last character is the end of the word it will return true
      return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
      TrieNode node = root;

      for (char c : prefix.toCharArray()) {

        //Substract unicode of the character from a to calculate index in the array
        int index = c - 'a';
        if (node.children[index] == null) {
          return false;
        }
        node = node.children[index];

      }
      return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
