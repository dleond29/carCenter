package com.carcenter.carCenter.repository;

import com.carcenter.carCenter.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
