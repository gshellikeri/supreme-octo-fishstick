class Solution {
    public Boolean[][] visited;
    public List<List<Integer>> getAndMarkNeighbors(Integer r, Integer c, Integer rows, Integer cols, char[][] grid) {
        List<List<Integer>> neighbors = new ArrayList();

        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if (Math.abs(i) == Math.abs(j)) {
                    continue;
                }
                if (r + i < 0 || r + i >= rows || c + j < 0 || c + j >= cols) {
                    continue;
                }
                Integer row = r + i;
                Integer col = c + j;
                if (visited[row][col]) {
                    continue;
                }

                if (grid[row][col] == '1') {
                    neighbors.add(List.of(row, col));
                }
                visited[row][col] = true;
            }
        }
        return neighbors;
    }

    public void markIslandVisited(Integer r, Integer c, Integer rows, Integer cols, char[][] grid) {
        List<List<Integer>> neighbors = getAndMarkNeighbors(r, c, rows, cols, grid);

        for(int i = 0; i < neighbors.size(); i++) {
            List<Integer> n = neighbors.get(i);
            neighbors.addAll(getAndMarkNeighbors(n.get(0), n.get(1), rows, cols, grid));
        }
    }

    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        this.visited = new Boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                this.visited[r][c] = false;
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (this.visited[r][c]) {
                    continue;
                }
                visited[r][c] = true;
                if (grid[r][c] == '1') {
                    numIslands ++;
                    markIslandVisited(r, c, rows, cols, grid);
                }
            }
        }
        return numIslands;
    }
}
