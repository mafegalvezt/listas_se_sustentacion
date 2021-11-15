package com.umanizales.lists_prog2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Clase para almacenar la información referente a un niño
 * Maneja campos obligatorios para (identificación, edad, ...
 * @autor Carlos Loaiza
 * @author Lucas López
 * @version 1.0 - 30-oct-2021
 *
 */

@Data
//se usa porque necesitamos que todos los metodos que use sean obligatorios cuando ingrese un niño
@AllArgsConstructor
public class Boy {
    @NotNull
    @NotEmpty
    @Size(min=2)
    //atributo unico para cada niño
    private String identification;
    @NotNull
    @NotEmpty
    @Size(min=2, max = 50)
    private String name;
    @Positive
    private byte age;
    @Valid
    @NotNull
    private String grade;
    @NotNull
    private Gender gender;
    @Valid
    @NotNull
    private Location location;
    @Valid
    @NotNull
    private String RH;


}
