package com.umanizales.lists_prog2.service;

import com.umanizales.lists_prog2.controller.dto.ResponseDTO;
import com.umanizales.lists_prog2.model.Boy;
import com.umanizales.lists_prog2.model.listade.GradeByLocationDTO;
import com.umanizales.lists_prog2.model.Location;
import com.umanizales.lists_prog2.model.listade.ListaDE;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListaDeService {
    private ListaDE listBoys;
    private List<Location> locations;

    //metodo para poder separar el espacio de esa lista
    public ListaDeService() {
        listBoys = new ListaDE();
        initializeLocations();
    }

    private void initializeLocations()
    {
        locations= new ArrayList<>();
        locations.add(new Location("16917001","Manizales"));
        locations.add(new Location("16917003","Chinchiná"));

    public ResponseEntity<ResponseDTO> getOrphansByGradeByLocation()
    {
        List<GradeByLocationDTO> gradeByLocationDTOS = new ArrayList<>();
        return new ResponseEntity<>(
                new ResponseDTO(message: "satisfactorio", gradeByLocationDTOS, errors: null),HttpStatus.OK)
        )
    }

    public ResponseEntity<ResponseDTO> listBoyVillamaria();
        {
            return new ResponseEntity<>(
                    new ResponseDTO("Satisfactorio",listaDE.listBoyVillamaria(), null),
                    HttpStatus.OK);
        }

        public ResponseEntity<ResponseDTO> listBoyManizales();
        {
            return new ResponseEntity<>(
                    new ResponseDTO("Satisfactorio",listaDE.listBoyManizales(), null),
                    HttpStatus.OK);
        }

        public ResponseEntity<ResponseDTO> listBoyChinchina();
        {
            return new ResponseEntity<>(
                    new ResponseDTO("Satisfactorio",listaDE.listBoyChinchina(), null),
                    HttpStatus.OK);
        }

        public ResponseEntity<ResponseDTO> listBoyNeira();
        {
            return new ResponseEntity<>(
                    new ResponseDTO("Satisfactorio",listaDE.listBoyNeira(), null),
                    HttpStatus.OK);
        }

        public ResponseEntity<ResponseDTO> adicionarNodeDE(Boy) {
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",true, null),
                HttpStatus.OK);
    }
}
