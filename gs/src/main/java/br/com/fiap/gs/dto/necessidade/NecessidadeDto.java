package br.com.fiap.gs.dto.necessidade;


import br.com.fiap.gs.model.enums.PrioridadeNecessidade;
import br.com.fiap.gs.model.enums.StatusNecessidade;
import br.com.fiap.gs.model.enums.TipoItem;
import jakarta.validation.constraints.NotNull;


public record NecessidadeDto(
        Long id,


        @NotNull(message = "O tipo do item é obrigatório")
        TipoItem tipo,


        @NotNull(message = "A quantidade é obrigatória")
        Integer quantidade,

        @NotNull(message = "A prioridade é obrigatória")
        PrioridadeNecessidade prioridade,

        @NotNull(message = "O status é obrigatório")
        StatusNecessidade status


) {

}
