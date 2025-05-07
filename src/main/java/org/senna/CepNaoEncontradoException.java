package org.senna;

public class CepNaoEncontradoException extends RuntimeException {
    public CepNaoEncontradoException(String cep) {
        super("CEP não encontrado ou inválido: " + cep);
    }
}
