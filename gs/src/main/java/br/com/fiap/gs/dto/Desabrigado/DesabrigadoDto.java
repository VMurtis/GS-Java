package br.com.fiap.gs.dto.Desabrigado;

import br.com.fiap.gs.model.entities.Abrigo;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;

public record DesabrigadoDto(
        Long id,

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
        String nome,

        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "Formato de e-mail inválido")
        String email,


        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
        String senha,

        @Min(value = 0, message = "Idade não pode ser negativa")
        @Max(value = 120, message = "Idade máxima permitida é 120 anos")
        int idade,

        @NotBlank(message = "O telefone é obrigatório")
        String telefone,

        @NotNull(message = "Abrigo é obrigatório")
        Abrigo abrigo
) {
}
