public class MultiplyTable {

    void printMultiplyTable(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.println("__________");
            for (int j = 1; j <= number; j++) {
                String string = i + " * " + j  + " = " + i * j;
                System.out.println(string);
            }
            System.out.println("__________");
        }
    }

    public static void main(String[] args) {
        int number = 9;
        System.out.printf("Таблица умножения от 1 до %s%n", number);
        MultiplyTable multiplyTable = new MultiplyTable();
        multiplyTable.printMultiplyTable(number);
        System.out.println("При написании кода были использованы и процедурная, и структурная парадигмы!");
    }
}
