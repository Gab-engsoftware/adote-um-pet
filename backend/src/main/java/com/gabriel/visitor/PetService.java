package com.gabriel.visitor;

import com.gabriel.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetService {
	private  PetVisitor vaccinationVisitor;
	private  PetVisitor petOwnerNameVisitor;
	// Classe responsável por alinhas as ações a serem realizadas em um Pet.
	@Autowired
	public PetService(PetVisitor vaccinationVisitor, PetVisitor petOwnerNameVisitor) {
		this.vaccinationVisitor = vaccinationVisitor;
		this.petOwnerNameVisitor = petOwnerNameVisitor;
	}
	//Método que realiza as ações no objeto Pet chamando o método accept do visitante.
	public void performActions(Pet pet) {
		pet.accept(vaccinationVisitor);
		pet.accept(petOwnerNameVisitor);
	}
}
