package com.carcenter.carCenter.repository;

import com.carcenter.carCenter.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacturaRepository extends JpaRepository<Factura,Long> {

}
