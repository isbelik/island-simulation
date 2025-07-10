package map;

public class Island {
    private final int width;
    private final int height;
    private final Cell[][] map;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = new Cell();
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell getCell(int x, int y) {
        return map[x][y];
    }
}
