/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
    
    @Before
    public void effacer(){
        
        service.deleteAll();
    }
    
    
            
    @Test
    public void ajouter(){
        
        Personne pers  = new Personne();
        pers.setNom("nombidon");
        pers.setPrenom("prenombidon");
        service.save(pers);
        
    }
    
    @Test
    public void verifservice(){
        
        service.findOneByPrenomAndNom("prbidon", "noidon");
    }
    
    
    
    //@Test
    public void lister(){
        
        service.findAll();
        
    }
    
    
}
