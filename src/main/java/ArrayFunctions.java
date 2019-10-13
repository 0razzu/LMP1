import java.io.IOException;
import java.util.Scanner;


public class ArrayFunctions {
    public static void printArray(int[] array) {
        for (int a: array)
            System.out.print(a + " ");
        System.out.println();
    }


    public static void readArrayFromConsole(int[] array) {
        Scanner In = new Scanner(System.in);

        for (int i = 0; i < array.length; i++)
            array[i] = In.nextInt();
    }


    public static int sumOfArrayElems(int[] array) {
        int sum = 0;

        for (int a: array)
            sum += a;

        return sum;
    }


    public static int kOfEvenElems(int[] array) {
        int k = 0;

        for (int a: array)
            if (a % 2 == 0)
                k++;

        return k;
    }


    public static int kOfElemsFromSegment(int[] array, int a, int b) {
        int k;

        if (a > b) {
            k = a;
            a = b;
            b = k;
        }

        k = 0;

        for (int e: array)
            if ((a <= e) && (e <= b))
                k++;

        return k;
    }


    public static boolean allElemsArePos(int[] array) {
        for (int a: array)
            if (a <= 0)
                return false;

        return true;
    }


    public static void reverse(int[] array) {
        int t;

        for (int i = 0; i < array.length / 2; i++) {
            t = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = t;
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner In = new Scanner(System.in);
        int[] array = null;
        int c = 0, size, a, b;

        while (c != 9) {
            System.out.print("\033[H\033[2JСодержимое массива: ");

            if (array == null)
                System.out.println("массив не создан");

            else if (array.length == 0)
                System.out.println("массив нулевой длины");

            else
                printArray(array);

            System.out.println("\n1) Новый массив;");
            System.out.println("2) Заполнение массива;");
            System.out.println("3) Удаление массива;");
            System.out.println("4) Сумма элементов;");
            System.out.println("5) Количество чётных элементов;");
            System.out.println("6) Количество элементов, принадлежащих отрезку [a; b];");
            System.out.println("7) Проверка, все ли элементы положительны;");
            System.out.println("8) Перестановка элементов в обратном порядке;");
            System.out.println("9) Выход\n");

            c = In.nextInt();

            if (c == 1) {
                System.out.println("\nВведите размер массива");
                size = In.nextInt();

                if (size >= 0)
                    array = new int[size];
            }

            else if ((c == 2) && (array != null)) {
                System.out.println("\nВведите элементы массива");
                readArrayFromConsole(array);
            }

            else if (c == 3)
                array = null;

            else if (array != null) {
                if (c == 4) {
                    System.out.println("\nСумма элементов равна " + sumOfArrayElems(array));
                    In.nextLine();
                    In.nextLine();
                }

                else if (c == 5) {
                    System.out.println("\nКоличество чётных элементов: " + kOfEvenElems(array));
                    In.nextLine();
                    In.nextLine();
                }

                else if (c == 6) {
                    System.out.println("\nВведите a и b");
                    a = In.nextInt();
                    b = In.nextInt();

                    System.out.println("\nКоличество элементов, принадлежащих отрезку [" + a + "; " + b + "]: " +
                            kOfElemsFromSegment(array, a, b));
                    In.nextLine();
                    In.nextLine();
                }

                else if (c == 7) {
                    System.out.println("\n" + (allElemsArePos(array)? "Все": "Не все") + " элементы массива положительны");
                    In.nextLine();
                    In.nextLine();
                }

                else if (c == 8)
                    reverse(array);
            }
        }

        System.out.println("\033[H\033[2JПрограмма завершена");
    }
}
