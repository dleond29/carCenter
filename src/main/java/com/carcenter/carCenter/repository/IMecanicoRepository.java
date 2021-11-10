package com.carcenter.carCenter.repository;

import com.carcenter.carCenter.model.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface IMecanicoRepository extends JpaRepository<Mecanico,Long> {

}
