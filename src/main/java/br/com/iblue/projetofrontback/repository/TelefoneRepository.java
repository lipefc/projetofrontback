package br.com.iblue.projetofrontback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.iblue.projetofrontback.entity.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
}