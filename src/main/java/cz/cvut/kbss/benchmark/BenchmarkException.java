package cz.cvut.kbss.benchmark;

public class BenchmarkException extends RuntimeException {
    public BenchmarkException(String message) {
        super(message);
    }

    public BenchmarkException(String message, Throwable cause) {
        super(message, cause);
    }

    public BenchmarkException(Throwable cause) {
        super(cause);
    }
}

