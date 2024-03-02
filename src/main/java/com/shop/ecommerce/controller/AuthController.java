package com.shop.ecommerce.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.ecommerce.dto.UtilisateurDto;
import com.shop.ecommerce.modele.Utilisateur;
import com.shop.ecommerce.service.UtilisateurService;

@Controller
public class AuthController {

	private UtilisateurService utilisateurService;

	public AuthController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	// handler method to handle home page request
	@GetMapping("/index")
	public String home() {
		return "index";
	}
	
	// handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }

	// handler method to handle user registration form request
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		// create model object to store form data
		UtilisateurDto utilisateur = new UtilisateurDto();
		model.addAttribute("utilisateur", utilisateur);
		return "register";
	}

	// handler method to handle user registration form submit request
	@PostMapping("/register/save")
	public String registration(@Validated @ModelAttribute("utilisateur") UtilisateurDto utilisateurdto,
			BindingResult result, Model model) {
		Utilisateur existingUser = utilisateurService.findUserByEmail(utilisateurdto.getEmail());

		if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
			result.rejectValue("email", null, "There is already an account registered with the same email");
		}

		if (result.hasErrors()) {
			model.addAttribute("utilisateur", utilisateurdto);
			return "/register";
		}

		utilisateurService.saveUser(utilisateurdto);
		return "redirect:/register?success";
	}

	// handler method to handle list of users
	@GetMapping("/utilisateurs")
	public String users(Model model) {
		List<UtilisateurDto> utilisateurs = utilisateurService.findAllUsers();
		model.addAttribute("utilisateurs", utilisateurs);
		return "utilisateurs";
	}

}
