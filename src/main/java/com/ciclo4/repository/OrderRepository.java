package com.ciclo4.repository;

import com.ciclo4.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

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
}
