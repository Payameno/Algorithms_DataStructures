import java.util.*;

class Solution {

    public boolean isBipartiteBFS(int[][] graph) {

        //Define the colors
        int UNVISITED = 0;
        int RED = 1;
        int GREEN = 2;

        //Define a table for colors
        int N = graph.length;
        int[] table = new int[N];

        //Define a queue to add visited nodes
        Queue<Integer> queue = new LinkedList<>(); 

        //Set cur node color to Red, add to the queue
        table[0] = RED;
        queue.add(0); //Adding the first node

        while(!queue.isEmpty()) {
            int curNode = queue.poll();
            int[] connectedNode = graph[curNode];
            int curColor = table[curNode];
            int targetColor = curColor == RED? GREEN: RED; //Set the adjecent nodes color target

            for (int item : connectedNode) {
                if (table[item] == curColor) return false;
                if (table[item] == UNVISITED) {
                    table[item] = targetColor;
                    queue.add(item);
                }
            }
        }
        return true; //If adjecent nodes are all of different colors, it is a Bipartite-Graph 
    }

    /*
     * DFS approach
     */

    //Define sets
    boolean set1 = false;
    boolean set2 = true;
    int[][] _graph;
    Boolean[] sets;

    public boolean isBipartiteDFS(int[][] graph) {
        this._graph = graph;
        int N = _graph.length;
        this.sets = new Boolean[N];

        for (int i = 0; i < N; i++) {
            if (sets[i] == null) {
                sets[i] = set1;
                if (!dfs(i)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int node) {
        int[] adjacentNodes = _graph[node];

        for (int item : adjacentNodes) {
            if (sets[item] == null) {
                sets[item] = !sets[node];
                if (!dfs(item)) return false;
            } else if (sets[item] == sets[node]) {
                return false;
            }
        }
        
        return true;
    }

}

/*
Solution:
Each node is in a different set comparing to its adjencent nodes, so we can say that each node
should have a differernt attribute that we set to other adjecent vertexes (Like color or Boolean)
If this condition is met the graph is Bipartite
We check this in both BFS and DFS

Time complexity:

BFS: O(E+V) where V is the number of vertices (Nodes) and E the number of adjacent nodes
In the worst case each node and its corresponding adjacent nodes are visited once

DFS:
O(V + E) V = Number of Vertices, E = adjacent nodes to each vertice
This is worst case

Space complexity:

BFS: o(V) the space needed for the queue and table

DFS:
O(V) space occupied by sets + call stack required space

Example 1:
Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.

Example 2:
Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 

Constraints:

graph.length == n
1 <= n <= 100
0 <= graph[u].length < n
0 <= graph[u][i] <= n - 1
graph[u] does not contain u.
All the values of graph[u] are unique.
If graph[u] contains v, then graph[v] contains u.
 */