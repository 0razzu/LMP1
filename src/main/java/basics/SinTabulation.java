package basics;


import java.text.DecimalFormat;
import java.util.Scanner;


public class SinTabulation {
    private static void fence(byte numLength) {
        System.out.print("+");

        for (byte i = 0; i < numLength + 2; i++)
            System.out.print("-");

        System.out.print("+");

        for (byte i = 0; i < numLength + 2; i++)
            System.out.print("-");

        System.out.println("+");
    }


    public static void main(String[] args) {
        final double EPS = 1E-9;
        Scanner In = new Scanner(System.in);
        double a, b, step, t;
        final byte numLength = 9, afterDot = 5;
        String format;

        System.out.println("Введите границы табулирования");
        a = In.nextDouble();
        b = In.nextDouble();

        System.out.println("\nВведите шаг");
        step = In.nextDouble();

        if ((step <= EPS) && (Math.abs(a - b) > EPS))
            System.out.println("\nШаг не может быть равен нулю при условии неравенства границ");

        else {
            if (a > b) {
                t = a;
                a = b;
                b = t;

                System.out.println("\nЗначение верхней границы не должно превышать значение правой (исправлено)");
            }

            if (step < 0) {
                step = -step;
                System.out.println("\nШаг не должен быть отрицательным (исправлено)");
            }

            format = "%." + afterDot + "f";
            System.out.format("%nТаблица значений sin(x) при x ∈ [" + format + "; " + format + "] с шагом " + format + "%n", a, b, step);

            if (step <= EPS)
                step = 1;

            format = "%" + numLength + "." + afterDot + "f";
            for (double x = a; x - b <= EPS; x += step) {
                fence(numLength);
                System.out.format("| " + format + " | " + format + " |%n", x, Math.sin(x));
            }
            fence(numLength);
        }
    }
}
