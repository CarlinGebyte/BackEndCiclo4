package com.ciclo4.controller;

import com.ciclo4.model.Order;
import com.ciclo4.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/order/")
public class OrderController {
    /**
     * Atributo servicio
     */
    private OrderService service;

    /**
     * Método para obtener todas las ordenes
     *
     * @return
     */
    @GetMapping("all")
    public List<Order> getAll() {
        return service.getAll();
    }

    /**
     * Método para obtener una orden por id
     *
     * @param idOrder
     * @return
     */
    @GetMapping("{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer idOrder) {
        return service.getOrder(idOrder);
    }

    /**
     * Método para obtener las ordenes por zona del coordinador
     *
     * @param zone
     * @return
     */
    @GetMapping("zona/{zone}")
    public List<Order> getByZone(@PathVariable("zone") String zone) {
        return service.getByZone(zone);
    }

    /**
     * Método para obtener las ordenes por Identificación el asesor
     *
     * @param identification
     * @return
     */
    @GetMapping("identificacion/{identification}")
    public List<Order> getByIdentification(@PathVariable("identification") String identification) {
        return service.getByIdentification(identification);
    }

    /**
     * Método para crear una orden
     *
     * @param order
     * @param bindingResult
     * @return
     */
    @PostMapping("new")
    public ResponseEntity<?> newOrder(@RequestBody @Valid Order order, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.newOrder(order));
    }

    /**
     * Método para actualizar una orden
     *
     * @param order
     * @param bindingResult
     * @return
     */
    @PutMapping("update")
    public ResponseEntity<?> editOrder(@RequestBody Order order, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.editOrder(order));
    }

//    @PutMapping("add/{id}")
//    public Order addProduct(@PathVariable("id") Integer idOrder, @RequestBody Optional<Gadget> gadget) {
//        return service.addProduct(gadget, idOrder);
//    }

    /**
     * Método para eliminar una orden
     *
     * @param idOrder
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("id") Integer idOrder) {
        service.deleteOrder(idOrder);
    }

    /**
     * Método para obtener la lista de órdenes por ID de asesor
     *
     * @param id
     * @return
     */
    @GetMapping("/salesman/{id}")
    public List<Order> getBySalesManId(@PathVariable("id") Integer id) {
        return service.getBySalesManId(id);
    }

    /**
     * Método para obtener las órdenes con un estado específico de un asesor por ID
     *
     * @param id
     * @param status
     * @return
     */
    @GetMapping("/state/{status}/{id}")
    public List<Order> getByIdSalesManIdAndStatus(@PathVariable("id") Integer id, @PathVariable("status") String status) {
        return service.getBySalesManIdAndStatus(id, status);
    }

    /**
     * Método para Obtener las órdenes por fecha de un Asesor por ID
     *
     * @param registerDay
     * @param id
     * @return
     */
    @GetMapping("/date/{registerDay}/{id}")
    public List<Order> getByRegisterDayAndSalesManId(@PathVariable("registerDay") String registerDay, @PathVariable("id") Integer id) {
        return service.getByRegisterDayAndSalesManId(registerDay, id);
    }
}
