package me.academia.digital.controller;

import me.academia.digital.entity.AvaliacaoFisica;
import me.academia.digital.entity.form.AlunoForm;
import me.academia.digital.entity.Aluno;
import me.academia.digital.entity.form.AlunoUpdateForm;
import me.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoServiceImpl service;

    @GetMapping("/{id}")
    public Aluno getById( Long id){
        return service.get(id);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataDeNascimento){
        return service.getAll(dataDeNascimento);
    }

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form){

        return service.create(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable Long id){
        return service.getAllAvaliacaoFisica(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody AlunoUpdateForm UpdateForm){

               Aluno aluno= service.update(id,UpdateForm);
        return ResponseEntity.ok(aluno);
    }

}
