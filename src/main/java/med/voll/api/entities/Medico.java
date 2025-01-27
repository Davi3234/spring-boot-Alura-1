package med.voll.api.entities;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dtos.DtoCadastroEndereco;
import med.voll.api.dtos.DtoCadastroMedico;
import med.voll.api.dtos.DtoEdicaoMedico;
import med.voll.api.enums.Especialidade;

import java.util.Objects;

@Table(name="medicos")
@Entity()
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Medico(){

    }

    public Medico(DtoCadastroMedico dtoCadastroMedico) {
        this.ativo = true;
        this.nome = dtoCadastroMedico.nome();
        this.email = dtoCadastroMedico.email();
        this.telefone = dtoCadastroMedico.telefone();
        this.crm = dtoCadastroMedico.crm();
        this.especialidade = dtoCadastroMedico.especialidade();
        this.endereco = new Endereco(dtoCadastroMedico.endereco());
    }

    public void atualizarInformacoes(DtoEdicaoMedico dtoEdicaoMedico){
        this.nome = dtoEdicaoMedico.nome() != null ? dtoEdicaoMedico.nome() : this.nome;
        this.telefone = dtoEdicaoMedico.telefone() != null ? dtoEdicaoMedico.telefone() : this.telefone;

        if(dtoEdicaoMedico.dtoCadastroEndereco() != null){
            this.endereco.atualizarInformacoes(dtoEdicaoMedico.dtoCadastroEndereco());
        }
    }

    public void excluir(){
        this.ativo = false;
    }
}
