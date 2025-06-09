package br.com.fiap.gs.dto.abrigo;

import br.com.fiap.gs.model.entities.*;
import br.com.fiap.gs.model.enums.TipoItem;

import java.util.List;

public record AbrigoGetDto(
        Long id,
        String nome,
        String endereco,
        Integer capacidadeMaxima,

        String cidade,

        String estado,
        String cep,

        List<Long> estoque,

        List<TipoItem> necessidades,

        List<Long> desabrigados,

        List<Long> adm
) {
    public AbrigoGetDto(Abrigo abrigo) {
        this(
                abrigo.getId(),
                abrigo.getNome(),
                abrigo.getEndereco(),
                abrigo.getCapacidadeMaxima(),
                abrigo.getCidade(),
                abrigo.getEstado(),
                abrigo.getCep(),
                abrigo.getEstoque().stream().map(Estoque::getId).toList(),
                abrigo.getNecessidades().stream().map(Necessidade::getTipo).toList(),
                abrigo.getDesabrigados().stream().map(Desabrigado::getId).toList(),
                abrigo.getAdministradores().stream().map(Administrador::getId).toList()
        );
    }



}