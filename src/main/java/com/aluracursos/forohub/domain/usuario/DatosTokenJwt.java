package com.aluracursos.forohub.domain.usuario;

public record DatosTokenJwt(
        String jwtToken,
        String expiracion
) {
}
