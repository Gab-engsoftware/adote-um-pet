package com.gabriel.models;

//Director: Comanda o processo de construção usando o builder
public class PetShop {
	private PetBuilder petBuilder;
	
	public PetShop(PetBuilder petBuilder) {
		this.petBuilder = petBuilder;
	}
	
	public Pet definirPet() {
		return petBuilder.getPet();
	}
}
