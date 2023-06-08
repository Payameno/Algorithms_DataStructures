import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {

    //if there is only one node , 0 is the root of MHT
    if (n == 1) return Collections.singletonList(0);
  
    List<Set<Integer>> adj = new ArrayList<>();
    
    //initializing a set for each indices
    for (int i = 0; i < n; ++i) {
      adj.add(new HashSet<>());
    }

    //populate the arraylist with each node edges
    for (int[] edge : edges) {
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }

    //find leaves
    List<Integer> leaves = new ArrayList<>();

    //add the indices of leaves to the arrayList
    for (int i = 0; i < n; ++i) {
      if (adj.get(i).size() == 1) leaves.add(i);
      
    }

      //remove leaves from the nodes and adj list      
      while (n > 2) {
        //new leaves array
        List<Integer> newLeaves = new ArrayList<>();

        n -= leaves.size();

        for (int leaf : leaves) {
  
          //Iterator is used to match the type
          int parent = adj.get(leaf).iterator().next();
          adj.get(parent).remove(leaf);
          if (adj.get(parent).size() == 1) newLeaves.add(parent);
  
        }        

        leaves = newLeaves;

      }


    return leaves;
  }

}
