package taylorseries;


public class SinhSeriesCalculator {

    public static SeriesResult calculate(double x, int k) {

        double eps = Math.pow(10, -k);
        double xSquared = x * x;

        double term = x;
        double sum = 0.0;
        int m = 0;
        int count = 0;

        while (Math.abs(term) >= eps) {

            sum += term;
            count++;

            term = term * xSquared / ((2.0 * m + 2) * (2.0 * m + 3));
            m++;
        }

        SeriesResult result = new SeriesResult();
        result.sum = sum;
        result.termsCount = count;
        return result;
    }
}
