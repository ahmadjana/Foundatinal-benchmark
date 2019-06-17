//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cz.cvut.kbss.benchmark;

import javax.security.auth.login.Configuration;

public interface BenchmarkRunner {
    default void setUpBeforeBenchmark() {
    }

    default void setUp() {
        System.gc();
        System.gc();
    }

    default void tearDown() {
    }

    default void tearDownAfterBenchmark() {
    }

    void execute();

    void setConfiguration(Configuration var1);

    default void beforeFirstMeasured() {
    }
}
