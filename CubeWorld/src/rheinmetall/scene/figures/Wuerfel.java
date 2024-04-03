package rheinmetall.scene.figures;

import rheinmetall.math.Vector;

import java.awt.*;

public class Wuerfel extends AbstractFigure{

    public Wuerfel() {

        getKnoten().add(new Vector(-100,-100, -100));
        getKnoten().add(new Vector(-100,100, -100));
        getKnoten().add(new Vector(100,100, -100));
        getKnoten().add(new Vector(100,-100, -100));

        getKnoten().add(new Vector(-100,-100, 100));
        getKnoten().add(new Vector(-100,100, 100));
        getKnoten().add(new Vector(100,100, 100));
        getKnoten().add(new Vector(100,-100, 100));

        getKanten().add(new Kante(0,1, Color.BLUE));
        getKanten().add(new Kante(1,2, Color.BLUE));
        getKanten().add(new Kante(2,3, Color.BLUE));
        getKanten().add(new Kante(3,0, Color.BLUE));


        getKanten().add(new Kante(0,4, Color.RED));
        getKanten().add(new Kante(1,5, Color.RED));
        getKanten().add(new Kante(2,6, Color.RED));
        getKanten().add(new Kante(3,7, Color.RED));


        getKanten().add(new Kante(4,5, Color.GREEN));
        getKanten().add(new Kante(5,6, Color.GREEN));
        getKanten().add(new Kante(6,7, Color.GREEN));
        getKanten().add(new Kante(7,4, Color.GREEN));
    }
}
