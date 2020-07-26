package cz.cvut.kbss.UFOIndex;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;
import org.eclipse.rdf4j.sail.lucene.LuceneSailSchema;

public class QueryTest {

    public static void main(String[] args) {
        String service = "http://localhost:8890/sparql";
//        String query = ("SELECT * FROM NAMED <http://localhost:8890/safetye> WHERE { GRAPH ?graph { ?s ?p ?o } } limit 100");
        String query1 =
                "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+
                "PREFIX aviation-safety: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+

                "SELECT\n" +
                "\n" +
                "  ?term \n" +
                " FROM NAMED <http://localhost:8890/safetyp>"                    +
                "where{ GRAPH ?g\n" +
                "\n" +

                "  {aviation-safety:Damage_manifestation ufo:has_participant ?term.\n" +
                //"  {?term ufo:is_participant_of aviation-safety:Ground_handling_operation-i.\n" +

                "} }  \n"

        ;
        String queryT =
                "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                        "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                        "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+
                        "PREFIX aviation-safety: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+

                        "SELECT\n" +
                        "\n" +
                        "  ?term \n" +
                        "                        FROM NAMED <http://localhost:8890/safetye>                  \n"                    +
                        "where{ GRAPH ?g\n" +
                        "\n" +

                        "   { ?term ufo:is_object_part_of aviation-safety:Aircraft-i." +
                        "    ?event ufo:has_participant   aviation-safety:Aircraft-i.\n" +
                        "                         }" +

                        //"  {?term ufo:is_participant_of aviation-safety:Ground_handling_operation-i.\n" +

                        "}   \n"
                ;


        String queryString1 = "PREFIX search: <http://www.openrdf.org/contrib/lucenesail#>\n" +
                "SELECT \n" +
                " ?subject ?predicate ?object\n" +
                "WHERE\n " +
                "{ ?subject ?predicate ?object\n" +
                "}" ;
//                    ;
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
        String queryu = "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+

        "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+

                "SELECT\n" +
                "\n" +
                "  ?term \n" +
                " FROM NAMED <http://localhost:8890/endurantmil>"                    +
                "where{ GRAPH ?g\n" +
                "\n" +

                "  {{benchmark:Person-1017289722 ufo:has_trope ?term.}" +
                "UNION" +
                "{benchmark:1011355929 ufo:has_trope ?term.}\n" +

                "} }  \n"
                ;
        String queryil = "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
"PREFIX aviation-safety: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>\n" +
                "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>\n" +
                "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>\n" +
                "\n" +
                "\n" +
                "SELECT ?term " +
                " ?term1 FROM NAMED <http://localhost:8890/perdurantmil> \n" +
                "FROM NAMED <http://localhost:8890/endurantmil>\n" +
                "\n" +
                "WHERE { GRAPH ?graph{ {?term ufo:has_participant benchmark:Person-48646540}\n" +
                "UNION{ \n" +
                "benchmark:Person-1017289722 ufo:has_trope ?term1}}}"
             ;

        String query= "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+



                "SELECT\n" +
                "\n" +
                "  ?term ?event \n" +
                " FROM NAMED <http://localhost:8890/perdurant200>"                    +
                "where{ GRAPH ?g\n" +
                "\n" +
               " {benchmark:Event966508596 ufo:has_part ?term}}"
//
//                "  {?event ufo:has_participant ?term.\n" +
//
//                "OPTIONAL { ?term rdf:label ?label.}} }  \n"
                ;
        String queryi = "PREFIX search: <http://www.openrdf.org/contrib/lucenesail#>\n" +
                "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
//                    "SELECT " +
//                    "(COUNT(*) as ?Triples) " +
//                    " FROM NAMED " +
//                    " <http://onto.fel.cvut.cz/ontologies/ufo/perdurant>" +
//                    " FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/endurant>  " +
//                    "+WHERE { ?s ?p ?o}"
                "SELECT (count (?agents) as ?num) " +
//                "//                    \"FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/endurant> \\n\" +\n" +

                "WHERE {   {?agents <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> \n" +

                                 "<http://onto.fel.cvut.cz/ontologies/ufo/Agent>}}\n"


                ;

        String queryyj = "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+


                "  SELECT (count (?event) as ?num)?event  ?term\n" +
//                " FROM NAMED <http://localhost:8890/perdurantmil>"+
//        "FROM NAMED <http://localhost:8890/endurantmil>"+
                "where{ GRAPH ?g\n" +
                "\n" +

//
                "  {?event ufo:has_trope ?term.\n" +

                "OPTIONAL { ?term rdf:label ?label.}} } " +
                "GROUP BY ?event ?term \n"
                ;
        String queryStrinkg= "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                "PREFIX t: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+
                "PREFIX aviation-safety: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+

                "SELECT\n" +
                "\n" +
                "  ?term ?event \n" +
                " FROM NAMED <file://C:/fakepath/model.owl>"                    +
                "where{ GRAPH ?g\n" +
                "\n" +

                //  "  {?term ufo:inheres_in aviation-safety:air_traffic_control_agent-i.\n" +
                "  {?term ufo:is_object_part_of aviation-safety:Aircraft-i.\n" +
                "  ?event ufo:has_participant   aviation-safety:Aircraft-i  .\n" +

                "} }  \n"
                ;
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
//                    "  {?term ufo:is_participant_of aviation-safety:Ground_handling_operation-i.\n" +

                "} }  \n"
                ;

        String queryStringi= "PREFIX search:<"+ LuceneSailSchema.NAMESPACE+"> \n" +
                "PREFIX aviation-safety: <http://onto.fel.cvut.cz/ontologies/aviation-safety/>"+
                "PREFIX ufo: <http://onto.fel.cvut.cz/ontologies/ufo/>"+
                "PREFIX benchmark:<http://krizik.felk.cvut.cz/ontologies/benchmark/>"+

                "SELECT\n" +
                "\n" +
                "  ?term \n" +
                " FROM NAMED <http://onto.fel.cvut.cz/ontologies/ufo/perdurant>"                    +
                "where{ GRAPH ?g\n" +
                "\n" +
//                    "  {?term ufo:is_part_of aviation-safety:flight-i.\n" +
                " {aviation-safety:Damage_manifestation ufo:has_participant ?term.\n" +
                //  "{<http://onto.fel.cvut.cz/ontologies/2014/ECCAIRS_Aviation_1.3.0.12/eccairs-events-390#category_2060000> ufo:has_participant ?term.\n"+

                "} }  \n"
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
        QueryExecution qe = QueryExecutionFactory.sparqlService(service, query);

        long t1 = System.currentTimeMillis();

        try {
            ResultSet results = qe.execSelect();
            System.out.println("Query solution1");
            long t2 = System.currentTimeMillis();
            System.out.println("totals" +
                    " time :" + (t2 - t1) + "ms");
            while (results.hasNext()) {
//                ResultSetFormatter.out(System.out, (org.apache.jena.query.ResultSet) results);
                QuerySolution soln = results.nextSolution();
                RDFNode x = soln.get("term");
                RDFNode r = soln.get("p");
                RDFNode l = soln.get("o");
                System.out.println("Query solution:" + x+"p"+r+"o"+l);

            }
        } catch (Exception e) {
            System.out.println("Query error:" + e);
        } finally {
            qe.close();
        }
    }}