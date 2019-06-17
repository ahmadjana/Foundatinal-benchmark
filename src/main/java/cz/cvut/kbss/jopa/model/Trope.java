package cz.cvut.kbss.jopa.model;
import cz.cvut.kbss.benchmark.model.Vocabulary;
import cz.cvut.kbss.jopa.model.annotations.Id;
import cz.cvut.kbss.jopa.model.annotations.OWLAnnotationProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;

import java.net.URI;
import java.util.Set;
@OWLClass(iri = Vocabulary.s_c_Trope)
public class Trope implements cz.cvut.kbss.benchmark.model.Trope {
    @OWLAnnotationProperty(iri = Vocabulary.s_p_label)
    private String name;
    @Id
    private URI uri;

    @OWLDataProperty(iri = Vocabulary.s_p_has_key)
    private String key;


    public void setUri(URI uri) {
        this.uri = uri;
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

    @Override
    public String gettrope() {
        return name;
    }

    @Override
    public void settrope(String name) {
this.name=name;
    }
}
