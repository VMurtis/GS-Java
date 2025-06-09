package br.com.fiap.gs.repository;

import br.com.fiap.gs.model.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
}
