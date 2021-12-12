package com.ciclo4.service;

import com.ciclo4.exception.BaseCustomException;
import com.ciclo4.model.Gadget;
import com.ciclo4.model.Order;
import com.ciclo4.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    /**
     * Atributo repositorio
     */
    private OrderRepository repository;

    /**
     * Método para obtener todas las ordenes
     *
     * @return
     */
    public List<Order> getAll() {
        return repository.findAll();
    }

    /**
     * Método para obtener una orden por id
     *
     * @param idOrder
     * @return
     */
    public Optional<Order> getOrder(Integer idOrder) {
        return repository.findById(idOrder);
//        if (exist.isPresent()) {
//            return exist.get();
//        } else {
//            return Order.builder().build();
//        }
    }

    /**
     * Método para obtener una lista de ordenes por identificación del asesor
     *
     * @param identification
     * @return
     */
    public List<Order> getByIdentification(String identification) {
        return repository.findByIdentification(identification);
    }

    /**
     * Método para obtener una lista de ordenes por zona del coordinador
     *
     * @param zone
     * @return
     */
    public List<Order> getByZone(String zone) {
        return repository.findByZone(zone);
    }

    /**
     * Metodo para top de usuarios
     * @return
     */
    public Optional<Order> TopUserId(){
        return repository.findTopByOrderByIdDesc();
    }

    /**
     * Método para crear una orden
     *
     * @param order
     * @return
     */
    public Order newOrder(Order order) {
        Optional<Order> exist = repository.findById(order.getId());
        if (exist.isEmpty()) {
            return repository.save(order);
        }
        return order;
    }

    /**
     * Método para actualizar una orden
     *
     * @param order
     * @return
     */
    public Order editOrder(Order order) {
        Order exist = repository.findById(order.getId()).orElseThrow(() -> new BaseCustomException("Order no encontrado", HttpStatus.BAD_REQUEST.value()));
        if (order.getRegisterDay() != null) {
            exist.setRegisterDay(order.getRegisterDay());
        }
        if (order.getStatus() != null) {
            exist.setStatus(order.getStatus());
        }
        if (order.getSalesMan() != null) {
            exist.setSalesMan(order.getSalesMan());
        }
        if (order.getProducts() != null) {
            exist.setProducts(order.getProducts());
        }
        if (order.getQuantities() != null) {
            exist.setQuantities(order.getQuantities());
        }
        return repository.save(exist);
    }

    /**
     * Método para agregar un producto a la orden
     *
     * @param gadget
     * @param idOrder
     * @return
     */
    public Order addProduct(Optional<Gadget> gadget, Integer idOrder) {
        if (gadget.isPresent()) {
            Optional<Order> exist = repository.findById(idOrder);
            Map<String, Gadget> products = exist.get().getProducts();
            Integer var = products.size() + 1;
            String key = var + "";
            products.put(key, gadget.get());
            exist.get().setProducts(products);
            return repository.save(exist.get());
        } else {
            return Order.builder().build();
        }
    }

    /**
     * Método para eliminar una orden
     *
     * @param idOrder
     */
    public void deleteOrder(Integer idOrder) {
        repository.deleteById(idOrder);
    }
}
