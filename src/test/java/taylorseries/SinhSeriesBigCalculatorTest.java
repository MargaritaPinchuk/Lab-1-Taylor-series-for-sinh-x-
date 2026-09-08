package taylorseries;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Юнит-тесты для SinhSeriesBigCalculator (доп. часть лабораторной, 1.b).
 */
class SinhSeriesBigCalculatorTest {

    @Test
    void zeroGivesZero() {
        SeriesResultBig result = SinhSeriesBigCalculator.calculate(BigDecimal.ZERO, 10);
        assertEquals(0.0, result.sum.doubleValue(), 1e-9);
    }

    @Test
    void matchesMathSinhForPositiveX() {
        BigDecimal x = new BigDecimal("0.5");
        SeriesResultBig result = SinhSeriesBigCalculator.calculate(x, 15);
        assertEquals(Math.sinh(0.5), result.sum.doubleValue(), 1e-10);
    }

    @Test
    void matchesMathSinhForNegativeX() {
        BigDecimal x = new BigDecimal("-1.2");
        SeriesResultBig result = SinhSeriesBigCalculator.calculate(x, 15);
        assertEquals(Math.sinh(-1.2), result.sum.doubleValue(), 1e-10);
    }
}
