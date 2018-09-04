
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                maxArea = Math.max(maxArea, dfs(i, j, grid, visited, r, c));
            }
        }
        return maxArea;
    }

    public int dfs(int i, int j, int[][] grid, boolean[][] visited, int r, int c) {
        if (i < 0 || i >= r || j < 0 || j >= c || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }

        visited[i][j] = true;

        return 1 + dfs(i, j - 1, grid, visited, r, c) + dfs(i - 1, j, grid, visited, r, c)
                + dfs(i, j + 1, grid, visited, r, c) + dfs(i + 1, j, grid, visited, r, c);
    }
}