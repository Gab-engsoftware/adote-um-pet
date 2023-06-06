package com.gabriel.services;

import com.gabriel.models.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*Nessa classe é possivel criar implementações de decoradores para
 adicionar novas funcionalidades ao PetService Nesse caso criei um Decorador de Logging*/
public class LoggingPetServiceDecorator extends AbstractPetServiceDecorator{
    private final Logger logger = LoggerFactory.getLogger(LoggingPetServiceDecorator.class);
    public Pet save(Pet petModel) {
        logger.info("Saving pet: {}", petModel.getName());
        return super.save(petModel);
    }
}
