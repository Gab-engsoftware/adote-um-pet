package com.gabriel.models;

import java.util.UUID;

//Interface Builder: Faz o papel de interface e diz o que tem que ser implementado para construir o objeto.

public interface PetBuilder {
	void setId(UUID id);
	void setName(String Name);
	void setBreed(String breed);
	void setDescription(String description);
	void setVaccinated(Boolean vaccinated);
	void setPetOwnerName(String petOwnerName);
	Pet getPet();
}
