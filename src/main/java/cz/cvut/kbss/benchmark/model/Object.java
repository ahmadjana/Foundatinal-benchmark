package cz.cvut.kbss.benchmark.model;

import java.io.Serializable;
import java.util.Set;

public interface Object<T extends Object> extends Serializable, HasIdentifier, HasKey {

    String getName();

    void setName(String name);
    Set<T> getobjectparts();

    void setObjectpart(Set<T> objectpart);


}
