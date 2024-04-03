package rheinmetall.gui;

import rheinmetall.math.Vector;

import java.awt.*;

public class ZentralProjektor implements Projektor{

    private static final double D = 1000;
    @Override
    public Point convertVectorToPixel(final Vector vector) {
        Point result =new Point();
        double nenner =  vector.getValues()[2]+D;
        if(nenner == 0)
            result.x = result.y = Integer.MAX_VALUE;
        else {
            result.x = Renderer.Window.SIZE/2 + (int) (D * vector.getValues()[0] / nenner)  ;
            result.y = Renderer.Window.SIZE/2-(int) (D * vector.getValues()[1] / nenner) ;
        }

        return result;
    }
}
