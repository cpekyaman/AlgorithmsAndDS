package udemy.algo.advanced.maze;

public final class Maze {
    public static final int START = 2;
    public static final int END = 3;

    public static final int WALL = 1;
    public static final int PASS = 0;

    private final int[][] map = {
            {WALL, WALL, WALL, WALL, WALL},
            {WALL, START, PASS, WALL, WALL},
            {WALL, WALL, PASS, WALL, WALL},
            {WALL, WALL, PASS, END, WALL},
            {WALL, WALL, WALL, WALL, WALL}
    };

    public static Maze build() {
        return new Maze();
    }

    private final int startRow;
    private final int startColumn;

    private Maze() {
        this.startRow = 1;
        this.startColumn = 1;
    }

    public int[][] getMap() {
        return map;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public final int getRows() {
        return map.length;
    }

    public final int getColumns() {
        return map[0].length;
    }
}
