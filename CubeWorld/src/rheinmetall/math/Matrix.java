package rheinmetall.math;

public class Matrix {

    private static final int DIMENSION = 4;
    private final double values[][] = new double[DIMENSION][DIMENSION];

    public Matrix() {
        for (int x = 0; x < DIMENSION; x++) {
            for (int y = 0; y < DIMENSION; y++) {
                values[x][y] = 0.0;
            }
        }

    }

    public double[][] getValues() {
        return values;
    }

    public void put(int zeile, int spalte, double value) {
        values[zeile][spalte] = value;
    }

    public double get(int zeile, int spalte) {
        return values[zeile] [spalte];
    }

    public Vector mal(Vector vector) {
        Vector result = new Vector();
        for (int zeile = 0; zeile < DIMENSION-1; zeile ++){
            for(int spalte = 0; spalte < DIMENSION; spalte++){
                result.values[zeile] += vector.values[spalte] * get(zeile, spalte);
            }
        }
        return result;
    }

    public static Matrix translate(Vector v){
        Matrix result = Matrix.einheitsMatrix();
        for (int i = 0; i < DIMENSION-1; i++) {
            result.put(i,DIMENSION-1,v.values[i]);
        }
        return result;
    }

    public static Matrix rotiereUmZAchse(double value) {
        Matrix m = Matrix.einheitsMatrix();
        var sin = Math.sin(value);
        var cos = Math.cos(value);
        m.put(0,0,cos);
        m.put(0,1,-sin);
        m.put(1,0,sin);
        m.put(1,1,cos);
        return m;
    }
    public static Matrix rotiereUmYAchse(double winkel) {
        Matrix m = Matrix.einheitsMatrix();
        var sin = Math.sin(winkel);
        var cos = Math.cos(winkel);
        m.put(0,0,cos);
        m.put(0,2,sin);
        m.put(2,0,-sin);
        m.put(2,2,cos);
        return m;
    }

    public static Matrix skalierungMatrix(double skalar) {
        Matrix m = Matrix.einheitsMatrix();
        for (int i = 0; i < DIMENSION-1; i++) {
            m.values[i][i]*= skalar;
        }
        return m;
    }
    public static Matrix rotiereUmXAchse(double winkel) {
        Matrix m = Matrix.einheitsMatrix();
        var sin = Math.sin(winkel);
        var cos = Math.cos(winkel);
        m.put(1,1,cos);
        m.put(1,2,-sin);
        m.put(2,1,sin);
        m.put(2,2,cos);
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
    public Matrix malGleich(Matrix other) {
        Matrix help = this.mal(other);
        for (int zeile = 0; zeile < DIMENSION; zeile++) {
            for (int spalte = 0; spalte < DIMENSION; spalte++) {
                this.put(spalte,zeile, help.get(spalte,zeile));
            }

        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < DIMENSION; x++) {
            for (int y = 0; y < DIMENSION; y++) {
                sb.append(String.format("%.2f\t",values[x][y]));
            }
            sb.append("\n");
        }
        return  sb.toString();
    }

    public static Matrix zeros() {
        return new Matrix();
    }

    public static Matrix createTransformationMatrix() {
        var result = new Matrix();
        result.put(DIMENSION-1, DIMENSION-1, 1.0);
        return result;
    }

    public static Matrix einheitsMatrix() {
        var result = Matrix.zeros();
        for (int i = 0; i < DIMENSION; i++) {
            result.put(i,i, 1.0);
        }
        return result;
    }
}
