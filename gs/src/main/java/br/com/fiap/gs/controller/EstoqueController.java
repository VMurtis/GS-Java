package br.com.fiap.gs.controller;


import br.com.fiap.gs.dto.estoque.EstoqueDto;
import br.com.fiap.gs.dto.estoque.EstoqueGetDto;
import br.com.fiap.gs.model.enums.TipoItem;
import br.com.fiap.gs.service.EstoqueService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {
    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    @Transactional
    public void post(@RequestBody @Valid EstoqueDto dto) {
        estoqueService.save(dto);
    }

    @GetMapping
    public List<EstoqueGetDto> getAll() {
        return estoqueService.getAll();
    }
    @GetMapping("/{id}")
    public EstoqueGetDto getById(@PathVariable Long id) {
        return estoqueService.getId(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public EstoqueGetDto update(@PathVariable Long id, @RequestBody EstoqueGetDto dto){
        return estoqueService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        estoqueService.delete(id);
    }

    @PostMapping("/retirar")
    public EstoqueGetDto retirarDoEstoque(
            @RequestParam TipoItem tipo,
            @RequestParam Integer quantidade,
            @RequestParam Long administradorId) {

        return estoqueService.retirarDoEstoquePorTipo(tipo, quantidade, administradorId);
    }
}