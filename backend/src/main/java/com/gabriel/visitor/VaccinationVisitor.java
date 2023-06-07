package com.gabriel.visitor;

import com.gabriel.models.Pet;
import org.springframework.stereotype.Component;

//É responsável por visitar um objeto Pet e realizar a vacinação
@Component
public class VaccinationVisitor implements PetVisitor {
	@Override
	public void visit(Pet pet) {
		pet.getName();
		pet.setVaccinated(true);
	}

	//É responsável por visitar um objeto Pet e obter o nome do proprietário.
	@Component
	public class PetOwnerNameVisitor implements PetVisitor {
		@Override
		public void visit(Pet pet) {
			pet.getPetOwnerName();
		}
	}
}
