package com.gabriel.visitor;

import com.gabriel.models.Pet;
//define o contrato para um visitante que pode interagir com objetos do tipo Pet.
public interface PetVisitor {
	void visit(Pet pet);
}
