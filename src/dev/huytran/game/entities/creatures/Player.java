package dev.huytran.game.entities.creatures;

import dev.huytran.game.Game;
import dev.huytran.game.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    private Game game;
    private float speed = 3;

    public Player(Game game, float x, float y) {
        super(x, y);
        this.game = game;
    }

    @Override
    public void tick() {
        if (game.getKeyManager().up) {
            y -= speed;
        }
        if (game.getKeyManager().down) {
            y += speed;
        }
        if (game.getKeyManager().left) {
            x -= speed;
        }
        if (game.getKeyManager().right) {
            x += speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, null);
    }
}
