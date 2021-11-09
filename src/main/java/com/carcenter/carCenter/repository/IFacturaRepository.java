package com.carcenter.carCenter.repository;

import com.carcenter.carCenter.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFacturaRepository extends JpaRepository<Factura,Long> {

    @Query(value = "SELECT F.*, M.estado FROM mecanicos F inner join mecanicos M on M.id = F.mecanico_id WHERE M.estado like %:true%", nativeQuery = true)
    List<Factura> getFacturaPorEstado(@Param("estado") Boolean estado);
}
