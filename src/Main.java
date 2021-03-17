import parcs.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main implements AM {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        task currTask = new task();
        currTask.addJarFile("Main.jar");
        (new Main()).run(new AMInfo(currTask, null));
        currTask.end();
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Total time: " + totalTime);
    }

    public void run(AMInfo info) {
        int N;
        double[][] A;
        double[] B;
        Matrix matrix = new Matrix();
        try {
            File file = new File(info.curtask.findFile("input"));
            Scanner sc = new Scanner(file);
            N = sc.nextInt();

            A = new double[N][N];
            matrix.setRows(new Row[N]);
            for (int i = 0; i < N; ++i) {
                matrix.getRows()[i] = new Row();
                matrix.getRows()[i].setA(new double[N]);
                for (int j = 0; j < N; ++j) {
                    double x = sc.nextDouble();
                    A[i][j] = x;
                    matrix.getRows()[i].getA()[j] = x;
                }
            }

            B = new double[N];
            for (int i = 0; i < N; ++i) {
                double x = sc.nextDouble();
                B[i] = x;
                matrix.getRows()[i].setB(x);
            }

            matrix.setN(N);
            matrix.setA(A);
            matrix.setB(B);
            matrix.setCurrent(1);

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        point point = info.createPoint();
        channel channel = point.createChannel();
        point.execute("Gauss");
        channel.write(matrix);
        channel.write(1);

        System.out.println("Waiting for result...");
        Matrix r = (Matrix) channel.readObject();

        double[] result = new double[N];
        result[N - 1] = r.getB()[N - 1] / r.getA()[N - 1][N - 1];
        for (int i = N - 2; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; ++j) {
                sum += r.getA()[i][j] * result[j];
            }
            result[i] = (r.getB()[i] - sum) / r.getA()[i][i];
        }

        System.out.println("Result: ");
        for (int i = 0; i < N; ++i) {
            System.out.print(result[i] + " ");
        }
    }
}
