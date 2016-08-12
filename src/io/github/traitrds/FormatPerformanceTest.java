package io.github.traitrds;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by yli on 1/19/2016.
 */
public class FormatPerformanceTest {
    private static DecimalFormat df = new DecimalFormat("#.#####");

    public static void main(String... args) {
        System.out.println("Java version is " + System.getProperty("java.version"));

        formatDoublePerformance();
        formatBigDecimalPerformance();
    }

    private static void formatDoublePerformance() {
        final int runs = 10 * 1000 * 1000; // about 1 second.
        long start = System.nanoTime();
        for (int i = 0; i < runs; i++) {
            double d = i * 0.0001;
            df.format(d);
        }
        long time = System.nanoTime() - start;
        System.out.printf("Took an average of %,d ns for format double value%n", time / runs);
    }

    private static void formatBigDecimalPerformance() {
        final int runs = 10 * 1000 * 1000; // about 1 second.
        long start = System.nanoTime();
        for (int i = 0; i < runs; i++) {
            double d = i * 0.0001;
            df.format(BigDecimal.valueOf(d));
        }
        long time = System.nanoTime() - start;
        System.out.printf("Took an average of %,d ns for format big decimal value%n", time / runs);
    }
}
