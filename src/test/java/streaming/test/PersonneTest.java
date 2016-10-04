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
import streaming.dao.PersonneDAO;
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
    private PersonneDAO dao;
            
    
    

    
    @Test
    public void ajouter(){
        
        Personne pers  = new Personne();
        pers.setNom("thomas");
        dao.ajouter(pers);
        
    }
    
    @Test
    public void lister(){
        
        dao.lister();
        
    }
    
    
}
