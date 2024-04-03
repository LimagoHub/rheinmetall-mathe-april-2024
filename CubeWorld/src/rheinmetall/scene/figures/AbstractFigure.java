package rheinmetall.scene.figures;

import rheinmetall.math.Matrix;
import rheinmetall.math.Vector;
import rheinmetall.scene.Camera;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AbstractFigure {

    private List<Vector> knoten = new ArrayList<>();

    private List<Vector> tranformierteKnoten = new ArrayList<>();

    private List<Kante> kanten = new ArrayList<>();

    private LokaleKoordinaten koordinaten = new LokaleKoordinaten();
    public List<Vector> getKnoten() {
        return knoten;
    }

    public void setKnoten(final List<Vector> knoten) {
        this.knoten = knoten;
    }

    public List<Kante> getKanten() {
        return kanten;
    }

    public void setKanten(final List<Kante> kanten) {
        this.kanten = kanten;
    }

    public List<Vector> getTranformierteKnoten() {
        return tranformierteKnoten;
    }

    public void setTranformierteKnoten(final List<Vector> tranformierteKnoten) {
        this.tranformierteKnoten = tranformierteKnoten;
    }


    private void transform() {

        Matrix transformation = koordinaten.calculateLocalTransformationMatrix();
        tranformierteKnoten.clear();

        for (int i = 0; i < knoten.size(); i++) {
            tranformierteKnoten.add(transformation.mal(knoten.get(i)));
        }


    }

    public LokaleKoordinaten getKoordinaten() {
        return koordinaten;
    }

    public void translateGlobal(Vector vector, double alpha, double beta, double gamma){

        transform();
        /*Matrix moveKamera = Matrix.translate(vector);

        Matrix rotation = Matrix.rotiereUmXAchse(alpha);
        rotation.malGleich(Matrix.rotiereUmYAchse(beta));
        rotation.malGleich(Matrix.rotiereUmZAchse(gamma));

        Matrix moveKameraBack = Matrix.translate(Vector.scalar(vector,-1));


        setTranformierteKnoten(
                new ArrayList<>(
                        getTranformierteKnoten().stream()
                                .map(v->moveKamera.mal(v))
                                .map(v->rotation.mal(v))
                                .map(v->moveKameraBack.mal(v))
                        .toList()));


         */
        Matrix moveKamera = Matrix.translate(vector);

        Matrix rotation =Matrix.rotiereUmXAchse(alpha);
        rotation.malGleich(Matrix.rotiereUmYAchse(beta));
        rotation.malGleich(Matrix.rotiereUmZAchse(gamma));


        Matrix moveKameraBack = Matrix.translate(Vector.scalar(vector,-1));
        setTranformierteKnoten(new ArrayList<>(
                getTranformierteKnoten().stream()
                        .map(k->moveKamera.mal(k))
                        .map(k->rotation.mal(k))
                        .map(k->moveKameraBack.mal(k))
                        .toList()));


    }

    public class LokaleKoordinaten {


            private Vector position = new Vector();
            private double alpha = 0;
            private double beta = 0;
            private double gamma = 0;

            private double skalierung = 1.0;
            public LokaleKoordinaten() {
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

        public double getSkalierung() {
            return skalierung;
        }

        public void setSkalierung(final double skalierung) {
            this.skalierung = skalierung;
        }

        protected Matrix calculateLocalTransformationMatrix() {
                Matrix result = Matrix.skalierungMatrix(getSkalierung());
                result.malGleich(Matrix.rotiereUmXAchse(getAlpha()));
                result.malGleich(Matrix.rotiereUmYAchse(getBeta()));
                result.malGleich(Matrix.rotiereUmZAchse(getGamma()));
                result.malGleich(Matrix.translate(getPosition()));
                return result;
        }

    }

}
