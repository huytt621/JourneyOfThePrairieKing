package dev.huytran.game.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[256];
    public static Tile dirtTile = new DirtTile(0);
    public static Tile darkRedStones = new DarkRedStones(1);
    public static Tile darkRedStones2 = new DarkRedStones2(2);
    public static Tile lightRedStones = new LightRedStones(3);
    public static Tile cactusTile = new CactusTile(4);

    public static final int TILE_WIDTH = 64;
    public static final int TILE_HEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }

    public int getId() {
        return id;
    }
}
