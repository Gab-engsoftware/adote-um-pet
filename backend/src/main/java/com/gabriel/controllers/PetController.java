package com.gabriel.controllers;

import com.gabriel.dtos.PetDto;
import com.gabriel.models.Pet;
import com.gabriel.models.PetBuilder;
import com.gabriel.models.PetBuilderImpl;
import com.gabriel.models.PetShop;
import com.gabriel.repositories.PetRepository;
import com.gabriel.services.LoggingPetServiceDecorator;
import com.gabriel.services.PetService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pet")
@AllArgsConstructor
public class PetController {

    final LoggingPetServiceDecorator petService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PetDto petDto){
        if(petService.existsByNameAndPetOwnerName(petDto.getName(), petDto.getPetOwnerName())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Pet already registered for this name/petOwnerName");
        }
        
        //Realizando a criação do pet via builder
        PetBuilder petBuilder = new PetBuilderImpl();
        BeanUtils.copyProperties(petDto, petBuilder);
        PetShop petshop = new PetShop(petBuilder);  
        Pet petModel = petshop.definirPet();
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.save(petModel));
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets(){
        return ResponseEntity.status(HttpStatus.OK).body(petService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePet(@PathVariable(value = "id") UUID id){
        Optional<Pet> petOptional = petService.findById(id);
        if (!petOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(petOptional.get());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePet(@PathVariable(value = "id") UUID id){
        Optional<Pet> petOptional = petService.findById(id);
        if (!petOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found.");
        }
        petService.delete(petOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pet deleted Sucessfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePet(@PathVariable(value = "id") UUID id,
                                            @RequestBody @Valid PetDto petDto){
        Optional<Pet> petOptional = petService.findById(id);
        if(!petOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found.");
        }
        
        //Realizando a criação do pet via builder
        PetBuilder petBuilder = new PetBuilderImpl();    
        BeanUtils.copyProperties(petDto, petBuilder);
        PetShop petshop = new PetShop(petBuilder);  
        Pet pet = petshop.definirPet();
        pet.setId(petOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(petService.save(pet));
    }

}
