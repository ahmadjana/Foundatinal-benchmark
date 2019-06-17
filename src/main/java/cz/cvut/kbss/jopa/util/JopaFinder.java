package cz.cvut.kbss.jopa.util;

import cz.cvut.kbss.jopa.model.Action;
import cz.cvut.kbss.benchmark.model.HasIdentifier;
import cz.cvut.kbss.benchmark.model.Vocabulary;
import cz.cvut.kbss.benchmark.util.Finder;
import cz.cvut.kbss.jopa.model.EntityManager;

import java.net.URI;
import java.util.Collection;

public class JopaFinder implements Finder<Action> {

    private final EntityManager em;

    public JopaFinder(EntityManager em) {
        this.em = em;
    }

    @Override
    public Action find(Action expected) {
        return em.find(Action.class, expected.getUri());
    }



    @Override
    public Collection<Action> findAll() {
        return em.createNativeQuery("SELECT ?x WHERE { ?x a ?type . }", Action.class)
                 .setParameter("type", URI.create(Vocabulary.s_c_Action)).getResultList();
    }

    @Override
    public boolean exists(HasIdentifier instance) {
        return em.find(instance.getClass(), URI.create(instance.getId())) != null;
    }

    @Override
    public void close() {
        em.close();
    }
}
