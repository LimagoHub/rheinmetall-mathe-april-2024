package rheinmetall.math;

public class Matrix {
    private static final int DIMENSION = 4;

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
                    result.values[zeile][spalte] +=  this.values[zeile][i]*other.values[i][spalte];
                }
            }

        }
        return result;
    }


    public static Matrix einheitsmatrix() {
        Matrix result = new Matrix();
        for (int i = 0; i < DIMENSION; i++) {

            result.values[i][i] = 1.0;
        }
        return  result;
    }

    public static Matrix translate(Vector v){
        Matrix result = Matrix.einheitsmatrix();
        for (int i = 0; i < DIMENSION-1; i++) {
            result.values[i][DIMENSION-1] = v.values[i];
        }
        return result;
    }

    public static Matrix rotiereUmZAchse(double value) {
        Matrix m = Matrix.einheitsmatrix();
        var sin = Math.sin(value);
        var cos = Math.cos(value);
        m.values[0][0] = cos;
        m.values[0][1] = -sin;
        m.values[1][0] = sin;
        m.values[1][1] = cos;
        return m;
    }
    public static Matrix rotiereUmYAchse(double winkel) {
        Matrix m = Matrix.einheitsmatrix();
        var sin = Math.sin(winkel);
        var cos = Math.cos(winkel);
        m.values[0][0] = cos;
        m.values[0][2] = sin;
        m.values[2][0] = -sin;
        m.values[2][2] = cos;
        return m;
    }

    public static Matrix skalierungMatrix(double skalar) {
        Matrix m = Matrix.einheitsmatrix();
        for (int i = 0; i < DIMENSION-1; i++) {
            m.values[i][i]*= skalar;
        }
        return m;
    }
    public static Matrix rotiereUmXAchse(double winkel) {
        Matrix m = Matrix.einheitsmatrix();
        var sin = Math.sin(winkel);
        var cos = Math.cos(winkel);
        m.values[1][1] = cos;
        m.values[2][2] = -sin;
        m.values[2][1] = sin;
        m.values[2][2] = cos;

        return m;
    }

    public Matrix mal(Matrix other) {
        Matrix result = new Matrix();
        for (int zeile = 0; zeile < DIMENSION; zeile++) {
            for (int spalte = 0; spalte < DIMENSION; spalte++) {
                for (int i = 0; i < DIMENSION; i++) {
                    result.put(zeile,spalte, result.get(zeile,spalte) + this.get(zeile,i)*other.get(i,spalte));
                }
            }

        }
        return result;
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
