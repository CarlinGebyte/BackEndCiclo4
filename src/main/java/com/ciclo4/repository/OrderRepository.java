package com.ciclo4.repository;

import com.ciclo4.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, Integer> {
    /**
     * Retorna las ordenes que coincidan con la zona recibida
     *
     * @param zone
     * @return
     */
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);

    /**
     * Retorna las ordenes que coincidan con la identificación del usuario recibida
     *
     * @param identification
     * @return
     */
    @Query("{'salesMan.identification': ?0}")
    List<Order> findByIdentification(final String identification);

    /**
     * Retorna las órdenes x estado
     *
     * @param status
     * @return
     */
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    /**
     * Para seleccionar la orden con el id maximo
     *
     * @return
     */
    Optional<Order> findTopByOrderByIdDesc();

    /**
     * Método para obtener la lista de órdenes por ID de asesor
     *
     * @param id
     * @return
     */
    List<Order> findBySalesManId(Integer id);

    /**
     * Método para obtener las órdenes con un estado específico de un asesor por ID
     *
     * @param id
     * @param status
     * @return
     */
    List<Order> findBySalesManIdAndStatus(Integer id, String status);

    /**
     * Método para Obtener las órdenes por fecha de un Asesor por ID
     *
     * @param registerDay
     * @param id
     * @return
     */
    List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer id);


}
