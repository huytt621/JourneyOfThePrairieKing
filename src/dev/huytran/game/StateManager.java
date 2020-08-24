package dev.huytran.game;

import dev.huytran.game.states.State;

public class StateManager {

    private static State currentState;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

}
