package com.umanizales.lists_prog2.model.listade;

import com.umanizales.lists_prog2.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountByGenderDTO {
    private Gender gender;
    private int count;
}
