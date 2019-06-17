package cz.cvut.kbss.jopa.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import cz.cvut.kbss.jopa.model.annotations.Id;
import cz.cvut.kbss.jopa.model.annotations.OWLAnnotationProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;

import java.net.URI;
import java.util.Set;
@OWLClass(iri = Vocabulary.s_c_Object)
public class Object implements cz.cvut.kbss.benchmark.model.Object {
    @OWLAnnotationProperty(iri = Vocabulary.s_p_label)
    private String name;
    @Id
    private URI uri;

    @OWLDataProperty(iri = Vocabulary.s_p_has_key)
    private String key;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
this.name=name;
    }

    @Override
    public Set getobjectparts() {
        return null;
    }

    @Override
    public void setObjectpart(Set objectpart) {

    }

    @Override

    public String getId() {
        return uri.toString();
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

}
