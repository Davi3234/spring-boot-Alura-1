package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dtos.DtoCadastroMedico;
import med.voll.api.dtos.DtoDetalhamentoMedico;
import med.voll.api.dtos.DtoEdicaoMedico;
import med.voll.api.dtos.DtoListagemMedico;
import med.voll.api.entities.Medico;
import med.voll.api.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DtoDetalhamentoMedico> create(@RequestBody @Valid DtoCadastroMedico dtoCadastroMedico, UriComponentsBuilder uriBuilder) {
        Medico medico = new Medico(dtoCadastroMedico);
        medicoRepository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DtoDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DtoListagemMedico>> list(Pageable paginacao) {
        return ResponseEntity.ok(medicoRepository.findAllByAtivoTrue(paginacao).map(DtoListagemMedico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DtoDetalhamentoMedico> editar(@RequestBody @Valid DtoEdicaoMedico dtoEdicaoMedico) {
        Medico medico = medicoRepository.getReferenceById(dtoEdicaoMedico.id());
        medico.atualizarInformacoes(dtoEdicaoMedico);

        return ResponseEntity.ok(new DtoDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Medico medico = this.medicoRepository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();
    }
}
