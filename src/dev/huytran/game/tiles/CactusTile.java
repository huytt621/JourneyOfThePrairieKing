package dev.huytran.game.tiles;

import dev.huytran.game.gfx.Assets;

import java.awt.image.BufferedImage;

public class CactusTile extends Tile {

    private BufferedImage texture2;

    public CactusTile(int id) {
        super(Assets.cactus, id);
        this.texture2 = Assets.cactus2;
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
