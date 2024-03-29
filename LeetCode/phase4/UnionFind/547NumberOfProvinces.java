class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j || isConnected[i][j] == 0) continue;
                uf.union(i, j);
            }
        }
        return uf.numOfComponets;
    }
}
class UnionFind {
    private int[] parents;
    private int[] size;
    int numOfComponets = 0;

    public UnionFind(int n) {
        parents = new int[n];
        size = new int[n];
        numOfComponets = n;
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int find(int cur) {
        int root = cur;
        while (root != parents[root]) {
            root = parents[root];
        }
        // Path Compression
        while (cur != root) {
            int preParent = parents[cur];
            parents[cur] = root;
            cur = preParent;
        }
        return root;
    }

    public int findComponentSize(int cur) {
        int parent = find(cur);
        return size[parent];
    }

    public void union(int node1, int node2) {
        int node1Parent = find(node1);
        int node2Parent = find(node2);

        if (node1Parent == node2Parent)
            return;

        if (size[node1Parent] > size[node2Parent]) {
            parents[node2Parent] = node1Parent;
            size[node1Parent] += size[node2Parent];
        } else {
            parents[node1Parent] = node2Parent;
            size[node2Parent] += size[node1Parent];
        }
        numOfComponets--;
    }
}

/*
The time complexity of the Union-Find (Disjoint-Set) data structure, 
when using both path compression and union by rank, is typically considered to be 
nearly O(1) or amortized O(1) per operation, rather than O(log n) 
or the inverse Ackermann function (α(n))

 * Time complexity: O(n^2 * α(n))
 * n^2 as we have a nested loop
 * 
 * where α(n) is the inverse Ackermann function - slow growing thus considered O(1)
 * 
 * Space complexity: O(n) - as we initialize an array with the size of n 
 */