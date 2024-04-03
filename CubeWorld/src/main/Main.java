package main;

import rheinmetall.math.Matrix;
import rheinmetall.math.Vector;

public class Main {
    public static void main(String[] args) {

        Vector a = new Vector(3,4,5);
        //Vector b = new Vector(2,3,4);

        Matrix rotation = Matrix.rotiereUmXAchse(Math.PI / 7);
        rotation.malGleich(Matrix.rotiereUmYAchse(0));
        rotation.malGleich(Matrix.rotiereUmZAchse(0));
        Vector b = rotation.mal(a);
        System.out.println(b);
        new Application().run();
    }
}