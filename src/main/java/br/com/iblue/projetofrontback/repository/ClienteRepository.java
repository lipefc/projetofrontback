package br.com.iblue.projetofrontback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.iblue.projetofrontback.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}