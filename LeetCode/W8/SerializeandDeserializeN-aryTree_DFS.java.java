/*
 * class Node {
 *  public int val;
 *  public List<Node> children;
 * 
 *  public Node() {}
 * 
 *  public Node(int _val) {
 *  val = _val
 * }
 * 
 *  public Node(int _val, List<Node> _Children) {
 *    val = _val;
 *    children = _children;
 * }
 * 
 * }
 */

class Codec {

  final String comma = ",";
  final String delimiter = "$";
  StringBuilder sb = new StringBuilder();

  public String serialize(Node root) {

    //base
    if (root == null) return delimiter;

    //Call encoding function
    encode(root);

    int size = sb.length();
    sb.deleteCharAt(size-1);
    return sb.toString();
    
  }

  private void encode(Node root) {

    sb.append(root.val);
    sb.append(comma);

    List<Node> children = root.children;

    if (children.size() > 0) {

      for (Node child : root.children) {
        encode(child);
      }

      sb.append(delimiter);
      sb.append(comma);

    }

  }

  String[] data_arr;
  int index = 0;

  public Node deserialize(String data) {

    data_arr = data.split(comma);
    return decode();
    
  }

  private Node decode() {

    String currItem = [index++];

    //base
    if (currItem.equals(delimiter)) return null;

    //Children list
    List<node> children = new LinkedList<>();

    while (index < data.length) {

      Node child = decode();

      if (child != null) {
        children.add(child);
      } else {
        break;
      }

    }

      //Build the root node
    Node node = new Node(Integer.parseInt(currItem), children);

    return node;

  }
  
}

//DF: 1,3,#,5,6,#2,4,
//BF: 1,#,3,2,4,#,5,6,#,#,#,

//Df approach : 1,2,#,3,6,7,11,14,#,4,8,12,#,5,9,13,#,10,#