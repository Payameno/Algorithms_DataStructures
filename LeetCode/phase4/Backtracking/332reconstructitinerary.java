import java.util.*;

class Solution {

    //Map each node to edges to imitate a graph
    Map<String, List<String>> graph = new HashMap<>();
    List<String> path = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {


        for (List<String> ticket : tickets) {
            
            String start = ticket.get(0);
            String des = ticket.get(1);
            
            //Place the key if it does not exist
            if (!graph.containsKey(start)) {
                graph.put(start, new LinkedList<>());
            }

            //Place the destination if it does not exist
            if (!graph.containsKey(des)) {
                graph.put(des, new LinkedList<>());
            }

            //Add the destination to the list edges
            graph.get(start).add(des);

        }

        //Sort the list of each key in the graph by lexical order
        for (String key : graph.keySet()) {
            Collections.sort(graph.get(key));
        }
        
        String start = "JFK";
        findPath(start, tickets.size()); //DFS the graph to find the valid path
        return path;
        
    }

    /*
     Basic example:
     Tickets = [["a", "b"], ["c", "a"], ["a", "c"]]

                           Graph
                            "a"
                             <
                           /  \\
                           >    >
                         "b"    "c" 
    Graph
     a : [b,c]
     b : []
     c : [a]

     Path = [a, c, a, b]
     */

    private boolean findPath(String start, int edgeCount) {

        //Add current path
        path.add(start);

        //Get the list
        List<String> list = graph.get(start);

        //Base
        if (list.size() == 0) {
            if (edgeCount == 0) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            String destination = list.remove(i);
            if (findPath(destination, edgeCount - 1)) return true;//cond met, no backtrack

            //Backtrack
            list.add(i, destination);
            path.remove(path.size() - 1);
        }

        return false;

    }
}

/*
Time complexity:
Overal O(V + eloge)where n is the number of vertices and e the number of edges
Sorting = eLoge where e is the number of edges
dfs would take O(V) in worth case which is the time needed to traverse all vertices

Space complexity:
Simplifies as overal auxiliary space of O(V) where V is the number of vertices
Graph representation O(V+E)
Path list O(V)
Recursive call stack O(V)


Example 1:
Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]

Example 2:
Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 

Constraints:
1 <= tickets.length <= 300
tickets[i].length == 2
fromi.length == 3
toi.length == 3
fromi and toi consist of uppercase English letters.
fromi != toi
 */