package com.carcenter.carCenter.repository;

import com.carcenter.carCenter.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface IServicioRepository extends JpaRepository<Servicio,Long> {

}
