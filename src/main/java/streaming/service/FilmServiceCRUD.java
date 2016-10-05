/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import streaming.entity.Film;
import streaming.entity.Lien;

/**
 *
 * @author admin
 */
public interface FilmServiceCRUD extends CrudRepository<Film, Long> {
    //long est le type de la clé primaire
    
    //01
   public Film findOneByTitre (String t);
   
   public List<Film> findAllByTitre(String t);
   
   //02
   public List<Film> findAllByAnnee(int annee);
   //03
   public List<Film> findAllByTitreOrAnnee (String t,Integer n);
   
   //04
   public List<Film> findAllByTitreAndAnnee (String t,Integer n);
   
   //05
   //dans Long on peut passer un objet nul
   public List<Film> findAllByGenreId (Long genreId);
   
   //06
   //dans long je peut mettre 0 mais ne peut pas etre nul.
   public List<Film> findAllByPaysId (long id);
   
   //07
   public List<Film> findAllByGenreIdAndPaysId (Long id1,Long id2);
   
   //08 relation acteurs dans l'entity film
   public List<Film> findAllByActeursNomAndActeursPrenom (String nom,String prenom);
   
   //09
   public  Long countByActeursNomAndActeursPrenom (String nom,String prenom);
   
   //10
   public List<Film> findAllByRealisateursNomAndRealisateursPrenomOrderByTitre (String nom,String prenom);
   
   //10 autre solution
   public List<Film> findAllByRealisateursIdOrderByTitre (long id);
   //11
   public Long countByRealisateursNomAndRealisateursPrenom(String nom,String prenom);
    
   //12
   public List<Film> findAllByPaysNomAndGenreNomAndRealisateursNomAndRealisateursPrenomAndActeursNomAndActeursPrenom (String pays,String genre,String nomReal,String preReal,String nomAct,String preAct); 
   
   //13 ceci ne marche pas dans FilmCRUD mais dans LienCRUD
  // public List<Lien> findAllByFilmTitre (String titre);
}
