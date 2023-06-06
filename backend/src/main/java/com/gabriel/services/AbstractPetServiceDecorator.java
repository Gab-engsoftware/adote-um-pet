package com.gabriel.services;

import com.gabriel.models.Pet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Essa classe Abstrata implementa a interface PetServiceDecorator
public abstract class AbstractPetServiceDecorator implements IPetServiceDecorator{
    protected IPetService decoratedService;
    @Override
    public void setDecoratedService(PetService decoratedService) {
        this.decoratedService = decoratedService;
    }

    public Pet save(Pet petModel){
        return decoratedService.save(petModel);
    }
    public boolean existsByNameAndPetOwnerName(String name, String petOwnerName) {
        return decoratedService.existsByNameAndPetOwnerName(name, petOwnerName);
    }

    public List<Pet> findAll() {
        return decoratedService.findAll();
    }

    public Optional<Pet> findById(UUID id) {
        return decoratedService.findById(id);
    }

    public void delete(Pet pet) {
        decoratedService.delete(pet);
    }


}
