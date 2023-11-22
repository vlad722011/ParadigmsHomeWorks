
import java.util.*;

public class NumberList {

    /*
    Дан список целых чисел numbers. Необходимо написать в императивном
    стиле процедуру для сортировки числа в списке в порядке убывания.
    Можно использовать любой алгоритм сортировки.
     */

    static Random rnd = new Random();
    static int[] numbers1 = new int[15];
    static int[] numbers2 = numbers1;
    static int max = Integer.MIN_VALUE;
    static int tmp = Integer.MIN_VALUE;
    static int index = Integer.MIN_VALUE;

    static void sortArrayImperativeParadigm(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    index = j;
                }
            }
            tmp = arr[i];
            arr[i] = max;
            arr[index] = tmp;

            max = Integer.MIN_VALUE;
            tmp = Integer.MIN_VALUE;

        }
    }

    static void sortArrayDeclarativeParadigm(int[] arr) {
        List<int[]> list = List.of(arr);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("_____________________________________________________________");
        System.out.println("Для начала создадим массив чисел, и выведем его на печать:");
        for (int i = 0; i < numbers1.length; i++) {
            numbers1[i] = rnd.nextInt(123);
        }
        for (int j : numbers1) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println("_____________________________________________________________");

        System.out.println("Решаем задачу в императивной парадигме:");
        System.out.println("Отсортируем массив, и выведем его на печать:");
        sortArrayImperativeParadigm(numbers1);
        for (int j : numbers1) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println("_____________________________________________________________");

        System.out.println("Решаем задачу в декларативной парадигме:");
        System.out.println("Отсортируем массив, и выведем его на печать:");
        sortArrayDeclarativeParadigm(numbers2);
        for (int j : numbers2) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println("_____________________________________________________________");

    }
}
















