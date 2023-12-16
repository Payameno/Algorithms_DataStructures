/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.*;
import org.w3c.dom.Node;

class Solution {
    public Node cloneGraph(Node node) {

        //Base
        if (node == null) return null;

        //Map each node to the clone
        Map<Node,Node> hm = new HashMap<>();
        hm.put(node, new Node(node.val));

        //A queue to hold Nodes to be processed
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node curNode = queue.remove();
            Node curNodeClone = hm.get(curNode);

            //Add clone's neighbors
            for (Node cur : curNode.neighbors) {
                Node curClone;
                if (hm.containsKey(cur)) {
                    curClone = hm.get(cur);
                } else {
                    queue.add(cur);
                    curClone = new Node(cur.val);
                    hm.put(cur, curClone);
                }
                //Add the neighbor to the list of adjacencies
                curNodeClone.neighbors.add(curClone);
            }

        }
        return hm.get(node); //Return the first node
    }
}

/*
Time Complexity:
O(V + E) V = vertices , E = Edges

Space complexity:
HashMap O(V)

 * 
 * Example 1:
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

Example 2:
Input: adjList = [[]]
Output: [[]]
Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.

Example 3:
Input: adjList = []
Output: []
Explanation: This an empty graph, it does not have any nodes.
 

Constraints:
The number of nodes in the graph is in the range [0, 100].
1 <= Node.val <= 100
Node.val is unique for each node.
There are no repeated edges and no self-loops in the graph.
The Graph is connected and all nodes can be visited starting from the given node.
 */