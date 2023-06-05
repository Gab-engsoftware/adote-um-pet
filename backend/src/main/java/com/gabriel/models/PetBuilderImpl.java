package com.gabriel.models;

import java.util.UUID;

//ConcreteBuilder: Implementa a interface Builder e constrói partes do objeto
class PetBuilderImpl implements PetBuilder {

	private Pet pet;
	
	public PetBuilderImpl() {
		this.pet = new Pet();
	}
	@Override
	public void setId(UUID id) {
		pet.setId(id);
	}

	@Override
	public void setName(String Name) {
		pet.setName(Name);
	}

	@Override
	public void setBreed(String breed) {
		pet.setBreed(breed);
	}

	@Override
	public void setDescription(String description) {
		pet.setDescription(description);
	}

	@Override
	public void setVaccinated(Boolean vaccinated) {
		pet.setVaccinated(vaccinated);
	}

	@Override
	public void setPetOwnerName(String petOwnerName) {
		pet.setPetOwnerName(petOwnerName);
	}

	@Override
	public Pet getPet() {
		return pet;
	}

}
