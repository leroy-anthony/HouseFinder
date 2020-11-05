package housefinder.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import housefinder.model.Parcelle;
import housefinder.service.CadastreService;

@Controller
public class CadastreController {

	@Autowired
	private CadastreService cadastreService;
	
	@GetMapping(value = "/{codeinsee}/list/size/{value}")
	@ResponseBody
	public List<Parcelle> listBySize(@PathVariable("value") int value, @PathVariable("codeinsee") int codeinsee) {
		return cadastreService.listBySize(value, codeinsee);
	}
	
	@GetMapping(value = "/")
	public String listBySize() {
		return "list";
	}
	
	@GetMapping(value = "/search")
	public String listBySize(@RequestParam(required = false) Integer size, @RequestParam(required = false) Integer codeinsee, Model model) {
		List<Parcelle> parcelles;
		
		if (size != null && codeinsee != null) {
			parcelles = cadastreService.listBySize(size, codeinsee);
		} else {
			parcelles = new ArrayList<>();
		}

		model.addAttribute("size", size);
		model.addAttribute("codeinsee", codeinsee);
		model.addAttribute("parcelles", parcelles);
		
		return "list";
	}

}
