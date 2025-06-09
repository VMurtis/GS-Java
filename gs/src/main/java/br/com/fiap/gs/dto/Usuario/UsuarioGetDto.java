package br.com.fiap.gs.dto.Usuario;

import br.com.fiap.gs.model.entities.Usuario;

public record UsuarioGetDto(
        Long id,

        String nome,


        String email,

        String senha



) {
    public UsuarioGetDto(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }
}
