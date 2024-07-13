package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.model.entity.Curso;
import com.aluracursos.forohub.model.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;
    @GetMapping
    public ResponseEntity<List<Curso>>listarCursos(){
        return ResponseEntity.ok(cursoService.listarCursos());
    }
}
