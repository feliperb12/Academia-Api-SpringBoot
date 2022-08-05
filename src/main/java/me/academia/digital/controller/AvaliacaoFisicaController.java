package me.academia.digital.controller;

import me.academia.digital.entity.AvaliacaoFisica;
import me.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @GetMapping
    public List<AvaliacaoFisica> getAll(){
        return service.getAll();
    }

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form){

        return service.create(form);
    }
    @GetMapping("/{id}")
    public AvaliacaoFisica getById(Long id){
        return service.get(id);
    }
}
