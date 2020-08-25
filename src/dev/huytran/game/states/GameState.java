package dev.huytran.game.states;

import dev.huytran.game.entities.creatures.Player;
import dev.huytran.game.gfx.Assets;

import java.awt.*;

public class GameState extends State {

    private Player player;

    public GameState() {
        player = new Player(512, 512);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
    }
}
