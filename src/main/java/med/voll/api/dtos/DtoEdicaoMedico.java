package med.voll.api.dtos;

import jakarta.validation.constraints.NotNull;

public record DtoEdicaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DtoCadastroEndereco dtoCadastroEndereco
) {
}
