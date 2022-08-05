package me.academia.digital.controller;

import me.academia.digital.entity.Matricula;
import me.academia.digital.service.impl.MatriculaServiceImpl;
import me.academia.digital.entity.form.MatriculaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {


    @Autowired
    private MatriculaServiceImpl service;

    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaForm form){
        return service.create(form);
    }

    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro){
        return service.getAll(bairro);
    }
@GetMapping("/{id}")
    public Matricula getById(Long id){
        return service.get(id);
}
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
