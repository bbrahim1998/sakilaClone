package sakilaApp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sakilaApp.model.dao.Actor;
import sakilaApp.model.dao.Pais;
import sakilaApp.model.dao.Pelicula;

@Repository
public class JdbcRepository {
	
	private static final Logger log = LogManager.getLogger(JdbcRepository.class);
	
	@Autowired
	private DataSource dataSource;
	
	public List<Actor> llistaActors() throws Exception {
        List<Actor> llistat = new ArrayList<>();
	
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT actor_id, first_name, last_name, last_update FROM actor");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	Actor p = new Actor(rs.getInt("actor_id"), rs.getString("first_name"),rs.getString("last_name"), rs.getTimestamp("last_update").toLocalDateTime());
                llistat.add(p);
            }
        } catch (SQLException e) {
        	log.error("Error recuperant actors: " + e.getStackTrace().toString());
        	
        	throw new Exception(e);
			// TODO Auto-generated catch block
			
		}
        return llistat;
    }
	
	public List<Pais> llistaPaisos() throws Exception {
        List<Pais> llistat = new ArrayList<>();
	
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT country_id, country, last_update FROM country");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	Pais p = new Pais(rs.getInt("country_id"), rs.getString("country"), rs.getTimestamp("last_update").toLocalDateTime());
                llistat.add(p);
            }
        } catch (SQLException e) {
        	log.error("Error recuperant paisos: " + e.getStackTrace().toString());
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
        return llistat;
    }
	public List<Pelicula> llistaPelis() throws Exception {
        List<Pelicula> llistat = new ArrayList<>();
	
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT film_id, title, description, release_year FROM film");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	Pelicula p = new Pelicula(rs.getInt("film_id"), rs.getString("title") , rs.getString("description"), rs.getInt("release_year"));
                llistat.add(p);
            }
        } catch (SQLException e) {
        	log.error("Error recuperant pelis: " + e.getStackTrace().toString());
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
        return llistat;
    }
	
	public Actor getActorByName(Actor a) throws Exception {
        
        try ( Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * from Actor where first_name = ? and last_name=?");
        	 ) {
	        ps.setString(1, a.nom().toUpperCase());
	       	ps.setString(2, a.cognoms().toUpperCase());
	        ResultSet rs = ps.executeQuery();
	        
            while (rs.next()) {
            	Actor aTrobat = new Actor(rs.getInt("actor_id"),rs.getString("first_name"),rs.getString("second_name"),rs.getTimestamp("last_update").toLocalDateTime());
            	return aTrobat;
            }
        } catch (SQLException e) {
        	log.error("Error recuperant pelis: " + e.getStackTrace().toString());
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
        return null;
    }
}
