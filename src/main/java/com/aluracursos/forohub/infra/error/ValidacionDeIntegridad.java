package com.aluracursos.forohub.infra.error;

public class ValidacionDeIntegridad extends RuntimeException{
    public ValidacionDeIntegridad(String message) {
        super(message);
    }
}
