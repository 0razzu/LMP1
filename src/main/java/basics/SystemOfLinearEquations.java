package basics;


import java.util.Scanner;


public class SystemOfLinearEquations {
    final static double EPS = 1E-9;
    
    
    private static boolean isNull(double x) {
        return Math.abs(x) <= EPS;
    }


    public static void main(String[] args) {
        Scanner In = new Scanner(System.in);
        double[] k = new double[6];
        double delta, q1, q2;

        System.out.println("ax + by = c,");
        System.out.println("dx + ey = f");
        System.out.println("\nВведите значения a, b, c, d, e и f");
        for (int i = 0; i < 6; i++)
            k[i] = In.nextDouble();

        delta = k[0] * k[4] - k[1] * k[3]; // ae - db

        if (isNull(delta)) {
            if (isNull(k[1] * k[5] - k[2] * k[4]))
                System.out.println("\nРешений бесконечно много");
            else
                System.out.println("\nРешений нет");
        }

        else {
            System.out.printf("%nx = %.5f", ((k[2] * k[4] - k[5] * k[1]) / delta + EPS)); // ce - fb
            System.out.printf("%ny = %.5f%n", ((k[0] * k[5] - k[3] * k[2]) / delta + EPS)); // af - dc
        }
    }
}
