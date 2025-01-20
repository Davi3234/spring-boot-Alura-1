package med.voll.api.dtos;

import med.voll.api.enums.Especialidade;

public record DtoCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DtoCadastroEndereco endereco) {
}
