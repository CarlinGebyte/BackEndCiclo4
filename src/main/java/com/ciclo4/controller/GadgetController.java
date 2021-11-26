package com.ciclo4.controller;

import com.ciclo4.model.Gadget;
import com.ciclo4.service.GadgetServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
     * @param gadgetService
     */
    public GadgetController(GadgetServiceImpl gadgetService) {
        this.gadgetService = gadgetService;
    }

    /**
     * Método para listar productos
     * @return
     */
    @GetMapping("all")
    public List<Gadget> getAll() {
        return gadgetService.getAll();
    }

    /**
     * Método para crear un producto
     * @param gadget
     * @return
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget newGadget(@RequestBody Gadget gadget) {
        return gadgetService.newGadget(gadget);
    }

    /**
     * Método para actualizar un producto
     * @param gadget
     * @return
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget editGadget(@RequestBody Gadget gadget) {
        return gadgetService.editGadget(gadget);
    }

    /**
     * Método para eliminar un producto
     * @param idGadget
     */
    @DeleteMapping("{id}")
    public void deleteGadget(@PathVariable("id") Integer idGadget) {
        gadgetService.deleteGadget(idGadget);
    }
}
