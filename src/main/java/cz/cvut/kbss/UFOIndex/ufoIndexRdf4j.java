package cz.cvut.kbss.UFOIndex;

import org.eclipse.rdf4j.common.iteration.Iteration;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.vocabulary.OWL;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jana on 10/31/2018.
 */
public class ufoIndexRdf4j {



    public static void main(String[] args)
            throws IOException
    {

        System.out.println  ("Running nothing");


        try {

            System.out.println("Enter the sesameServer and the repositoryID ");
            // Scanner in = new Scanner(System.in);
//
            // String sesameServer1 = in.next("http://localhost:8080/rdf4j-server");
            // String repositoryID1= in.next("test5");
            String sesameServer ="http://localhost:8080/rdf4j-server";
            //String sesameServer ="http://localhost:7200/";
           // String repositoryID ="aviation-safety";
            String repositoryID ="generate";
            //  String serverUrl = "http://localhost:8080/openrdf-sesame";
            // RemoteRepositoryManager manager = new RemoteRepositoryManager(sesameServer);
            //manager.initialize();
            System.out.println  ("Running query jana1");
            Repository myRepository = new HTTPRepository(sesameServer, repositoryID);
            System.out.println  ("Running query jana10");
            myRepository.initialize ();
            try (RepositoryConnection connection  = myRepository.getConnection ()) {
                ValueFactory f = myRepository.getValueFactory();

                String object = "http://onto.fel.cvut.cz/ontologies/ufo/object";

                String endurants = "http://onto.fel.cvut.cz/ontologies/ufo/endurant";
                System.out.println("like1");
                /**
                 * UFO CONCEPTS.
                 */
                System.out.println("UFO CONCEPTS");
                IRI aviationisSubcategoryOf = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviationisSubcategoryOf");
                IRI endurant = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/endurant");
                IRI context = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/endurant");
                IRI Object = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/Object");
                IRI Agent = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/Agent");
                IRI Trope = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/Trope");
                IRI Physical_object = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/Physical_object");
                String baseURI = "http://onto.fel.cvut.cz/ontologies/ufo/endurant";
                IRI inheres_in = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/inheres_in");
                IRI is_part_of = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/is_part_of");
                IRI is_participant_of = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/is_participant_of");
                IRI has_object_part = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/has_object_part");
                IRI is_object_part_of = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/is_object_part_of");
                IRI has_part = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/ufo:has_part");
                IRI has_trope = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/has_trope");
                IRI performs = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/ufo:performs");
                IRI Disposition = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/ufo:Disposition");
                IRI is_manifested_by = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/ufo:is_manifested_by");
                IRI is_classified_by = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/ufo:is_classified_by");
                System.out.println("UFO triples");
                /**
                 * iterate all UFO triples.
                 */
                Iteration<? extends Statement, RepositoryException> iter1 = connection.getStatements(null, aviationisSubcategoryOf, null);
                Iteration<? extends Statement, RepositoryException> iter2 = connection.getStatements(null, RDFS.SUBCLASSOF, endurant);
                Iteration<? extends Statement, RepositoryException> iter3 = connection.getStatements(null, RDFS.RANGE, Object);
                Iteration<? extends Statement, RepositoryException> iter4 = connection.getStatements(null, RDFS.DOMAIN, Object);
                Iteration<? extends Statement, RepositoryException> iter5 = connection.getStatements(null, RDFS.SUBCLASSOF, endurant);
                Iteration<? extends Statement, RepositoryException> iter6 = connection.getStatements(null, OWL.SOMEVALUESFROM, null);
                Iteration<? extends Statement, RepositoryException> iter7 = connection.getStatements(null, RDFS.SUBCLASSOF, Object);
                Iteration<? extends Statement, RepositoryException> iter8 = connection.getStatements(null, RDFS.SUBCLASSOF, Agent);
                Iteration<? extends Statement, RepositoryException> iter9 = connection.getStatements(null, RDFS.RANGE, Agent);
                Iteration<? extends Statement, RepositoryException> iter10 = connection.getStatements(null, RDFS.DOMAIN, Agent);
                Iteration<? extends Statement, RepositoryException> iter11 = connection.getStatements(null, RDFS.SUBCLASSOF, Physical_object);
                Iteration<? extends Statement, RepositoryException> iter12 = connection.getStatements(null, RDFS.RANGE, Physical_object);
                Iteration<? extends Statement, RepositoryException> iter13 = connection.getStatements(null, RDFS.DOMAIN, Physical_object);
                Iteration<? extends Statement, RepositoryException> iter14 = connection.getStatements(null, RDFS.SUBCLASSOF, Trope);
                Iteration<? extends Statement, RepositoryException> iter15 = connection.getStatements(null, RDFS.RANGE, Trope);
                Iteration<? extends Statement, RepositoryException> iter16 = connection.getStatements(null, RDFS.RANGE, Trope);
                Iteration<? extends Statement, RepositoryException> iter17 = connection.getStatements(null, RDFS.SUBCLASSOF, Disposition);
                Iteration<? extends Statement, RepositoryException> iter18 = connection.getStatements(null, RDFS.RANGE, Disposition);
                Iteration<? extends Statement, RepositoryException> iter19 = connection.getStatements(null, RDFS.DOMAIN, Disposition);
                Iteration<? extends Statement, RepositoryException> iter20 = connection.getStatements(null, inheres_in, null);
                Iteration<? extends Statement, RepositoryException> iter21 = connection.getStatements(null, is_part_of, null);
                Iteration<? extends Statement, RepositoryException> iter22 = connection.getStatements(null, is_participant_of, null);
                Iteration<? extends Statement, RepositoryException> iter23 = connection.getStatements(null, has_object_part, null);
                Iteration<? extends Statement, RepositoryException> iter24 = connection.getStatements(null, has_part, null);
                Iteration<? extends Statement, RepositoryException> iter25 = connection.getStatements(null, has_trope, null);
                Iteration<? extends Statement, RepositoryException> iter26 = connection.getStatements(null, performs, null);
                Iteration<? extends Statement, RepositoryException> iter27 = connection.getStatements(null, is_manifested_by, null);
                Iteration<? extends Statement, RepositoryException> iter28 = connection.getStatements(null, is_classified_by, null);
                /**
                 * add UFO triples to named graphs.
                 */
                System.out.println("no prpblem");
                while (iter1.hasNext()) {

                    Statement st1 = iter1.next();
                    //logger.info ("like5"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter2.hasNext()) {

                    Statement st1 = iter2.next();
                    //logger.info ("like5"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter3.hasNext()) {

                    Statement st1 = iter3.next();
                    //logger.info ("like5"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter4.hasNext()) {

                    Statement st1 = iter4.next();
                 //   System.out.println("iter4" + st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter5.hasNext()) {

                    Statement st1 = iter5.next();
                    //logger.info ("like5"+st1);
                    System.out.println("iter5" + st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter6.hasNext()) {

                    Statement st1 = iter6.next();
                    //logger.info ("like5"+st1);
                    // System.out.println("iter6"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter7.hasNext()) {

                    Statement st1 = iter7.next();
                    //logger.info ("like5"+st1);
                    // System.out.println("iter7"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter8.hasNext()) {

                    Statement st1 = iter8.next();
                    //logger.info ("like5"+st1);
                    // System.out.println("iter8"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter9.hasNext()) {

                    Statement st1 = iter9.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter9"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter10.hasNext()) {

                    Statement st1 = iter10.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter10" + st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter11.hasNext()) {

                    Statement st1 = iter11.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter11"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter12.hasNext()) {

                    Statement st1 = iter12.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter10"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter13.hasNext()) {

                    Statement st1 = iter13.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter10"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter14.hasNext()) {

                    Statement st1 = iter14.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter14"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter15.hasNext()) {

                    Statement st1 = iter15.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter15"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter16.hasNext()) {

                    Statement st1 = iter16.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter16"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter18.hasNext()) {

                    Statement st1 = iter18.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter17"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter12.hasNext()) {

                    Statement st1 = iter18.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter18"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter19.hasNext()) {

                    Statement st1 = iter19.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter10"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter20.hasNext()) {

                    Statement st1 = iter20.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter20"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter21.hasNext()) {

                    Statement st1 = iter21.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter20"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter22.hasNext()) {

                    Statement st1 = iter22.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter22"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter23.hasNext()) {

                    Statement st1 = iter23.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter23"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter24.hasNext()) {

                    Statement st1 = iter24.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter24"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter25.hasNext()) {

                    Statement st1 = iter25.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter25"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter26.hasNext()) {

                    Statement st1 = iter26.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter26"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter27.hasNext()) {

                    Statement st1 = iter27.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter27"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                while (iter28.hasNext()) {

                    Statement st1 = iter28.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter28"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                System.out.println("no problem 1 ");
                //relates to in both
                IRI relates_to = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/relates_to");
                Iteration<? extends Statement, RepositoryException> iterrelates = connection.getStatements(null, is_classified_by, null);
                while (iterrelates.hasNext()) {

                    Statement st1 = iterrelates.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iterrelates"+st1);
                    connection.add(st1, context);
                    //  connection.add(st1, context);
                }
                //Endurant in aviation safety
                /////
                //
                IRI has_function = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/has_function");
                IRI is_located_in = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/is_located_in");
                IRI is_used_by = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/is_used_by");
                IRI is_used_for = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/is_used_for");
                IRI has_related_eccairs_term = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/has_related_eccairs_term");
                IRI is_produced_by = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/is_produced_by");
                IRI Aerodrome = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/Aerodrome");
                IRI Technical_system = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/Technical_system");
                IRI Data = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/Data");
                IRI Aircraft = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/Aircraft");
                IRI Ground_object = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/Ground_object");
                IRI Service = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/Service");
                System.out.println("like2");
                // IRI context1 = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/object");
//relates to in both
                //  IRI relates_to = f.createIRI ("http://onto.fel.cvut.cz/ontologies/aviation-safety/relates_to");

//Prerdurant
                /**
                 *  UFO Prerdurant Concepts.
                 */
                IRI perdurant = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/perdurant");
                IRI Event = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/Event");

                IRI object_snapshot = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/object_snapshot");
                IRI Situation = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/Situation");
                IRI has_participant = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/has_participant");
                IRI is_snapshot_of = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/is_snapshot_of");
                IRI is_performed_by = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/is_performed_by");
                IRI is_event_part_of = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/has_part");
                IRI activates = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/activates");
                IRI Fact = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/Fact");
                //IRI is_snapshot_of = f.createIRI ("http://onto.fel.cvut.cz/ontologies/ufo/is_snapshot_of");
                IRI Action = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/Action");
                IRI has_event_part = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/has_event_part");
                //IRI Action = f.createIRI("http://onto.fel.cvut.cz/ontologies/ufo/Event");

                /**
                 *  iterate UFO Prerdurant Concepts.
                 */
                Iteration<? extends Statement, RepositoryException> iter50 = connection.getStatements(null, RDFS.SUBCLASSOF, perdurant);
                Iteration<? extends Statement, RepositoryException> iter51 = connection.getStatements(null, RDFS.RANGE, perdurant);
                Iteration<? extends Statement, RepositoryException> iter52 = connection.getStatements(null, RDFS.DOMAIN, perdurant);
                Iteration<? extends Statement, RepositoryException> iter53 = connection.getStatements(null, RDFS.SUBCLASSOF, Event);
                Iteration<? extends Statement, RepositoryException> iter54 = connection.getStatements(null, RDFS.RANGE, Event);
                Iteration<? extends Statement, RepositoryException> iter55 = connection.getStatements(null, RDFS.DOMAIN, Event);
                Iteration<? extends Statement, RepositoryException> iter56 = connection.getStatements(null, RDFS.SUBCLASSOF, object_snapshot);
                Iteration<? extends Statement, RepositoryException> iter57 = connection.getStatements(null, RDFS.RANGE, object_snapshot);
                Iteration<? extends Statement, RepositoryException> iter58 = connection.getStatements(null, RDFS.DOMAIN, object_snapshot);
                Iteration<? extends Statement, RepositoryException> iter59 = connection.getStatements(null, RDFS.SUBCLASSOF, Action);
                Iteration<? extends Statement, RepositoryException> iter60 = connection.getStatements(null, RDFS.RANGE, Action);
                Iteration<? extends Statement, RepositoryException> iter61 = connection.getStatements(null, RDFS.DOMAIN, Action);
                Iteration<? extends Statement, RepositoryException> iter62 = connection.getStatements(null, RDFS.SUBCLASSOF, Situation);
                Iteration<? extends Statement, RepositoryException> iter63 = connection.getStatements(null, RDFS.RANGE, Situation);
                Iteration<? extends Statement, RepositoryException> iter64 = connection.getStatements(null, RDFS.DOMAIN, Situation);

                Iteration<? extends Statement, RepositoryException> iter65 = connection.getStatements(null, RDFS.SUBCLASSOF, Fact);
                Iteration<? extends Statement, RepositoryException> iter66 = connection.getStatements(null, RDFS.RANGE, Fact);
                Iteration<? extends Statement, RepositoryException> iter67 = connection.getStatements(null, RDFS.DOMAIN, Fact);
                Iteration<? extends Statement, RepositoryException> iter68 = connection.getStatements(null, has_participant, null);
                Iteration<? extends Statement, RepositoryException> iter69 = connection.getStatements(null, is_snapshot_of, null);
                Iteration<? extends Statement, RepositoryException> iter70 = connection.getStatements(null, is_performed_by, null);
                Iteration<? extends Statement, RepositoryException> iter71 = connection.getStatements(null, is_event_part_of, null);

                Iteration<? extends Statement, RepositoryException> iter72 = connection.getStatements(null, activates, null);

                Iteration<? extends Statement, RepositoryException> iter73 = connection.getStatements(null,  has_event_part, null);

// aviation safety Properties
                IRI Occurence = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/Occurence");
                IRI communication = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/communication");
                IRI Maintenance = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/Maintenance");
                IRI is_provided_to = f.createIRI("http://onto.fel.cvut.cz/ontologies/aviation-safety/is_provided_to");
                /**
                 *  add UFO Prerdurant to named graphs.
                 */
                while (iter50.hasNext()) {

                    Statement st1 = iter50.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter50"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter51.hasNext()) {

                    Statement st1 = iter51.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter51"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter52.hasNext()) {

                    Statement st1 = iter52.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter52"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter53.hasNext()) {

                    Statement st1 = iter53.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter53"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter54.hasNext()) {

                    Statement st1 = iter54.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter54"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter55.hasNext()) {

                    Statement st1 = iter55.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter50"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter56.hasNext()) {

                    Statement st1 = iter56.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter56"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter57.hasNext()) {

                    Statement st1 = iter57.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter57"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter58.hasNext()) {

                    Statement st1 = iter58.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter58"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter59.hasNext()) {

                    Statement st1 = iter59.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter59"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter60.hasNext()) {

                    Statement st1 = iter60.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter60"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter61.hasNext()) {

                    Statement st1 = iter61.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter61"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter62.hasNext()) {

                    Statement st1 = iter62.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter62"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter63.hasNext()) {

                    Statement st1 = iter63.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter63"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter64.hasNext()) {

                    Statement st1 = iter64.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter60"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter65.hasNext()) {

                    Statement st1 = iter65.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter65"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter66.hasNext()) {

                    Statement st1 = iter66.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter66"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter67.hasNext()) {

                    Statement st1 = iter67.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter67"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }


                while (iter68.hasNext()) {

                    Statement st1 = iter68.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter68"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter69.hasNext()) {

                    Statement st1 = iter69.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter69"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter70.hasNext()) {

                    Statement st1 = iter70.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter70"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter71.hasNext()) {

                    Statement st1 = iter71.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter71"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                while (iter72.hasNext()) {

                    Statement st1 = iter72.next();
                    //logger.info ("like5"+st1);
                    //System.out.println("iter70"+st1);
                    connection.add(st1, perdurant);
                    //  connection.add(st1, context);
                }
                //URL url = new URL (context123);



                System.out.println("Running query jana2");

//

            }
            catch (Exception e) {
                System.out.println("some error:"+e);
                //logger.error ("some error", e);
                // return;
            } finally {
                //connection.close ();
                myRepository.shutDown ();
            }

//
        }
        catch  (RepositoryException e) {
            System.out.println("RepositoryException:"+e);
            //logger.error(e);
            // return;
        }
    }
}

