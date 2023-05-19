import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class AccountsMerge {

  class UnionFind {
    int[] parent;
    int[] weight;

    public UnionFind(int num) {

      parent = new int[num];
      weight = new int[num];
      
      for (int i=0; i<num; i++) {
        parent[i] = i;
        weight[i] = 1;
      }

    }

    public void union(int a, int b) {

      int roota = find(a);
      int rootb = find(b);

      if (roota==rootb) {
        return;
      }

      //path compression

      if (weight[roota] > weight[rootb]) {

        parent[rootb] = roota;

      } else {

        parent[roota] = rootb;

      }
    }

    public int find(int a) {

      if (parent[a]==a) {
        return a;
      } 

      parent[a] = find(parent[a]);
      return parent[a];
    }
  }

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    
    int size = accounts.size();
    UnionFind uf = new UnionFind(size);

    //Map emails to Id
    HashMap<String, Integer> emailToId = new HashMap<>();

    for (int i=0; i<size; i++) {

      List<String> account = accounts.get(i);

      for (int j=1; j<account.size(); j++) {
        
        String email = account.get(j);

        if (emailToId.containsKey(email)) {
          
          int emailId = emailToId.get(email);
          uf.union(i, emailId);

        } else {
          
          emailToId.put(email, i);

        }

      }

    }


      //A hash to map id with unique emails
      HashMap<Integer, List<String>> idToEmails = new HashMap<>();

      for (String email: emailToId.keySet()) {

        int root = uf.find(emailToId.get(email));

        if(!idToEmails.containsKey(root)) {
          
          idToEmails.put(root, new ArrayList<String>());

        }

        idToEmails.get(root).add(email);

      }

      //Merge name with list of emails associated with it
      List<List<String>> mergedList = new ArrayList<>();

      for (Integer id : idToEmails.keySet()) {
        List<String> emails = idToEmails.get(id);
        Collections.sort(emails);
        emails.add(0, accounts.get(id).get(0));
        mergedList.add(emails);
      }

    return mergedList;
  }

}
