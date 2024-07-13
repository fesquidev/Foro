package com.aluracursos.forohub.model.service;

import com.aluracursos.forohub.model.entity.Curso;
import com.aluracursos.forohub.model.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso obtenerCurso(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }
}
