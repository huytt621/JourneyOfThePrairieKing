package dev.huytran.game.states;

import dev.huytran.game.Game;

import java.awt.*;

public abstract class State {

    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
