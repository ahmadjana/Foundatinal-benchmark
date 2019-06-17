package cz.cvut.kbss.jopa.util;

import cz.cvut.kbss.jopa.model.Action;
import cz.cvut.kbss.jopa.model.Person;
import cz.cvut.kbss.benchmark.util.Saver;
import cz.cvut.kbss.jopa.model.EntityManager;

import java.util.Collection;

public class JopaSaver implements Saver<Person, Action> {

    private final EntityManager em;

    public JopaSaver(EntityManager em) {
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
    public void persistAll(Collection<Person> persons) {
        persons.forEach(em::persist);
    }

    @Override
    public void persist(Action Action) {
        em.persist(Action);
    }


}
