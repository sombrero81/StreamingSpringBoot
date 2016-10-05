/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import streaming.entity.Lien;

/**
 *
 * @author admin
 */
public interface LienServiceCRUD extends CrudRepository<Lien,Long>{
    
    //13
   public List<Lien> findAllByFilmTitre (String titre);
   
   //16
   public List<Lien> findAllByEpisodeNumEpisodeAndEpisodeSaisonNumSaisonAndEpisodeSaisonSerieTitre  (int numEpis,int numSaison,String titre );
    
}
