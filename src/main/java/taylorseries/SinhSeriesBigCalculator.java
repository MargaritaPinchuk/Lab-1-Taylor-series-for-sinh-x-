package taylorseries;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class SinhSeriesBigCalculator {

    private static final MathContext MC = new MathContext(60);

    public static SeriesResultBig calculate(BigDecimal x, int k) {

        BigDecimal eps = BigDecimal.ONE.movePointLeft(k);

        BigDecimal xSquared = x.multiply(x, MC);

        BigDecimal term = x;
        BigDecimal sum = BigDecimal.ZERO;

        BigInteger twoM = BigInteger.ZERO;
        int count = 0;

        while (term.abs(MC).compareTo(eps) >= 0) {

            sum = sum.add(term, MC);
            count++;

            BigInteger denominatorInt = twoM.add(BigInteger.TWO)
                    .multiply(twoM.add(BigInteger.valueOf(3)));
            BigDecimal denominator = new BigDecimal(denominatorInt);

            term = term.multiply(xSquared, MC).divide(denominator, MC);

            twoM = twoM.add(BigInteger.TWO);
        }

        SeriesResultBig result = new SeriesResultBig();
        result.sum = sum;
        result.termsCount = count;
        return result;
    }
}
