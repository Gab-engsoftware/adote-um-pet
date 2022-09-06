package com.gabriel.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PetDto {

    @NotBlank
    @Size(max=50)
    private String name;

    @NotBlank
    private String breed;

    @NotBlank
    @Size(max=100)
    private String description;

    private Boolean vaccinated;

    @NotBlank
    @Size(max=50)
    private String petOwnerName;
}
