package dev.huytran.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int SPRITE_WIDTH = 64;
    private static final int SPRITE_HEIGHT = 64;

    public static BufferedImage player;
    public static BufferedImage title;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        player = sheet.crop(SPRITE_WIDTH * 23 - 4, SPRITE_HEIGHT * 7, SPRITE_WIDTH, SPRITE_HEIGHT);
        title = sheet.crop(0, 320, 380, 388);
    }

}
