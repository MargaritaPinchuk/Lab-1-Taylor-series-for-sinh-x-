package taylorseries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Formatter;


public class BigMain {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введите x (вещественное число): ");
        BigDecimal x = new BigDecimal(reader.readLine().trim());

        System.out.print("Введите k (натуральное число, точность 10^-k): ");
        int k = Integer.parseInt(reader.readLine().trim());

        SeriesResultBig result = SinhSeriesBigCalculator.calculate(x, k);

        double standard = Math.sinh(x.doubleValue());
        double diff = Math.abs(result.sum.doubleValue() - standard);

        int precision = k + 1;

        System.out.println();
        System.out.println(" Результаты (BigDecimal / BigInteger) ");

        Formatter formatter = new Formatter();
        formatter.format("%20." + precision + "f", result.sum);
        System.out.println("Сумма ряда (Formatter)   : " + formatter.toString());
        formatter.close();

        System.out.printf("Math.sinh(x)             : %20." + precision + "f%n", standard);
        System.out.printf("Отклонение от эталона    : %20." + precision + "e%n", diff);
        System.out.println("Количество слагаемых     : " + result.termsCount);

        long rounded = Math.round(result.sum.doubleValue());
        System.out.printf("Округлённая сумма, 8-ричн. : %#-10o|%n", rounded);
        System.out.printf("Округлённая сумма, 16-ричн.: %#010X%n", rounded);
        System.out.printf("Число слагаемых со знаком  : %+d%n", result.termsCount);
    }
}
