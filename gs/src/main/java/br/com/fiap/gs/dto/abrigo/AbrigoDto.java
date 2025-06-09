package br.com.fiap.gs.dto.abrigo;

import br.com.fiap.gs.model.entities.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record AbrigoDto(
        @NotBlank(message = "O nome não pode estar em branco")
        @Size(min = 3, max = 50)
        String nome,

        @NotBlank(message = "O endereço não pode estar em branco")
        String endereco,

        @NotNull(message = "A capacidade máxima deve ser informada")
        Integer capacidadeMaxima,

        @NotNull(message = "A capacidade máxima deve ser informada")
        String cidade,

        @NotNull(message = "A capacidade máxima deve ser informada")
        String estado,
        @NotNull(message = "A capacidade máxima deve ser informada")
        String cep,

        @NotNull(message = "A lista de estoque não pode ser nula")
        @Size(min = 0)
        List<Estoque> estoque,
        @NotNull(message = "A lista de necessidades não pode ser nula")
        List<Necessidade> necessidades,

        @NotNull(message = "A lista de desabrigados não pode ser nula")
        List<Desabrigado> desabrigados,

        @NotNull(message = "A lista de administradores não pode ser nula")
        List<Administrador> adm


) {
}
