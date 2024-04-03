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

    public Scene() {
        figures.add(new KoordinatenSystem());
        figures.add(new Wuerfel());
    }

    public void calucate() {
        figures.get(1).getKoordinaten().setPosition(new Vector(-200,0,0));
        figures.forEach(f->f.translateGlobal(new Vector(0,0,0.0), 0,0,Math.PI/4));

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
