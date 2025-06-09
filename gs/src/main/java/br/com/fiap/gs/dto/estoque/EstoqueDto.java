package br.com.fiap.gs.dto.estoque;


import br.com.fiap.gs.model.enums.TipoItem;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record EstoqueDto(
        Long id,

        @NotNull(message = "O tipo do item não pode ser nulo")
        TipoItem estoqueAtual,
        @NotNull(message = "A quantidade não pode ser nula")
        @Min(value = 0, message = "A quantidade não pode ser negativa")
        Integer quantidade,

        @NotNull(message = "O ID do abrigo não pode ser nulo")
        Long abrigoId
) {

}
