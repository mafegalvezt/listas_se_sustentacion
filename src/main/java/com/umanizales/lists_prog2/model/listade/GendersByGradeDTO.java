package com.umanizales.lists_prog2.model.listade;

import com.umanizales.lists_prog2.model.listade.CountByGenderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GendersByGradeDTO {
    private byte grade;
    private String gender;
    private GradeByRH [] gradeByRHS;
}
