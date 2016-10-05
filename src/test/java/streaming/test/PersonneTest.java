/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.InputSource;
import streaming.service.PersonneServiceCRUD;
import streaming.entity.Personne;
import streaming.spring.SpringConfig;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringConfig.class)
public class PersonneTest {
    
    @Autowired
    private PersonneServiceCRUD service;
    
    //@Before
    public void effacer() throws ClassNotFoundException, SQLException, DatabaseUnitException, FileNotFoundException{
        
        // Connexion DB
        Class driverClass = Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection jdbcConnection = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/sample", "app", "app");//user et pwd de la BD
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
        
        // Import
        FlatXmlDataSet dataSet = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(new FileInputStream("donnees.xml"))));
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
        
        service.deleteAll();
    }
    
    
            
//    @Test
    public void ajouter(){
        
        Personne pers  = new Personne();
        pers.setNom("nombidon");
        pers.setPrenom("prenombidon");
        service.save(pers);
        
    }
    
//    @Test
    public void verifservice(){
        
        service.findOneByPrenomAndNom("prbidon", "noidon");
    }
    
    
    
    @Test
    public void lister(){
        
//        service.findAll();
        
    }
    
    
}
