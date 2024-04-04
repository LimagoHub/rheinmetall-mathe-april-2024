package rheinmetall.gui;

import rheinmetall.math.Vector;

import java.awt.*;

public class ParallelProjektor implements Projektor{
    @Override
    public Point convertVectorToPixel(final Vector vector) {
        Point result = new Point();
        result.x = Renderer.Window.SIZE/2 + (int)(vector.getValues()[0]+vector.getValues()[2]/2);
        result.y = Renderer.Window.SIZE/2 - (int)(vector.getValues()[1]+vector.getValues()[2]/2);

        return result;
    }
}
