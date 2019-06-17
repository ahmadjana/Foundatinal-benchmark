package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.model.Action;


/**
 * Deletes the specified report.
 *
 * @param <A> Concrete implementation of {@link Action}
 */
public interface Deleter<A extends Action> extends Transactional {

    void delete(A action);
}
