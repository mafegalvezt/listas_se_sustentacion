package com.umanizales.lists_prog2.controller;


import com.umanizales.lists_prog2.controller.dto.ResponseDTO;
import com.umanizales.lists_prog2.exception.ListaSeException;
import com.umanizales.lists_prog2.model.Boy;
import com.umanizales.lists_prog2.service.ListSeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//para poder decir como lo voy a llamar por la URL
@RequestMapping(path= "boys")
public class BoysController {
    //para que lo inyecte
    @Autowired
    //creo la capacidad de utilizar el servicio
    private ListSeService listSeService;

    @PostMapping(path= "add")
    //metodo publico que recibe como parametro un niño con todos los datos, osea que capturo
    public ResponseEntity<ResponseDTO> addBoy(@RequestBody @Valid Boy boy) throws ListaSeException
    {
        //me retorna lo que diga el servicio adicionando un niño
        return listSeService.addBoy(boy);
    }
    @GetMapping(path= "list")
    //metodo para listar u obtener niños
    public ResponseEntity<ResponseDTO> listBoys() throws ListaSeException
     //me retorna lo que dice el servicio
    {return listSeService.listBoys();}

    //cuando llamen boys/invert se va a invertir la lista
    @GetMapping(path = "invert")
    public ResponseEntity<ResponseDTO> invertList() throws ListaSeException
    {
        return listSeService.invertList();
    }
    @PostMapping(path="addtostart")
    public ResponseEntity<ResponseDTO> addBoyToStart(@RequestBody Boy boy) throws ListaSeException
    {
        return listSeService.addBoy(boy);
    }

    @PostMapping(path="addtoposition/{position}")
    public ResponseEntity<ResponseDTO> addBoyByPosition(@PathVariable int position, @RequestBody Boy boy) throws ListaSeException
    {
        return listSeService.addBoyByPosition(boy,position);
    }


    @PostMapping(path = "addboys")
    public ResponseEntity<ResponseDTO> addBoys(@RequestBody List<Boy> boys) throws ListaSeException
    {
        for(Boy boy:boys)
        {
            listSeService.addBoy(boy);
        }
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Satisfactorio,",
                listSeService.listBoys(),null), HttpStatus.OK);
    }
    @GetMapping(path="getcount")
    public ResponseEntity<ResponseDTO> getCount()
    {
        return listSeService.getCount();
    }
    @GetMapping(path="count")
    public ResponseEntity<ResponseDTO> count()
    {
        return listSeService.Count();
    }
    @GetMapping(path = "free")
    public ResponseEntity<ResponseDTO> listBoysFree() throws ListaSeException{
            return listSeService.listBoysFree();
    }
    
    @GetMapping(path="changextremes")
    public ResponseEntity<ResponseDTO> changeXtremes() throws ListaSeException{
        return listSeService.changeXtremes();
    }

    @GetMapping(path = "delete/{identification}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable String identification) throws ListaSeException
    {
        return listSeService.delete(identification);
    }

    @GetMapping(path = "variant")
    public ResponseEntity<ResponseDTO> variantList() throws ListaSeException
    {
        return listSeService.variantList();
    }

   /** @GetMapping(path = "boysbylocation")
    public ResponseEntity<ResponseDTO> boysByLocation() throws ListaSeException {
        return listSeService.getBoysByLocation();
    }**/

//metodo que me permite listar los niños de chinchina y me retorna lo que esta ubicado en el servicio
   @GetMapping(path = "listBoyChinchina")
   public ResponseEntity<ResponseDTO> listBoyChinchina(){return listaDeService.listBoyChinchina();}

    //metodo que me permite listar los niños de manizales y me retorna lo que esta ubicado en el servicio
    @GetMapping(path = "listBoyManizales")
    public ResponseEntity<ResponseDTO> listBoyManizales(){return listaDeService.listBoyManizales();}

    //metodo que me permite listar los niños de villamaria y me retorna lo que esta ubicado en el servicio
    @GetMapping(path = "listBoyVillamaria")
    public ResponseEntity<ResponseDTO> listBoyVillamaria(){return listaDeService.listBoyVillamaria();}

    //metodo que me permite listar los niños de neira y me retorna lo que esta ubicado en el servicio
    @GetMapping(path = "listBoyNeira")
    public ResponseEntity<ResponseDTO> listBoyNeira(){return listaDeService.listBoyNeira();}

    //metodo que me permite listar los niños de chinchina,manizales,neira y villamaria por medio concatenacion
    // y me retorna lo que esta ubicado en el servicio de cada uno.
    @GetMapping(path = "listAll")
    public ResponseEntity<ResponseDTO> listBoyAll(){return listaDeService.listBoyChinchina(),
        listaDeService.listBoyManizales(),
                listaDeService.listBoyNeira(),
                listaDeService.listBoyVillamaria();}


}

