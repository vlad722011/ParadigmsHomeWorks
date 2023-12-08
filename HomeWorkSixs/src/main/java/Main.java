import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Service service = new Service();

        System.out.println("Запросим у пользователя длину будущего массива -> ");
        int size = service.setArrLength();
        System.out.println();

        System.out.println("Запросим у пользователя число, которое будем искать во входящем массиве -> ");
        int findNumberForUser = service.setFindNumber();
        System.out.println();

        System.out.println("Получаем на вход рандомный целочисленный массив заданной длины");
        int[] inputArray = service.getArr(size);
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Ищем во входящем массиве число заданное пользователем: " + findNumberForUser);
        int indexFindNumberForUser = service.findNumberInArrayBinarySearch(inputArray, findNumberForUser);
        System.out.println();

        System.out.println("Также получим случайное число, которое будем искать во входящем массиве");
        int findNumberRandom = rnd.nextInt(1000);
        System.out.println(findNumberRandom);
        System.out.println();

        System.out.println("Ищем во входящем массиве число полученное случайно: " + findNumberRandom);
        int indexFindNumberRandom = service.findNumberInArrayBinarySearch(inputArray, findNumberRandom);
        System.out.println();

        System.out.println("Для того, чтобы убедиться, что поиск числа во входящем массиве работает " +
                "корректно, входящий массив и искомое число зададим сами.");
        System.out.println();

        int[] array = new int[]{123, 2, 1, 2, -234, 0, 21, 898, 12};
        System.out.println("Входящий массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println();

        int number = 12;
        System.out.println("Искомое число -> " + number);
        System.out.println();
        int indexNumber = service.findNumberInArrayBinarySearch(array, number);
        System.out.println();
        System.out.println();


        System.out.println("Также можем получить рандомный массив заданной длины  используя класс Service -> ");
        int [] inputArray2 = service.getArr(size);
        System.out.println("Входящий массив: ");
        for (int i = 0; i < inputArray2.length; i++) {
            System.out.print(inputArray2[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("И также в нем можно искать желаемое число -> " + number);

        int indexNumber2 = service.findNumberInArrayBinarySearch(inputArray2, number);
    }

}
