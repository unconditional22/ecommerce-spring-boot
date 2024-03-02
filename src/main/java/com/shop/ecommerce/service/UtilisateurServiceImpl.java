package com.shop.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shop.ecommerce.dto.UtilisateurDto;
import com.shop.ecommerce.modele.Utilisateur;
import com.shop.ecommerce.repository.UtilisateurRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService{

	private final UtilisateurRepository utilisateurRepository;
    private PasswordEncoder passwordEncoder;

	@Override
	public Utilisateur creer(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public List<Utilisateur> lire() {
		return utilisateurRepository.findAll(); 
	}

	@Override
	public Utilisateur modifier(Long idUser, Utilisateur utilisateur) {
		return utilisateurRepository.findById(idUser)
        .map(u -> {
            u.setUsername(utilisateur.getUsername());
            u.setPassword(utilisateur.getPassword());
            u.setEmail(utilisateur.getEmail());
            return utilisateurRepository.save(u);
        }).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé!"));
	}

	@Override
	public String supprimer(Long idUser) {
		utilisateurRepository.deleteById(idUser);
		return "Utilisateur supprimer avec success!";
	}
	
	@Override
    public void saveUser(UtilisateurDto utilisateurdto) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setUsername(utilisateur.getUsername());
		utilisateur.setEmail(utilisateur.getEmail());
        // encrypt the password using spring security
		utilisateur.setPassword(passwordEncoder.encode(utilisateurdto.getPassword())); // Encode the password
        utilisateurRepository.save(utilisateur); // Save the user to the repository
	}

    @Override
    public Utilisateur findUserByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    @Override
    public List<UtilisateurDto> findAllUsers() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream()
                .map((utilisateur) -> mapToUtilisateurDto(utilisateur))
                .collect(Collectors.toList());
    }
    
    private UtilisateurDto mapToUtilisateurDto(Utilisateur utilisateur){
    	UtilisateurDto utilisateurdto = new UtilisateurDto();
        utilisateurdto.setUsername(utilisateur.getUsername());
        utilisateurdto.setEmail(utilisateur.getEmail());
        return utilisateurdto;
    }

}
