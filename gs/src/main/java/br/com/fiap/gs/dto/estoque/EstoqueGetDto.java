package br.com.fiap.gs.dto.estoque;



import br.com.fiap.gs.model.entities.Estoque;
import br.com.fiap.gs.model.enums.TipoItem;


public record EstoqueGetDto(
        Long id,
        TipoItem estoqueAtual,
        Integer quantidade,
        Long abrigoId
) {
    public EstoqueGetDto(Estoque estoque) {
        this(estoque.getId(),estoque.getEstoqueAtual(), estoque.getQuantidade(), estoque.getAbrigo().getId());
    }
}