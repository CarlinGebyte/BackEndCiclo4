package com.ciclo4.controller;

import com.ciclo4.model.Gadget;
import com.ciclo4.service.GadgetServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public void deleteGadget(@PathVariable("id") Integer idGadget) {
        gadgetService.deleteGadget(idGadget);
    }
}
