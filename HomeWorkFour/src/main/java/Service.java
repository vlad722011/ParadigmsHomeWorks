public class Service {


    public static int[] iq = new int[]{100, 115, 117, 119, 134, 94, 105, 103, 111, 124, 122, 109, 110, 86};
    public static int[] agr = new int[]{24, 27, 26, 21, 20, 31, 26, 22, 20, 18, 30, 29, 24, 26};
    Service service;

    public Service(Service service) {
        this.service = service;
    }

    static int findSumParameters(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

    static double findAverage(int[] arr) {
        return (double) ((Service.findSumParameters(arr) * 100) / arr.length) / 100;
    }

    static double [] findIQDeviation(int []arr, double arg){
        double [] iqDeviation = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            iqDeviation[i] = arg - arr[i];
        }
        return iqDeviation;
    }

    static double [] findAgrDeviation(int []arr, double arg){
        double [] agrDeviation = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            agrDeviation[i] = arg - arr[i];
        }
        return agrDeviation;
    }

    static double [] sqrtDeviation(double [] arr){
        double [] sqrtDeviation = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sqrtDeviation[i] = arr[i] * arr[i];
        }
        return sqrtDeviation;
    }

    static double findSum(double[] arr) {
        double sum = 0.0;
        for (double j : arr) {
            sum += j;
        }
        return sum;
    }

    static double [] multiDiffBetweenAverageAndArgument(double [] arr1, double [] arr2){
        double [] arr3 = new double[arr1.length];
        for (int i = 0; arr1.length > i; i++) {
            arr3[i] = arr1[i] * arr2 [i];
        }
        return arr3;
    }


    /*
    Решение данной задачи в функциональной парадигме - могло выглядеть вот так:
    Функции вычисляющая результат (промежуточный или итоговый) в качестве аргументов могут принимать другие функции.
    Глубина вложенности не ограничена.
     */
    static double coefficientPearson (){
        return  Service.findSum(Service.multiDiffBetweenAverageAndArgument(Service.findIQDeviation
                (iq, Service.findAverage(iq)), Service.findAgrDeviation(agr, Service.findAverage(agr))))
                /
                Math.sqrt(Service.findSum(Service.sqrtDeviation
                        (Service.findIQDeviation(iq, Service.findAverage(iq))))
                        *
                        Service.findSum(Service.sqrtDeviation(Service.findAgrDeviation
                                (agr, Service.findAverage(agr)))));
    }

}
