class Solution {
    int directions [][] = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        dfs(image, image[sr][sc], newColor, sr, sc);
        return image;
    }
    
    private void dfs (int [][] image, int color, int newColor, int i, int j)
    {   
        int m = image.length;
        int n = image[0].length;
        if (i < 0 || j < 0 || i >= m || j>= n  || image[i][j] != color) {
            return;
        }
        int oldColor = image[i][j];
        image[i][j] = newColor;
        for (int k = 0; k < directions.length; k ++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            dfs(image, oldColor, newColor, x, y);
        }
    } 
}