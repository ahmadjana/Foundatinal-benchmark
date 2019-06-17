package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.model.Action;
import cz.cvut.kbss.benchmark.model.Person;

import java.util.Collection;

/**
 * Saves data into repository.
 *
 * @param <P> Concrete implementation of {@link Person}
 * @param <A> Concrete implementation of {@link Action}
 */
public interface Saver<P extends Person, A extends Action> extends Transactional {

    void persistAll(Collection<P> persons);

    void persist(A Action);

   // void persist(A a);
}
