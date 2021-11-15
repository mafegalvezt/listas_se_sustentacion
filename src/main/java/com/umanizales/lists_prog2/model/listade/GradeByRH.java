package com.umanizales.lists_prog2.model.listade;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GradeByRH {
    private String RH;
    private byte grade;
    private int count;
}
