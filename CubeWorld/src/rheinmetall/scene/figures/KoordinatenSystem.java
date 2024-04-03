package rheinmetall.scene.figures;

import rheinmetall.math.Vector;

import java.awt.*;

public class KoordinatenSystem extends AbstractFigure{

    public KoordinatenSystem() {
        getKnoten().add(new Vector(-500,0,0));
        getKnoten().add(new Vector(500,0,0));
        getKnoten().add(new Vector(0,-500,0));
        getKnoten().add(new Vector(0,500,0));
        getKnoten().add(new Vector(0,0,-500));
        getKnoten().add(new Vector(0,0,500));

        getKanten().add(new Kante(0,1, Color.LIGHT_GRAY));
        getKanten().add(new Kante(2,3, Color.LIGHT_GRAY));
        getKanten().add(new Kante(4,5, Color.LIGHT_GRAY));
    }
}
