package cz.cvut.kbss.jopa.data;

import cz.cvut.kbss.benchmark.data.ModelDataGenerator;
import cz.cvut.kbss.jopa.model.*;
import cz.cvut.kbss.jopa.model.Action;
import cz.cvut.kbss.jopa.model.Person;

public class JopaDataGenerator extends ModelDataGenerator<Person, Action> {

    public JopaDataGenerator(float factor) {
        super(factor);
        generate();
    }
    @Override
    protected Person person() {
        final Person p = new Person();
        p.setUri(generateUri(Person.class));
        return p;
    }
    @Override
    protected Action action() {
        final Action action = new Action();
        action.setUri(generateUri(Event.class));
        return action;
    }



    @Override
    protected Event event() {
        final Event event = new Event();
        event.setUri(generateUri(Event.class));
        return event;
    }

    @Override
    protected Trope trope() {
        final Trope trope = new Trope();
        trope.setUri(generateUri(Trope.class));
        return trope;
    }


}
