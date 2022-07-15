// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    ArrayList<String> resultList = new ArrayList<>();
    public ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        boolean [][] visited = new boolean[n][n];
        dfs(m, visited, 0, 0, n, new ArrayList<>(), "");
        Collections.sort(resultList);
        return resultList;
    }
    
    private void dfs (int[][] m , boolean[][] visited,
    int i, int j, int n, List<String> result, String dir)
    {
        if (i == n-1 && j == n-1) {
            if (isValid(m, visited, i, j, n)) {
                //result.add(dir);
                StringBuilder str = new StringBuilder();
                for (String s : result) {
                    str.append(s);
                }
                str.append(dir);
                resultList.add(str.toString());
            }
            return;
        }
        if (m[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        //System.out.println(result);
        result.add(dir);
        if (isValid(m, visited, i-1, j, n)) {
            dfs(m, visited, i-1, j, n, result, "U");
        }
        if (isValid(m, visited, i+1, j, n)) {
            dfs(m, visited, i+1, j, n, result, "D");
        }
        if (isValid(m, visited, i, j-1, n)) {
            dfs(m, visited, i, j-1, n, result, "L");
        }
        if (isValid(m, visited, i, j+1, n)) {
            dfs(m, visited, i, j+1, n, result, "R");
        }
        result.remove(result.size()-1);
        visited[i][j] = false;
    }
    
    private boolean isValid (int [][] m, boolean[][] visited, int i, int j, int n)
    {
        return i >= 0 && j >= 0 &&
        i <= n-1 && j <= n-1 && m[i][j] == 1 && !visited[i][j];
    }
}