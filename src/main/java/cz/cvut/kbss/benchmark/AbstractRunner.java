package cz.cvut.kbss.benchmark;

import cz.cvut.kbss.benchmark.data.ModelDataGenerator;
import cz.cvut.kbss.benchmark.model.Action;
import cz.cvut.kbss.benchmark.model.Event;
import cz.cvut.kbss.benchmark.model.Person;
import cz.cvut.kbss.benchmark.util.*;

import javax.annotation.Resource;
import javax.security.auth.login.Configuration;
import java.io.File;
import java.util.*;

import static cz.cvut.kbss.benchmark.util.Constants.ITEM_COUNT;
import static org.junit.Assert.*;

/**
 * Abstract implementation of {@link BenchmarkRunner} which defines the performance benchmark algorithm.
 *
 * @param <P> Concrete implementation of {@link Person}
 * @param <A> Concrete implementation of {@link cz.cvut.kbss.benchmark.model.Action}
 */
public abstract class AbstractRunner<P extends Person, A extends Action> implements BenchmarkRunner {

    protected ModelDataGenerator<P, A> generator;

    protected List<A> updated;
    protected List<A> deleted;

    protected Configuration configuration;

    private boolean measured = false;
    private Process memoryWatcher;

    @Override
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }



    @Override
    public void tearDown() {
        if (memoryWatcher != null) {
            memoryWatcher.destroy();
            this.memoryWatcher = null;
        }
    }

    /**
     * Creates the data generator.
     * <p>
     * This is called before the benchmark.
     *
     * @param factor Scaling factor used for data generator initialization
     */
    protected abstract ModelDataGenerator<P, A> createGenerator(int factor);

    protected void persistPersons(Saver<P, A> saver) {
        saver.begin();
        saver.persistAll(generator.getPersons());
        saver.commit();
    }

    protected void executeBatchCreate(Saver<P, A> saver) {
        saver.begin();
        generator.getActions().forEach(saver::persist);
        saver.commit();
    }

    protected void executeCreate(Saver<P, A> saver) {
        generator.getActions().forEach(r -> {
            saver.begin();
            saver.persist(r);
            saver.commit();
        });
    }

    protected void persistData(Saver<P, A> saver) {
        saver.begin();
        saver.persistAll(generator.getPersons());
        generator.getActions().forEach(saver::persist);
        saver.commit();
    }

//    protected void executeRetrieve(Finder<R> finder) {
//        findAndVerifyAll(finder);
//    }

//    protected <A extends Action, A1 extends Resource> void findAndVerifyAll(Finder<R> finder) {
//        generator.getReports().forEach(r -> checkReport(r, finder.find(r)));
//    }

//    protected void checkReport(OccurrenceReport expected, OccurrenceReport actual) {
//        assertNotNull(actual);
//        assertEquals(expected.getRevision(), actual.getRevision());
//        assertEquals(expected.getLastModified(), actual.getLastModified());
//        assertNotNull(actual.getOccurrence());
//        assertEquals(expected.getOccurrence().getName(), actual.getOccurrence().getName());
//        assertEquals(expected.getSeverityAssessment(), actual.getSeverityAssessment());
//        assertEquals(expected.getAttachments(), actual.getAttachments());
//        assertEquals(expected.getAuthor(), actual.getAuthor());
//        assertEquals(expected.getLastModifiedBy(), actual.getLastModifiedBy());
//        assertEquals(expected.getAuthor().getContacts(), actual.getAuthor().getContacts());
//        assertEquals(expected.getLastModifiedBy().getContacts(), actual.getLastModifiedBy().getContacts());
//        checkEvents(expected.getOccurrence().getSubEvents(), actual.getOccurrence().getSubEvents());
//    }

    protected void checkEvents(Set<Event> expected, Set<Event> actual) {
        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        for (Event expEvent : expected) {
            final Optional<Event> actEvent =
                    actual.stream().filter(e -> expEvent.getKey().equals(e.getKey())).findAny();
            assertTrue(actEvent.isPresent());
            final Event evt = actEvent.get();
            assertEquals(expEvent.getStartTime(), evt.getStartTime());
            assertEquals(expEvent.getEndTime(), evt.getEndTime());
            assertEquals(expEvent.getEventType(), evt.getEventType());
            if (expEvent.getSubEvents() != null) {
                checkEvents(expEvent.getSubEvents(), evt.getSubEvents());
            }
        }
    }

    protected void executeRetrieveAll(Finder<A> finder) {
        final Collection<A> result = finder.findAll();
        assertEquals(generator.getActions().size(), result.size());
        for (A action : generator.getActions()) {
            boolean found = false;
            for (A resultAction : result) {
                // Using file number, because some libraries do not support access to instance identifier
                if (action.getKey().equals(resultAction.getKey())) {
                    found = true;
                    //checkReport(report, resultReport);
                    break;
                }
            }
            assertTrue(found);
        }
    }

    protected void executeUpdate(Updater<A> updater) {
        this.updated = new ArrayList<>(ITEM_COUNT / 2);
        for (int i = 0; i < generator.getActions().size(); i++) {
            if (i % 2 == 0) {
                continue;
            }
            final A toUpdate = generator.getActions().get(i);
            updateAction(toUpdate, generator);
            updater.begin();
            updater.update(toUpdate);
            updater.commit();
            updated.add(toUpdate);
        }
    }

    public static <P extends Person, A extends Action> void updateAction(A toUpdate,
                                                                                   ModelDataGenerator<P, A> generator) {
      //  toUpdate.setParticipants(generator.randomItem(generator.getPerson()));
//        toUpdate.getOccurrence().setName(toUpdate.getOccurrence().getName() + "-updated");
//        toUpdate.setSeverityAssessment(generator.randomInt(Constants.MAX_SEVERITY));
//        toUpdate.setLastModified(new Date(toUpdate.getLastModified().getTime() + 100000));
//        toUpdate.setRevision(toUpdate.getRevision() + 1);
//        toUpdate.getAttachments().add(generator.generateAttachment());
    }

//    protected <A extends Occurrence, A extends Resource> void verifyUpdates(Finder<R> finder) {
//        updated.forEach(r -> {
//            final R result = finder.find(r);
//            checkReport(r, result);
//        });
//    }

    protected void executeDelete(Deleter<A> deleter) {
        this.deleted = new ArrayList<>(ITEM_COUNT / 2);
        for (int i = 0; i < generator.getActions().size(); i++) {
            if (i % 2 != 0) {
                continue;
            }
            final A toDelete = generator.getActions().get(i);
            deleter.begin();
            deleter.delete(toDelete);
            deleter.commit();
            deleted.add(toDelete);
        }
    }

//    protected <O extends Occurrence, A extends Resource> void verifyDelete(Finder<R> finder) {
//        deleted.forEach(r -> {
//            assertFalse(finder.exists(r));
//            assertFalse(finder.exists(r.getOccurrence()));
//            r.getAttachments().forEach(a -> assertFalse(finder.exists((A) a)));
//            verifyDeletedEvents(r.getOccurrence().getSubEvents(), finder);
//        });
//    }

    private void verifyDeletedEvents(Set<Event> events, Finder<A> finder) {
        if (events == null) {
            return;
        }
        events.forEach(e -> {
            assertFalse(finder.exists(e));
            verifyDeletedEvents(e.getSubEvents(), finder);
        });
    }
}
