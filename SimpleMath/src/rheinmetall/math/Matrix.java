package rheinmetall.math;

public class Matrix {
    private static final int DIMENSION = 3;

    private final double values[][] = new double[DIMENSION][DIMENSION];

    public double[][] getValues() {
        return values;
    }

    public Matrix() {
        for (int zeile = 0; zeile < DIMENSION; zeile++) {
            for (int spalte = 0; spalte < DIMENSION; spalte++) {
                values[zeile][spalte] = 0;
            }
        }
    }

    public Vector mal(Vector vector) {
        Vector result = new Vector();
        for (int zeile = 0; zeile < DIMENSION-1; zeile ++){
            for(int spalte = 0; spalte < DIMENSION; spalte++){
                result.values[zeile] += vector.values[spalte] * values[zeile][spalte];
            }
        }
        return result;
    }

    public Matrix mal(Matrix other) {
        Matrix result = new Matrix();
        for (int zeile = 0; zeile < DIMENSION; zeile++) {
            for (int spalte = 0; spalte < DIMENSION; spalte++) {
                for (int i = 0; i < DIMENSION; i++) {
                    result.values[zeile][spalte] +=  this.values[zeile][i]*other.values[i][spalte]);
                }
            }

        }
        return result;
    }
    public Matrix malGleich(Matrix other) {
        Matrix help = this.mal(other);
        for (int zeile = 0; zeile < DIMENSION; zeile++) {
            for (int spalte = 0; spalte < DIMENSION; spalte++) {
                this.values[spalte][zeile] =  help.values[spalte][zeile];
            }

        }
        return this;
    }

    public static Matrix einheitsmatrix() {
        Matrix result = new Matrix();
        for (int i = 0; i < DIMENSION; i++) {

            result.values[i][i] = 1.0;
        }
        return  result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int zeile = 0; zeile < DIMENSION; zeile++) {
            for (int spalte = 0; spalte < DIMENSION; spalte++) {
                sb.append(String.format("%.2f\t",values[zeile][spalte]));
            }
            sb.append("\n");
        }
        return  sb.toString();
    }
}
