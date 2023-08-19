/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class solution {

  //Delimiter defintion
  private String comma = ",";
  private String x = "x";
  private StringBuilder sb = new StringBuilder();

  //Encodes the tree into a single string
  public String serialize(Node root) {

    //Base
    if (root == null) return x;

    //Construct the data
    sb.append(root.val);
    sb.append(comma);

    //construct the string
    encode(root);

    //Delete the last comma at the end
    int size = sb.length();
    sb.deleteCharAt(size - 1);

    //return data
    sb.toString();

  }

  //Helper function
  private void encode(Node root) {
    //Construct the children
    List<Nodes> children = root.children;

    if (children.length > 0) {

      for (Node child : children) {
        sb.append(child);
        encode(child);
      }

      sb.append(x);
      sb.append(comma);

    }

  }

  String[] data_arr;
  int index = 0;

  //Decodes the string data into a tree
  public Node deserialize(String data) {

    data_arr = data.split(comma);
    return decode();

  }
  
  private Node decode() {

    String curEl = data_arr[index++];

    if (curEl.equals("x")) return null;

    //Construct childre nodes
    List<Node> children = new LinkedList<>();
    
    while (index < data_arr.length) {

      Node child = decode();
      if (child != null) {
        children.add(child);
      } else {
        break;
      }

    }            queue.add(null);            queue.add(null);

    //Return the tree
    Node root = new Node(Integer.parseInt(curEl), children);
    return root;

  }
  
}

/*
 * Solution: Depth First Approach
 *                          
 *                               root(1)
 *                        2         3       4
 *                   5   6  7       8  
 * 
 *   String : 1,
 */