package cz.cvut.kbss.UFOIndex;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.log4j.Logger;
import org.eclipse.rdf4j.sail.lucene.LuceneSailSchema;

import java.io.IOException;

public class fuseki {
    public static void main(String[] args)
            throws IOException {
        Logger logger = Logger.getLogger(sparqltests.class);
        String serviceURI = "http://localhost:3030/aviation-safety";
        //"http://localhost:3030/ds";
        try{
            System.out.println (" neej");
            DatasetAccessorFactory factory = null;
            DatasetAccessor accessor;
            accessor = factory.createHTTP(serviceURI);

            String sparqlEndpoint = "http://localhost:3030//aviation-safety/query";

            String queryString= "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
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
                    //"  {?term ufo:is_participant_of aviation-safety:Ground_handling_operation-i.\n" +

                    "} }  \n"
                    ;

            String queryStringy= "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                    "PREFIX aviation-safety: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                    "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+

                    "SELECT\n" +
                    "\n" +
                    "  ?term \n" +
                    " FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/perduran>"                    +
                    "where{ GRAPH ?g\n" +
                    "\n" +
                    "  {?term ufo:is_part_of aviation-safety:Fligt-i.\n" +
                    // " {?term ufo:is_performed_by aviation-safety:Cabin_crew-i.\n" +
                   //"{<http://onto.fel.cvut.cz/ontologies/2014/ECCAIRS_Aviation_1.3.0.12/eccairs-events-390#category_2060000> ufo:has_participant ?term.\n"+

                    "} }  \n"
                    ;

            String sparqlQuery = "" +
                "SELECT \n" +
                " ?subject ?predicate ?object\n" +
                "WHERE\n " +
                "{ ?subject ?predicate ?object \n" +
                "}\n" +
                "LIMIT 25";
            String queryString2=
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                    "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+

                    "SELECT\n" +
                    "\n" +
                    "  ?term \n" +
                    " FROM NAMED <http://localhost:3030/ufo5/data/perdurant>"                    +
                    "where{ GRAPH ?g\n" +
                    "\n" +

                    "  {benchmark:Event-1914950487 ufo:has_part ?term.\n" +

                    "} }  \n"
                    ;
            String queryStringtest=
                    "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                    "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                    "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+

                    "SELECT\n" +
                    "\n" +
                    "  ?term \n" +
                    " FROM NAMED <http://localhost:3030/ufo5/data/endurant>"                    +
                    "where{ GRAPH ?g\n" +
                    "\n" +

                    "  {benchmark:Person-1000344628 ufo:has_trope ?term.\n" +

                    "} }  \n"
                    ;
            //long t1 = System.currentTimeMillis();
            QueryExecution q = QueryExecutionFactory.sparqlService(serviceURI,
                    queryString);
            long t1 = System.currentTimeMillis();
            ResultSet results = q.execSelect();
            long t2 = System.currentTimeMillis();
            System.out.println("totals" +
                    " time :" + (t2 - t1) + "ms");
            ResultSetFormatter.out(System.out, results);
            System.out.println("test");
//            while (results.hasNext()) {
//                QuerySolution soln = results.nextSolution();
//                RDFNode x = soln.get("x");
//
//
//                System.out.println(x);
//            }

        //Query query1 = QueryFactory.create(sparqlQuery);
//			QueryExecution qexec = (QueryExecution) QueryExecutionFactory.sparqlService(sparqlEndpoint, query1).execConstruct ();
//			ResultSet results1 = qexec.execSelect();
//			ResultSetFormatter.out(System.out, results1,query1) ;
//			//ResultSetFormatter.asRDF(model, results1);
//        System.out.println (" neej");
//        while (results1.hasNext ()) {
//            QuerySolution solution = results1.next ();
//            // get the value of the variables in the select clause
//            //String attribute_label = solution.get("attribute_label").toString ();
//            //String eccairs_term  = solution.get ("eccairs_term").asLiteral ().getLexicalForm ();
//            //String z = solution.get ("z").asLiteral ().getLexicalForm ();
//            // print the output to stdout
//            logger.info (" resj");
//            //logger.info ("tony " + expressionValue + "\t" + pValue);
//            ResultSetFormatter.out(System.out, results1);
//            //logger.info ("tony1 " + eccairs_term );
//        }
//        //	logger.info (" neej");


    } catch (Exception e) {
        e.printStackTrace ();
        logger.error (e.getMessage ());
    }
}
    }
