package cz.cvut.kbss.benchmark.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface Action <T extends Event, P extends Person>
        extends Event<T>,Serializable, HasIdentifier, HasKey
        {

    String getName();

    void setName(String name);

            Set<P> getParticipants();

            void setParticipants(Set<P> Person);
}
