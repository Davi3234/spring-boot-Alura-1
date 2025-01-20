package med.voll.api.controllers;

import med.voll.api.dtos.DtoCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public String create(@RequestBody DtoCadastroMedico dtoCadastroMedico) {
        return dtoCadastroMedico.toString();
    }
}
