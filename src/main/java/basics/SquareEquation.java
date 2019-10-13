package basics;


import java.util.Scanner;


public class SquareEquation {
    public static void main(String[] args) {
        Scanner In = new Scanner(System.in);
        double a, b, c, d, res1 = 0, res2 = 0;
        int kRoots;

        System.out.println("Введите коэффициенты квадратного уравнения");
        a = In.nextDouble();
        b = In.nextDouble();
        c = In.nextDouble();

        d = b*b - 4*a*c;

        if (d < 0)
            kRoots = 0;

        else {
            if (a == 0) {
                if (b == 0)
                    kRoots = 0;

                else {
                    kRoots = 1;
                    res1 = -c / b;
                }
            }

            else {
                kRoots = 2;

                res1 = (-b + Math.sqrt(d)) / 2 / a;

                if (d == 0)
                    res2 = -res1;
                else
                    res2 = ((-b - Math.sqrt(d)) / 2 / a);
            }
        }

        System.out.println("Количество корней: " + kRoots);

        if (kRoots > 0) {
            System.out.print("Корни: " + res1);

            if (kRoots == 2)
                System.out.print(", " + res2);

            System.out.println();
        }
    }
}
