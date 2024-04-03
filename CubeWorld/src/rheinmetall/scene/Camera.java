package rheinmetall.scene;

import rheinmetall.math.Matrix;
import rheinmetall.math.Vector;

public class Camera {

    private Vector position = new Vector();
    private double alpha = 0;
    private double beta = 0;
    private double gamma = 0;

    public Camera() {
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(final Vector position) {
        this.position = position;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(final double alpha) {
        this.alpha = alpha;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(final double beta) {
        this.beta = beta;
    }

    public double getGamma() {
        return gamma;
    }

    public void setGamma(final double gamma) {
        this.gamma = gamma;
    }

    public void move() {
        move(1.0);
    }

    public void move(double skalar){
        Vector einheitsVektorZ = new Vector(0,0,1);
        Matrix rotationsMatrix = Matrix.rotiereUmYAchse(beta);
        rotationsMatrix.malGleich(Matrix.rotiereUmZAchse(gamma));
        rotationsMatrix.malGleich(Matrix.rotiereUmXAchse(alpha));
        Vector richtung = rotationsMatrix.mal(einheitsVektorZ);
        richtung.scalarGleich(skalar);
        position.plusGleich(richtung);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Camera{");
        sb.append("position=").append(position);
        sb.append(", alpha=").append(alpha);
        sb.append(", beta=").append(beta);
        sb.append(", gamma=").append(gamma);
        sb.append('}');
        return sb.toString();
    }
}
