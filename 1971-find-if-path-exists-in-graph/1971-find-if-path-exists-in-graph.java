class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       int [] parent = new int[n];
       int [] rank = new int[n];
       for (int i = 0; i < parent.length; i++) {
           parent[i] = i;
       } 
       for (int [] edge : edges) {
           union(parent, rank, edge);
       }
       return find(parent, source) == find(parent, destination); 
    }
    
    private int find (int [] parent, int p) {
        if (parent[p] != p) {
            parent[p] = find(parent, parent[p]);
        }
        return parent[p];
    }
    private void union (int [] parent, int [] rank, int [] edge) {
        //System.out.println(Arrays.toString(edge));
        int p0 = find(parent, edge[0]);
        int p1 = find(parent, edge[1]);
        //System.out.println("p0" + p0);
        //System.out.println("p1" + p1);
        if (p0 == p1) {
            return;
        }
        if (rank[p0] < rank[p1]) {
            parent[p0] = edge[1];
        } else if (rank[p0] > rank[p1]) {
            parent[p1] = edge[0];
        } else {
            parent[p1] = edge[0];
            rank[p0]++;
        }
        //System.out.println(Arrays.toString(rank));
        //System.out.println(Arrays.toString(parent));
    }
}