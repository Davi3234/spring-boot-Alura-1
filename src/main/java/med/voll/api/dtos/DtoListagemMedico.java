package med.voll.api.dtos;

import med.voll.api.entities.Medico;
import med.voll.api.enums.Especialidade;

public record DtoListagemMedico(String nome, String email, String crm, Especialidade especialidade) {
    public DtoListagemMedico(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
