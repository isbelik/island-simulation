package map;

public class Island {
    private final int width;
    private final int height;
    private final Cell[][] map;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new Cell[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                map[y][x] = new Cell(x, y);
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
        return map[y][x];
    }
}
