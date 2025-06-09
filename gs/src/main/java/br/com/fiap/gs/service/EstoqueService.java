package br.com.fiap.gs.service;


import br.com.fiap.gs.dto.estoque.EstoqueDto;
import br.com.fiap.gs.dto.estoque.EstoqueGetDto;
import br.com.fiap.gs.model.entities.Abrigo;
import br.com.fiap.gs.model.entities.Administrador;
import br.com.fiap.gs.model.entities.Estoque;
import br.com.fiap.gs.model.enums.TipoItem;
import br.com.fiap.gs.repository.AbrigoRepository;
import br.com.fiap.gs.repository.AdministradorRepository;
import br.com.fiap.gs.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private AbrigoRepository abrigoRepository;

    @Autowired
    private AdministradorRepository administradorRepository;




    public Estoque save(EstoqueDto dto) {
        Abrigo abrigo = abrigoRepository.findById(dto.abrigoId())
                .orElseThrow(() -> new RuntimeException("Abrigo não encontrado"));

        Estoque estoque = new Estoque();
        estoque.setEstoqueAtual(dto.estoqueAtual());
        estoque.setQuantidade(dto.quantidade());
        estoque.setAbrigo(abrigo);

        return estoqueRepository.save(estoque);
    }

    public List<EstoqueGetDto> getAll() {
        return estoqueRepository.findAll().stream().map(EstoqueGetDto::new).toList();
    }

    public EstoqueGetDto getId(Long id) {

        Optional<Estoque> estoque = estoqueRepository.findById(id);

        if (estoque.isPresent()) {
            Estoque e = estoque.get();

            return new EstoqueGetDto(e.getId(), e.getEstoqueAtual(), e.getQuantidade(), e.getAbrigo().getId());
        } else {
            return null;
        }
    }

    public EstoqueGetDto update(Long id, EstoqueGetDto dto) {
        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

        estoque.setEstoqueAtual(dto.estoqueAtual());
        estoque.setQuantidade(dto.quantidade());

        Estoque atualizado = estoqueRepository.save(estoque);
        return new EstoqueGetDto(atualizado);
    }


    public void delete(Long id) {
        estoqueRepository.deleteById(id);
    }

    public EstoqueGetDto retirarDoEstoquePorTipo(TipoItem tipo, Integer quantidade, Long administradorId) {

        Administrador admin = administradorRepository.findById(administradorId)
                .orElseThrow(() -> new RuntimeException("Administrador não encontrado"));

        Estoque estoque = estoqueRepository
                .findByAbrigo_IdAndEstoqueAtual(admin.getAbrigo().getId(), tipo)
                .orElseThrow(() -> new RuntimeException("Item do estoque não encontrado para este abrigo"));


        if (estoque.getQuantidade() < quantidade) {
            throw new RuntimeException("Estoque insuficiente de " + tipo);
        }

        estoque.setQuantidade(estoque.getQuantidade() - quantidade);
        Estoque atualizado = estoqueRepository.save(estoque);

        return new EstoqueGetDto(atualizado);
    }
}


