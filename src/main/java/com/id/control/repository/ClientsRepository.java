package com.id.control.repository;

import com.id.control.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco-romero
 */
@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {
    
    //Buscar cliente por correo
    

}
