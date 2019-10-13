package basics;


import java.util.Scanner;


public class TailorSeriesExp {
    final static double EPS = 1E-9;


    public static double exp(double x, double eps) {
        double res = 1, curr = 1;
        int i = 1;

        while (Math.abs(curr) - eps > EPS) {
            curr *= x / i;
            res += curr;
            i++;
        }

        return res;
    }


    public static void main(String[] args) {
        Scanner In = new Scanner(System.in);
        double x, eps;

        System.out.println("Введите аргумент");
        x = In.nextDouble();

        System.out.println("\nВведите точность");
        eps = In.nextDouble();

        if (eps <= EPS)
            System.out.println("\nНекорректное значение точности");

        else
            System.out.println("\nexp(" + x + ") = " + exp(x, eps));
    }
}
