package com.umanizales.lists_prog2.model.listade;

import com.umanizales.lists_prog2.model.Location;
import com.umanizales.lists_prog2.model.listade.GendersByGradeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GradeByLocationDTO {
    private Location location;
    private List<GendersByGradeDTO> gendersByGradeDTOS;
}
