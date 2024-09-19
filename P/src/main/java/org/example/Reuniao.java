package org.example;

public class Reuniao extends Evento {
    private boolean privada;
    private String senha;
    public Reuniao(String nome, String data, boolean privada, String senha) {
        super(nome, data);
        this.privada = privada;
        this.senha = senha;
    }

    public boolean acessarReuniao(String senhaTentativa) {
        if (!privada) {
            return true;
        }
        return senha != null && senha.equals(senhaTentativa);
    }

    @Override
    public boolean validar() {
        return !privada || (senha != null && !senha.isEmpty());
    }
}