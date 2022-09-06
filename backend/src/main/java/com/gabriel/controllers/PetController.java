package com.gabriel.controllers;

import com.gabriel.dtos.PetDto;
import com.gabriel.models.Pet;
import com.gabriel.services.PetService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pet")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class PetController {

    final PetService petService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PetDto petDto){
        if(petService.existsByNameAndPetOwnerName(petDto.getName(), petDto.getPetOwnerName())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Pet already registered for this name/petOwnerName");
        }

        var petModel = new Pet();
        BeanUtils.copyProperties(petDto, petModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.save(petModel));
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets(){
        return ResponseEntity.status(HttpStatus.OK).body(petService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePet(@PathVariable(value = "id") UUID id){
        Optional<Pet> petOptional = petService.findById(id);
        return petOptional.<ResponseEntity<Object>>map(pet -> ResponseEntity.status(HttpStatus.OK).body(pet)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found."));
    }

}
