package com.shop.ecommerce.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.ecommerce.dto.PaimentRequestDto;
import com.shop.ecommerce.modele.Paiement;
import com.shop.ecommerce.service.PaiementService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/paiement")
@AllArgsConstructor
public class PaiementController {
	
private final PaiementService paiementService;
	
	@PostMapping("/create")
	public Paiement create(@RequestBody Paiement paiement) {
		return paiementService.creer(paiement); 
	}
	
	@GetMapping("/read")
	public List<Paiement> read() {
		return paiementService.lire();
	}
	
	@PutMapping("/update/{idPaiement}")
	public Paiement update(@PathVariable Long idPaiement, @RequestBody Paiement paiement) {
		return paiementService.modifier(idPaiement, paiement);
	}
	
	@DeleteMapping("/delete/{idPaiement}")
	public String delete(@PathVariable Long idPaiement) {
		return paiementService.supprimer(idPaiement);
	}

	@PostMapping("/paiement")
    public String processPayment(@RequestBody PaimentRequestDto paymentRequest) {
        // You can add your payment processing logic here
        // The paymentRequest object will contain the data sent from the front-end

        return "Paiement proceder avec success!";
    }

}

