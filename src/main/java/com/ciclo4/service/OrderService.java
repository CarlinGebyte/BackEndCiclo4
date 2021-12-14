package com.ciclo4.service;

import com.ciclo4.exception.BaseCustomException;
import com.ciclo4.model.Order;
import com.ciclo4.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
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
     *
     * @return
     */
    public Optional<Order> TopUserId() {
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
     * Método para eliminar una orden
     *
     * @param idOrder
     */
    public void deleteOrder(Integer idOrder) {
        repository.deleteById(idOrder);
    }

    /**
     * Método para obtener la lista de órdenes por ID de asesor
     *
     * @param id
     * @return
     */
    public List<Order> getBySalesManId(Integer id) {
        return repository.findBySalesManId(id);
    }

    /**
     * Método para obtener las órdenes con un estado específico de un asesor por ID
     *
     * @param id
     * @param status
     * @return
     */
    public List<Order> getBySalesManIdAndStatus(Integer id, String status) {
        return repository.findBySalesManIdAndStatus(id, status);
    }

    /**
     * Método para Obtener las órdenes por fecha de un Asesor por ID
     *
     * @param registerDay
     * @param id
     * @return
     */
    public List<Order> getByRegisterDayAndSalesManId(Date registerDay, Integer id) {
//        try {
            return repository.findByRegisterDayAndSalesManId(registerDay, id);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return null;
//        }
    }


}
