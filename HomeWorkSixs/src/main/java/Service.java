import java.util.*;

public class Service {
    Scanner scanner = new Scanner(System.in);
    private int[] arr;
    private int arrLength;
    private int findNumber;

    public Service() {
    }

    public int setFindNumber() {
        System.out.println("Введите число: ");
        findNumber = scanner.nextInt();
        return findNumber;
    }

    public int[] getArr(int size) {
        int[] array = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rnd.nextInt(-1000, 1001);
        }
        return array;
    }


    public int getArrLength() {
        Random rnd = new Random();
        return rnd.nextInt(1, 21);
    }

    public int setArrLength() {
        System.out.println("Введите желаемую длину массива: ");
        Scanner scanner = new Scanner(System.in);
        arrLength = scanner.nextInt();
        return arrLength;
    }

    List<Integer> convertArrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    public int findNumberInArrayBinarySearch(int[] array, int number) {
        List<Integer> tempList = convertArrayToList(array);
        List<Integer> list = convertArrayToList(array);
        int indexNumber = -1;
        int findNumber = Integer.MIN_VALUE;
        int temp = Integer.MIN_VALUE;

        Collections.sort(tempList);

        for (int i = 0; i < tempList.size(); i++) {
            int size = tempList.size();
            temp = tempList.get((tempList.size() / 2));
            int index = tempList.indexOf(temp);

            if (temp > number) {
                int count = size - index;
                while (count > 0) {
                    tempList.remove(tempList.get(tempList.size() - 1));
                    count -= 1;
                }
                i = -1;
            } else if (temp < number) {
                int count = 0;
                while (count <= index) {
                    tempList.remove(tempList.get(0));
                    count += 1;
                }
                i = -1;
            } else if (temp == number) {
                indexNumber = list.indexOf(temp);
                break;
            } else {
                indexNumber = -1;
            }
        }

        if (indexNumber == -1) {
            System.out.println("Искомого числа нет во входящем массиве.");
            System.out.println(indexNumber);

        } else {
            System.out.println("Искомое число есть в массиве. Это число " + temp);
            System.out.println("Индекс этого числа во входящем массиве " + indexNumber);
        }
        return indexNumber;
    }
}
