package sakilaApp.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sakilaApp.model.dao.Actor;
import sakilaApp.model.dao.Pais;
import sakilaApp.model.dao.Pelicula;
import sakilaApp.repository.JdbcRepository;

@Service
public class CinemaService {
	
	private static final Logger log = LogManager.getLogger(CinemaService.class);
	
	@Autowired
	private JdbcRepository jdbcRepo;
	
    public List<Actor> llistaActors() {
    	log.info("Petició recuperació Actors rebuda" );
    	List<Actor> actors = new ArrayList<Actor>();
    	
    		actors = jdbcRepo.llistaActors();
    	
    	log.info("Actors recuperats: "+actors);
    	return actors;
    	
        
    }
    
    public List<Pais> llistaPaisos() {
    	log.info("Petició recuperació Pais rebuda.");
    	List<Pais> paisos = new ArrayList<Pais>();
    	paisos = jdbcRepo.llistaPaisos();
    	log.info("Països recuperats: "+paisos);
    	return paisos;
    	
        
    }
    public List<Pelicula> llistaPelis() {
    	log.info("Petició recuperació Pelicules rebuda.");
    	List<Pelicula> pelis = new ArrayList<Pelicula>();
    	pelis = jdbcRepo.llistaPelis();
    	log.info("Pelicules recuperats: "+pelis);
    	return pelis;
    	
        
    }
}