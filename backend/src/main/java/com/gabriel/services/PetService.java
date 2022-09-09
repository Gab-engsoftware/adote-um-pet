package com.gabriel.services;

import com.gabriel.models.Pet;
import com.gabriel.repositories.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class PetService {

    final PetRepository petRepository;

    @Transactional
    public Pet save(Pet petModel){
        return petRepository.save(petModel);
    }

   public boolean existsByNameAndPetOwnerName(String name, String petOwnerName){
        return petRepository.existsByNameAndPetOwnerName(name, petOwnerName);
   }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Optional<Pet> findById(UUID id) {
        return petRepository.findById(id);
    }

    @Transactional
    public void delete(Pet pet) {
       petRepository.delete(pet);
    }

}
