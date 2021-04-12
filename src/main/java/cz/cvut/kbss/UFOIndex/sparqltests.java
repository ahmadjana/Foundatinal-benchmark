package cz.cvut.kbss.UFOIndex;
import org.apache.log4j.Logger;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.eclipse.rdf4j.sail.lucene.LuceneSailSchema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class sparqltests {
    protected Repository repository;

    protected RepositoryConnection connection;

    public static void main(String[] args)
            throws IOException
    { Logger logger = Logger.getLogger(sparqltests.class);
       // String sesameServer = "http://localhost:8080/rdf4j-server";
      String sesameServer = "http://localhost:7200";
//       String sesameServer = "http://localhost:3030";
        //
        //String repositoryID = "aviation-safety";
       //
      String repositoryID = "csat-onto";
       // String repositoryID = "ufo5oo";

        try {
            //  String serverUrl = "http://localhost:8080/openrdf-sesame";
            // RemoteRepositoryManager manager = new RemoteRepositoryManager(sesameServer);
            //manager.initialize();
            logger.info ("Running query jana1");
            Repository myRepository = new HTTPRepository (sesameServer, repositoryID);
            logger.info ("Running query jana1");
            myRepository.initialize ();

            RepositoryConnection connection = myRepository.getConnection ();

            logger.info ("Running query jana2");
            String queryStringgg=
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                            "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                            "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+

                            "SELECT\n" +
                            "\n" +
                            "  ?term \n" +
                            " FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/endurant>"                    +
                            "where{ GRAPH ?g\n" +
                            "\n" +

                            "  {benchmark:Person300773191 ufo:has_trope ?term.\n" +

                            "} }  \n"
                    ;
            String queryStringyuj = "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                    "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+

                    "SELECT\n" +
                    "\n" +
                    "  ?term ?event \n" +
                    " FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/perdurant>"                    +
                    "where{ \n" +
                    "\n" +

                    "  {benchmark:Event-100097490 ufo:has_part ?term" +
//                    "?event ufo:has_participant ?term.\n" +

                    "} }  \n"
                    ;
            String queryStringo = "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                    "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+

                    "SELECT\n" +
                    "\n" +
                    "  ?tropeP1 ?tropeP2 \n" +
                    " FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/endurant>"                    +
                    "WHERE {GRAPH ?g " +
                    "  {{benchmark:Person300773191 ufo:has_trope ?tropeP1.}" +
                    "UNION" +
                    "{benchmark:Person-Person618426418 ufo:has_trope ?tropeP2.}}}\n"
                    ;
            String queryStringop=  "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                    "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+
//"SELECT DISTINCT ?term  FROM NAMED \n" +
//                    "<http://onto.fel.cvut.cz/ontologies/ufo/endurant>  \n" +
//                    "WHERE {GRAPH ?g {{benchmark:Person-1003094006 ufo:has_trope ?term}\n" +
//                    "UNION {benchmark:Person-1015104543 ufo:has_trope ?term}}}"
                    "  SELECT (count (?event) as ?num)?event ?term  " +
//                    "FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/perdurant>"+
                    "FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/endurant>"+
                    "WHERE {GRAPH ?g {{?event ufo:has_trope ?term" +
                    "}\n" +
                    "OPTIONAL { ?term rdf:label ?label.}\n" +
                    "}}" +
                    "GROUP BY ?event ?term " +
                    ""
                    ;


            String queryString1 = "PREFIX search: <http://www.openrdf.org/contrib/lucenesail#>\n" +
                    "SELECT \n" +
                    " ?subject ?predicate ?object\n" +
                    "WHERE\n " +
                    "{ ?subject ?predicate ?object\n" +
                    "}" ;
            String queryString = "PREFIX search: <http://www.openrdf.org/contrib/lucenesail#>\n" +
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
//                    "SELECT " +
//                    "(COUNT(*) as ?Triples) " +
//                    " FROM NAMED " +
//                    " <http://onto.fel.cvut.cz/ontologies/ufo/perdurant>" +
//                    " FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/endurant>  " +
//                    "+WHERE { ?s ?p ?o}"
                    "SELECT (count (?agents) as ?num)  \n" +
//             "     FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/endurant> \n" +
                    "WHERE {   {?agents <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> \n" +
                    "<http://onto.fel.cvut.cz/ontologies/ufo/Agent>}}\n" +""

                    ;
            String queryStringi = "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX u: <http://onto.fel.cvut.cz/ontologies/ufo/>"+

                    "SELECT\n" +
                    "\n" +
                    "  ?term \n" +
//                    " FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/endurant>"                    +
////                    "where{ GRAPH ?g {\n" +
                    "where{\n" +
                    "{\n" +
                    "      # all events\n" +
                    "      # j.0:A-390 j.0:hasChild+ ?c.\n" +
                    "      # ANS events\n" +
                    "    ?term  rdfs:subClassOf+ u:trope.}\n" +
                    "      UNION {\n" +
                    "   ?term  rdfs:subClassOf+ u:Object.\n" +
                    " }"




                    +"OPTIONAL {  ?term rdfs:label ?label.} " +
                    "}" ;
            String queryStringTR = "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                    "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+

                    "SELECT\n" +
                    "\n" +
                    "  ?term \n" +
                    " FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/endurant>"                    +
                    "where{ GRAPH ?g {\n" +
                    "\n" +

                    "  {benchmark:Person-1000344628 ufo:has_trope ?term.\n" +
                    "} UNION"+
                    " { benchmark:Person-1009237217 ufo:has_trope ?term.\n" +
                    "} }  }\n"
                   ;

            String queryStringU = "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                    "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+
                    "PREFIX rdf: <http://www.w3.org/2000/01/rdf-schema#label>"+

                    "SELECT DISTINCT\n" +
                    "\n" +
                    "  ?term ?label \n" +
                    " FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/perdurant>"                    +
                    "where{ GRAPH ?g {\n" +
                    "\n" +

                    "  {?event ufo:has_participant ?term.\n" +
                    "}" +
                    //"FILTER(LANG(?label) = \"en\")"+
                    "FILTER(LANG(?label) = \"en\")"+
//                    " FILTER"+
//                   " { ?event rdf:lable {Action1638849867\"@en}.}\n" +
                    " } " +
                    "}\n"
                    ;


            String queryStringtrope= "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                    "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+
                    "PREFIX aviation-safety: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+

                    "SELECT\n" +
                    "\n" +
                    "  ?term \n" +
                    " FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/endurant>"                    +
                    "where{ GRAPH ?g\n" +
                    "\n" +

                    "  {?term ufo:inheres_in aviation-safety:air_traffic_control_agent-i.\n" +
                   // "  {?term ufo:is_participant_of aviation-safety:Ground_handling_operation-i.\n" +

                    "} }  \n"
                    ;

            String queryStringp= "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                    "PREFIX aviation-safety: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                    "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+

                    "SELECT\n" +
                    "\n" +
                    //"  ?event ?subEvent \n" +
                   "(COUNT(*) AS ?count)"+
                  //  "  ?event ?subEvent \n" +
                  // " FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/perdurant>"+
           " FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/endurant>" +
                    "where{ GRAPH ?g\n" +
                    "\n" +
                   // "  {?term ufo:is_part_of aviation-safety:flight-i.\n" +
                    //" ?term ufo:is_performed_by aviation-safety:Cabin_crew-i.\n" +
                    "{?event  ufo:has_trope ?subEvent"+

                    "} }  \n"
                   // "GROUP BY ?count"

                    ;

            String queryStringwithout = "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                    "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+

                    "SELECT\n" +
                    "\n" +
                    "  ?term \n" +

                    "where{ \n" +
                    "\n" +

                    "  {benchmark:Event-1914950487 ufo:has_part ?term.\n" +

                    "} }  \n"
                    ;
            String queryString2 = "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX u: <http://onto.fel.cvut.cz/ontologies/ufo/>"+

                    "SELECT     ?term ?Agent WHERE { \n"
                    //"?match search:query "Collision_Factors" \n" +

                    +" ?term u:has_participant ?Agent."




                    +" }" ;
//            "SELECT ?x WHERE { \n"
//                    //"?match search:query "Collision_Factors" \n" +
//
//                    +"?x rdfs:subClassOf+ t:Collision_Factors"
//
//
//                    +" }" ;
//            try (RepositoryConnection connection = myRepository.getConnection()) {
//                String queryString1 = "SELECT ?x ?y WHERE { ?x ?p ?y } ";
//                TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
//                TupleQueryResult result = tupleQuery.evaluate();
//                try (TupleQueryResult result1 = tupleQuery.evaluate()) {
//                    while (result.hasNext()) {  // iterate over the result
//                        BindingSet bindingSet = result.next();
//                        Value valueOfX = bindingSet.getValue("x");
//                        Value valueOfY = bindingSet.getValue("y");
//                        // do something interesting with the values here...
//                    }
//                }
//            }
            final List<Literal> allResults = new ArrayList<Literal> ();

            List<BindingSet> tuples = new ArrayList<BindingSet>();


            String queryString0 =
                    "PREFIX search: <http://www.openrdf.org/contrib/lucenesail#>\n" +
                            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                            + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                            + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                            + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                            + "PREFIX e-m: <http://onto.fel.cvut.cz/ontologies/eccairs/model/>"
                            + "PREFIX e-mv: <http://onto.fel.cvut.cz/ontologies/eccairs/model-view/>"
                            + "PREFIX f: <http://onto.fel.cvut.cz/ontologies/ufo/>"
                            +"PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"
                            + "SELECT  ?term"
                            + " WHERE{"
                            //+ "  ?cls1 a e:"+dlQueryq+" .}"
                            //+ "  ?cls1 a e-m:value-list .}"
                            //+ " ?cls a  e-m:"+dlQueryq+" .}"
                            +"?term rdfs:subClassOf+ t:Collision_Factors."
                            +"}";

            String queryString4=  " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                    +" PREFIX e: <http://onto.fel.cvut.cz/ontologies/aviation/safety/factors>"
                    +" PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"

                    +" PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"

                    +" CONSTRUCT {"

                    +" ?term rdfs:label ?label ;"

                    +  "rdfs:comment ?comment."
                    +"} WHERE {"


                    +"?term rdfs:subClassOf+ t:Collision_Factors."


                    +"OPTIONAL {  ?term rdfs:label ?label.}"
                    +"OPTIONAL {  ?term rdfs:comment ?comment.}"
                    +" }";

            String queryString6 = "SELECT ?o  WHERE {?s ?p ?o .}";
            System.out.println ("Running query: \n" + queryString);
            TupleQuery query =  connection.prepareTupleQuery (QueryLanguage.SPARQL, queryString);
            logger.info ("found 2: ");
            long t1 = System.currentTimeMillis();
            //  TupleResult result = query.evaluate();
            // TupleQueryResult result = query.evaluate();
            // logger.info("found 1: ");
            try {
                TupleQueryResult result = query.evaluate ();
                //logger.info ("found 1: ");
                // print the results
//                long t2 = System.currentTimeMillis();
//                System.out.println("totals time :" + (t2 - t1) + "ms");
                while (result.hasNext ()) {
//                    BindingSet bindings = result.next ();
//                    System.out.println ("found match: ");
//                    Value valueOfX = bindings.getValue ("x");
//                    Value valueOfY = bindings.getValue ("y");
////                    for (Binding binding : bindings) {
                    //allResults.add((Literal)bindings.getBinding(variableName).getValue());
                    tuples.add(result.next());
                  //  long t2 = System.currentTimeMillis();

                   // System.out.println (" testtuples " + tuples + ": " );
                    // }
                    //long t2 = System.currentTimeMillis();
                   // System.out.println("totals time :" + (t2 - t1) + "ms");
                }

//
                long t2 = System.currentTimeMillis();

//                System.out.println("totals time :" + (t2 - t1) + "ms");
                System.out.println (" tuples " + tuples + ": " );
                System.out.println("totals time :" + (t2 - t1) + "ms");
            }
            catch (Exception e){
                logger.error ("some error", e);
            }
            finally {
                connection.close ();
                myRepository.shutDown();
            }
//         finally {
//            connection.close();
//            myRepository.shutDown();
//        }
        }
        catch  (RepositoryException e) {
            logger.error(e);
        }
    }
}

