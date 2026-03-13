package sakilaApp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sakilaApp.services.CinemaService;

@Controller
public class CinemaController {

	private static final Logger log = LogManager.getLogger(CinemaController.class);
	
	@Autowired
	private CinemaService cinemaService;	

	@GetMapping("/")
	public String index() {
		log.info("Petició d'inici i càrrega d'index");
		return "index";
	}

	@GetMapping("/actors")
	public String jndi(Model model) {
		try {
			model.addAttribute("actors", cinemaService.llistaActors());
			log.info("Commit jenkins");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e.getClass().getSimpleName() + ": " + e.getMessage());
		}
		return "llistat";
	}
	
	@GetMapping("/paisos")
	public String paisos(Model model) {
		try {
			model.addAttribute("paisos", cinemaService.llistaPaisos());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e.getClass().getSimpleName() + ": " + e.getMessage());
		}
		return "llistatPaisos";
	}
	
	@GetMapping("/pelis")
	public String pelis(Model model) {
		try {
			model.addAttribute("pelis", cinemaService.llistaPelis());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e.getClass().getSimpleName() + ": " + e.getMessage());
		}
		return "llistatPelis";
	}
}
