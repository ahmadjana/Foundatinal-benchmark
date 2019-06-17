package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.model.Action;
import cz.cvut.kbss.benchmark.model.HasIdentifier;
//import cz.cvut.kbss.benchmark.model.OccurrenceReport;

import java.util.Collection;

/**
 * Finds reports.
 *
 * @param <A> Concrete implementation of {@link Action}
 */
public interface Finder<A extends Action> {

    A find(A expected);

    Collection<A> findAll();

    boolean exists(HasIdentifier instance);

    /**
     * Closes the repository accessor.
     */
    void close();
}
