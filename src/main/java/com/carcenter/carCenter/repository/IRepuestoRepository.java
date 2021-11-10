package com.carcenter.carCenter.repository;

import com.carcenter.carCenter.model.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface IRepuestoRepository extends JpaRepository<Repuesto,Long> {
}
