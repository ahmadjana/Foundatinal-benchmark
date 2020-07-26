package cz.cvut.kbss.benchmark.util;

import java.net.URI;

public class Constants {

    /**
     * Number of items of one kind to use in one round.
     */
    public static final int ITEM_COUNT =9000;

    public static final int MAX_SEVERITY = 2;//10

    public static final int ATTACHMENT_COUNT = 3;
    public static final int Participants_COUNT =4;

    public static final int MAX_CHILD_EVENTS = 2;
    public static final int MAX_tropes =3;

    public static final int MAX_EVENT_DEPTH = 2;

    public static final String FACTOR_PARAMETER = "f";

    public static final String MEMORY_PARAMETER = "m";

    // Default memory-measurement application runtime in milliseconds
    public static final long DEFAULT_MEMORY_RUNTIME = 60000;

    /**
     * Randomly generated string usable as report summary.
     */


    public static final URI[] EVENT_TYPES =
            new URI[]{URI.create("http://onto.fel.cvut.cz/ontologies/stamp/riskEvent-3.4.0.2/vl-a-430/v-1"),
                    URI.create("http://onto.fel.cvut.cz/ontologies/stamp/riskEvent-3.4.0.2/vl-a-430/v-10"),
                    URI.create("http://onto.fel.cvut.cz/ontologies/stamp/riskEvent-3.4.0.2/vl-a-430/v-100"),
                    URI.create("http://onto.fel.cvut.cz/ontologies/stamp/riskEvent-3.4.0.2/vl-a-430/v-101"),
                    URI.create("http://onto.fel.cvut.cz/ontologies/stamp/riskEvent-3.4.0.2/vl-a-430/v-102"),
                    URI.create("http://onto.fel.cvut.cz/ontologies/stamp/riskEvent-3.4.0.2/vl-a-430/v-103"),
                    URI.create("http://onto.fel.cvut.cz/ontologies/stamp/riskEvent-3.4.0.2/vl-a-430/v-104"),
                    URI.create("http://onto.fel.cvut.cz/ontologies/stamp/riskEvent-3.4.0.2/vl-a-430/v-105")};
}
