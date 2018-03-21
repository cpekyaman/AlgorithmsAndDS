package udemy.algo.advanced.maze;

public class MazeRunner {
    private final Maze maze;
    private final boolean[][] visited;

    public MazeRunner(Maze maze) {
        this.maze = maze;
        this.visited = new boolean[maze.getRows()][maze.getColumns()];
    }

    public void run() {
        dfs(maze.getStartRow(), maze.getStartColumn());
    }

    private void dfs(int row, int column) {
        System.out.printf("At (%d, %d) \n", row, column);

        //TODO: find a way without exception
        if(maze.getMap()[row][column] == Maze.END) {
            // do what ?
            // throw new RuntimeException("Found");
        }

        if(shouldGoFurther(row, column)) {
            markCell(row, column);

            // down -> right -> left -> up
            dfs(row + 1, column);
            dfs(row, column + 1);
            dfs(row, column - 1);
            dfs(row - 1, column);
        }
    }

    private boolean shouldGoFurther(int row, int column) {
        return ! (visited[row][column] || endRows(row) || endColumns(column) || isWall(maze.getMap()[row][column]));
    }

    private void markCell(int row, int column) {
        this.visited[row][column] = true;
    }

    private boolean isWall(int i) {
        return i == Maze.WALL;
    }

    private boolean endColumns(int column) {
        return column < 0 || column >= maze.getColumns() - 1;
    }

    private boolean endRows(int row) {
        return row < 0 || row >= maze.getRows() - 1;
    }
}
