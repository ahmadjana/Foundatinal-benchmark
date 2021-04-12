package cz.cvut.kbss.UFOIndex;

import org.openrdf.OpenRDFException;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.sparql.SPARQLRepository;
public class blazequery {
    public static void main(String[] args) throws OpenRDFException {
        String strQuery = "SELECT  (COUNT(DISTINCT ?s) AS ?sbjts) " + //
                "WHERE " +
                "{" +
                "?s ?p ?o " +
                "} ";
        SPARQLRepository repo = new SPARQLRepository("http://localhost:9999/bigdata/#namespace" );

        repo.initialize();
        RepositoryConnection conn = repo.getConnection();

        try {

            System.out.println("helllo");
            TupleQuery query = conn.prepareTupleQuery(QueryLanguage.SPARQL, strQuery);
            TupleQueryResult rs = query.evaluate();

            while (rs.hasNext ()) {
                System.out.println(rs.hasNext ());
            }
            //return Long.parseLong(rs.next().getValue("sbjts"));
        } finally {
            conn.close();
            repo.shutDown();
        }
    }
}