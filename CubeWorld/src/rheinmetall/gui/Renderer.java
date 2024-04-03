package rheinmetall.gui;


import rheinmetall.scene.Scene;
import rheinmetall.scene.figures.AbstractFigure;
import rheinmetall.scene.figures.Kante;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Renderer {

    private final Window window = new Window();
    private final Scene scene;
    private final Projektor projektor;

    public Renderer(final Scene scene, final Projektor projektor) {
        this.scene = scene;
        this.projektor = projektor;
    }

    public void drawScene() {
        Graphics g = window.strategy.getDrawGraphics();
        g.clearRect(0, 0, window.getWidth(), window.getHeight());

        scene.getFigures().forEach(figur -> drawFigure(g, figur));
        g.dispose();
        window.strategy.show();
    }

    private void drawFigure(Graphics g, AbstractFigure figur){


        figur.getKanten().forEach(kante -> drawLine(g,figur,kante));

    }

    private void drawLine(Graphics g, AbstractFigure f, Kante k){
        g.setColor(k.getColor());
        Point start = projektor.convertVectorToPixel(f.getTranformierteKnoten().get(k.getStart()));
        Point end = projektor.convertVectorToPixel(f.getTranformierteKnoten().get(k.getEnd()));
        g.drawLine(start.x, start.y, end.x, end.y);

    }

    static class Window extends Frame {

        private final transient BufferStrategy strategy;
        protected static final int SIZE =1000;

        public Window(){
            super("Rheinmetall Math");
            setSize(SIZE,SIZE);
            setVisible(true);
            createBufferStrategy(2);
            strategy = getBufferStrategy();
        }
    }

}
