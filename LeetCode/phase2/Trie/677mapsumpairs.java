import java.util.HashMap;
import java.util.Map;

class Trie {
    int val = 0;
    HashMap<Character, Trie> children = new HashMap<>();
}

class MapSum {
    Trie root;
    HashMap<String, Integer> map;

    public MapSum() {
        this.root = new Trie();
        this.map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        Trie temp = root;
        char[] stringToChar = key.toCharArray();

        for (char cur : stringToChar) {
            //If character is not added as a try, put it as a child of temp
            if (!temp.children.containsKey(cur)) {
                temp.children.put(cur,new Trie());
            }
            //Assign the character as current temp
            temp = temp.children.get(cur);
            //Add the assigned value to string to each and every char of trie
            temp.val += val;
            //If a string input is repeated, subtract the old value in the trie
            if (map.containsKey(key)) {
                temp.val -= map.get(key);
            }
        }
        
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        char[] prefixToChar = prefix.toCharArray();
        Trie temp = root;
        for (char cur : prefixToChar) {
            //if the String is not inserted return zero
            if (!temp.children.containsKey(cur)) {
                return 0;
            }
            //Access the nodes in the trie to reach the leaf
            temp = temp.children.get(cur);
        }
        return temp.val;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 * 
 * 
 * Time complexity:
 * Insert method: O(k) where k is the number of characters in the string
 * Sum method: O(p) where p is the number of characters in the prefix
 * 
 * Space complexity:
 * O(k*n) where k is the number of keys insterted and n the average length of keys
 * This accounts for all characters inserted in the trie
 * 
 * There would be also n number of key-value pairs whcih would be subsumed
 * by the larger amount O(K*n)
 * 
 * 
 */