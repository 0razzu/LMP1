package basics;


import java.util.Scanner;


public class DoubleAvg {
    public static void main(String[] args) {
        final double EPS = 1E-9;
        Scanner In = new Scanner(System.in);
        double[] numbers = new double[3];
        double t;

        System.out.println("Введите 3 вещественных числа");
        for (int i = 0; i < 3; i++)
            numbers[i] = In.nextDouble();

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2 - i; j++)
                if (numbers[j] - numbers[j + 1] > EPS) {
                    t = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = t;
                }

        System.out.print("\nВведённые числа: ");
        for (double n: numbers)
            System.out.print(n + " ");
        System.out.println();

        t = 1;
        for (double n: numbers)
            t *= n;

        System.out.println("\nПроизведение: " + t);

        t = 0;
        for (double n: numbers)
            t += n;
        t /= 3;

        System.out.format("%nСреднее арифметическое: %.5f%n", t);
    }
}
