package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.model.Action;

/**
 * Updates data using the provided instance.
 * <p>
 * The provided instance should not be managed by the persistence context.
 *
 * @param <A> Concrete implementation of {@link Action}
 */
public interface Updater<A extends Action> extends Transactional {

    void update(A Action);
}
