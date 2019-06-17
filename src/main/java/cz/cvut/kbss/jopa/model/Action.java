package cz.cvut.kbss.jopa.model;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Set;
import cz.cvut.kbss.benchmark.model.Vocabulary;
import cz.cvut.kbss.jopa.model.annotations.*;

@OWLClass(iri = Vocabulary.s_c_Action)
public class Action extends Event implements cz.cvut.kbss.benchmark.model.Action<Event,Person> {
    @OWLAnnotationProperty(iri = Vocabulary.s_p_label)
    private String name;
    @OWLObjectProperty(iri = Vocabulary.s_c_has_participant, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Person> persons;
    @Id
    private URI uri;

    @OWLDataProperty(iri = Vocabulary.s_p_has_key)
    private String key;

    @OWLDataProperty(iri = Vocabulary.s_p_has_start_time)
    private Date startTime;

    @OWLDataProperty(iri = Vocabulary.s_p_has_end_time)
    private Date endTime;

    @OWLObjectProperty(iri = Vocabulary.s_p_has_part, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Event> subEvents;

    @OWLObjectProperty(iri = Vocabulary.s_p_has_event_type)
    private URI eventType;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public Set<Person> getParticipants() {
        return persons;
    }


    @Override
    public void setParticipants(Set<Person> persons) {
        this.persons= persons;
    }





    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getId() {
        return uri.toString();
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public Date getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public Set<Event> getSubEvents() {
        return subEvents;
    }

    public void setSubEvents(Set<Event> subEvents) {
        this.subEvents = subEvents;
    }

    @Override
    public URI getEventType() {
        return eventType;
    }

    @Override
    public void setEventType(URI eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "uri=" + uri +
                ", subEvents=" + subEvents +
                ", eventType=" + eventType +
                '}';
    }
}
