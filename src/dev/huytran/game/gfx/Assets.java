package dev.huytran.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int SPRITE_WIDTH = 16;
    private static final int SPRITE_HEIGHT = 16;

    public static BufferedImage player, title, cactus, cactus2, darkRedStones, darkRedStones2, lightRedStones, dirt,
    dirtAndGrass;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        player = sheet.crop(367, 112, SPRITE_WIDTH, SPRITE_HEIGHT);
        title = sheet.crop(0, 90, 95, 86);
        cactus = sheet.crop(415, 32, SPRITE_WIDTH, SPRITE_HEIGHT);
        cactus2 = sheet.crop(431, 32, SPRITE_WIDTH, SPRITE_HEIGHT);
        darkRedStones = sheet.crop(351, 32, SPRITE_WIDTH, SPRITE_HEIGHT);
        darkRedStones2 = sheet.crop(335, 32, SPRITE_WIDTH, SPRITE_HEIGHT);
        lightRedStones = sheet.crop(367, 32, SPRITE_WIDTH, SPRITE_HEIGHT);
        dirt = sheet.crop(383, 32, SPRITE_WIDTH, SPRITE_HEIGHT);
        dirtAndGrass = sheet.crop(399, 32, SPRITE_WIDTH, SPRITE_HEIGHT);
    }

}
