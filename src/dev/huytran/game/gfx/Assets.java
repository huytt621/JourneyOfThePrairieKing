package dev.huytran.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int SPRITE_WIDTH = 16;
    private static final int SPRITE_HEIGHT = 16;

    public static BufferedImage player;
    public static BufferedImage title;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        player = sheet.crop(367, 112, SPRITE_WIDTH, SPRITE_HEIGHT);
    }

}
