package dev.huytran.game;

import dev.huytran.game.display.Display;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("Journey of the Prairie King", 1024, 1024);
        game.start();
    }

}
