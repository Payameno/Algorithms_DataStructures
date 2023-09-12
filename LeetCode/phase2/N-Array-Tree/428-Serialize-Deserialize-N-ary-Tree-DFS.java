import java.util.*;

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

class codec {

  StringBuilder sb = new StringBuilder();
  //Define delimiters
    String bckTrck = "X";
    String comma = ",";

  //Encode tree to a string
  public String serialize(Node root) {

    encode(root);
    //Delete the comma at the end of the string
    sb.deleteCharAt(sb.length()-1);

    return sb.toString();

  }

  private void encode(Node node) {

    if (node == null) {
      sb.append(bckTrck);
      return;
    }
    
    sb.append(node.val);
    sb.append(comma);

    List<Node> children = node.children;

    if (!children.isEmpty()) {
      for(Node child : children) {
      encode(child);
      }
    }

    sb.append(bckTrck);
    sb.append(comma);

  }

  String[] dataArr;
  int idx = 0;
  //Decodes a string to a tree data structure
  public Node deSerialize(String data) {
    dataArr = data.split(comma);
    return decode();
  }

  private Node decode() {

    String curItem = dataArr[idx++];
    if (curItem == bckTrck) return null;

    //Create list of children node
    List<Node> children = new LinkedList<>();

    while (idx < dataArr.length) {

      Node child = decode();

      //Check if the backtracking delimiter is present,if yes break the loop
      if (child != null) {
        children.add(child);
      } else {
        break;
      }
    }

    //Construct the node using the value and children
    Node node = new Node(Integer.parseInt(curItem), children);
    
    return node;

  }
}