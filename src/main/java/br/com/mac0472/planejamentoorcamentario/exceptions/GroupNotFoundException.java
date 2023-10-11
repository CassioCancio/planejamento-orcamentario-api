package br.com.mac0472.planejamentoorcamentario.exceptions;

public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(Long id) {
        super("Could not find group " + id);
    }
}
