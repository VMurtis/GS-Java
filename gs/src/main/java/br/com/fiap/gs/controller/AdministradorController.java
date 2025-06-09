package br.com.fiap.gs.controller;

import br.com.fiap.gs.dto.Administrador.AdministradorDto;
import br.com.fiap.gs.dto.Administrador.AdministradorGetDto;
import br.com.fiap.gs.dto.Desabrigado.DesabrigadoDto;
import br.com.fiap.gs.dto.Desabrigado.DesabrigadoGetDto;
import br.com.fiap.gs.service.AdministradorService;
import br.com.fiap.gs.service.DesabrigadoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/adm")
public class AdministradorController {
    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    @Transactional
    public void post(@RequestBody @Valid AdministradorDto dto) {
        administradorService.save(dto);
    }

    @GetMapping
    public List<AdministradorGetDto> getAll() {
        return administradorService.getAll();
    }

    @GetMapping("/{id}")
    public AdministradorGetDto getById(@PathVariable Long id) {
        return administradorService.getId(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public AdministradorGetDto update(@PathVariable Long id, @RequestBody AdministradorGetDto dto) {
        return administradorService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        administradorService.delete(id);
    }

}