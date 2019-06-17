package cz.cvut.kbss.jopa;

import cz.cvut.kbss.benchmark.AbstractMemoryBenchmark;
import cz.cvut.kbss.jopa.data.JopaDataGenerator;
import cz.cvut.kbss.jopa.model.Action;
import cz.cvut.kbss.jopa.model.Person;
import cz.cvut.kbss.jopa.util.JopaDeleter;
import cz.cvut.kbss.jopa.util.JopaFinder;
import cz.cvut.kbss.jopa.util.JopaSaver;
import cz.cvut.kbss.jopa.util.JopaUpdater;
import cz.cvut.kbss.benchmark.util.Deleter;
import cz.cvut.kbss.benchmark.util.Finder;
import cz.cvut.kbss.benchmark.util.Saver;
import cz.cvut.kbss.benchmark.util.Updater;

public class JopaMemoryBenchmark extends AbstractMemoryBenchmark<Person, Action> {

    private final PersistenceFactory persistenceFactory;

    private JopaMemoryBenchmark() {
        super(new JopaDataGenerator(1));
        persistenceFactory = new PersistenceFactory();
    }

    public static void main(String[] args) {
        new JopaMemoryBenchmark().execute();
    }

    @Override
    protected Saver<Person, Action> getSaver() {
        return new JopaSaver(persistenceFactory.entityManager());
    }

    @Override
    protected Finder<Action> getFinder() {
        return new JopaFinder(persistenceFactory.entityManager());
    }

    @Override
    protected Updater<Action> getUpdater() {
        return new JopaUpdater(persistenceFactory.entityManager());
    }

    @Override
    protected Deleter<Action> getDeleter() {
        return new JopaDeleter(persistenceFactory.entityManager());
    }
}
