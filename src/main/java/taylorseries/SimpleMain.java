package taylorseries;

import java.util.Formatter;
import java.util.Scanner;


public class SimpleMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите x (вещественное число): ");
        double x = scanner.nextDouble();

        System.out.print("Введите k (натуральное число, точность 10^-k): ");
        int k = scanner.nextInt();

        SeriesResult result = SinhSeriesCalculator.calculate(x, k);

        double standard = Math.sinh(x);
        double diff = Math.abs(result.sum - standard);

        int precision = k + 1;

        System.out.println();
        System.out.println(" Результаты (простые типы, double) ");

        Formatter formatter = new Formatter();
        formatter.format("%15." + precision + "f", result.sum);
        System.out.println("Сумма ряда (Formatter)   : " + formatter.toString());
        formatter.close();

        System.out.printf("Math.sinh(x)             : %15." + precision + "f%n", standard);
        System.out.printf("Отклонение от эталона    : %15." + precision + "e%n", diff);
        System.out.println("Количество слагаемых     : " + result.termsCount);

        int rounded = (int) Math.round(result.sum);
        System.out.printf("Округлённая сумма, 8-ричн. : %#-10o|%n", rounded);
        System.out.printf("Округлённая сумма, 16-ричн.: %#010X%n", rounded);
        System.out.printf("Число слагаемых со знаком  : %+d%n", result.termsCount);

        scanner.close();
    }
}
