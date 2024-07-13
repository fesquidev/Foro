package com.aluracursos.forohub.domain.topico.validacion;

import com.aluracursos.forohub.domain.topico.DatosCrearTopico;
import com.aluracursos.forohub.model.repository.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TituloUnico implements ValidadorDeTopico{
    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DatosCrearTopico datos) {
        if(datos.titulo() != null) {
            boolean esUnico = topicoRepository.existsByTitulo(datos.titulo());
            if(esUnico) {
                throw new ValidationException("El título del tópico ya existe");
            }
        }
    }
}
