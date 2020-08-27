package dev.huytran.game.entities.creatures;

import dev.huytran.game.Game;
import dev.huytran.game.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    private float speed = 3;

    public Player(Game game, float x, float y) {
        super(game, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (game.getKeyManager().up) {
            yMove = -speed;
        }
        if (game.getKeyManager().down) {
            yMove = speed;
        }
        if (game.getKeyManager().left) {
            xMove = -speed;
        }
        if (game.getKeyManager().right) {
            xMove = speed;
        }
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
    }
}
