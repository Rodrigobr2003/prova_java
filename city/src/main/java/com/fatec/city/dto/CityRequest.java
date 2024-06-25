package com.fatec.city.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CityRequest(
    @NotNull(message = "Nome da cidade não pode ser vazio")
    @NotBlank(message = "Nome da cidade não pode ser branco")
    String nome,

    @NotNull(message = "Nome do estado não pode ser vazio")
    @NotBlank(message = "Nome do estado não pode ser branco")
    String estado,

    @NotNull(message = "Populacao não pode ser vazia")
    Integer populacao,

    @NotNull(message = "PIB não pode ser vazio")
    Integer pib
){    
    
}
