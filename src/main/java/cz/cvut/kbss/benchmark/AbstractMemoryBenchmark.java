package cz.cvut.kbss.benchmark;

import cz.cvut.kbss.benchmark.data.ModelDataGenerator;
import cz.cvut.kbss.benchmark.model.Action;
import cz.cvut.kbss.benchmark.model.Person;
import cz.cvut.kbss.benchmark.util.*;


import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Primary entry point for the memory benchmark application.
 * <p>
 * Defines the algorithm invoked during the benchmark (CRUD operations in a loop) which are executed in a loop for a configured
 * amount of time.
 * <p>
 * Subclasses need to provide implementation of {@link Saver}, {@link Finder}, {@link Updater} and {@link Deleter} factory methods.
 *
 * @param <P> Concrete implementation of {@link Person}
 * @param <A> Concrete implementation of {@link Action}
 */
public abstract class AbstractMemoryBenchmark<P extends Person, A extends Action> {

    private final ModelDataGenerator<P, A> generator;

    protected AbstractMemoryBenchmark(ModelDataGenerator generator) {
        this.generator = generator;
    }

    protected void execute() {
        System.out.println("helloexcute");

        BenchmarkUtil.scheduleApplicationShutdown(Config.getRuntime().orElse(Constants.DEFAULT_MEMORY_RUNTIME));
        System.out.println("helloexcute1");
        persistPersons();
        while (true) {
            persist();
            findAll();
            update();
            remove();
        }
    }
    private void persistPersons(Saver<P, A> saver) {
        saver.begin();
        saver.persistAll(generator.getPersons());
        saver.commit();
        saver.close();
    }
    private void persistPersons() {
        generator.generatePersons();
        final Saver<P, A> saver = getSaver();
        try {
            saver.begin();
            saver.persistAll(generator.getPersons());
            saver.commit();
        }
        finally {
            saver.close();
        }
    }

    protected abstract Saver<P, A> getSaver();

    private void persist() {
        generator.generateActions();
        final Saver<P, A> saver = getSaver();
        try {
            generator.getActions().forEach(r -> {
                saver.begin();
                saver.persist(r);
                saver.commit();
            });
        } finally {
            saver.close();
        }
    }

    private void findAll() {
        final Finder<A> finder = getFinder();
        try {
            final Collection<A> result = finder.findAll();
            assertEquals(generator.getActions().size(), result.size());
        } finally {
            finder.close();
        }
    }

    protected abstract Finder<A> getFinder();

    private void update() {
        final Updater<A> updater = getUpdater();
        try {
            generator.getActions().forEach(r -> {
                updater.begin();
                AbstractRunner.updateAction(r, generator);
                updater.update(r);
                updater.commit();
            });
        } finally {
            updater.close();
        }
    }

    protected abstract Updater<A> getUpdater();

    private void remove() {
        final Deleter<A> deleter = getDeleter();
        try {
            generator.getActions().forEach(r -> {
                deleter.begin();
                deleter.delete(r);
                deleter.commit();
            });
        } finally {
            deleter.close();
        }
    }

    protected abstract Deleter<A> getDeleter();
}
