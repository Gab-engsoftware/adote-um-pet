package com.gabriel.services;

import com.gabriel.models.Pet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Essa interface define os metódos necessários para as operações relacionadas a classe PetService;
public interface IPetService {
    Pet save (Pet petModel);
    boolean existsByNameAndPetOwnerName(String name, String petOwnerName);
    List<Pet> findAll();
    Optional<Pet> findById(UUID id);
    void delete(Pet pet);
}
