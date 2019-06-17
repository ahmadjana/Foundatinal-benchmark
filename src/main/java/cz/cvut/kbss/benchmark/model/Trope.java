package cz.cvut.kbss.benchmark.model;

import java.io.Serializable;
import java.util.Set;
public interface Trope <T extends Trope> extends Serializable, HasIdentifier, HasKey {

        String gettrope();

        void settrope(String name);
}
