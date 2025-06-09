package br.com.fiap.gs.dto.Desabrigado;

import br.com.fiap.gs.model.entities.Abrigo;
import br.com.fiap.gs.model.entities.Desabrigado;

public record DesabrigadoGetDto(
        Long id,

        String nome,


        String email,

        String senha,

        int idade,
        String telefone,

        Abrigo abrigo
) {
    public DesabrigadoGetDto(Desabrigado desabrigado) {
        this(desabrigado.getId(), desabrigado.getNome(), desabrigado.getEmail(), desabrigado.getSenha(), desabrigado.getIdade(), desabrigado.getTelefone(), desabrigado.getAbrigo());
    }
}
