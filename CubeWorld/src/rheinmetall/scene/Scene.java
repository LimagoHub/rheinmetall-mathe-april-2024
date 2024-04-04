package rheinmetall.scene;

import rheinmetall.math.Vector;
import rheinmetall.scene.figures.AbstractFigure;
import rheinmetall.scene.figures.KoordinatenSystem;
import rheinmetall.scene.figures.Wuerfel;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    private final Camera camera = new Camera();
    private final List<AbstractFigure> figures = new ArrayList<>();
    private double winkel = 0;

    public Scene() {
        figures.add(new KoordinatenSystem());
        figures.add(new Wuerfel());
        figures.add(new Wuerfel());
        figures.add(new Wuerfel());
    }

    public void calucate() {

        if(winkel > Math.PI*2) winkel = 0;
        winkel += 0.01;

        figures.get(1).getKoordinaten().setSkalierung(1.5);
        figures.get(1).getKoordinaten().setAlpha(Math.PI/7);
        figures.get(1).getKoordinaten().setBeta(winkel);

        figures.get(1).getKoordinaten().setPosition(new Vector(200,0,0));

        figures.get(3).getKoordinaten().setSkalierung(0.5);
        figures.get(3).getKoordinaten().setGamma(Math.PI/7);
        //figures.get(3).getKoordinaten().setGamma(Math.PI/7);
        figures.get(3).getKoordinaten().setPosition(new Vector(-250,100,0));


        for(var figure :figures)
            figure.transform();

    }

    public List<AbstractFigure> getFigures() {
        return figures;
    }

    public void step() {
        camera.move(10.0);
    }

    public void rotateRight() {
        camera.setAlpha(camera.getAlpha() +0.001);
    }

    public void rotateLeft() {
        camera.setAlpha(camera.getAlpha() -0.001);
    }
}
