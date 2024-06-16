package com.camberos.challengeforohub.infra.errores;

public class ApplicationException extends RuntimeException{

    public ApplicationException(String mensaje) {super(mensaje);}
}
