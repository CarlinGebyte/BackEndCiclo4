package com.ciclo4.service;

import com.ciclo4.exception.BaseCustomException;
import com.ciclo4.model.Gadget;
import com.ciclo4.repository.GadgetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author CarlinGebyte
 */
@Service
public class GadgetServiceImpl {
    /**
     * Atributo gadget repository
     */
    private GadgetRepository gadgetRepository;

    /**
     * Método constructor
     *
     * @param gadgetRepository
     */
    public GadgetServiceImpl(GadgetRepository gadgetRepository) {
        this.gadgetRepository = gadgetRepository;
    }

    /**
     * Método para listar todos los productos
     *
     * @return
     */
    public List<Gadget> getAll() {
        return gadgetRepository.findAll();
    }

    /**
     * Método para encontrar un producto por Id
     *
     * @param idGadget
     * @return
     */
    public Optional<Gadget> getGadget(Integer idGadget) {
        return gadgetRepository.findById(idGadget);
    }

    /**
     * Método para crear un Producto
     *
     * @param gadget
     * @return
     */
    public Gadget newGadget(Gadget gadget) {
        Gadget savedGadget = gadgetRepository.save(gadget);
        return savedGadget;
    }

    /**
     * Método para actualizar Producto
     *
     * @param gadget
     * @return
     */
    public Gadget editGadget(Gadget gadget) {
        Gadget currentGadget = gadgetRepository.findById(gadget.getId()).orElseThrow(() -> new BaseCustomException("Gadget no encontrado", HttpStatus.BAD_REQUEST.value()));

        if (gadget.getBrand() != null) {
            currentGadget.setBrand(gadget.getBrand());
        }
        if (gadget.getCategory() != null) {
            currentGadget.setCategory(gadget.getCategory());
        }
        if (gadget.getName() != null) {
            currentGadget.setName(gadget.getName());
        }
        if (gadget.getDescription() != null) {
            currentGadget.setDescription(gadget.getDescription());
        }
        if (gadget.getPrice() != null) {
            currentGadget.setPrice(gadget.getPrice());
        }
        if (gadget.getAvailability() != null) {
            currentGadget.setAvailability(gadget.getAvailability());
        }
        if (gadget.getQuantity() != null) {
            currentGadget.setQuantity(gadget.getQuantity());
        }
        if (gadget.getPhotography() != null) {
            currentGadget.setPhotography(gadget.getPhotography());
        }

        return gadgetRepository.save(currentGadget);

    }

    /**
     * Método para eliminar Programa
     *
     * @param idGadget
     */
    public void deleteGadget(Integer idGadget) {
        Optional<Gadget> gadget = gadgetRepository.findById(idGadget);
        if (gadget.isPresent()) {
            gadgetRepository.deleteById(idGadget);
        }
    }

    /**
     * Listar gadgets por un String enviado, si se encuentra en su descripción
     *
     * @param description
     * @return
     */
    public List<Gadget> gadgetByDesc(String description) {
        return gadgetRepository.findGadgetByDescriptionContains(description);
    }

    /**
     * Listar gadgets que tengan un precio menor o igual al ingresado
     *
     * @param price
     * @return
     */
    public List<Gadget> gadgetByPrice(Double price) {
        return gadgetRepository.findGadgetByPriceIsLessThanEqual(price);
    }
}
