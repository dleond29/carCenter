package com.carcenter.carCenter.repository;

import com.carcenter.carCenter.model.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMecanicoRepository extends JpaRepository<Mecanico,Long> {
    @Query(value = "SELECT * FROM mecanicos  WHERE estado like %:true%", nativeQuery = true)
    List<Mecanico> findByEstado(@Param("estado") Boolean estado);

}
