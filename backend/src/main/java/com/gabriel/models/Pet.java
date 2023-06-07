package com.gabriel.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.gabriel.visitor.PetVisitor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "Pets")
@AllArgsConstructor
@NoArgsConstructor
public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;
//Classe Product
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = true)
    private Boolean vaccinated;

    @Column(nullable = false, length = 50)
    private String petOwnerName;
    
    //permite que um objeto Pet seja visitado por um visitante, que executará operações no objeto visitado
    public void accept(PetVisitor visitor) {
        visitor.visit(this);
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getPetOwnerName() {
        return petOwnerName;
    }

    public void setPetOwnerName(String petOwnerName) {
        this.petOwnerName = petOwnerName;
    }
}
