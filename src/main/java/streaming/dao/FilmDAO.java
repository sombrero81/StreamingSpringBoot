/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import streaming.entity.Film;

/**
 *
 * @author admin
 */
public interface FilmDAO extends CrudRepository<Film, Long> {
    //long est le type de la clé primaire
    
    public List<Film> findallbyannee(long annee);
    
}
