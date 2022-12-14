package me.academia.digital.service.impl;

import me.academia.digital.entity.Aluno;
import me.academia.digital.entity.AvaliacaoFisica;
import me.academia.digital.entity.form.AlunoForm;
import me.academia.digital.entity.form.AlunoUpdateForm;
import me.academia.digital.exception.AlunoNotFoundException;
import me.academia.digital.repository.AlunoRepository;
import me.academia.digital.infra.utils.JavaTimeUtils;
import me.academia.digital.repository.MatriculaRepository;
import me.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl  implements IAlunoService {



    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AlunoRepository repository;


    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno= new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return repository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new AlunoNotFoundException(id));
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        if(dataDeNascimento == null){
        return repository.findAll();

        }else {
            LocalDate localDate= LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
        return repository.findByDataDeNascimento(localDate);
        }
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Aluno aluno = get(id);
        aluno.setNome(formUpdate.getNome());
        aluno.setBairro(formUpdate.getBairro());
        aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
        repository.save(aluno);
        return aluno;
    }

    @Override
    public void delete(Long id) {
        get(id);
        repository.deleteById(id);
        matriculaRepository.deleteById(id);

    }
//Pegar todas as avali????es
    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(Long id) {
        Aluno aluno =  repository.findById(id).get();
        return aluno.getAvaliacoes();

    }
}
