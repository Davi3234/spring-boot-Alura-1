package med.voll.api.controllers;

import med.voll.api.dtos.DtoCadastroMedico;
import med.voll.api.entities.Medico;
import med.voll.api.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public String create(@RequestBody DtoCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
        return "Ué";
    }
}
