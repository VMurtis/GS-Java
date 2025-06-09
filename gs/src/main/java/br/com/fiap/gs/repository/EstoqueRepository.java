package br.com.fiap.gs.repository;

import br.com.fiap.gs.model.entities.Estoque;
import br.com.fiap.gs.model.enums.TipoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional<Estoque> findByAbrigo_IdAndEstoqueAtual(Long id, TipoItem tipo);
}
