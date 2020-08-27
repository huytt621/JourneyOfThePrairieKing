package dev.huytran.game;

import dev.huytran.game.display.Display;
import dev.huytran.game.gfx.Assets;
import dev.huytran.game.gfx.GameCamera;
import dev.huytran.game.input.KeyManager;
import dev.huytran.game.states.GameState;
import dev.huytran.game.states.MenuState;
import dev.huytran.game.states.State;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Display display;
    public String title;
    private int width, height;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private State menuState;
    private State gameState;

    private KeyManager keyManager;

    private GameCamera gameCamera;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        gameCamera = new GameCamera(0, 0);

        menuState = new MenuState(this);
        gameState = new GameState(this);
        StateManager.setState(gameState);
    }

    private void tick() {
        keyManager.tick();

        if (StateManager.getState() != null) {
            StateManager.getState().tick();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        if (StateManager.getState() != null) {
            StateManager.getState().render(g);
        }
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1e9 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1e9) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();;
        }
    }
}
