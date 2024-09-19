package org.example;

public abstract class Evento {
    protected String nome;
    protected String data;

    public Evento(String nome, String data) {
        this.nome = nome;
        this.data = data;
    }

    public abstract boolean validar();
}
