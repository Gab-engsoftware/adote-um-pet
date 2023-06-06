package com.gabriel.services;

//Essa interface tem o metodo que configura o serviço decorador;
public interface IPetServiceDecorator {
    void setDecoratedService(PetService decoratedService);
}
