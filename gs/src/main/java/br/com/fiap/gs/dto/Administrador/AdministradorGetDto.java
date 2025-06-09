package br.com.fiap.gs.dto.Administrador;

import br.com.fiap.gs.model.entities.Abrigo;
import br.com.fiap.gs.model.entities.Administrador;

public record AdministradorGetDto(
        Long id,
        String nome,
        String email,
        String senha,
        String cpf

) {
    public AdministradorGetDto(Administrador administrador) {
        this(administrador.getId(), administrador.getNome(), administrador.getEmail(), administrador.getSenha(), administrador.getCpf());
    }



}
