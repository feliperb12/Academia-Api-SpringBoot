package me.academia.digital.service.impl;


import me.academia.digital.exception.AvaliacaoNotFound;
import me.academia.digital.service.IAvaliacaoFisicaService;
import me.academia.digital.entity.Aluno;
import me.academia.digital.entity.AvaliacaoFisica;
import me.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.academia.digital.repository.AlunoRepository;
import me.academia.digital.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;


    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica= new AvaliacaoFisica();
        Aluno aluno=alunoRepository.findById(form.getAlunoId()).get();
        avaliacaoFisica.setAluno(aluno);

        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {

        return avaliacaoFisicaRepository.findById(id).orElseThrow(() ->
                new AvaliacaoNotFound(id));
    }

    @Override
    public List<AvaliacaoFisica> getAll() {

        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacaoFisica = get(id);
        avaliacaoFisica.setPeso(formUpdate.getPeso());
        avaliacaoFisica.setAltura(formUpdate.getAltura());
        avaliacaoFisicaRepository.save(avaliacaoFisica);
        return avaliacaoFisica;
    }

    @Override
    public void delete(Long id) {

    }
}
