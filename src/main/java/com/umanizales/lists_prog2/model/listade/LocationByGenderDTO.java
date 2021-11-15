package com.umanizales.lists_prog2.model.listade;

import com.umanizales.lists_prog2.model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LocationByGenderDTO {
    private Location location;
    private List<GendersByGradeDTO> gendersByGradeDTOList;
}
