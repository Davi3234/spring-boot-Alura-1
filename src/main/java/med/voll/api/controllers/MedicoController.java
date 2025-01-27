package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dtos.DtoCadastroMedico;
import med.voll.api.dtos.DtoListagemMedico;
import med.voll.api.entities.Medico;
import med.voll.api.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Medico> create(@RequestBody DtoCadastroMedico dtoCadastroMedico) {
        return ResponseEntity.ok(medicoRepository.save(new Medico(dtoCadastroMedico)));
    }

    @GetMapping
    public Page<DtoListagemMedico> list(Pageable paginacao) {
        return medicoRepository.findAll(paginacao).map(DtoListagemMedico::new);
    }
}
