package com.ciclo4.controller;

import com.ciclo4.model.Gadget;
import com.ciclo4.service.GadgetServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/gadget/")
public class GadgetController {
    private GadgetServiceImpl gadgetService;

    public GadgetController(GadgetServiceImpl gadgetService) {
        this.gadgetService = gadgetService;
    }

    @GetMapping("all")
    public List<Gadget> getAll() {
        return gadgetService.getAll();
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget newGadget(@RequestBody Gadget gadget) {
        return gadgetService.newGadget(gadget);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget editGadget(@RequestBody Gadget gadget) {
        return gadgetService.editGadget(gadget);
    }

    @DeleteMapping("{id}")
    public void deleteGadget(@PathVariable("id") Integer idGadget) {
        gadgetService.deleteGadget(idGadget);
    }
}
