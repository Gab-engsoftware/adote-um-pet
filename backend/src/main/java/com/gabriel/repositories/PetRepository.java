package com.gabriel.repositories;

import com.gabriel.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PetRepository extends JpaRepository<Pet, UUID> {
    boolean existsByNameAndPetOwnerName(String name, String petOwnerName);
}
