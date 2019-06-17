package cz.cvut.kbss.UFOIndex;
import org.apache.log4j.Logger;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;
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
        String sesameServer = "http://localhost:8080/rdf4j-server";
        String repositoryID = "test1";

        try {
            //  String serverUrl = "http://localhost:8080/openrdf-sesame";
            // RemoteRepositoryManager manager = new RemoteRepositoryManager(sesameServer);
            //manager.initialize();
            logger.info ("Running query jana1");
            Repository myRepository = new HTTPRepository (sesameServer, repositoryID);
            logger.info ("Running query jana1");
            myRepository.initialize ();

            RepositoryConnection connection = myRepository.getConnection ();
            // connection.begin();
            // create a sesame memory sail
//        Repository myRepository = new HTTPRepository (
//                "http://pathway.di.uoa.gr:8080/openrdf-sesame",
//                "HISTORY_KB");
//        myRepository.initialize();

            // LuceneSail lucenesail = new LuceneSail();

            //  MemoryStore memoryStore = new MemoryStore();
            // File file = new  File("C:\\Users\\jana\\Desktop\\ibas-m\\inbasModel\\inbas-model\\aviation.rdf");
            // System.out.println("Running query jana");
            // create a lucenesail to wrap the memorystore


            // set this parameter to let the lucene index store its data in ram
            // lucenesail.setParameter(LuceneSail.LUCENE_RAMDIR_KEY, "true");
            // set this parameter to store the lucene index on disk
            // lucenesail.setParameter(LuceneSail.LUCENE_DIR_KEY, "./data/mydirectory");
            // Repository myRepository1 = new SailRepository( new MemoryStore(file) );


            // wrap memorystore in a lucenesail
            // lucenesail.setBaseSail(memoryStore);
            //lucenesail.setDelegate(memoryStore);

            // create a Repository to access the sails
            //SailRepository repository = new SailRepository(lucenesail);

            //myRepository.initialize();
            // System.out.println("Running query jana");
            // add some test data, the FOAF myRepository

            logger.info ("Running query jana2");

//			connection.setAutoCommit(false);
//            File file = new  File("C:\\Users\\jana\\Desktop\\ibas-m\\inbasModel\\inbas-model\\aviation.rdf");
//            System.out.println(file.exists());
//            connection.add(
//                    file,
//                    "",
//                    RDFFormat.RDFXML);
//            connection.commit();

            // search for all resources that mention "person"



            String queryString1 = "PREFIX search: <http://www.openrdf.org/contrib/lucenesail#>\n" +
                    "SELECT \n" +
                    " ?subject ?predicate ?object\n" +
                    "WHERE\n " +
                    "{ ?subject ?predicate ?object\n" +
                    "}" ;
//                    "\n" +
//                    "LIMIT 25";
////         " SELECT DISTINCT ?resource ?score ?snippet ?property ?value ?type\n" +
//           " WHERE {\n" +
//               " ?match search:query \"pilot\";  \n" +
//                "search:score ?score;\n" +
//               " search:snippet ?snippet; \n" +
//               " search:property ?property.\n" +
//
//                      "  ?resource <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?type .\n" +
//                       " OPTIONAL { ?from ?resource ?x .\n" +
//                      "  ?from <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?domain }\n" +
//                   " ?resource <http://www.w3.org/2000/01/rdf-schema#label> ?value.\n" +
//                   " ?resource search:matches ?match.\n" +
//              "  }ORDER BY ?score";
            String queryString8 = "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX u: <http://onto.fel.cvut.cz/ontologies/ufo/>"+

                    "SELECT\n" +
                    "\n" +
                    "  ?term \n" +
                    "where{\n" +
                    "{\n" +
                    "      # all events\n" +
                    "      # j.0:A-390 j.0:hasChild+ ?c.\n" +
                    "      # ANS events\n" +
                    "    ?term  rdfs:subClassOf+ u:Event.}\n" +
                    "      UNION {\n" +
                    "   ?term  rdfs:subClassOf+ u:Object.\n" +
                    " }"




                    +" }" ;
            String queryString = "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX u: <http://onto.fel.cvut.cz/ontologies/ufo/>"+

                    "SELECT\n" +
                    "\n" +
                    "  ?term ?Agent\n" +
                    "where{\n" +
                    "\n" +
                    "      # all events\n" +
                    "      # j.0:A-390 j.0:hasChild+ ?c.\n" +
                    "      # ANS events\n" +
                    "    \n" +
                    "  ?term   u:has_participant?Agent.\n" +
                    "        \n" +
                    "  #?Agent a [owl:class(u:Agent)].\n" +
                    " \n" +
                    "      \n" +
                    "}   \n" +
                    "ORDER BY (rdfs:label)";




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
                logger.info ("found 1: ");
                // print the results
                while (result.hasNext ()) {
                    BindingSet bindings = result.next ();
                    logger.info ("found match: ");
                    Value valueOfX = bindings.getValue ("x");
                    Value valueOfY = bindings.getValue ("y");
//                    for (Binding binding : bindings) {
                    //allResults.add((Literal)bindings.getBinding(variableName).getValue());
                    tuples.add(result.next());

                    System.out.println (" dbeh1 " + tuples + ": " );
                    // }
                    long t2 = System.currentTimeMillis();
                    logger.info("totals time :" + (t2 - t1) + "ms");
                }

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

