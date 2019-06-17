package cz.cvut.kbss.jopa.util;

import cz.cvut.kbss.benchmark.util.Deleter;
import cz.cvut.kbss.jopa.model.Action;
import cz.cvut.kbss.jopa.model.EntityManager;

public class JopaDeleter implements Deleter<Action> {

    private final EntityManager em;

    public JopaDeleter(EntityManager em) {
        this.em = em;
    }

    @Override
    public void begin() {
        em.getTransaction().begin();
    }

    @Override
    public void commit() {
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        em.close();
    }

    @Override
    public void delete(Action action) {
        final Action r = em.find(Action.class, action.getUri());
        em.remove(r.getName());
        em.remove(r);
    }


}
