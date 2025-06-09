package br.com.fiap.gs.service;

import br.com.fiap.gs.dto.Administrador.AdministradorDto;
import br.com.fiap.gs.dto.Administrador.AdministradorGetDto;
import br.com.fiap.gs.model.entities.Administrador;
import br.com.fiap.gs.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;


    public Administrador save(AdministradorDto dto) {

        return administradorRepository.save(new Administrador(dto));
    }

    public List<AdministradorGetDto> getAll() {
        return administradorRepository.findAll().stream().map(AdministradorGetDto::new).toList();
    }

    public AdministradorGetDto getId(Long id) {

        Optional<Administrador> administrador = administradorRepository.findById(id);

        if (administrador.isPresent()) {
            Administrador a = administrador.get();

            return new AdministradorGetDto(a.getId(), a.getNome(), a.getEmail(), a.getSenha(), a.getCpf());
        } else {
            return null;
        }
    }

    public AdministradorGetDto update(Long id, AdministradorGetDto dto) {
        Administrador administrador = administradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrador não encontrado"));

        administrador.setNome(dto.nome());
        administrador.setEmail(dto.email());
        administrador.setSenha(dto.senha());
        administrador.setCpf(dto.cpf());


        Administrador atualizado = administradorRepository.save(administrador);
        return new AdministradorGetDto(atualizado);
    }


    public void delete(Long id) {
        administradorRepository.deleteById(id);
    }

}
