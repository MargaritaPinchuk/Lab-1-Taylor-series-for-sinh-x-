package taylorseries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Юнит-тесты для SinhSeriesCalculator (доп. часть лабораторной, 1.b).
 * Проверяем, что наш ряд даёт то же самое, что и стандартная
 * функция Math.sinh, а также несколько граничных случаев.
 */
class SinhSeriesCalculatorTest {

    @Test
    void zeroGivesZero() {
        SeriesResult result = SinhSeriesCalculator.calculate(0.0, 5);
        assertEquals(0.0, result.sum, 1e-9);
    }

    @Test
    void matchesMathSinhForPositiveX() {
        double x = 0.5;
        SeriesResult result = SinhSeriesCalculator.calculate(x, 6);
        assertEquals(Math.sinh(x), result.sum, 1e-5);
    }

    @Test
    void matchesMathSinhForNegativeX() {
        double x = -1.2;
        SeriesResult result = SinhSeriesCalculator.calculate(x, 6);
        assertEquals(Math.sinh(x), result.sum, 1e-5);
    }

    @Test
    void higherPrecisionNeedsAtLeastAsManyTerms() {
        double x = 1.0;
        SeriesResult lowPrecision = SinhSeriesCalculator.calculate(x, 2);
        SeriesResult highPrecision = SinhSeriesCalculator.calculate(x, 8);
        assertTrue(highPrecision.termsCount >= lowPrecision.termsCount);
    }
}
