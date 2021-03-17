import java.io.Serializable;

public class Row implements Serializable {
    private double[] A;
    private double B;

    public Row() {
    }

    public double[] getA() {
        return A;
    }

    public void setA(double[] a) {
        A = a;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }
}
