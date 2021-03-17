import java.io.Serializable;

public class Matrix implements Serializable {
    private Row[] rows;

    private int N;
    private double[][] A;
    private double[] B;

    public Matrix() {
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public double[][] getA() {
        return A;
    }

    public void setA(double[][] a) {
        A = a;
    }

    public double[] getB() {
        return B;
    }

    public void setB(double[] b) {
        B = b;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    private int current = 0;

    public Row[] getRows() {
        return rows;
    }

    public void setRows(Row[] rows) {
        this.rows = rows;
    }
}
