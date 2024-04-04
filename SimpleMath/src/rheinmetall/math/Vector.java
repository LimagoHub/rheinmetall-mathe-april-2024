package rheinmetall.math;

import java.util.Arrays;

public class Vector {

    private static final int DIMENSION = 3;

    protected final double values[] = new double[DIMENSION];

    public Vector() {
        for (int i = 0; i < DIMENSION-1; i++) {
            values[i] = 0;
        }
        values[DIMENSION-1]=1;
    }

    public Vector(double ... entries) {
        if(entries.length != DIMENSION-1) throw new IllegalArgumentException("Ungueltige Anzahl von Parametern");
        for (int i = 0; i < DIMENSION-1; i++) {
            values[i] = entries[i];
        }
        values[DIMENSION-1]=1;
    }

    public Vector(Vector other) {
        if(other.DIMENSION != DIMENSION) throw new IllegalArgumentException("Ungueltige Anzahl von Parametern");
        for (int i = 0; i < DIMENSION; i++) {
            values[i] = other.values[i];
        }
        values[DIMENSION-1]=1;
    }


    public double[] getValues() {
        return values;
    }

    public static Vector plus(Vector a, Vector b){
        Vector result =new Vector();
        for (int i = 0; i < DIMENSION-1; i++) {
            result.values[i] = a.values[i] +b.values[i];
        }
        return result;
    }

    public Vector plusGleich(Vector other){
        for (int i = 0; i < DIMENSION-1; i++) {
            values[i] += other.values[i];
        }
        return this;
    }

    public Vector minus(final Vector other){
        Vector result = new Vector();
        for (int i = 0; i < DIMENSION -1; i++) {
            result.values[i] = values[i] - other.values[i];
        }
        return result;
    }

    public Vector minusGleich(final Vector other){

        for (int i = 0; i < DIMENSION -1; i++) {
            values[i] -= other.values[i];
        }

        return this;
    }

    public Vector scalarGleich(double skalar){
        for (int i = 0; i < DIMENSION; i++) {
            values[i] *= skalar;
        }
        return this;
    }

    public Vector scalar(double skalar){
        Vector result = new Vector();
        for (int i = 0; i < DIMENSION; i++) {
            result.values[i] = values[i] * skalar;
        }
        return result;
    }

    public static Vector scalar(Vector other , double skalar){
        Vector result = new Vector();
        for (int i = 0; i < DIMENSION; i++) {
            result.values[i] = other.values[i] * skalar;
        }
        return result;
    }


    public void normalize() {
        double sum = 0;
        for (int i = 0; i < DIMENSION -1; i++) {
            sum += values[i]*values[i];
        }
        double betrag = Math.sqrt(sum);
        for (int i = 0; i < DIMENSION-1; i++) {
            values[i] /= betrag;
        }
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vector{");
        sb.append("values=").append(Arrays.toString(values));
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Vector vector = (Vector) o;
        return Arrays.equals(values, vector.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
}
