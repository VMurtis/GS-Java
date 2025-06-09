package br.com.fiap.gs.controller;


import br.com.fiap.gs.dto.Desabrigado.DesabrigadoDto;
import br.com.fiap.gs.dto.Desabrigado.DesabrigadoGetDto;
import br.com.fiap.gs.service.DesabrigadoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/desabrigado")
public class DesabrigadoController {
    @Autowired
    private DesabrigadoService desabrigadoService;

    @PostMapping
    @Transactional
    public void post(@RequestBody @Valid DesabrigadoDto dto) {
        desabrigadoService.save(dto);
    }

    @GetMapping
    public List<DesabrigadoGetDto> getAll() {
        return desabrigadoService.getAll();
    }

    @GetMapping("/{id}")
    public DesabrigadoGetDto getById(@PathVariable Long id) {
        return desabrigadoService.getId(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public DesabrigadoGetDto update(@PathVariable Long id, @RequestBody DesabrigadoGetDto dto) {
        return desabrigadoService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        desabrigadoService.delete(id);
    }

}


