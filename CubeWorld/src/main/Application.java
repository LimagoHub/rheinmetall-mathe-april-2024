package main;

import rheinmetall.gui.ParallelProjektor;
import rheinmetall.gui.Projektor;
import rheinmetall.gui.Renderer;
import rheinmetall.gui.ZentralProjektor;
import rheinmetall.scene.Scene;

public class Application {

    private final Scene scene = new Scene();
    private final Projektor projektor = new ZentralProjektor();
    private final Renderer renderer = new Renderer(scene,projektor);

    private boolean gameover = false;
    public void run() {

        while (! gameover) {
            scene.calucate();
            renderer.drawScene();
        }

    }

}
