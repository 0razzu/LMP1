package basics;


import java.util.Scanner;


public class IntAvg {
    public static void main(String[] args) {
        Scanner In = new Scanner(System.in);
        int[] numbers = new int[3];
        int t;
        double res;

        System.out.println("Введите 3 целых числа");
        for (int i = 0; i < 3; i++)
            numbers[i] = In.nextInt();

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2 - i; j++)
                if (numbers[j] > numbers[j + 1]) {
                    t = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = t;
                }

        System.out.print("\nВведённые числа: ");
        for (int n: numbers)
            System.out.print(n + " ");
        System.out.println();

        res = 1;
        for (double n: numbers)
            res *= n;

        System.out.println("\nПроизведение: " + res);

        res = 0;
        for (double n: numbers)
            res += n;
        res /= 3.;

        System.out.println("\nСреднее арифметическое: " + res);
    }
}
