package com.shop.ecommerce.security;

import com.shop.ecommerce.modele.Utilisateur;
import com.shop.ecommerce.repository.UtilisateurRepository;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UtilisateurRepository utilisateurRepository;

    public CustomUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);

        if (utilisateur != null) {
            return new org.springframework.security.core.userdetails.User(
                    utilisateur.getEmail(),
                    utilisateur.getPassword(), // Return the hashed password stored in the database
                    new ArrayList<>()
            );
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }
}

