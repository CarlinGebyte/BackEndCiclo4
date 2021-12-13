package com.ciclo4.controller;

import com.ciclo4.model.Gadget;
import com.ciclo4.service.GadgetServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author CarlinGebyte
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/gadget/")
public class GadgetController {
    /**
     * Atributo Service
     */
    private GadgetServiceImpl gadgetService;

    /**
     * Constructor
     *
     * @param gadgetService
     */
    public GadgetController(GadgetServiceImpl gadgetService) {
        this.gadgetService = gadgetService;
    }

    /**
     * Método para listar productos
     *
     * @return
     */
    @GetMapping("all")
    public List<Gadget> getAll() {
        return gadgetService.getAll();
    }

    /**
     * Método para encontrar un producto por Id
     *
     * @param idGadget
     * @return
     */
    @GetMapping("{id}")
    public Optional<Gadget> getGadget(@PathVariable("id") Integer idGadget) {
        return gadgetService.getGadget(idGadget);
    }

    /**
     * Método para crear un producto
     *
     * @param gadget
     * @return
     */
    @PostMapping("new")
    public ResponseEntity<?> newGadget(@RequestBody @Valid Gadget gadget, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(gadget);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(gadgetService.newGadget(gadget));
    }

    /**
     * Método para actualizar un producto
     *
     * @param gadget
     * @return
     */
    @PutMapping("update")
    public ResponseEntity<?> editGadget(@RequestBody @Valid Gadget gadget, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(gadget);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(gadgetService.editGadget(gadget));
    }

    /**
     * Método para eliminar un producto
     *
     * @param idGadget
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGadget(@PathVariable("id") Integer idGadget) {
        gadgetService.deleteGadget(idGadget);
    }

    /**
     * Listar gadgets por un String enviado, si se encuentra en su descripción
     *
     * @param description
     * @return
     */
    @GetMapping("description/{desc}")
    public List<Gadget> gadgetByDesc(@PathVariable("desc") String description) {
        return gadgetService.gadgetByDesc(description);
    }

    /**
     * Listar gadgets que tengan un precio menor o igual al ingresado
     *
     * @param price
     * @return
     */
    @GetMapping("price/{price}")
    public List<Gadget> gadgetByPrice(@PathVariable("price") Double price) {
        return gadgetService.gadgetByPrice(price);
    }
}
