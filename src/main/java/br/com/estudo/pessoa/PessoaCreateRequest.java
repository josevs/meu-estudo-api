package br.com.estudo.pessoa;

import jakarta.validation.constraints.*;

public record PessoaCreateRequest(
    @NotBlank String nome,
    @NotNull @Min(0) Integer idade
) { }
