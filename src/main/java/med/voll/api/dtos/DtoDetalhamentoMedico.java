package med.voll.api.dtos;

import med.voll.api.entities.Endereco;
import med.voll.api.entities.Medico;
import med.voll.api.enums.Especialidade;

public record DtoDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {
    public DtoDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
