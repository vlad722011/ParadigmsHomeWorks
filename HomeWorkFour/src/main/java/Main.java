
/*
Задача:
Написать скрипт для расчета корреляции Пирсона между двумя случайными величинами (двумя массивами). Можно
использовать любую парадигму, но рекомендую использовать функциональную, т.к. в этом примере она значительно
упростит решение.
 */

/*
Пример расчета коэффициента корреляции Пирсона:
Рассмотрим пример использования коэффициента корреляции Пирсона.
Например, нам необходимо определить взаимосвязь двух переменных агрессивности и IQ у школьников по полученным
данным тестирования.
 */

public class Main {
    public static void main(String[] args) {

        /*
        Пример расчета коэффициента корреляции Пирсона:
        Рассмотрим пример использования коэффициента корреляции Пирсона.
        Например, нам необходимо определить взаимосвязь двух переменных агрессивности и IQ у школьников по полученным
        данным тестирования, которые поместим в два массива.

        */
        int[] iq = new int[]{100, 115, 117, 119, 134, 94, 105, 103, 111, 124, 122, 109, 110, 86};
        int[] agr = new int[]{24, 27, 26, 21, 20, 31, 26, 22, 20, 18, 30, 29, 24, 26};


         /*
        Решим данную задачу двумя вариантами. В первом случае воспользуемся более привычным способом,
        используя сочетание ООП парадигмы (у нас имеется класс Service, содержащий все основные функции вычисляющие
        промежуточные и итоговые результаты, и класс Main, который в данном случае отвечает и за отображение
        результатов и является основным исполняемым классом), и процедурную и императивные парадигмы.
         */

        System.out.println("______________________________________________________________________________________________________________________________");
        System.out.println("Первый вариант решения данной задачи.");
        System.out.println("Прежде, чем мы смогли вычислить итоговое искомое значение, пришлось вызвать и вычислить несколько промежуточных функции.");
        System.out.println("И в конце получен итоговый результат");


        /*
        1. Вычисляем сумму значений X_{agr} и Y_{IQ}
         */
        int sumIQ = Service.findSumParameters(iq);
        int sumAgr = Service.findSumParameters(agr);

         /*
        2. Вычисляем среднее арифметическое для X_{agr} и Y_{IQ}
         */
        double averageIQ = Service.findAverage(iq);
        double averageAgr = Service.findAverage(agr);

        /*
        3. Вычисляем для каждого испытуемого отклонения от среднего арифметического для X_{agr} и Y_{IQ}
         */
        double[] iqDeviation = Service.findIQDeviation(iq, averageIQ);
        double[] agrDeviation = Service.findAgrDeviation(agr, averageAgr);

        /*
        4.Возведём в квадрат каждое отклонение:
        */
        double[] sqrtIQDeviation = Service.sqrtDeviation(iqDeviation);
        double[] sqrtAgrDeviation = Service.sqrtDeviation(agrDeviation);

        /*
        5. Рассчитаем сумму квадратов отклонений:
         */
        double sumSqrtIQDeviation = Service.findSum(sqrtIQDeviation);
        double sumSqrtAgrDeviation = Service.findSum(sqrtAgrDeviation);

        /*
        6. Рассчитываем для каждого наблюдения произведение разности среднего арифметического и значения
         */
        double[] multiply = Service.multiDiffBetweenAverageAndArgument(iqDeviation, agrDeviation);

        /*
        7. Рассчитываем сумму (\bar{X_{agr}} - X_{agr}) * (\bar{Y_{IQ}} - Y_{IQ})
         */
        double sumMultiplyDiffBetweenAverageAndValue = Service.findSum(multiply);

        /*
        8. Подставляем предварительно найденные значения в формулу коэффициента корреляции Пирсона и
        найдем итоговое значение коэффициента:
         */

        double pearson =  sumMultiplyDiffBetweenAverageAndValue
                /  Math.sqrt(sumSqrtIQDeviation * sumSqrtAgrDeviation);
        System.out.println("Итоговое значение коэффициента Пирсона равно: " + pearson);
        System.out.println("______________________________________________________________________________________________________________________________");




        System.out.println("______________________________________________________________________________________________________________________________");
        System.out.println("Второй вариант решения данной задачи. Используем функциональную парадигму.");
        System.out.println("Функции вычисляющие результат (промежуточный или итоговый) в качестве аргументов могут принимать другие функции.");
        System.out.println("Глубина вложенности не ограничена.");

        double coefficientPearson = Service.coefficientPearson();
        System.out.println(coefficientPearson);
        System.out.println("______________________________________________________________________________________________________________________________");

    }


}