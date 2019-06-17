package cz.cvut.kbss.benchmark.data;
import cz.cvut.kbss.benchmark.model.Event;
import cz.cvut.kbss.benchmark.model.Person;
import cz.cvut.kbss.benchmark.model.Vocabulary;
import cz.cvut.kbss.benchmark.model.*;
import cz.cvut.kbss.benchmark.util.Constants;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static cz.cvut.kbss.benchmark.util.Constants.EVENT_TYPES;
import static cz.cvut.kbss.benchmark.util.Constants.ITEM_COUNT;

/**
 * Generates data for the benchmark.
 * <p>
 * The generator takes a factor parameter, which is used to configure the size of the generated dataset by multiplying
 * the {@link Constants#ITEM_COUNT} with it.
 * <p>
 * Implement the abstract methods generating implementations of the model classes in concrete OTM frameworks.
 * <p>
 * If the generator is able to create detached instances of the object model classes, {@link #generate()} should be
 * called in the subclass constructor so that instance generation is not executed during benchmark, possibly skewing performance data.
 *
 * @param <P> Concrete implementation of {@link Person}
 * @param <A> Concrete implementation of {@link Action}
 *
 */

public abstract class ModelDataGenerator <P extends Person, A extends Action> {
    protected final Random random = new Random();

    private final int itemCount;

    private List<A> actions;
    private List<P> persons;

    public ModelDataGenerator(float factor) {
        assert factor > 0;
        this.itemCount = Math.round(ITEM_COUNT * factor);
        generate();
    }

    public void generate() {
        this.persons = generatePersonsImpl();
        this.actions = generateActionsImpl();
    }
    public void generateActions() {
        generateActionsImpl();
    }

    private String generateKey() {

        return Long.toString(System.currentTimeMillis()) + random.nextInt();
    }

    private Date currentTime() {
        final long time = (System.currentTimeMillis() / 1000) * 1000;
        return new Date(time);
    }

    protected List<A> generateActionsImpl() {
        final List<A> actions = new ArrayList<>();
        for (int i = 0; i < itemCount; i++) {
            final A a = action();
           a.setParticipants(generatePersonss());
            a.setName("Action" + random.nextInt());
            a.setSubEvents(generateEventHierarchy(a));
            a.setEventType(EVENT_TYPES[random.nextInt(EVENT_TYPES.length)]);
            a.setStartTime(new Date(currentTime().getTime() - 10000));
            a.setEndTime(currentTime());
            a.setKey(generateKey());
            actions.add(a);
        }
        return actions;
    }


    public void generatePersons() {
        generatePersonsImpl();
    }
    protected List<P> generatePersonsImpl() {
        final List<P> list = new ArrayList<>();
        for (int i = 0; i < itemCount; i++) {
            final P p = person();
            p.setKey(generateKey());
            p.setPassword("password-" + i);
            p.setFirstName("firstName" + i);
            p.setLastName("lastName" + i);
            p.setUsername("user" + i);
            p.setName("lable"+ i);
            p.setTrope(generattopes());
            p.setContacts(IntStream.range(0, 5)
                    .mapToObj(j -> String.format("%s_%d@kbss.felk.cvut.cz", p.getUsername(), j))
                    .collect(Collectors.toSet()));
            list.add(p);
        }
        return list;
    }
    protected Person generatePerson() {
                  final P p = person();
            p.setKey(generateKey());
            p.setPassword("password-" +random.nextInt() );
            p.setFirstName("firstName" + random.nextInt() );
            p.setLastName("lastName" +random.nextInt() );
            p.setUsername("user" + random.nextInt() );
            p.setName("lable"+ random.nextInt());
            p.setTrope(generattopes());
            p.setContacts(IntStream.range(0, 5)
                    .mapToObj(j -> String.format("%s_%d@kbss.felk.cvut.cz", p.getUsername(), j))
                    .collect(Collectors.toSet()));
return p;
        }


    protected Set<Person> generatePersonss() {
        return IntStream.range(0, Constants.Participants_COUNT).mapToObj(i -> generatePerson())
                .collect(Collectors.toSet());
    }
    protected abstract P person();
    protected abstract A action();
    protected abstract Event event();
    protected abstract Trope trope();

    protected URI generateUri(Class<?> type) {
        return URI.create(Vocabulary.BASE_URI + type.getSimpleName() + random.nextInt());
    }
    private Set<Event> generateEventHierarchy(Action action) {
        return generateEvents(action, 0, Constants.MAX_EVENT_DEPTH);
    }
    private Set<Event> generateEvents(Action action, int level, int maxLevel) {
        if (level >= maxLevel) {
            return null;
        }
        final Set<Event> events = new HashSet<>();
        for (int i = 0; i < Constants.MAX_CHILD_EVENTS; i++) {
            final Event evt = event();
            evt.setStartTime(action.getStartTime());
            evt.setEndTime(action.getEndTime());
            evt.setSubEvents(generateEvents(action, level + 1, maxLevel));
            evt.setEventType(EVENT_TYPES[random.nextInt(EVENT_TYPES.length)]);
            evt.setKey(generateKey());
            events.add(evt);
        }
        return events;
    }

//    protected Set<Trope> generattopes() {
//        return IntStream.range(0, Constants.MAX_tropes).mapToObj(i -> generattope())
//                .collect(Collectors.toSet());
//    }
    private Set<Trope> generattopes() {
                final Set<Trope> tropes = new HashSet<>();
        for (int i = 0; i < Constants.MAX_tropes; i++) {
            final Trope tr = trope();
            tr.settrope("trope" +random.nextInt());
            tr.setKey(generateKey());
        tropes.add(tr);}
        return tropes;


    }
    public List<P> getPersons() {
        return Collections.unmodifiableList(persons);
    }
    public List<A> getActions() {
        return Collections.unmodifiableList(actions);

    }

    public int randomInt(int max) {
        return random.nextInt(max);
    }
    public <T> T randomItem(List<T> items) {
        return items.get(random.nextInt(items.size()));
    }

}
