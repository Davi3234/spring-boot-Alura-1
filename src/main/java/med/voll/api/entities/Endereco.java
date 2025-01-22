package med.voll.api.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import med.voll.api.dtos.DtoCadastroEndereco;

@Embeddable
@Getter
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco() {
    }

    public Endereco(DtoCadastroEndereco dtoCadastroEndereco) {
        this.logradouro = dtoCadastroEndereco.logradouro();
        this.bairro = dtoCadastroEndereco.bairro();
        this.cep = dtoCadastroEndereco.cep();
        this.numero = dtoCadastroEndereco.numero();
        this.complemento = dtoCadastroEndereco.complemento();
        this.cidade = dtoCadastroEndereco.cidade();
        this.uf = dtoCadastroEndereco.uf();
    }
}
