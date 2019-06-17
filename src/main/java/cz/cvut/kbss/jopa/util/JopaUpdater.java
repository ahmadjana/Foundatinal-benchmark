package cz.cvut.kbss.jopa.util;
import  cz.cvut.kbss.benchmark.util.Updater;
import cz.cvut.kbss.jopa.model.Action;
import cz.cvut.kbss.jopa.model.EntityManager;

public class JopaUpdater implements Updater<Action> {

    private final EntityManager em;

    public JopaUpdater(EntityManager em) {
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
//
//    @Override
//    public void update(Action Action) {
//
//    }

    @Override
    public void update(Action action) {
        em.merge(action.getName());
        em.merge(action);
    }
}
