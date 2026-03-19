package sakilaApp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String actors(Model model) throws Exception {
			model.addAttribute("actors", cinemaService.llistaActors());
		return "llistat";
	}
	/**
	 * Pendent d'acabar
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/newActor")
	public String newActor(Model model) throws Exception {
			model.addAttribute("actors", cinemaService.llistaActors());
		return "llistat";
	}
	
	@GetMapping("/paisos")
	public String paisos(Model model) throws Exception {
			model.addAttribute("paisos", cinemaService.llistaPaisos());
		return "llistatPaisos";
	}
	
	@GetMapping("/pelis")
	public String pelis(Model model) throws Exception {

			model.addAttribute("pelis", cinemaService.llistaPelis());

		return "llistatPelis";
	}
	
}
