package ca.sheridancollege.nguye399.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import ca.sheridancollege.nguye399.database.DogList;
import ca.sheridancollege.nguye399.dogs.Dog;

@Controller
public class DogShowController {

	@Autowired
	private DogList dogRepo;
	
	@Autowired
	private DogList showRepo;
	
	@GetMapping("/")
	public String homePage() {
		return "doghome.html";
	}

	@GetMapping("/dogAdd")
	public String addPage(Model model, Model modelTwo) {
		model.addAttribute("dog", new Dog());
		modelTwo.addAttribute("breeds", dogRepo.getBreeds());
		return "dogadd.html";
	}
	
	@GetMapping("/dogValidate")
	public String validateDog(Model model, @ModelAttribute Dog dog) {
		dogRepo.addDog(dog);
		model.addAttribute("dog", new Dog());
		return "redirect:/dogAdd";
	}

	@GetMapping("/dogBreeds")
	public String breedPage(Model model, @ModelAttribute Dog dog) {
		model.addAttribute("dog", new Dog());
		dogRepo.updateShowList(dog);
		return "dogbreeds.html";
	}
	
	@GetMapping("/dogBreedValidate")
	public String validateBreed(Model model, @ModelAttribute Dog dog) {
		dogRepo.addBreed(dog);
		model.addAttribute("dog", new Dog());
		return "redirect:/dogBreeds";
	}

	@GetMapping("/dogView")
	public String viewPage(Model model) {
		model.addAttribute("dogs", dogRepo.getDogs());
		return "dogview.html";
	}

	@GetMapping("/dogEdit/{id}")
	public String editPage(Model model, Model modelTwo, @PathVariable int id) {
		Dog dog = dogRepo.getDogById(id);
		model.addAttribute("dog", dog);
		modelTwo.addAttribute("breeds", dogRepo.getBreeds());
		return "dogedit.html";
	}
	
	@GetMapping("/dogModify")
	public String modifyDog(Model model, @ModelAttribute Dog dog) {
		dogRepo.updateDog(dog);
		dogRepo.updateShowList(dog);
		return "redirect:/dogView";
	}
	
	@GetMapping("/dogDelete/{id}")
	public String deleteDog(@PathVariable int id, @ModelAttribute Dog dog) {
		dogRepo.deleteDog(id);
		dogRepo.updateShowList(dog);
		return "redirect:/dogView";
	}
	
	@GetMapping("/dogShowList")
	public String showListPage(Model model) {
		model.addAttribute("showList", showRepo.getShowList());
		return "dogshowlist.html";
	}
}
